package com.btcag.bootcamp.OldVersions;


public class Game {

    public static void main(String[] args) {

        System.out.println
                ("  _____   ____  ____   ____ _______  __          __     _____   _____ \n" +
                        " |  __ \\ / __ \\|  _ \\ / __ \\__   __| \\ \\        / /\\   |  __ \\ / ____|\n" +
                        " | |__) | |  | | |_) | |  | | | |     \\ \\  /\\  / /  \\  | |__) | (___  \n" +
                        " |  _  /| |  | |  _ <| |  | | | |      \\ \\/  \\/ / /\\ \\ |  _  / \\___ \\ \n" +
                        " | | \\ \\| |__| | |_) | |__| | | |       \\  /\\  / ____ \\| | \\ \\ ____) |\n" +
                        " |_|  \\_\\\\____/|____/ \\____/  |_|        \\/  \\/_/    \\_\\_|  \\_\\_____/ \n" +
                        "                                                                     ");

        Player player1 = new Player("");
        player1.getName();
        Player player2 = new Player("");
        player2.getName();

        Robot robot1 = new Robot(player1);
        Robot robot2 = new Robot(player2);


        System.out.println("Spieler:  " + player1.username + " " + robot1.userAvatar + " " + player2.username + " " + robot2.userAvatar);
        System.out.println("HealthPoints: " + robot1.HP + " || " + robot2.HP);
        System.out.println("DamagePoints: " + robot1.damage + " || " + robot2.damage);
        System.out.println("Range:        " + robot1.range + " || " + robot2.range);
        System.out.println("Movement:     " + robot1.movement + " || " + robot2.movement);

        Map map = new Map();
        map.updateGame(player1,player2,robot1,robot2);

    }
}
