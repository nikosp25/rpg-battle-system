package com.game.rpg.ui;

import com.game.rpg.entities.Entity;
import com.game.rpg.entities.classes.Knight;
import com.game.rpg.entities.classes.Mage;
import com.game.rpg.entities.classes.Rogue;

public class ClassSelectIntro {
    public static void printClass() {
        System.out.println("""
                ╔════════════════════════════════════════════════════════════════╗
                ║                                                                ║
                ║                    🏰 CHOOSE YOUR CLASS 🏰                       ║
                ║                                                                ║
                ║  1) Mage   🔮  - Wielder of forbidden arcane powers            ║
                ║  2) Knight ⚔️  - Valiant protector of the realm               ║
                ║  3) Rogue  🗡️  - Shadowy assassin with deadly skill           ║
                ║                                                                ║
                ║                                              ║
                ╚════════════════════════════════════════════════════════════════╝
                """);


    }

    public static void showStats() {
        Entity[] classes = {new Knight("info"),new Mage("info"),new Rogue("info")};

        System.out.println("\n══════════════ CLASS DETAILS ══════════════");

        for (Entity e : classes) {
            System.out.println("Role: " + e.getClass().getSimpleName().toUpperCase());

            //loop through the entities and get the stats of each one.
            System.out.println("   [Attributes] " + e.getAttributes());
            System.out.println("   [Combat]     " + e.getCombatStats());
            System.out.println("───────────────────────────────────────────");
        }

        System.out.println("Type 1, 2 or 3 to choose : ");

    }

    public static void chooseName() {
        System.out.println("""
                ╔════════════════════════════════════════╗
                ║                                        ║
                ║       ✦ Choose Your Character's Name ✦ ║
                ║                                        ║
                ╚════════════════════════════════════════╝
                """);



    }


}


