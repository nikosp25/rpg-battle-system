package com.game.rpg.components;

public class CombatStats {
    private double baseDamage;
    private double crtRate; //Percentage as decimal (0.0 to 1.0) We assume 1.0 is 100% chance
    private double crtDamage; //Percentage as decimal (0.0 to 1.0) We assume 1.0 is 100% chance
    private double dodgeChance; //Percentage as decimal (0.0 to 1.0) We assume 1.0 is 100% chance
    private double blockChance; //Percentage as decimal (0.0 to 1.0) We assume 1.0 is 100% chance
    private int initiative;
    private double armor;
    private double magicDmg;
    private double magicRes;
    private double currentArmor;

    public CombatStats(double baseDamage, double crtRate, double crtDamage, double dodgeChance, double blockChance, int initiative, double armor, double magicDmg, double magicRes) {
        this.baseDamage = baseDamage;
        this.crtRate = crtRate;
        this.crtDamage = crtDamage;
        this.dodgeChance = dodgeChance;
        this.blockChance = blockChance;
        this.initiative = initiative;
        this.armor = armor;
        this.magicDmg = magicDmg;
        this.magicRes = magicRes;
        this.currentArmor = armor;
    }

    public double getBaseDamage() {
        return baseDamage;
    }

    public double getCrtRate() {
        return crtRate;
    }

    public double getCrtDamage() {
        return crtDamage;
    }

    public double getDodgeChance() {
        return dodgeChance;
    }

    public double getBlockChance() {
        return blockChance;
    }

    public int getInitiative() {
        return initiative;
    }

    public double getArmor() {
        return armor;
    }

    public double getMagicDmg() {
        return magicDmg;
    }

    public double getMagicRes() {
        return magicRes;
    }

    public double getCurrentArmor() {
        return currentArmor;
    }

    public void setBaseDamage(double baseDamage) {
        this.baseDamage = baseDamage;
    }

    public void setCrtRate(double crtRate) {
        this.crtRate = crtRate;
    }

    public void setCrtDamage(double crtDamage) {
        this.crtDamage = crtDamage;
    }

    public void setDodgeChance(double dodgeChance) {
        this.dodgeChance = dodgeChance;
    }

    public void setBlockChance(double blockChance) {
        this.blockChance = blockChance;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public void setArmor(double armor) {
        this.armor = armor;
    }

    public void setMagicDmg(double magicDmg) {
        this.magicDmg = magicDmg;
    }

    public void setMagicRes(double magicRes) {
        this.magicRes = magicRes;
    }

    public void setCurrentArmor(double currentArmor) {
        this.currentArmor = currentArmor;
    }

    @Override
    public String toString() {
        return String.format(
                "Offense: [Dmg: %.0f | Mag: %.0f | Crit: %.0f%% (x%.1f)]\n" +
                        "Defense: [Armor: %.0f | Res: %.0f | Block: %.0f%% | Dodge: %.0f%%]\n" +
                        "Utility: [Initiative: %d | Current Armor: %.0f]",
                baseDamage, magicDmg, (crtRate * 100), crtDamage,
                armor, magicRes, (blockChance * 100), (dodgeChance * 100),
                initiative, currentArmor
        );
    }


}


