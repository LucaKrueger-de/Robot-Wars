package com.btcag.bootcamp.APIconnectedGame.Views;

import com.btcag.bootcamp.APIconnectedGame.Models.Bot;

import java.util.Scanner;

public class BotSkillPoints {
    public void displaySkillPoints(Bot robot) {
        int SkillPoints = 10;

        while (SkillPoints > 0) {
            System.out.println();
            System.out.println("Wohin willst du deine Skillpunkte verteilen");
            System.out.println("Skillpunkte verbleibend: " + SkillPoints);
            System.out.println("(1) -> Healthpoints ");
            System.out.println("(2) -> Damagepoints ");
            System.out.println("(3) -> Movementrange ");
            System.out.println("(4) -> Range \n");
//test2

            Scanner readIn = new Scanner(System.in);

            int userInput = readIn.nextInt();
            System.out.println("Wie viele Punkte möchtest du diesem Attribut zuweisen? \n");
            int points = readIn.nextInt();
            if (points > SkillPoints) {
                System.out.println("Du hast nicht genügend Skillpunkte. Versuche es erneut.\n ");
            } else if (userInput == 1) {
                robot.setHealth(robot.getHealth() + points);
                SkillPoints-=points;
            } else if (userInput == 2) {
                robot.setAttackDamage(robot.getAttackDamage() + points);
                SkillPoints-=points;
            } else if (userInput == 3) {
                robot.setMovementRate(robot.getMovementRate()+ points);
                SkillPoints-=points;
            } else if (userInput == 4) {
                robot.setAttackRange(robot.getAttackRange() + points);
                SkillPoints-=points;
            } else {
                System.out.println("Ungültige Eingabe!");
            }


        }
        showPlayerStats(robot);
    }


    public void showPlayerStats(Bot robot) {
        System.out.println("Spieler:      " + robot.getName());
        System.out.println("Healthpoints: || " + robot.getHealth());
        System.out.println("Damagepoints: || " + robot.getAttackDamage());
        System.out.println("Movementrange:|| " + robot.getMovementRate());
        System.out.println("Range:        || " + robot.getAttackRange());
    }

}



