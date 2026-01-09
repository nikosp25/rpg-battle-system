package com.game.rpg.entities.enemies;

import com.game.rpg.components.Attributes;
import com.game.rpg.components.CombatStats;
import com.game.rpg.entities.Entity;

public class Dragon extends Entity {
    public Dragon() {
        super("Borgoth",new Attributes(600.0, 300, 200),
                new CombatStats(40.0, 0.20, 0.50, 0.10, 0.10, 15, 20.0, 50.0, 20.0));
    }


    /**
     * Dragon specific magic attack
     * cost 50 mana
     * @param target the entity to attack.
     */

    @Override
    public void attack (Entity target) {
        int cost = 50;
        if (!spendMana(cost)){
            return;
        }

        double flamebreath = calculateAttack(true);
        System.out.println(getName() + " used flame breath on " + target.getName() + "!");
        target.takeDamage(flamebreath,true);
    }
}
