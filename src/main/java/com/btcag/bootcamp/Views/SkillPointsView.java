package com.btcag.bootcamp.Views;

import com.btcag.bootcamp.Models.Robot;

import java.util.Scanner;

public class SkillPointsView {

    public void displaySkillPoints(Robot robot) {
        int SkillPoints = 10;

        while (SkillPoints > 0) {
            System.out.println("Wohin willst du deine Skillpunkte verteilen");
            System.out.println("Skillpunkte verbleibend: " + SkillPoints);
            System.out.println("(1) -> Healthpoints ");
            System.out.println("(2) -> Damagepoints ");
            System.out.println("(3) -> Movementrange ");
            System.out.println("(4) -> Range ");

            Scanner readIn = new Scanner(System.in);

            int userInput = readIn.nextInt();
            System.out.println("Wie viele Punkte möchtest du diesem Attribut zuweisen? ");
            int points = readIn.nextInt();

            if (points > SkillPoints) {
                System.out.println("Du hast nicht genügend Skillpunkte. Versuche es erneut. ");
            } else if (userInput == 1) {
                robot.setHp(robot.getHp() + points);
                SkillPoints-=points;
            } else if (userInput == 2) {
                robot.setHp(robot.getDamage() + points);
                SkillPoints-=points;
            } else if (userInput == 3) {
                robot.setMovementRate(robot.getMovementRate() + points);
                SkillPoints-=points;
            } else if (userInput == 4) {
                robot.setRange(robot.getRange() + points);
                SkillPoints-=points;
            } else {
                System.out.println("Ungültige Eingabe!");
            }


        }
        showPlayerStats(robot);
    }


    public void showPlayerStats(Robot robot) {
        System.out.println("Spieler:      -> " + robot.getName());
        System.out.println("Healthpoints: || " + robot.getHp());
        System.out.println("Damagepoints: || " + robot.getDamage());
        System.out.println("Movementrange:|| " + robot.getMovementRate());
        System.out.println("Range:        || " + robot.getRange());


    }

}


