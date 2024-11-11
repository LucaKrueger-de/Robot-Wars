package com.btcag.bootcamp.OldVersions;

import java.util.Scanner;

public class PlayerMover {
    Scanner readIn = new Scanner(System.in);
    int fieldHeight = 10;
    int fieldWidth = 15;
    public void movePlayer(Player player, Robot robot) {
        int newX = player.x;
        int newY = player.y;
        while (robot.movement > 0) {
            System.out.println("Wohin wollen Sie laufen ?: (w),(a),(s),(d)");
            String direction = readIn.nextLine();
            switch (direction) {
                case "w":
                    if (player.y > 0 && robot.movement > 0) {
                        newY = player.y - 1;
                        robot.movement--;
                    }
                    break;
                case "a":
                    if (player.x > 0 && robot.movement > 0) {
                        newX = player.x - 1;
                        robot.movement--;
                    }
                    break;
                case "s":
                    if (player.y < fieldHeight - 1 && robot.movement > 0) {
                        newY = player.y + 1;
                        robot.movement--;
                    }
                    break;
                case "d":
                    if (player.x < fieldWidth - 1 && robot.movement > 0) {
                        newX = player.x + 1;
                        robot.movement--;
                    }
                    break;
                default:
                    System.out.println("Ungültige Eingabe!");
                    break;
            }
        }

    }
}
