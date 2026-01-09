package com.game.rpg.entities.enemies;

import com.game.rpg.components.Attributes;
import com.game.rpg.components.CombatStats;
import com.game.rpg.entities.Entity;

public class Orc extends Entity {
    public Orc() {
        super("Orc",new Attributes(300.0,200,0),
                new CombatStats(25.0,0.15,0.50,0.05,0.10,5,10.0,0.0,2.0));
    }

    /**
     * Orc specific physical skill.
     * costs 40 stamina
     * @param target the entity to attack.
     */

    @Override
    public void attack (Entity target) {
        int cost = 40;
        if (!spendStamina(cost)) {
            return;
        }

        double clubAttack = calculateAttack(false);

        System.out.println(getName()+ " smashes" + target.getName() + " with its club!");
        target.takeDamage(clubAttack,false);
    }
}
