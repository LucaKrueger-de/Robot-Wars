package com.btcag.bootcamp;

import java.util.Random;
import java.util.Scanner;

public class SpielBoard {
    public static Scanner readIn = new Scanner(System.in);
    public static Random random = new Random();
    public static int fieldWidth = 15;
    public static int fieldHeight = 10;
    //---------------------------------------------------String-Variables----------------------------------------------
    public static String username = getName();
    public static String roboter = avatar(username);
    public static String enemy = enemyRobot();
    public static String roboter2 = enemyAvatar(enemy);
    //--------------------------------------------Colors------------------------------------------------------------------
    public static final String red = "\u001B[31m";
    public static final String blue = "\u001B[34m";
    public static final String yellow = "\u001B[93m";
    public static final String green = "\u001B[32m";
    public static final String purple = "\u001B[35m";
    public static final String RESET = "\u001B[0m";
    public static String[] colors = {red, blue, yellow, green, purple};

    //----------------------------------------------------Intro-------------------------------------------------------------
    public static void intro() {

        System.out.println();
        String text =("  _____   ____  ____   ____ _______  __          __     _____   _____ \n" +
                " |  __ \\ / __ \\|  _ \\ / __ \\__   __| \\ \\        / /\\   |  __ \\ / ____|\n" +
                " | |__) | |  | | |_) | |  | | | |     \\ \\  /\\  / /  \\  | |__) | (___  \n" +
                " |  _  /| |  | |  _ <| |  | | | |      \\ \\/  \\/ / /\\ \\ |  _  / \\___ \\ \n" +
                " | | \\ \\| |__| | |_) | |__| | | |       \\  /\\  / ____ \\| | \\ \\ ____) |\n" +
                " |_|  \\_\\\\____/|____/ \\____/  |_|        \\/  \\/_/    \\_\\_|  \\_\\_____/ \n" +
                "                                                                     ");

    for (int i = 0; i < text.length(); i++) {
        System.out.print(colors[i % colors.length] + text.charAt(i) + RESET);
    }

        System.out.println("MACH DICH BEREIT ZU KÄMPFEN");
        System.out.println();
    }
    //----------------------------------------------------Spielername-------------------------------------------------------------

    private static String getName() {
        String username;
        do {
            System.out.println("(ง'̀-'́)ง Geben Sie ihren Username ein, bevor es in die Schlacht geht (ง'̀-'́)ง: ");
            username = readIn.nextLine();
        } while (username.length() < 3 || username.length() > 15);
        return username;
    }

    //----------------------------------------------------Player-Avatar-------------------------------------------------------------
    public static String avatar(String username) {
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
                    System.out.println(username + ", das ist dein Avatar:" + roboter);
                    avatar = false;
                    break;
                case "%":
                case "3":
                    roboter = "%";
                    System.out.println(username + ", das ist dein Avatar:" + roboter);
                    avatar = false;
                    break;
                case "&":
                case "4":
                    roboter = "&";
                    System.out.println(username + ", das ist dein Avatar:" + roboter);
                    avatar = false;
                    break;
                case "*":
                case "5":
                    roboter = "*";
                    System.out.println(username + ", das ist dein Avatar: " + roboter);
                    avatar = false;
                    break;
                default:
                    System.out.println("Ungültige Avatarauswahl!");
                    break;
            }
        }
        return roboter;
    }

    //----------------------------------------------------Enemy-Robot-------------------------------------------------------------
    public static String enemyRobot() {
        String enemy;
        System.out.println();
        System.out.println("Wie soll ihr Gegner heißen? ");
        enemy = readIn.nextLine();

        return enemy;
    }

    //----------------------------------------------------Enemy-Symbol-------------------------------------------------------------
    public static String enemyAvatar(String enemy) {
        System.out.println();

        System.out.println("Wählen Sie ein Symbol als Gegner, oder geben Sie eine Zahl von 1-5 ein: ");
        System.out.println();
        System.out.println("Avatar 1 --> §\n" +
                "Avatar 2 --> $\n" +
                "Avatar 3 --> %\n" +
                "Avatar 4 --> &\n" +
                "Avatar 5 --> *\n");

        boolean avatar = true;
        String roboter2 = "";

        while (avatar) {
            roboter2 = readIn.nextLine();
            switch (roboter2) {
                case "§":
                case "1":
                    roboter2 = "§";
                    System.out.println(enemy + " ,so heißt dein Gegner und er hat dieses Symbol: " + roboter2);
                    avatar = false;
                    break;
                case "$":
                case "2":
                    roboter2 = "$";
                    System.out.println(enemy + ",so heißt dein Gegner und er hat dieses Symbol: " + roboter2);
                    avatar = false;
                    break;
                case "%":
                case "3":
                    roboter2 = "%";
                    System.out.println(enemy + ",so heißt dein Gegner und er hat dieses Symbol: " + roboter2);
                    avatar = false;
                    break;
                case "&":
                case "4":
                    roboter2 = "&";
                    System.out.println(enemy + ",so heißt dein Gegner und er hat dieses Symbol: " + roboter2);
                    avatar = false;
                    break;
                case "*":
                case "5":
                    roboter2 = "*";
                    System.out.println(enemy + ", so heißt dein Gegner und er hat dieses Symbol: " + roboter2);
                    avatar = false;
                    break;
                default:
                    System.out.println("Ungültige Avatarauswahl! ");
                    break;
            }
            System.out.println();
        }
        return roboter2;
    }


    //----------------------------------------------------Spielzug-------------------------------------------------------------

    public static void turn(String username, String enemy, String roboter, String roboter2) {
        System.out.println("\n\n\n");


        int x1 = 0, y1 = 0;
        int x2 = 14, y2 = 9;

        while (true) {
            System.out.println(red + username + ": " + roboter + RESET + "                                                                 " + blue + enemy + ": " + roboter2 + "\n" + RESET);
            System.out.print("    ");
            for (int c = 0; c < fieldWidth; c++) {
                System.out.printf(" %2d  ", c);
            }
            System.out.println();
            for (int i = 0; i < fieldHeight; i++) {
                System.out.printf(" %2d ", i);
                for (int j = 0; j < fieldWidth; j++) {
                    if (i == y1 && j == x1) {
                        System.out.print("[" + red + roboter + RESET + "]");
                    } else if (i == y2 && j == x2) {
                        System.out.print("[" + blue + roboter2 + RESET + "]");
                    } else {
                        System.out.print("[ ]");
                    }
                }
                System.out.println();
            }

            System.out.println(username + ", wo willst du deinen Roboter hinbewegen?");
            System.out.print("X-Koordinate (0-" + (fieldWidth - 1) + "): ");
            int newX = readIn.nextInt();
            System.out.print("Y-Koordinate (0-" + (fieldHeight - 1) + "): ");
            int newY = readIn.nextInt();

            if (newX >= 0 && newX < fieldWidth && newY >= 0 && newY < fieldHeight) {
                x1 = newX;
                y1 = newY;
            } else {
                System.out.println("Ungültige Koordinaten für " + username + ". Bitte versuche es erneut.");
            }

            System.out.println("\nNach dem Zug von " + username + "\n");

            System.out.println(red + username + ": " + roboter + RESET + "                                                                 " + blue + enemy + ": " + roboter2 + "\n" + RESET);
            System.out.print("    ");
            for (int c = 0; c < fieldWidth; c++) {
                System.out.printf(" %2d  ", c);
            }
            System.out.println();
            for (int i = 0; i < fieldHeight; i++) {
                System.out.printf("%2d  ", i);
                for (int j = 0; j < fieldWidth; j++) {
                    if (i == y1 && j == x1) {
                        System.out.print("[" + red + roboter + RESET + "]");
                    } else if (i == y2 && j == x2) {
                        System.out.print("[" + blue + roboter2 + RESET + "]");
                    } else {
                        System.out.print("[ ]");
                    }
                }
                System.out.println();
            }

            System.out.println(enemy + ", wo willst du deinen Roboter hinbewegen?");
            System.out.print("X-Koordinate (0-" + (fieldWidth - 1) + "): ");
            int newX2 = readIn.nextInt();
            System.out.print("Y-Koordinate (0-" + (fieldHeight - 1) + "): ");
            int newY2 = readIn.nextInt();

            if (newX2 >= 0 && newX2 < fieldWidth && newY2 >= 0 && newY2 < fieldHeight) {
                x2 = newX2;
                y2 = newY2;
            } else {
                System.out.println("Ungültige Koordinaten für " + enemy + ". Bitte versuche es erneut.");
            }

            System.out.println("\nNach dem Zug von " + enemy + ":");

            System.out.println("\n\n\n");

            if (x1 == x2 && y1 == y2) {
                System.out.println("Beide Roboter haben sich getroffen!");
                int winner = random.nextInt(0, 2);
                if (winner == 1) {
                    System.out.println(username + " hat gewonnen!");
                } else {
                    System.out.println(enemy + " hat gewonnen!");
                }
                break;
            }
        }
    }

    public static void main(String[] args) {
        intro();
        turn(username, enemy, roboter, roboter2);
    }
}


















