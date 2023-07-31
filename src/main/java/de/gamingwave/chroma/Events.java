package de.gamingwave.chroma;

import de.razer.java.JAppInfoType;
import de.razer.java.JChromaSDK;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.gui.screens.PauseScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.gui.screens.worldselection.SelectWorldScreen;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.biome.BiomeData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.client.gui.TitleScreenModUpdateIndicator;
import net.minecraftforge.client.gui.overlay.GuiOverlayManager;
import net.minecraftforge.client.gui.overlay.NamedGuiOverlay;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.extensions.IForgeBlockState;
import net.minecraftforge.common.world.ModifiableBiomeInfo;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.PlayerContainerEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.event.server.ServerStoppedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistry;
import net.minecraftforge.registries.RegistryManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class Events extends ChromaEffects{
    private class PlayerState {
        public boolean mAlive = true;
        public boolean mInAir = false;
        public boolean mOnGround = true;
        public boolean mOnLadder = false;
        public boolean mInLava = false;
        public boolean mInWater = false;
        public boolean mInMinecart = false;
        public boolean mIsRaining = false;
        public boolean mIsSnowing = false;
        public BlockPos mPosition = BlockPos.ZERO;
    }

    private PlayerState mPlayerState = new PlayerState();

    List<String> mEvents = new ArrayList<String>();

    private boolean mChromaInitialized = false;

    private List<TimerTask> sChromaTasks = new ArrayList<TimerTask>();

    private boolean mWaitForExit = true;

    private void logMessage(String msg) {
        System.out.println(msg);
    }

    private void logError(String msg) {
        System.err.println(msg);
    }

    private void addChromaTask(TimerTask task) {
        sChromaTasks.add(task);
    }

    private void setupChromaThread() {
        mWaitForExit = true;
        Timer timer = new Timer("Timer");
        TimerTask task = new TimerTask() {
            public void run() {
                try {
                    while (mWaitForExit) {
                        if (sChromaTasks.size() > 0) {
                            TimerTask nextTask = sChromaTasks.get(0);
                            sChromaTasks.remove(0);
                            try {
                                if (nextTask != null) {
                                    nextTask.run();
                                }
                            } catch (Exception e) {
                                logError("Exception running Chroma Task!");
                                e.printStackTrace();
                            }

                        }
                        try {
                            Thread.sleep(0);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        timer.schedule(task, 0);
    }

    public void register() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void init() {

        if (sChromaAnimationAPI == null) {

            sChromaAnimationAPI = JChromaSDK.getInstance();
            ChromaEffects.sChromaAnimationAPI = sChromaAnimationAPI;

            logMessage("*****Constructing AppInfo...");
            JAppInfoType appInfo = new JAppInfoType();

            appInfo.setTitle("Minecraft Chroma Mod");
            appInfo.setDescription("A sample application using Razer Chroma SDK");
            appInfo.setAuthorName("GamingWave");
            appInfo.setAuthorContact("https://github.com/tgraupmann/MinecraftChromaMod");

            //appInfo.SupportedDevice =
            //    0x01 | // Keyboards
            //    0x02 | // Mice
            //    0x04 | // Headset
            //    0x08 | // Mousepads
            //    0x10 | // Keypads
            //    0x20   // ChromaLink devices
            //    ;
            appInfo.supportedDevice = (0x01 | 0x02 | 0x04 | 0x08 | 0x10 | 0x20);
            appInfo.category = 2;
            logMessage("*****Initializing Chroma...");
            int result = sChromaAnimationAPI.initSDK(appInfo);
            if (result == 0) {
                mChromaInitialized = true;
                logMessage("*****Initialized ChromaSDK!");
            } else {
                logError("******* Failed to initialize ChromaSDK! error="+result);
                mChromaInitialized = false;
            }

            // Keep Chroma in the same thread to avoid multiple threads manipulating the same animations
            setupChromaThread();

            //avoid blocking the main thread
            TimerTask task = new TimerTask() {
                public void run() {
                    try {
                        if (mChromaInitialized) {
                            setupBaseAnimation("ChromaLink");
                            setupBaseAnimation("Headset");
                            setupBaseAnimation("Keyboard");
                            setupBaseAnimation("Keypad");
                            setupBaseAnimation("Mouse");
                            setupBaseAnimation("Mousepad");
                            sChromaAnimationAPI.useIdleAnimations(true);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            addChromaTask(task);
        }
    }

    private void uninit() {
        mWaitForExit = false;
        Timer timer = new Timer("Timer");
        TimerTask task = new TimerTask() {
            public void run() {
                try {
                    if (mChromaInitialized) {
                        sChromaAnimationAPI.stopAll();
                        sChromaAnimationAPI.closeAll();
                        sChromaAnimationAPI.uninit();
                        mChromaInitialized = false;
                    }

                    ChromaEffects.sChromaAnimationAPI = null;
                    sChromaAnimationAPI = null;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        timer.schedule(task, 100);
    }

    private void playAnimationName(String name, boolean loop) {
        //avoid blocking the main thread
        TimerTask task = new TimerTask() {
            public void run() {
                try {
                    if (mChromaInitialized) {
                        String path = getAnimationPath() + name;
                        sChromaAnimationAPI.closeAnimationName(path);
                        sChromaAnimationAPI.playAnimationName(path, loop);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        addChromaTask(task);
    }
    private void playAnimationReverseName(String name, boolean loop) {
        //avoid blocking the main thread
        TimerTask task = new TimerTask() {
            public void run() {
                try {
                    if (mChromaInitialized) {
                        String path = getAnimationPath() + name;
                        sChromaAnimationAPI.closeAnimationName(path);
                        sChromaAnimationAPI.reverseAllFramesName(path);
                        sChromaAnimationAPI.playAnimationName(path, loop);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        addChromaTask(task);
    }

    private void setupBaseAnimation(String device) {
        //avoid blocking the main thread
        TimerTask task = new TimerTask() {
            public void run() {
                try {
                    if (mChromaInitialized) {
                        int ground = sChromaAnimationAPI.getRGB(64, 32, 0);

                        String baseLayer = getAnimationPath() + "Blank_" + device + ".chroma";
                        sChromaAnimationAPI.closeAnimationName(baseLayer);
                        sChromaAnimationAPI.fillZeroColorAllFramesName(baseLayer, ground);

                        String idleAnimation = "Idle_" + device + ".chroma";
                        sChromaAnimationAPI.copyAnimationName(baseLayer, idleAnimation);
                        sChromaAnimationAPI.setIdleAnimationName(idleAnimation);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        addChromaTask(task);
    }

    @SubscribeEvent
    public void handleStart(ServerStartingEvent event) {
        init();
    }


    @SubscribeEvent
    public void handleStop(ServerStoppedEvent event) {
        uninit();
    }

    private boolean _mWasPaused = false;
    private Minecraft _mMinecraft = null;

    private void base(){
        TimerTask task = new TimerTask() {
            public void run() {
                try {
                    if (mChromaInitialized) {
                        showBaseEffect_Mouse();
                        showBaseEffect_Link();
                        showBaseEffect_Headset();
                        showBaseEffect_Keyboard();
                        showBaseEffect_Keypad();
                        showBaseEffect_Mousepad();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        addChromaTask(task);


    }
    private void setupInWater() {
        //avoid blocking the main thread
        TimerTask task = new TimerTask() {
            public void run() {
                try {
                    if (mChromaInitialized) {
                        showWater_Mouse();
                        showWater_Link();
                        showWater_Headset();
                        showWater_Keyboard();
                        showWater_Keypad();
                        showWater_Mousepad();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        addChromaTask(task);

    }

    private void stopAll() {
        //avoid blocking the main thread
        TimerTask task = new TimerTask() {
            public void run() {
                try {
                    if (mChromaInitialized) {
                        sChromaAnimationAPI.stopAll();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        addChromaTask(task);
    }



    @SubscribeEvent
    public void handlePlayerTickEvent(TickEvent.PlayerTickEvent event){
        init();

        String threadName = Thread.currentThread().getName();
        switch (threadName) {
            case "Server thread":
                // Only interested in Client thread
                return;
        }

        mPlayerState.mPosition = new BlockPos((int) event.player.position().x, (int) event.player.position().y, (int) event.player.position().z);

        if (event.player.isInWater() && !mPlayerState.mInWater) {
            mPlayerState.mInWater = true;
            logMessage("Player is in Water");
            setupInWater();
        }
        else if (!event.player.isInWater() && mPlayerState.mInWater) {
            mPlayerState.mInWater = false;
            logMessage("Player is not in Water");
            stopAll();
            base();
        }

        boolean isOnGround = event.player.onGround() && !event.player.isSwimming();
        if (isOnGround && !mPlayerState.mOnGround) {
            mPlayerState.mOnGround = true;
        }
        else if (!isOnGround && mPlayerState.mOnGround) {
            mPlayerState.mOnGround = false;
            //logMessage("Player is not on the ground");
        }

        if (!event.player.onGround() && !mPlayerState.mInAir) {
            mPlayerState.mInAir = true;
            //logMessage("Player is in the air");
        }
        else if (event.player.onGround() && mPlayerState.mInAir) {
            mPlayerState.mInAir = false;
            //logMessage("Player is not in the air");
        }

        if (!event.player.isAlive() && mPlayerState.mAlive) {
            mPlayerState.mAlive = false;
            logMessage("Player is Dead");
        }
        else if (event.player.isAlive() && !mPlayerState.mAlive) {
            mPlayerState.mAlive = true;
            logMessage("Player is Alive");
        }

        if (event.player.isInLava() && !mPlayerState.mInLava) {
            mPlayerState.mInLava = true;
            logMessage("Player is in Lava");
            TimerTask task = new TimerTask() {
                public void run() {
                    try {
                        if (mChromaInitialized) {
                            showLava_Mouse();
                            showLava_Link();
                            showLava_Headset();
                            showLava_Keyboard();
                            showLava_Keypad();
                            showLava_Mousepad();

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };

            addChromaTask(task);

        }
        else if (!event.player.isInLava() && mPlayerState.mInLava) {
            mPlayerState.mInLava = false;
            logMessage("Player is not in Lava");
            base();
        }

        if (event.player.onClimbable() && !mPlayerState.mOnLadder) {
            mPlayerState.mOnLadder = true;
            logMessage("Player is on ladder");
            TimerTask task = new TimerTask() {
                public void run() {
                    try {
                        if (mChromaInitialized) {

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            addChromaTask(task);
        }
        else if (!event.player.onClimbable() && mPlayerState.mOnLadder) {
            mPlayerState.mOnLadder = false;
            logMessage("Player is not on ladder");
            stopAll();
        }





        // If you want to check if the biome belongs to a specific type (e.g., forest, desert, etc.),
        // you can use the BiomeDictionary like this:






    }

    @SubscribeEvent
    public void handleArrowLooseEvent(ArrowLooseEvent event){
        init();
        String threadName = Thread.currentThread().getName();
        switch (threadName) {
            case "Server thread":
                // Only interested in Client thread
                return;
        }

        logMessage("Player shot an arrow");
        //avoid blocking the main thread
        TimerTask task = new TimerTask() {
            public void run() {
                try {
                    if (mChromaInitialized) {
                        showBow_Mouse();
                        showBow_Link();
                        showBow_Headset();
                        showBow_Keyboard();
                        showBow_Keypad();
                        showBow_Mousepad();
                        TimeUnit.MILLISECONDS.sleep(500);
                        showBaseEffect_Mouse();
                        showBaseEffect_Link();
                        showBaseEffect_Headset();
                        showBaseEffect_Keyboard();
                        showBaseEffect_Keypad();
                        showBaseEffect_Mousepad();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        addChromaTask(task);


    }

    @SubscribeEvent
    public void handlePickUpEvent(PlayerEvent.ItemPickupEvent event){
        logMessage("Player picked an item up");
        //avoid blocking the main thread
        TimerTask task = new TimerTask() {
            public void run() {
                try {
                    if (mChromaInitialized) {
                        showPick_Mouse();
                        showPick_Link();
                        showPick_Headset();
                        showPick_Keyboard();
                        showPick_Keypad();
                        showPick_Mousepad();
                        TimeUnit.MILLISECONDS.sleep(500);
                        showBaseEffect_Mouse();
                        showBaseEffect_Link();
                        showBaseEffect_Headset();
                        showBaseEffect_Keyboard();
                        showBaseEffect_Keypad();
                        showBaseEffect_Mousepad();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        addChromaTask(task);
    }

    @SubscribeEvent
    public void handlePlyerContainerEvent(PlayerContainerEvent event){
        init();
        logMessage("handlePlayerContainerEvent: countainer="+event.getContainer().getClass());
        if (event.getContainer() instanceof ChestMenu) {
            if (event.getClass() == PlayerContainerEvent.Open.class) {
                logMessage("Chest Opened");
                TimerTask task = new TimerTask() {
                    public void run() {
                        try {
                            if (mChromaInitialized) {
                                showChest_Mouse();
                                showChest_Link();
                                showChest_Headset();
                                showChest_Keyboard();
                                showChest_Keypad();
                                showChest_Mousepad();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };

                addChromaTask(task);
            } else if (event.getClass() == PlayerContainerEvent.Close.class) {
                logMessage("Chest Closed");
                base();
            }
        }
    }

    @SubscribeEvent
    public void handleDamage(LivingDamageEvent event) {
        if (event.getEntity().getType() == EntityType.PLAYER) {
        TimerTask task = new TimerTask() {
            public void run() {
                try {

                        logMessage("handlePlayerDamage directEntity=" + event.getSource().getDirectEntity());


                        if (mChromaInitialized) {
                            showDamage_Mouse();
                            showDamage_Link();
                            showDamage_Headset();
                            showDamage_Keyboard();
                            showDamage_Keypad();
                            showDamage_Mousepad();
                            TimeUnit.MILLISECONDS.sleep(500);
                            showBaseEffect_Mouse();
                            showBaseEffect_Link();
                            showBaseEffect_Headset();
                            showBaseEffect_Keyboard();
                            showBaseEffect_Keypad();
                            showBaseEffect_Mousepad();
                        }

                    } catch(Exception e){
                        e.printStackTrace();
                    }
                }
            };

            addChromaTask(task);
        }
        try {
            if (event.getSource().getEntity().getType() == EntityType.PLAYER) {
                TimerTask task = new TimerTask() {
                    public void run() {
                        try {
                            logMessage("SWORD Attack by" + Minecraft.getInstance().player.getDisplayName().getString());
                            if (mChromaInitialized) {
                                showAttack_Mouse();
                                showAttack_Link();
                                showAttack_Headset();
                                showAttack_Keyboard();
                                showAttack_Keypad();
                                showAttack_Mousepad();
                                TimeUnit.MILLISECONDS.sleep(440);
                                showBaseEffect_Mouse();
                                showBaseEffect_Link();
                                showBaseEffect_Headset();
                                showBaseEffect_Keyboard();
                                showBaseEffect_Keypad();
                                showBaseEffect_Mousepad();
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
                addChromaTask(task);
            }
        }catch (Exception ignored){

        }
    }

    @SubscribeEvent
    public void handleCraftItem(PlayerEvent.ItemCraftedEvent event) {
        init();


        logMessage("Crafted item");
        //avoid blocking the main thread
        TimerTask task = new TimerTask() {
            public void run() {
                try {
                    if (mChromaInitialized) {
                        showCrafting_Mouse();
                        showCrafting_Link();
                        showCrafting_Headset();
                        showCrafting_Keyboard();
                        showCrafting_Keypad();
                        showCrafting_Mousepad();
                        TimeUnit.MILLISECONDS.sleep(500);
                        showBaseEffect_Mouse();
                        showBaseEffect_Link();
                        showBaseEffect_Headset();
                        showBaseEffect_Keyboard();
                        showBaseEffect_Keypad();
                        showBaseEffect_Mousepad();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        addChromaTask(task);
    }

    @SubscribeEvent
    public void handlePotion(PlayerInteractEvent.RightClickItem event){
        if (event.getEntity().getItemInHand(event.getHand()).getItem() == Items.POTION ||
                event.getEntity().getItemInHand(event.getHand()).getItem() == Items.LINGERING_POTION ||
                event.getEntity().getItemInHand(event.getHand()).getItem() == Items.SPLASH_POTION) {
            logMessage("Drinking potion");
            //avoid blocking the main thread
            TimerTask task = new TimerTask() {
                public void run() {
                    try {
                        if (mChromaInitialized) {
                            showPotion_Mouse();
                            showPotion_Link();
                            showPotion_Headset();
                            showPotion_Keyboard();
                            showPotion_Keypad();
                            showPotion_Mousepad();
                            TimeUnit.MILLISECONDS.sleep(1560);
                            showBaseEffect_Mouse();
                            showBaseEffect_Link();
                            showBaseEffect_Headset();
                            showBaseEffect_Keyboard();
                            showBaseEffect_Keypad();
                            showBaseEffect_Mousepad();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            addChromaTask(task);



        }
    }

    @SubscribeEvent
    public void handleMenu(ScreenEvent.Opening event){
        init();
        Screen gui = event.getScreen();
        if (null != gui) {
            _mMinecraft = gui.getMinecraft();
        }


            if (!_mWasPaused){
                logMessage("Menu Opened");
                if (!(gui instanceof TitleScreen)){
                    if (!(gui instanceof TitleScreenModUpdateIndicator)){
                        if (!(gui instanceof SelectWorldScreen)){
                            _mWasPaused = true;
                            TimerTask task = new TimerTask() {
                                public void run() {
                                    try {
                                        if (mChromaInitialized) {
                                            showMenu_Mouse();
                                            showMenu_Link();
                                            showMenu_Headset();
                                            showMenu_Keyboard();
                                            showMenu_Keypad();
                                            showMenu_Mousepad();
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            };
                            addChromaTask(task);
                        }
                    }
                }

            }








    }

    @SubscribeEvent
    public void handleMenuClose(ScreenEvent.Closing event){
        if (_mWasPaused){
            logMessage("Menu Closed");
            _mWasPaused = false;
            base();
        }
    }




}
