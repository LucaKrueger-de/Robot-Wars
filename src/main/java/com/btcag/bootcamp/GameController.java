package com.btcag.bootcamp;


import com.btcag.bootcamp.Models.Battlefield;
import com.btcag.bootcamp.Models.Items;
import com.btcag.bootcamp.Models.Obstacles;
import com.btcag.bootcamp.Models.Robot;
import com.btcag.bootcamp.Services.MoveDirection;
import com.btcag.bootcamp.Services.RobotService;
import com.btcag.bootcamp.Views.*;

import java.util.Random;

public class GameController {
    public static Obstacles[] obstacles = new Obstacles[15];
    public static Random rand = new Random();

    public static void main(String[] args) {
        for (int i = 0; i < obstacles.length; i++) {
            obstacles[i] = new Obstacles(rand.nextInt(1, 16), rand.nextInt(1, 11));
        }
        IntroScreenView.display();

        //Spieler 1 wird erstellt-------------------------------------------------------------------
        String robotName = RobotNameView.display();
        char robotAvatar = RobotAvatarView.display();
        Robot robot = new Robot(robotName, 1, 1, robotAvatar);
        RobotView.display(robot);
        SkillPointsView skillPointsRobot = new SkillPointsView();
        skillPointsRobot.displaySkillPoints(robot);

        //Spieler 2 wird erstellt-------------------------------------------------------------------
        String robotName2 = RobotNameView.display();
        char robotAvatar2 = RobotAvatarView.display();
        Robot enemy = new Robot(robotName2, 15, 10, robotAvatar2);
        RobotView.display(enemy);
        SkillPointsView skillPointsEnemy = new SkillPointsView();
        skillPointsEnemy.displaySkillPoints(enemy);


        //Spielfeld wird erstellt-------------------------------------------------------------------
        Battlefield battlefield = new Battlefield(15, 10);


        //Items/Hindernisse werden erstellt und zufällig plaziert-------------------------------------------------------------
        Random rand = new Random();

        Items item1 = new Items("Range", 2, 8, 6, rand.nextInt(-2, 2));
        Items item2 = new Items("Movement", 2, 9, 7, rand.nextInt(-2, 2));
        Items item3 = new Items("Damage", 2, 8, 7, rand.nextInt(-2, 2));


        //Hindernisse werden plaziert-------------------------------------------------------------------
        for (Obstacles obstacle : obstacles) {
            battlefield.setField(obstacle.getX(), obstacle.getY(), obstacle.getSymbol());
        }



        //Spieler werden aufs Spielfeld gesetzt-------------------------------------------------------------------
        battlefield.setField(robot.getX(), robot.getY(), robotAvatar);
        battlefield.setField(enemy.getX(), enemy.getY(), robotAvatar2);
        battlefield.setField(item1.getX(), item1.getY(), item1.getSymbol());
        battlefield.setField(item2.getX(), item2.getY(), item2.getSymbol());
        battlefield.setField(item3.getX(), item3.getY(), item3.getSymbol());

        //Spielzüge mit sämtlichen Überprüfungen-------------------------------------------------------------------
        Robot winner = null;
        boolean robotTurn = true;

        do {
            robotTurn = !robotTurn;
            if (robotTurn) {
                BattlefieldView.display(battlefield, robotName, robotAvatar);
                int action = ActionMenuView.action();
                if (action == 1) {
                    moveRobot(robot, robotAvatar, battlefield, robotName, item1, item2, item3, skillPointsRobot);
                } else if (action == 2) {
                    if (RobotService.inRange(robot, enemy)) {
                        enemy.gettingDamage(robot.getDamage());
                        winner = RobotService.CheckHP(robot, enemy);
                        AttackView.attackDisplay(robot, enemy);
                    } else {
                        AttackView.noRange();
                    }
                }
            } else {
                BattlefieldView.display(battlefield, robotName2, robotAvatar2);
                int action = ActionMenuView.action();
                if (action == 1) {
                    moveRobot(enemy, robotAvatar2, battlefield, robotName2, item1, item2, item3, skillPointsEnemy);
                } else if (action == 2) {
                    if (RobotService.inRange(robot, enemy)) {
                        robot.gettingDamage(enemy.getDamage());
                        winner = RobotService.CheckHP(robot, enemy);
                        AttackView.attackDisplay(robot, enemy);
                    } else {
                        AttackView.noRange();
                    }

                }
            }

        } while (null == winner);
        WinnerView.display(winner);
    }

    //Roboterbewegung, mit Überprüfung, ob er ein Item eingesammelt hat, oder nicht--------------------------------------
    public static void moveRobot(Robot robot, char robotAvatar, Battlefield battlefield, String username, Items item1, Items item2, Items item3, SkillPointsView skillPointsRobot) {
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
                BattlefieldView.display(battlefield, username, robotAvatar);
                System.out.println("<=============================>");
                System.out.println("Bewege " + username + " nach " + "X: " + tempX + " Y: " + tempY);
                System.out.println("Verbleibende Laufzüge: " + remainingMovementPoints);
                System.out.println("<=============================>");

                if (RobotService.checkPlayerOnItem(robot, item1)) {
                    int temp = robot.getRange();
                    temp += item1.getValue();
                    robot.setRange(temp);
                    ItemView.effectView(item1);
                    item1.setSymbol(' ');
                    item1.setPosition(-10, -10);
                    skillPointsRobot.showPlayerStats(robot);
                }
                if (RobotService.checkPlayerOnItem(robot, item2)) {
                    int temp2 = robot.getMovementRate();
                    temp2 += item2.getValue();
                    robot.setMovementRate(temp2);
                    ItemView.effectView(item2);
                    item2.setSymbol(' ');
                    item2.setPosition(-10, -10);
                    skillPointsRobot.showPlayerStats(robot);
                }
                if (RobotService.checkPlayerOnItem(robot, item3)) {
                    int temp3 = robot.getDamage();
                    temp3 += item3.getValue();
                    robot.setDamage(temp3);
                    ItemView.effectView(item3);
                    item3.setSymbol(' ');
                    item3.setPosition(-10, -10);
                    skillPointsRobot.showPlayerStats(robot);
                }
            } else {
                System.out.println("Ungültiges Feld. Bitte wähle eine andere Richtung");
            }
        }
    }
}


