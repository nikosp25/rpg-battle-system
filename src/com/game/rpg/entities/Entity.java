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


}
