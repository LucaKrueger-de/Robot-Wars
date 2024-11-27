package com.btcag.bootcamp;


import com.btcag.bootcamp.Models.Battlefield;
import com.btcag.bootcamp.Models.Robot;
import com.btcag.bootcamp.Services.MoveDirection;
import com.btcag.bootcamp.Services.RobotService;
import com.btcag.bootcamp.Views.*;

public class GameController {
    public static void main(String[] args) {
        IntroScreenView.display();

        String robotName = RobotNameView.display();
        char robotAvatar = RobotAvatarView.display();
        Robot robot = new Robot(robotName, 1, 1, robotAvatar);
        RobotView.display(robot);
        SkillPointsView skillPointsRobot = new SkillPointsView();
        skillPointsRobot.displaySkillPoints(robot);


        String robotName2 = RobotNameView.display();
        char robotAvatar2 = RobotAvatarView.display();
        Robot enemy = new Robot(robotName2, 15, 10, robotAvatar2);
        RobotView.display(enemy);
        SkillPointsView skillPointsEnemy = new SkillPointsView();
        skillPointsEnemy.displaySkillPoints(enemy);


        Battlefield battlefield = new Battlefield(15, 10);

        battlefield.setField(robot.getX(), robot.getY(), robotAvatar);
        battlefield.setField(enemy.getX(), enemy.getY(), robotAvatar2);


        Robot winner = null;
        boolean robotTurn = true;


        do {
            robotTurn = !robotTurn;
            if (robotTurn) {
                BattlefieldView.display(battlefield, robotName, robotAvatar);
                int action = ActionMenuView.action();
                if (action == 1) {
                    moveRobot(robot, robotAvatar, battlefield, robotName);
                } else if (action == 2) {
                    if (inRange(robot, enemy)) {
                        enemy.gettingDamage(robot.getDamage());
                        winner = RobotService.CheckHP(robot, enemy);
                        System.out.println("Spieler " + robotName + " hat dem Spieler " + robotName2 +" "+ robot.getDamage() + " Lebenspunkte abgezogen" +" "+
                                "Verbleibende Lebenspunkte: " + robotName + " " + robot.getHp() + " \n" + robotName2 + " " + enemy.getHp());
                    } else {
                        System.out.println("Dein Gegner ist nicht in Reichweite ! ");
                    }
                }
            } else {
                BattlefieldView.display(battlefield, robotName2, robotAvatar2);
                int action = ActionMenuView.action();
                if (action == 1) {
                    moveRobot(enemy, robotAvatar2, battlefield, robotName2);
                } else if (action == 2) {
                    if (inRange(robot, enemy)) {
                        robot.gettingDamage(enemy.getDamage());
                        winner = RobotService.CheckHP(robot, enemy);
                        System.out.println("Spieler " + robotName2 + " hat dem Spieler " + robotName +" "+ enemy.getDamage() + " Lebenspunkte abgezogen " +" "+
                                " Verbleibende Lebenspunkte: " + robotName + " " + robot.getHp() + " \n" + robotName2 + " " + enemy.getHp());
                    } else {
                        System.out.println("Dein Gegner ist nicht in Reichweite ! ");
                    }

                }
            }


        } while (null == winner);
        WinnerView.display(winner);
    }


    public static boolean inRange(Robot robot, Robot enemy) {
        return (robot.getX() + robot.getRange() >= enemy.getX() && enemy.getX() >= robot.getX()) && (robot.getY() + robot.getRange() >= enemy.getY() && enemy.getY() >= robot.getY())
                || (robot.getX() + robot.getRange() >= enemy.getX() && enemy.getX() >= robot.getX()) && (robot.getY() - robot.getRange() <= enemy.getY() && enemy.getY() <= robot.getY())
                || (robot.getX() - robot.getRange() <= enemy.getX() && enemy.getX() <= robot.getX()) && (robot.getY() + robot.getRange() >= enemy.getY() && enemy.getY() >= robot.getY())
                || (robot.getX() - robot.getRange() <= enemy.getX() && enemy.getX() <= robot.getX()) && (robot.getY() - robot.getRange() <= enemy.getY() && enemy.getY() <= robot.getY());
    }


    private static void moveRobot(Robot robot, char robotAvatar, Battlefield battlefield, String username) {
        int newX = robot.getX();
        int newY = robot.getY();
        int remainingMovementPoints = robot.getMovementRate();

        while (remainingMovementPoints > 0) {
            MoveDirection direction = MovementView.display(username);
            int tempX = newX + direction.getX();
            int tempY = newY + direction.getY();

            if (battlefield.isValidField(newX, newY)) {
                newX = tempX;
                newY = tempY;
                remainingMovementPoints--;
                battlefield.setField(robot.getX(), robot.getY(), ' ');
                robot.setPosition(newX, newY);
                battlefield.setField(robot.getX(), robot.getY(), robotAvatar);
                BattlefieldView.display(battlefield,username,robotAvatar);
                System.out.println("Moving " + username + " to " + tempX + " " + tempY);
                System.out.println("Verbleibende Laufzüge: " + remainingMovementPoints);

            } else {
                System.out.println("Ungültiges Feld. Bitte wähle eine andere Richtung");
            }
        }

    }
}


