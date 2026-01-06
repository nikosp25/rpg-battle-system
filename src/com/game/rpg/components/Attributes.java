package com.game.rpg.components;

public class Attributes {
    private double maxHealth;
    private double currentHealth;
    private int maxStamina;
    private int currentStamina;
    private int maxMana;
    private int currentMana;

    public Attributes(double maxHealth, int maxStamina, int maxMana) {
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.maxStamina = maxStamina;
        this.currentStamina = maxStamina;
        this.maxMana = maxMana;
        this.currentMana = maxMana;
    }

    public double getMaxHealth() {
        return maxHealth;
    }

    public double getCurrentHealth() {
        return currentHealth;
    }

    public int getMaxStamina() {
        return maxStamina;
    }

    public int getCurrentStamina() {
        return currentStamina;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public int getCurrentMana() {
        return currentMana;
    }
}
