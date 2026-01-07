package com.game.rpg.entities.classes;

import com.game.rpg.components.Attributes;
import com.game.rpg.components.CombatStats;
import com.game.rpg.entities.Entity;

public class Rogue extends Entity {
    public Rogue(String name) {
        super(name,new Attributes(150.0,150,150),
                new CombatStats(30.0,0.3,1.4,0.3,0.010,18,25.0,7.0,12.0));

    }
}
