package com.game.rpg.ui;

public class Intro {


    /**
     * prints the into in the console using threads to print each line with a 250ms delay.
     * @throws InterruptedException if sleep is interrupted.
     */
    public static void play() throws InterruptedException {

        String[] intro = {
                "╔════════════════════════════════════════════════════════════╗",
                "║                                                            ║",
                "║      W E L C O M E   T O   T H E   D U N G E O N             ║",
                "║                                                            ║",
                "║      ████▓▒░  blood drips from the ceiling…  ░▒▓████       ║",
                "║                                                            ║",
                "║          🩸   drip…      drip…      drip…   🩸             ║",
                "║                                                            ║",
                "║      ☠  chains creak… something breathes… ☠               ║",
                "║                                                            ║",
                "║      ████▓▒░  you should not have come here  ░▒▓████       ║",
                "║                                                            ║",
                "╚════════════════════════════════════════════════════════════╝"
        };

        for (String line : intro) {
            System.out.println(line);
            Thread.sleep(250);
        }


    }


}

