package com.btcag.bootcamp;


import java.util.Scanner;

public class Robot {
    int HP = 1;
    int energy = 1;
    int shield = 1;
    int damage = 1;
    int range = 1;
    int damageZone = 1;
    int accuracy = 1;
    int movement = 1;
    String userAvatar;

    public Robot(){
        avatar();
        skillPoints();
    }

    public void avatar() {
        System.out.println("Hier ist Ihre Avatarauswahl: \n" +
                "Avatar 1 --> §\n" +
                "Avatar 2 --> $\n" +
                "Avatar 3 --> %\n" +
                "Avatar 4 --> &\n" +
                "Avatar 5 --> *\n"
        );
        Scanner readIn = new Scanner(System.in);
        System.out.println("Wählen Sie ein Symbol als Avatar, oder geben Sie eine Zahl von 1-5 ein: ");
        boolean avatar = true;
        String userAvatar = "";

        while (avatar) {
            userAvatar = readIn.nextLine();
            switch (userAvatar) {
                case "§":
                case "1":
                    userAvatar = "§";
                    avatar = false;
                    break;
                case "$":
                case "2":
                    userAvatar = "$";
                    avatar = false;
                    break;
                case "%":
                case "3":
                    userAvatar = "%";
                    avatar = false;
                    break;
                case "&":
                case "4":
                    userAvatar = "&";
                    avatar = false;
                    break;
                case "*":
                case "5":
                    userAvatar = "*";
                    avatar = false;
                    break;
                default:
                    System.out.println("Ungültige Avatarauswahl!");
                    break;
            }
        }
        this.userAvatar = userAvatar;
    }
    public void skillPoints(){
        System.out.println("=========== PLAYER STATS ===========");
        System.out.printf("| %-12s : %2d |\n", "Health Points", HP);
        System.out.printf("| %-12s : %2d |\n", "Energy", energy);
        System.out.printf("| %-12s : %2d |\n", "Shield", shield);
        System.out.printf("| %-12s : %2d |\n", "Damage", damage);
        System.out.printf("| %-12s : %2d |\n", "Range", range);
        System.out.printf("| %-12s : %2d |\n", "Damage Zone", damageZone);
        System.out.printf("| %-12s : %2d |\n", "Accuracy", accuracy);
        System.out.printf("| %-12s : %2d |\n", "Movement", movement);
        System.out.println("====================================");

        Scanner readIn = new Scanner(System.in);
        System.out.println("Wählen Sie ein Symbol als Avatar, oder geben Sie eine Zahl von 1-5 ein: ");
        boolean avatar = true;
        String userAvatar = "";

        while (avatar) {
            userAvatar = readIn.nextLine();
            switch (userAvatar) {
                case "§":
                case "1":
                    userAvatar = "§";
                    avatar = false;
                    break;
                case "$":
                case "2":
                    userAvatar = "$";
                    avatar = false;
                    break;
                case "%":
                case "3":
                    userAvatar = "%";
                    avatar = false;
                    break;
                case "&":
                case "4":
                    userAvatar = "&";
                    avatar = false;
                    break;
                case "*":
                case "5":
                    userAvatar = "*";
                    avatar = false;
                    break;
                default:
                    System.out.println("Ungültige Avatarauswahl!");
                    break;
            }
        }
        this.userAvatar = userAvatar;


    }



}

