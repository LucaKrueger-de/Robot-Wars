package com.btcag.bootcamp.Services;

import java.util.Random;
import com.btcag.bootcamp.Models.Robot;

public class RobotService {

    public static boolean CheckCollision(Robot robot1, Robot robot2) {
        return(robot1.getX() == robot2.getX() && robot1.getY() == robot2.getY());
    }


    public static Robot getWinner(Robot robot1, Robot robot2) {
        Random rand = new Random();
        return(rand.nextBoolean())? robot1:robot2;
    }





}




