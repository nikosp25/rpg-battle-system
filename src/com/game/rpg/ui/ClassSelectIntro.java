package com.game.rpg.ui;

import com.game.rpg.entities.classes.Knight;
import com.game.rpg.entities.classes.Mage;
import com.game.rpg.entities.classes.Rogue;

public class ClassSelectIntro {
    public static void printClass() {
        System.out.println("""
                ╔════════════════════════════════════════════════════════════════╗
                ║                                                                ║
                ║                    🏰 CHOOSE YOUR CLASS 🏰                       ║
                ║                                                                ║
                ║  1) Mage   🔮  - Wielder of forbidden arcane powers            ║
                ║  2) Knight ⚔️  - Valiant protector of the realm               ║
                ║  3) Rogue  🗡️  - Shadowy assassin with deadly skill           ║
                ║                                                                ║
                ║                                              ║
                ╚════════════════════════════════════════════════════════════════╝
                """);


    }

    public static void showStats() {
        // --- DISPLAY STATS START ---
        Knight k = new Knight("Info");
        Mage m = new Mage("Info");
        Rogue r = new Rogue("Info");

        System.out.println("\n══════════════ CLASS DETAILS ══════════════");

        // 1. KNIGHT
        System.out.println("1. KNIGHT (Tank)");
        System.out.println("   [Attributes] HP: " + k.getAttributes().getMaxHealth() + " | Stam: " + k.getAttributes().getMaxStamina() + " | Mana: " + k.getAttributes().getMaxMana());
        System.out.println("   [Offense]    Dmg: " + k.getCombatStats().getBaseDamage() + " | Mag Dmg: " + k.getCombatStats().getMagicDmg());
        System.out.println("                Crit: " + (k.getCombatStats().getCrtRate() * 100) + "% (x" + k.getCombatStats().getCrtDamage() + ")");
        System.out.println("   [Defense]    Armor: " + k.getCombatStats().getArmor() + " | Mag Res: " + k.getCombatStats().getMagicRes());
        System.out.println("                Block: " + (k.getCombatStats().getBlockChance() * 100) + "% | Dodge: " + (k.getCombatStats().getDodgeChance() * 100) + "%");
        System.out.println("───────────────────────────────────────────");

        // 2. MAGE
        System.out.println("2. MAGE (Magic DPS)");
        System.out.println("   [Attributes] HP: " + m.getAttributes().getMaxHealth() + " | Stam: " + m.getAttributes().getMaxStamina() + " | Mana: " + m.getAttributes().getMaxMana());
        System.out.println("   [Offense]    Dmg: " + m.getCombatStats().getBaseDamage() + " | Mag Dmg: " + m.getCombatStats().getMagicDmg());
        System.out.println("                Crit: " + (m.getCombatStats().getCrtRate() * 100) + "% (x" + m.getCombatStats().getCrtDamage() + ")");
        System.out.println("   [Defense]    Armor: " + m.getCombatStats().getArmor() + " | Mag Res: " + m.getCombatStats().getMagicRes());
        System.out.println("                Block: " + (m.getCombatStats().getBlockChance() * 100) + "% | Dodge: " + (m.getCombatStats().getDodgeChance() * 100) + "%");
        System.out.println("───────────────────────────────────────────");

        // 3. ROGUE
        System.out.println("3. ROGUE (Speed/Crit)");
        System.out.println("   [Attributes] HP: " + r.getAttributes().getMaxHealth() + " | Stam: " + r.getAttributes().getMaxStamina() + " | Mana: " + r.getAttributes().getMaxMana());
        System.out.println("   [Offense]    Dmg: " + r.getCombatStats().getBaseDamage() + " | Mag Dmg: " + r.getCombatStats().getMagicDmg());
        System.out.println("                Crit: " + (r.getCombatStats().getCrtRate() * 100) + "% (x" + r.getCombatStats().getCrtDamage() + ")");
        System.out.println("   [Defense]    Armor: " + r.getCombatStats().getArmor() + " | Mag Res: " + r.getCombatStats().getMagicRes());
        System.out.println("                Block: " + (r.getCombatStats().getBlockChance() * 100) + "% | Dodge: " + (r.getCombatStats().getDodgeChance() * 100) + "%");
        System.out.println("═══════════════════════════════════════════\n");

        System.out.println("Type 1, 2 or 3 to choose : ");
        // --- DISPLAY STATS END ---
    }

    public static void chooseName() {
        System.out.println("""
                ╔════════════════════════════════════════╗
                ║                                        ║
                ║       ✦ Choose Your Character's Name ✦ ║
                ║                                        ║
                ╚════════════════════════════════════════╝
                """);



    }


}


