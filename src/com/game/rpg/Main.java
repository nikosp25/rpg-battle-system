package com.game.rpg;

import com.game.rpg.battleLogic.BattleManager;
import com.game.rpg.entities.Entity;
import com.game.rpg.entities.classes.Knight;
import com.game.rpg.entities.classes.Mage;
import com.game.rpg.entities.classes.Rogue;
import com.game.rpg.ui.ClassSelectIntro;
import com.game.rpg.ui.Intro;
import com.game.rpg.ui.Narrator;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;
        do {


            ArrayList<Entity> party = new ArrayList<>();

            try {
                Intro.play();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 2 second delay before class selection.
            try {
                Thread.sleep(2000); //
            } catch (InterruptedException e) {
                //ignore
            }


            ClassSelectIntro.printClass();
            ClassSelectIntro.showStats();


            int choice = 0;

            while (true) {
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();

                    if (choice >= 1 && choice <= 3) {
                        break;
                    } else {
                        System.out.println("""
                                ╔════════════════════════════════════════╗
                                ║                                        ║
                                ║   ⚠️  Please enter a correct number   ║
                                ║           between 1 - 3                ║
                                ║                                        ║
                                ╚════════════════════════════════════════╝
                                """);

                    }


                } else {
                    System.out.println("That is not a number!");
                    scanner.next();
                }
            }
            scanner.nextLine(); //clears scanner from earlier uses. Avoids scanner glitch
            ClassSelectIntro.chooseName();
            String charName = scanner.nextLine();

            //Adds the player class choice first in the party list, so they can attack first,
            //based on the Battle logic.

            switch (choice) {
                case 1:
                    System.out.println("You choose Knight!");

                    party.add(new Knight(charName));

                    //add the 2 remaining classes with generic predetermined names.
                    party.add(new Rogue("Shadow"));
                    party.add(new Mage("Inferius"));
                    break;

                case 2:
                    System.out.println("You choose Mage!");

                    party.add(new Mage(charName));


                    party.add(new Rogue("Shadow"));
                    party.add(new Knight("Artorious"));
                    break;

                case 3:
                    System.out.println("You choose Rogue!");

                    party.add(new Rogue(charName));


                    party.add(new Knight("Artorious"));
                    party.add(new Mage("Inferius"));
                    break;


            }

            // small delay between character select and game starting.
            try {
                Thread.sleep(2000); //
            } catch (InterruptedException e) {
                //ignore
            }
            Narrator.dungeonEntry();

            BattleManager battleManager = new BattleManager(); //start the game logic.

            battleManager.startDungeon(party); //Pass the created party into the game logic so the game can begin.

            //ask player if they want to play again
            System.out.println("Would you like to play again? Type Yes/No : "); // assume the user will only enter a string.
            String answer = scanner.next().toLowerCase().trim();

            if (answer.equals("yes")) {
                System.out.println("Restarting the game!");

            }
            else {
                playAgain = false;
                System.out.println("Thank you for clearing the dungeon!");
            }
        } while (playAgain);
        scanner.close();





    }
}

