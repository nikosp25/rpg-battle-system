package com.game.rpg;

import com.game.rpg.entities.classes.Knight;
import com.game.rpg.entities.classes.Mage;
import com.game.rpg.entities.classes.Rogue;

public class Main {
    public static void main(String[] args) {
        Mage myMage = new Mage("Arcanis");
        Knight myKnight = new Knight("Arthur");
        Rogue myRogue = new Rogue("Shadow");

        System.out.println("--- DEFENSE SYSTEM TEST ---");

        // 1. Test the Knight (High Armor Test)
        // Arthur should absorb most of this with his armor.
        System.out.println("\n[Testing Knight's Heavy Armor]");
        System.out.println("Arthur's Armor: " + myKnight.getCombatStats().getCurrentArmor());
        myKnight.takeDamage(30);
        System.out.println("Arthur's Armor remaining: " + myKnight.getCombatStats().getCurrentArmor());

        // 2. Test the Rogue (Dodge/Evasion Test)
        // Shadow might ignore this completely if isDodged() returns true.
        System.out.println("\n[Testing Rogue's Evasion]");
        myRogue.takeDamage(50);
        System.out.println("--- Stress Testing Shadow's Dodge (30%) ---");

        for (int i = 1; i <= 100; i++) {
            // We use a small amount of damage so he doesn't die during the test
            myRogue.takeDamage(1);
        }

        System.out.println("--- Test Complete ---");

        // 3. Test the Mage (The "Glass Cannon" Test)
        // Arcanis likely has low armor, so this should leak to health quickly.
        System.out.println("\n[Testing Mage's Vulnerability]");
        System.out.println("Arcanis Health: " + myMage.getAttributes().getCurrentHealth());
        myMage.takeDamage(40);
        System.out.println("Arcanis Health after hit: " + myMage.getAttributes().getCurrentHealth());

        // 4. Test the Lethal Hit
        // Testing the healthDamage method and the "is dead" message.
        System.out.println("\n[Testing Lethal Damage]");
        myMage.takeDamage(500);

        System.out.println("\n--- TEST COMPLETE ---");
    }


    }

