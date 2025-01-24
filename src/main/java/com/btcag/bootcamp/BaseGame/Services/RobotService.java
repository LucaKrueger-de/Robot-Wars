package com.btcag.bootcamp.BaseGame.Services;

import com.btcag.bootcamp.BaseGame.Models.Items;
import com.btcag.bootcamp.BaseGame.Models.Robot;

public class RobotService {

    public static Robot CheckHP(Robot robot1, Robot robot2) {
        if (robot1.getHp() <=0 && robot2.getHp() > 0) {
            return robot2;
        } else if (robot2.getHp() <= 0 && robot1.getHp() > 0) {
            return robot1;
        } else if (robot1.getHp() <= 0 && robot2.getHp() <= 0) {
            return null;
        } else {
            return null;
        }
    }

    public static boolean inRange(Robot robot, Robot enemy) {
        return (robot.getX() + robot.getRange() >= enemy.getX() && enemy.getX() >= robot.getX()) && (robot.getY() + robot.getRange() >= enemy.getY() && enemy.getY() >= robot.getY())
                || (robot.getX() + robot.getRange() >= enemy.getX() && enemy.getX() >= robot.getX()) && (robot.getY() - robot.getRange() <= enemy.getY() && enemy.getY() <= robot.getY())
                || (robot.getX() - robot.getRange() <= enemy.getX() && enemy.getX() <= robot.getX()) && (robot.getY() + robot.getRange() >= enemy.getY() && enemy.getY() >= robot.getY())
                || (robot.getX() - robot.getRange() <= enemy.getX() && enemy.getX() <= robot.getX()) && (robot.getY() - robot.getRange() <= enemy.getY() && enemy.getY() <= robot.getY());
    }

    public static boolean checkPlayerOnItem(Robot robot, Items item ) {
        return (robot.getX()==item.getX() && robot.getY()==item.getY());
    }

}





