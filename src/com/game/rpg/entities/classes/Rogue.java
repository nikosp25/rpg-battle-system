package com.game.rpg.entities.classes;

import com.game.rpg.components.Attributes;
import com.game.rpg.components.CombatStats;
import com.game.rpg.entities.Entity;

public class Rogue extends Entity {
    public Rogue(String name) {
        super(name,new Attributes(150.0,150,150),
                new CombatStats(30.0,0.3,1.4,0.3,0.010,18,25.0,7.0,12.0));

    }

    /**
     * Uses the backstab skill,
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

        double backstab = calculateAttack(false);

        System.out.println(getName() + " uses backstab on " + target.getName() + "!");
        target.takeDamage(backstab,false);
    }


}
