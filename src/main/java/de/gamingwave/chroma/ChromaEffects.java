package de.gamingwave.chroma;

import de.razer.java.JChromaSDK;

public class ChromaEffects {

    protected static JChromaSDK sChromaAnimationAPI = null;

    protected static String getAnimationPath() {
        String cd = System.getProperty("user.dir");
        //System.out.println("********* getAnimationPath: cd="+cd);
        String path = cd + "\\mods\\MinecraftChromaMod\\Animations\\";
        //System.out.println("********* getAnimationPath: path="+path);
        return path;
    }

    public static void showBaseEffect_Mouse(){
        String baseLayer = getAnimationPath() + "BaseEffect_Mouse.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }

    public static void showBaseEffect_Link(){
        String baseLayer = getAnimationPath() + "BaseEffect_ChromaLink.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }

    public static void showBaseEffect_Mousepad(){
        String baseLayer = getAnimationPath() + "BaseEffect_Mousepad.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }

    public static void showBaseEffect_Keyboard(){
        String baseLayer = getAnimationPath() + "BaseEffect_Keyboard.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }

    public static void showBaseEffect_Keypad(){
        String baseLayer = getAnimationPath() + "BaseEffect_Keypad.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }
    public static void showBaseEffect_Headset(){
        String baseLayer = getAnimationPath() + "BaseEffect_Headset.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }





    public static void showWater_Mouse(){
        String baseLayer = getAnimationPath() + "Water_Mouse.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }

    public static void showWater_Link(){
        String baseLayer = getAnimationPath() + "Water_ChromaLink.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }

    public static void showWater_Mousepad(){
        String baseLayer = getAnimationPath() + "Water_Mousepad.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }

    public static void showWater_Keyboard(){
        String baseLayer = getAnimationPath() + "Water_Keyboard.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }
    public static void showWater_Keypad(){
        String baseLayer = getAnimationPath() + "Water_Keypad.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }

    public static void showWater_Headset(){
        String baseLayer = getAnimationPath() + "Water_Headset.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }






    public static void showBow_Mouse(){
        String baseLayer = getAnimationPath() + "Bow_Mouse.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }

    public static void showBow_Link(){
        String baseLayer = getAnimationPath() + "Bow_ChromaLink.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }

    public static void showBow_Mousepad(){
        String baseLayer = getAnimationPath() + "Bow_Mousepad.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }

    public static void showBow_Keyboard(){
        String baseLayer = getAnimationPath() + "Bow_Keyboard.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }

    public static void showBow_Keypad(){
        String baseLayer = getAnimationPath() + "Bow_Keypad.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }

    public static void showBow_Headset(){
        String baseLayer = getAnimationPath() + "Bow_Headset.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }







    public static void showLava_Mouse(){
        String baseLayer = getAnimationPath() + "Lava_Mouse.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }

    public static void showLava_Link(){
        String baseLayer = getAnimationPath() + "Lava_ChromaLink.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }

    public static void showLava_Mousepad(){
        String baseLayer = getAnimationPath() + "Lava_Mousepad.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }

    public static void showLava_Keyboard(){
        String baseLayer = getAnimationPath() + "Lava_Keyboard.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }

    public static void showLava_Keypad(){
        String baseLayer = getAnimationPath() + "Lava_Keypad.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }

    public static void showLava_Headset(){
        String baseLayer = getAnimationPath() + "Lava_Headset.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }










    public static void showPick_Mouse(){
        String baseLayer = getAnimationPath() + "PickUp_Mouse.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }

    public static void showPick_Link(){
        String baseLayer = getAnimationPath() + "PickUp_ChromaLink.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }

    public static void showPick_Mousepad(){
        String baseLayer = getAnimationPath() + "PickUp_Mousepad.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }
    public static void showPick_Keyboard(){
        String baseLayer = getAnimationPath() + "PickUp_Keyboard.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }
    public static void showPick_Keypad(){
        String baseLayer = getAnimationPath() + "PickUp_Keypad.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }
    public static void showPick_Headset(){
        String baseLayer = getAnimationPath() + "PickUp_Headset.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }





    public static void showChest_Mouse(){
        String baseLayer = getAnimationPath() + "Chest_Barrel_Mouse.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }

    public static void showChest_Link(){
        String baseLayer = getAnimationPath() + "Chest_Barrel_ChromaLink.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }

    public static void showChest_Mousepad(){
        String baseLayer = getAnimationPath() + "Chest_Barrel_Mousepad.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }

    public static void showChest_Keyboard(){
        String baseLayer = getAnimationPath() + "Chest_Barrel_Keyboard.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }

    public static void showChest_Keypad(){
        String baseLayer = getAnimationPath() + "Chest_Barrel_Keypad.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }

    public static void showChest_Headset(){
        String baseLayer = getAnimationPath() + "Chest_Barrel_Headset.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }



    public static void showMenu_Mouse(){
        String baseLayer = getAnimationPath() + "Menu_Mouse.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }

    public static void showMenu_Link(){
        String baseLayer = getAnimationPath() + "Menu_ChromaLink.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }

    public static void showMenu_Mousepad(){
        String baseLayer = getAnimationPath() + "Menu_Mousepad.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }

    public static void showMenu_Keyboard(){
        String baseLayer = getAnimationPath() + "Menu_Keyboard.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }

    public static void showMenu_Keypad(){
        String baseLayer = getAnimationPath() + "Menu_Keypad.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }

    public static void showMenu_Headset(){
        String baseLayer = getAnimationPath() + "Menu_Headset.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }




    public static void showDamage_Mouse(){
        String baseLayer = getAnimationPath() + "Damage_Mouse.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }

    public static void showDamage_Link(){
        String baseLayer = getAnimationPath() + "Damage_ChromaLink.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }
    public static void showDamage_Mousepad(){
        String baseLayer = getAnimationPath() + "Damage_Mousepad.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }

    public static void showDamage_Keyboard(){
        String baseLayer = getAnimationPath() + "Damage_Keyboard.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }
    public static void showDamage_Keypad(){
        String baseLayer = getAnimationPath() + "Damage_Keypad.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }
    public static void showDamage_Headset(){
        String baseLayer = getAnimationPath() + "Damage_Headset.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }








    public static void showCrafting_Mouse(){
        String baseLayer = getAnimationPath() + "Crafting_Mouse.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }

    public static void showCrafting_Link(){
        String baseLayer = getAnimationPath() + "Crafting_ChromaLink.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }

    public static void showCrafting_Mousepad(){
        String baseLayer = getAnimationPath() + "Crafting_Mousepad.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }

    public static void showCrafting_Keyboard(){
        String baseLayer = getAnimationPath() + "Crafting_Keyboard.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }
    public static void showCrafting_Keypad(){
        String baseLayer = getAnimationPath() + "Crafting_Keypad.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }
    public static void showCrafting_Headset(){
        String baseLayer = getAnimationPath() + "Crafting_Headset.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }










    public static void showAttack_Mouse(){
        String baseLayer = getAnimationPath() + "Attack_Mouse.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }

    public static void showAttack_Link(){
        String baseLayer = getAnimationPath() + "Attack_ChromaLink.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }
    public static void showAttack_Mousepad(){
        String baseLayer = getAnimationPath() + "Attack_Mousepad.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }
    public static void showAttack_Keyboard(){
        String baseLayer = getAnimationPath() + "Attack_Keyboard.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }
    public static void showAttack_Keypad(){
        String baseLayer = getAnimationPath() + "Attack_Keypad.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }
    public static void showAttack_Headset(){
        String baseLayer = getAnimationPath() + "Attack_Headset.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }







    public static void showPotion_Mouse(){
        String baseLayer = getAnimationPath() + "Potion_Mouse.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }

    public static void showPotion_Link(){
        String baseLayer = getAnimationPath() + "Potion_ChromaLink.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }

    public static void showPotion_Headset(){
        String baseLayer = getAnimationPath() + "Potion_Headset.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }
    public static void showPotion_Keyboard(){
        String baseLayer = getAnimationPath() + "Potion_Keyboard.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }
    public static void showPotion_Keypad(){
        String baseLayer = getAnimationPath() + "Potion_Keypad.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }
    public static void showPotion_Mousepad(){
        String baseLayer = getAnimationPath() + "Potion_Mousepad.chroma";
        sChromaAnimationAPI.closeAnimationName(baseLayer);
        sChromaAnimationAPI.getAnimation(baseLayer);
        sChromaAnimationAPI.overrideFrameDurationName(baseLayer, 0.033f);
        sChromaAnimationAPI.playAnimationName(baseLayer, true);
    }



}
