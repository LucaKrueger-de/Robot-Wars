package com.btcag.bootcamp.Services;

import java.util.Random;

import com.btcag.bootcamp.Models.Robot;

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
}





