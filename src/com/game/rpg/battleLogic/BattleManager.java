package com.game.rpg.battleLogic;


import com.game.rpg.entities.Entity;
import com.game.rpg.entities.enemies.Dragon;
import com.game.rpg.entities.enemies.Goblin;
import com.game.rpg.entities.enemies.Orc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BattleManager {
    //tracks the number of encounters the player has successfully passed.
    int encounterNumber = 1;


    /**
     * The main battle logic.
     * uses RNG to spawn certain enemies according to a certain probability.
     * a dragon boss always appears after 5 encounters.
     *
     * @return the list of spawned enemies.
     */
    public List<Entity> createRandomEncounter() {
        List<Entity> enemies = new ArrayList<>();
        Random random = new Random();
        int roll = random.nextInt(100);

        if (encounterNumber == 5 || roll >= 80) {
            enemies.add(new Dragon());
            System.out.println("Borgoth has appeared!");
            return enemies;
        }

        if (roll <= 50) {
            enemies.add(new Goblin());
            enemies.add(new Goblin());
            enemies.add(new Goblin());
            System.out.println("A band of goblins appeared.");

        } else {
            enemies.add(new Orc());
            enemies.add(new Orc());
            System.out.println("2 huge orcs appear infront of you!");
        }

        return enemies;
    }

    /**
     * The main game loop.
     * Keeps looping encounters and tracks encounter numbers each time the player wins
     * Keeps going till full player party is defeated.
     *
     * @param party the list of player heroes that are alive.
     */
    public void startDungeon(List<Entity> party) {
        while (!party.isEmpty()) {
            List<Entity> enemies = createRandomEncounter();
            System.out.println("Encounter " + encounterNumber + " starts.");
            startBattle(party, enemies);
            encounterNumber++;
        }
    }


    /**
     * Handles the core turn-based combat logic.
     * Loops continuously, giving every Hero a turn to pick a target and attack,
     * followed by the Enemies picking random targets.
     *  Checks for death after every single attack and removes
     * entities from the lists immediately so they can't be attacked again.
     *
     * @param party   Your team of heroes.
     * @param enemies The generated list of monsters.
     */
    public void startBattle(List<Entity> party, List<Entity> enemies) {
        Scanner scanner = new Scanner(System.in);

        //Runs while both party and enemies are alive.
        while (!party.isEmpty() && !enemies.isEmpty()) {
            System.out.println("---New Round---");

            // --- HEROES TURN ---
            //loop through the party list
            for (Entity hero : party) {
                System.out.println("It is " + hero.getName() + "'s turn to attack. ");

                //loop through the enemy list and show the enemy choices to user.
                for (int j = 0; j < enemies.size(); j++) {
                    System.out.println(j + 1 + ". " + enemies.get(j).getName());
                }

                //Take user input and validate it.
                int answerCheck = -1; //just a random negative number to keep the loop running
                while (answerCheck < 0) {
                    System.out.println("Please choose which enemy to attack. Type a number between 1 - " + enemies.size() + ":");
                    if (scanner.hasNextInt()) {
                        int input = scanner.nextInt();
                        if (input >= 1 && input <= enemies.size()) {
                            answerCheck = input - 1; // we do -1 cause the index starts counting from 0, so when user presses 1, we need to attack 0.
                        } else {
                            System.out.println("invalid number.");
                        }

                    } else {
                        System.out.println("That is not a number.");
                        scanner.next();
                    }
                }
                Entity target = enemies.get(answerCheck);
                hero.attack(target);

                if (!target.isAlive()) {

                    enemies.remove(answerCheck);
                    if ( target instanceof Dragon) {
                        System.out.println("\n************************************************");
                        System.out.println("Borgoth falls with a deafening roar! The kingdom is saved.");
                        System.out.println("CONGRATULATIONS! YOU HAVE CLEARED THE DUNGEON!");
                        System.out.println("************************************************");

                        party.clear();// we clear the party so the fight doesnt continue on endlessly.
                        return; // This exits the battle and goes back to Main
                    }
                    if (enemies.isEmpty()) {
                        System.out.println("You defeated all the enemies! \n Encounter cleared!\n");
                        break;
                    }
                }
            }

            // --- ENEMY TURN ---

            if (!enemies.isEmpty()) {
                Random random = new Random();
                for (Entity enemy : enemies) {
                    if (party.isEmpty()) {
                        System.out.println("The party has been defeated! Game over!");
                        break;
                    }

                    // Pick a random hero to attack.
                    Entity heroToAttack = party.get(random.nextInt(party.size()));
                    enemy.attack(heroToAttack);

                    //check if picked hero is alive.
                    if (!heroToAttack.isAlive()) {
                        System.out.println(heroToAttack.getName() + " has fallen.");
                        party.remove(heroToAttack);

                    }


                }
            }
        }


    }


}
