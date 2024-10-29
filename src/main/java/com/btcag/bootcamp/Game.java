package com.btcag.bootcamp;

public class Game {

    public static void main(String[] args) {

        Player p1 = new Player();
        Player p2 = new Player();
        Robot r1 = new Robot();
        Robot r2 = new Robot();

        System.out.println
                ("  _____   ____  ____   ____ _______  __          __     _____   _____ \n" +
                        " |  __ \\ / __ \\|  _ \\ / __ \\__   __| \\ \\        / /\\   |  __ \\ / ____|\n" +
                        " | |__) | |  | | |_) | |  | | | |     \\ \\  /\\  / /  \\  | |__) | (___  \n" +
                        " |  _  /| |  | |  _ <| |  | | | |      \\ \\/  \\/ / /\\ \\ |  _  / \\___ \\ \n" +
                        " | | \\ \\| |__| | |_) | |__| | | |       \\  /\\  / ____ \\| | \\ \\ ____) |\n" +
                        " |_|  \\_\\\\____/|____/ \\____/  |_|        \\/  \\/_/    \\_\\_|  \\_\\_____/ \n" +
                        "                                                                     ");
        System.out.println("Spieler 1: " + p1.username + " " + r1.userAvatar + "                                  " + "Spieler 2: " + p2.username + " " + r2.userAvatar);
    }
}
