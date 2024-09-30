package com.btcag.bootcamp;
import java.util.Random;
import java.util.Scanner;

public class SpielBoard {
    public static Scanner readIn = new Scanner(System.in);
    public static Random random = new Random();


    public static void main(String[] args) {
        intro();
        String username = getName();
        String roboter = avatar(username);
        String enemy = enemyRobot();
        String roboter2 = enemyAvatar(enemy);


        drawFieldwithPlayer(roboter, username, roboter2, enemy);
        turn(roboter, roboter2);
    }


    //----------------------------------------------------FieldWithPlayer-------------------------------------------------------------
    public static void drawFieldwithPlayer(String roboter, String username, String enemy, String roboter2) {
        System.out.println("Hier sehen Sie das Spielfeld mit Ihrem Avatar und ihrem Gegner: ");
        System.out.println();
        System.out.println(username + " " + roboter + "                                                 " + roboter2 + " " + enemy);
        int x = 0;
        int y = 0;
        while (y < 10) {
            x = 0;
            while (x < 15) {
                System.out.print("[  ]");
                x = x + 1;
                if (y == 6 && x == 14) {
                    System.out.print("[ " + roboter + "]");
                    x++;
                }
                if (y == 6 && x == 1) {
                    System.out.print("[ " + enemy + "]");
                    x++;
                }
            }
            System.out.println();
            y++;
        }
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

    //----------------------------------------------------Intro-------------------------------------------------------------
    public static void intro() {

        System.out.println();
        System.out.println("  _____   ____  ____   ____ _______  __          __     _____   _____ \n" +
                " |  __ \\ / __ \\|  _ \\ / __ \\__   __| \\ \\        / /\\   |  __ \\ / ____|\n" +
                " | |__) | |  | | |_) | |  | | | |     \\ \\  /\\  / /  \\  | |__) | (___  \n" +
                " |  _  /| |  | |  _ <| |  | | | |      \\ \\/  \\/ / /\\ \\ |  _  / \\___ \\ \n" +
                " | | \\ \\| |__| | |_) | |__| | | |       \\  /\\  / ____ \\| | \\ \\ ____) |\n" +
                " |_|  \\_\\\\____/|____/ \\____/  |_|        \\/  \\/_/    \\_\\_|  \\_\\_____/ \n" +
                "                                                                     ");
        System.out.println();
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

    public static void turn(String roboter2, String roboter) {
        System.out.println("\n\n\n");


        int fieldWidth = 15;
        int fieldHeight = 10;

        int x1 = 0, y1 = 0;
        int x2 = 14, y2 = 9;

        while (true) {
            for (int i = 0; i < fieldHeight; i++) {
                for (int j = 0; j < fieldWidth; j++) {
                    if (i == y1 && j == x1) {
                        System.out.print("[ " + roboter + " ]");
                    } else if (i == y2 && j == x2) {
                        System.out.print("[ " + roboter2 + " ]");
                    } else {
                        System.out.print("[   ]");
                    }
                }
                System.out.println();
            }

            System.out.println(roboter + ", wo willst du deinen Roboter hinbewegen?");
            System.out.print("X-Koordinate (0-" + (fieldWidth - 1) + "): ");
            int newX = readIn.nextInt();
            System.out.print("Y-Koordinate (0-" + (fieldHeight - 1) + "): ");
            int newY = readIn.nextInt();

            if (newX >= 0 && newX < fieldWidth && newY >= 0 && newY < fieldHeight) {
                x1 = newX;
                y1 = newY;
            } else {
                System.out.println("Ungültige Koordinaten für " + roboter + ". Bitte versuche es erneut.");
            }

            System.out.println("\nNach dem Zug von " + roboter + ":");

            for (int i = 0; i < fieldHeight; i++) {
                for (int j = 0; j < fieldWidth; j++) {
                    if (i == y1 && j == x1) {
                        System.out.print("[ " + roboter + " ]");
                    } else if (i == y2 && j == x2) {
                        System.out.print("[ " + roboter2 + " ]");
                    } else {
                        System.out.print("[   ]");
                    }
                }
                System.out.println();
            }

            System.out.println(roboter2 + ", wo willst du deinen Roboter hinbewegen?");
            System.out.print("X-Koordinate (0-" + (fieldWidth - 1) + "): ");
            int newX2 = readIn.nextInt();
            System.out.print("Y-Koordinate (0-" + (fieldHeight - 1) + "): ");
            int newY2 = readIn.nextInt();

            if (newX2 >= 0 && newX2 < fieldWidth && newY2 >= 0 && newY2 < fieldHeight) {
                x2 = newX2;
                y2 = newY2;
            } else {
                System.out.println("Ungültige Koordinaten für " + roboter2 + ". Bitte versuche es erneut.");
            }

            System.out.println("\nNach dem Zug von " + roboter2 + ":");

            System.out.println("\n\n\n");

            if (x1 == x2 && y1 == y2) {
                System.out.println("Beide Roboter haben sich getroffen!");
                int winner = random.nextInt(2) + 1;
                if (winner == 1) {
                    System.out.println(roboter + " hat gewonnen!");
                } else {
                    System.out.println(roboter2 + " hat gewonnen!");
                }
                break;
            }
        }
    }
}
//----------------------------------------------------Win-------------------------------------------------------------






