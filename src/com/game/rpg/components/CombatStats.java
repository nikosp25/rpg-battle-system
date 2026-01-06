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
}


