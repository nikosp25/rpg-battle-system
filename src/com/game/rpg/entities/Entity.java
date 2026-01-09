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

    @Override
    public String toString() {
        return "Entity{" +
                "name = '" + name + '\'' +
                ", \n attributes = " + attributes +
                ", \n combatStats = " + combatStats +
                '}';
    }

    // ========================================================================
    //                          DEFENSE LOGIC
    // ========================================================================

    /**
     * Checks if the entity's current health is > 0 .
     * @return true if current health > 0, false otherwise.
     */
    public boolean isAlive() {
        return getAttributes().getCurrentHealth() > 0;
    }

    /**
     * Uses Math.random against the dodge chance of the entity to check if they dodge the attack.
     * @return true if the roll is less than the getDodgeChance value, false otherwise.
     */
    public boolean isDodged() {
       boolean dodged = Math.random() < getCombatStats().getDodgeChance(); //get a decimal with math.random and checks it against the dodge chance.

        //inform user that they dodged the attack
        if (dodged) {
            System.out.println(getName() + " dodged the attack!");
        }
        return dodged;

    }

    /**
     * uses Math.random against the entity's block chance to see if they either, don't block at all,
     * partially block if the dice roll < entity's block chance and if they succeed the first roll,
     * it rolls one more time to see if they fully blocked all the damage.
     * @param incomingDamage the full damage value before the method is applied.
     * @return 0 if fully blocked, 50% of the incoming damage if partially blocked and 100% of the
     * incoming damage if they didn't block at all.
     *
     */
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



    /**
     * Checks the incoming damage value against the entity's current armor value.
     * if the incoming damage exceeds the current armor value, then the armor value becomes 0 and the remaining damage is returned.
     *
     * @param incomingDamage the value to check against the armor value.
     * @return the damage that passed through the armor if any.
     */
    public double applyArmor(double incomingDamage) {
        double currentArmor = getCombatStats().getCurrentArmor();
        double damageLeft = 0;

        // calculate the damage taken to armor
        if (currentArmor >= incomingDamage) {
            double newArmorValue = currentArmor - incomingDamage;
            getCombatStats().setCurrentArmor(newArmorValue);
            damageLeft = 0;
        } else {
            // armor is less than damage
            damageLeft = incomingDamage - currentArmor;
            getCombatStats().setCurrentArmor(0);
        }

        // inform the player if their armor is broken.
        if (getCombatStats().getCurrentArmor() == 0) {
            System.out.println(getName() + "'s armor is broken!");
        }

        return damageLeft;

    }

    /**
     * Deducts the magic resist value from the incoming damage
     * @param incomingDamage the original damage.
     * @return the damage after the deduction
     */
    private double magicResist(double incomingDamage) {
        double magicRes = getCombatStats().getMagicRes();
        return Math.max(0,incomingDamage - magicRes);

    }

    /**
     * Deducts the incoming damage from the current health value and
     * uses Math.max to ensure that health will never go below 0.
     *
     * @param incomingDamage the damage to deduct from health.
     */
    private void healthDamage(double incomingDamage) {
        double currentHealth = getAttributes().getCurrentHealth();
        double healthAfterDamage = Math.max(0,currentHealth - incomingDamage);
        getAttributes().setCurrentHealth(healthAfterDamage);
        if (healthAfterDamage == 0) {
            System.out.println(getName() + " is dead.");
        }

    }

    /**
     * Takes a damage value and filters it to see if
     * 1) the target is alive
     * 2) If the target dodged
     * 3) If they blocked any damage.
     * 4) If the attack is magic or not and applies
     * the correct resist (magic or armor)
     * 5)Deducts the damage value after the filters from health.
     *
     *
     * @param incomingDamage the value before being filtered.
     */
    public void takeDamage(double incomingDamage, boolean isMagic) {
        //check if alive
        if (!isAlive()) return;

        //check if they dodged
        if (isDodged()) return;

        //check if they perfect blocked and if not calculate the damage.
        double damageAfterBlock = blockedDamage(incomingDamage);

        //check if attack is magic or not
        double finalDamage;
        //if its magic, use magic resist.
        if (isMagic) {
            finalDamage = magicResist(damageAfterBlock);

        //if its not magic use armor.
        }else {
             finalDamage = applyArmor(damageAfterBlock);
        }


        //remove the damage that bypassed armor from health
        healthDamage(finalDamage);

    }


    // ========================================================================
    //                          ATTACK LOGIC
    // ========================================================================

    public void attack(Entity target) {
        System.out.println("entity attacks");
    }

    /**
     * Checks the entity's current stamina to see if they can afford to use their skill
     * and deducts the cost from their stamina pool if they can.
     * @param cost the cost of the skill
     * @return true if they have enough stamina, false otherwise.
     */
    protected boolean spendStamina(int cost) {
        int currentStamina = getAttributes().getCurrentStamina();
        if (cost <= currentStamina) {
            getAttributes().setCurrentStamina(currentStamina - cost);
            return true;
        }else {
            System.out.println("Not enough stamina!");
            return false;
        }


    }

    /**
     * Checks the entity's current mana to see if they can afford to cast
     * and deducts the cost from their mana pool if they can.
     * @param cost the cost of the spell.
     * @return true if they have enough mana, false otherwise.
     */
    protected boolean spendMana(int cost) {
        int currentMana = getAttributes().getCurrentMana();
        if (cost <= currentMana) {
            getAttributes().setCurrentMana(currentMana - cost);
            return true;
        } else {
            System.out.println("Not enough mana!");
            return false;

        }
    }

    /**
     * Uses Math.random against the entity's crtRate to see if they actually critically striked.
     * @return true if Math.random < get.crtRate, false otherwise.
     */
    private boolean isCrit() {
        return Math.random() < getCombatStats().getCrtRate();
    }


    /**
     * Takes in a damage value and calculates its critical damage using a
     * Damage * ( 1 + Critical damage) formula.
     * @param damage the damage to calculate.
     * @return the damage value after the critical damage calculation.
     */
    private double crtDamageCalculator(double damage) {
        double criticalDamage = getCombatStats().getCrtDamage();
        return damage * (1 + criticalDamage);

    }

    /**
     * Calculates the damage base of the type of the attack. (Magic or not)
     * @param isMagic this is true if it is a magic attack, false otherwise.
     * @return the final damage after the calculations.
     */
    public double calculateAttack(boolean isMagic) {
        //check if the attack is magic or not
        double damageType = isMagic ? getCombatStats().getMagicDmg() : getCombatStats().getBaseDamage();

        //check if the attack is a crit
        if (isCrit()) {
            double crtDamage = crtDamageCalculator(damageType);
            System.out.println(getName() + " landed a critical!");
            return crtDamage;

        }

        return damageType;

    }

}
















