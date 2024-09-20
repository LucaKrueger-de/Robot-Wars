package com.btcag.bootcamp;

import java.util.Scanner;

public class SpielBoard {
    public static void main(String[] args) {
        Scanner readIn = new Scanner(System.in);
        System.out.println("(ง'̀-'́)ง Geben Sie ihren Username ein, bevor es in die Schlacht geht (ง'̀-'́)ง: ");
        String username = readIn.nextLine();
        System.out.println();

        System.out.println("  _____   ____  ____   ____ _______  __          __     _____   _____ \n" +
                " |  __ \\ / __ \\|  _ \\ / __ \\__   __| \\ \\        / /\\   |  __ \\ / ____|\n" +
                " | |__) | |  | | |_) | |  | | | |     \\ \\  /\\  / /  \\  | |__) | (___  \n" +
                " |  _  /| |  | |  _ <| |  | | | |      \\ \\/  \\/ / /\\ \\ |  _  / \\___ \\ \n" +
                " | | \\ \\| |__| | |_) | |__| | | |       \\  /\\  / ____ \\| | \\ \\ ____) |\n" +
                " |_|  \\_\\\\____/|____/ \\____/  |_|        \\/  \\/_/    \\_\\_|  \\_\\_____/ \n" +
                "                                                                     ");
        System.out.println();
        System.out.println("MACH DICH BEREIT ZU KÄMPFEN:" + username);
        System.out.println();

        System.out.println("Hier ist Ihre Avatarauswahl: \n" +
                "Avatar 1 --> §\n" +
                "Avatar 2 --> $\n" +
                "Avatar 3 --> %\n" +
                "Avatar 4 --> &\n" +
                "Avatar 5 --> *\n"
        );

        System.out.println("Wählen Sie ein Symbol als Avatar, oder geben Sie eine Zahl von 1-5 ein: ");
        boolean avatar = true;
        String roboter = "";

        while (avatar) {
            roboter = readIn.nextLine();
            switch (roboter) {
                case "§":
                case "1":
                    roboter = "§";
                    System.out.println(username + " das ist dein Avatar: " + roboter);
                    avatar = false;
                    break;
                case "$":
                case "2":
                    roboter = "$";
                    System.out.println(username + " das ist dein Avatar:" + roboter);
                    avatar = false;
                    break;
                case "%":
                case "3":
                    roboter = "%";
                    System.out.println(username + " das ist dein Avatar:" + roboter);
                    avatar = false;
                    break;
                case "&":
                case "4":
                    roboter = "&";
                    System.out.println(username + " das ist dein Avatar:" + roboter);
                    avatar = false;
                    break;
                case "*":
                case "5":
                    roboter = "*";
                    System.out.println(username + " das ist dein Avatar: " + roboter);
                    avatar = false;
                    break;
                default:
                    System.out.println("Ungültige Avatarauswahl!");
                    break;
            }
        }


        System.out.println();
        System.out.println("Hier sehen Sie das Spielfeld mit Ihrem Avatar: ");
        System.out.println();
        int x = 0;
        int y = 0;
        while (y < 10) {
            x = 0;
            while (x < 15) {
                System.out.print("[  ]");
                x = x + 1;
                if (y == 6 && x == 7) {
                    System.out.print("[ " + roboter + "]");
                    x++;
                }
            }
            System.out.println();
            y++;
        }
    }
}