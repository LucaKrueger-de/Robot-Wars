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
        char robotAvatar= RobotAvatarView.display();
        Robot robot = new Robot(robotName, 1, 1, robotAvatar);
        RobotView.display(robot);
        SkillPointsView skillPointsRobot = new SkillPointsView();
        skillPointsRobot.displaySkillPoints(robot);



        String robotName2 = RobotNameView.display();
        char robotAvatar2= RobotAvatarView.display();
        Robot enemy = new Robot(robotName2, 15, 10, robotAvatar2);
        RobotView.display(enemy);
        SkillPointsView skillPointsEnemy = new SkillPointsView();
        skillPointsEnemy.displaySkillPoints(enemy);




        Battlefield battlefield = new Battlefield(15, 10);

        battlefield.setField(robot.getX(), robot.getY(), robotAvatar);
        battlefield.setField(enemy.getX(), enemy.getY(), robotAvatar2);

        Robot winner = null;
        int newX;
        int newY;

        do {
            BattlefieldView.display(battlefield);
            do {
                MoveDirection direction = MovementView.display();
                newX = robot.getX() + direction.getX();
                newY = robot.getY() + direction.getY();
            } while (!battlefield.isValidField(newX, newY));

            battlefield.setField(robot.getX(), robot.getY(), ' ');

            robot.setPosition(newX, newY);
            battlefield.setField(robot.getX(), robot.getY(), robotAvatar);


            if (RobotService.CheckCollision(robot, enemy)) {
                winner = RobotService.getWinner(robot, enemy);
            }
        } while (null == winner);
        WinnerView.display(winner);
    }


    }


