package com.game.rpg.entities.classes;

import com.game.rpg.components.Attributes;
import com.game.rpg.components.CombatStats;
import com.game.rpg.entities.Entity;

public class Mage extends Entity {
    public Mage (String name) {
        super(name,
                new Attributes(100.0,100,200),
                new CombatStats(10.0,0.05,2.0,0.07,0.01,6,15.0,40.0,25.0));
    }

}
