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
    int SkillPoints;

    public Robot() {
        avatar();
        skillPoints();
    }

    public void avatar() {
        System.out.println("===============AVATAR============");
        System.out.println(" Wählen Sie ein Symbol als Avatar");
        System.out.println(" oder geben Sie eine Zahl von 1-5 ein:");
        System.out.println("=================================");
        System.out.println("1 - §");
        System.out.println("2 - $");
        System.out.println("3 - %");
        System.out.println("4 - &");
        System.out.println("5 - *");
        System.out.println("=================================");

        Scanner readIn = new Scanner(System.in);
        System.out.println("Ihre Wahl: ");
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


    public void skillPoints() {
        Scanner readIn = new Scanner(System.in);
        System.out.println("Verteilen Sie ihre Skillpunkte: ");
        int points = 10;
        String skillPoints = "";
        System.out.println();
        while (points > 0) {
            playerStats();
            System.out.println("Punkte zur Verfügung: " + points);
            skillPoints = readIn.nextLine();
            switch (skillPoints) {
                case "hp":
                    this.HP++;
                    points--;
                    break;
                case "energy":
                    this.energy++;
                    points--;
                    break;
                case "shield":
                    this.shield++;
                    points--;
                    break;
                case "damage":
                    this.damage++;
                    points--;
                    break;
                case "range":
                    this.range++;
                    points--;
                    break;
                case "damageZone":
                    this.damageZone++;
                    points--;
                    break;
                case "accuracy":
                    this.accuracy++;
                    points--;
                    break;
                case "movement":
                    this.movement++;
                    points--;
                    break;
                default:
                    System.out.println("Ungültige Skillpunkte!");
                    break;
            }
        }
        this.SkillPoints = points;

    }

    public void playerStats() {
        System.out.println("===========PLAYER STATS=============");
        System.out.printf("| %-12s : %2d |\n", "HealthPoints", HP);
        System.out.printf("| %-12s : %2d |\n", "Energy", energy);
        System.out.printf("| %-12s : %2d |\n", "Shield", shield);
        System.out.printf("| %-12s : %2d |\n", "Damage", damage);
        System.out.printf("| %-12s : %2d |\n", "Range", range);
        System.out.printf("| %-12s : %2d |\n", "Damage Zone", damageZone);
        System.out.printf("| %-12s : %2d |\n", "Accuracy", accuracy);
        System.out.printf("| %-12s : %2d |\n", "Movement", movement);
        System.out.println("====================================");
    }
}

