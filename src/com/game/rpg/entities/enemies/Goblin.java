package com.game.rpg.entities.enemies;

import com.game.rpg.components.Attributes;
import com.game.rpg.components.CombatStats;
import com.game.rpg.entities.Entity;

public class Goblin extends Entity {
    public Goblin () {
        super("Goblin",new Attributes(100.0,120,0),
                new CombatStats(12.0,0.30,1.0,0.25,0.0,20,2.0,0.0,1.0));
    }

    /**
     * goblin specific skills,
     * costs 20 stamina
     * @param target the entity to attack.
     */

    @Override
    public void attack(Entity target) {
        int cost = 20;
        if (!spendStamina(cost)){
            return;
        }
        double quickstab = calculateAttack(false);
        System.out.println(getName() + " used Quick stab on " + target.getName() + "!");
        target.takeDamage(quickstab,false);


    }
}
