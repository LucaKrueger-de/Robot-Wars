package OldVersions;


import java.util.Scanner;

public class Robot {
    int HP = 1;
    int damage = 1;
    int range = 1;
    int movement = 1;
    String userAvatar;
    int SkillPoints;


    public Robot(Player player) {
        this.avatar(player);
        this.skillPoints(player);
    }

    public void avatar(Player player) {
        System.out.println("===============AVATAR============");
        System.out.println(" Wählen Sie ein Symbol als Avatar für " + player.username);
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


    public void skillPoints(Player player) {
        Scanner readIn = new Scanner(System.in);
        System.out.println("Verteilen Sie ihre Skillpunkte: (1),(2),(3),(4) " + player.username + ": ");
        playerStats();
        int points = 3;
        String skillPoints = "";
        System.out.println();
        while (points > 0) {
            System.out.println("Punkte zur Verfügung: " + points);
            skillPoints = readIn.nextLine();
            switch (skillPoints) {
                case "1":
                    this.HP++;
                    points--;
                    break;
                case "2":
                    this.damage++;
                    points--;
                    break;
                case "3":
                    this.range++;
                    points--;
                    break;
                case "4":
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
        System.out.println("1 HealthPoints: " + this.HP + " || " + this.HP);
        System.out.println("2 DamagePoints: " + this.damage + " || " + this.damage);
        System.out.println("3 Range:        " + this.range + " || " + this.range);
        System.out.println("4 Movement:     " + this.movement + " || " + this.movement);


    }
}


