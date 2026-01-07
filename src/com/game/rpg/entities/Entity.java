package com.game.rpg.entities;

import com.game.rpg.components.Attributes;
import com.game.rpg.components.CombatStats;


public class Entity {
    private String name;
    private Attributes attributes;
    private CombatStats combatStats;

    public Entity(String name, Attributes attributes, CombatStats combatStats) {
        this.name = name;
        this.attributes = attributes;
        this.combatStats = combatStats;
    }

    public String getName() {
        return name;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public CombatStats getCombatStats() {
        return combatStats;
    }

    public boolean isAlive() {
        return getAttributes().getCurrentHealth() > 0;
    }

    public boolean isDodged() {
       boolean dodged = Math.random() < getCombatStats().getDodgeChance(); //get a decimal with math.random and checks it against the dodge chance.

        //inform user that they dodged the attack
        if (dodged) {
            System.out.println(getName() + " dodged the attack!");
        }
        return dodged;

    }

    private double blockedDamage(double incomingDamage) {
        if (Math.random() < getCombatStats().getBlockChance()) {
            if (Math.random() < 0.05) {
                System.out.println(getName() + " blocked perfectly and takes no damage!");
                return 0;
            }


            double halvedDamage = incomingDamage * 0.5;
            System.out.println(getName() + " blocked some of the damage!");
            return halvedDamage;
        }
        return incomingDamage;
    }

    public double applyArmor(double incomingDamage) {
        double currentArmor = getCombatStats().getCurrentArmor();

        // calculate the damage taken to armor
        if (currentArmor >= incomingDamage) {
            double newArmorValue = currentArmor - incomingDamage;
            getCombatStats().setCurrentArmor(newArmorValue);

            // inform player that their armor is broken if it reaches 0
            if (newArmorValue == 0) {
                System.out.println(getName() + "'s armor is broken!");
            }
            return 0;
        } else {
            // armor is less than damage
            double damageLeft = incomingDamage - currentArmor;
            getCombatStats().setCurrentArmor(0);

            // inform the player that their armor is broken
            System.out.println(getName() + "'s armor is broken!");
            return damageLeft;
        }
    }

    private void healthDamage(double incomingDamage) {
        double currentHealth = getAttributes().getCurrentHealth();
        double healthAfterDamage = Math.max(0,currentHealth - incomingDamage);
        getAttributes().setCurrentHealth(healthAfterDamage);
        if (healthAfterDamage == 0) {
            System.out.println(getName() + " is dead.");
        }

    }

    public void takeDamage(double incomingDamage) {
        //check if alive
        if (!isAlive()) return;

        //check if they dodged
        if (isDodged()) return;

        //check if they perfect blocked and if not calculate the damage.
        double damageAfterBlock = blockedDamage(incomingDamage);


        //take the remaining damage after block and use it on armor
        double damageAfterArmor = applyArmor(damageAfterBlock);

        //remove the damage that bypassed armor from health
        healthDamage(damageAfterArmor);
    }
}
















