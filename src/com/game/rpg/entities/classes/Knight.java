package com.game.rpg.entities.classes;

import com.game.rpg.components.Attributes;
import com.game.rpg.components.CombatStats;
import com.game.rpg.entities.Entity;

public class Knight extends Entity {
    public Knight(String name) {
        super(name,new Attributes(200.0,200,100),
                new CombatStats(50.0,0.15,1.4,0.03,0.4,12,45.0,10.0,20.0));
    }


    /**
     * Uses the decapitation skill,
     * costs 20 stamina.
     * Deals damage based of the physical dmg stat.
     * @param target the entity to attack.
     */

    @Override
    public void attack(Entity target) {
        int cost = 20;
        if (!spendStamina(cost)){
            return;
        }

        double decapitation = calculateAttack(false);

        System.out.println(getName() + " uses decapitation on " + target.getName() + "!");
        target.takeDamage(decapitation,false);
    }
}
