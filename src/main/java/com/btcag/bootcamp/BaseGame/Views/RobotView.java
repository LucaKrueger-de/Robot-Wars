package com.btcag.bootcamp.BaseGame.Views;

import com.btcag.bootcamp.BaseGame.Models.Robot;

public class RobotView {
    public static void display(Robot robot) {
        System.out.println("Dein Roboter heisst: " + robot.getName());
        System.out.println("Der Roboter befindet sich auf Position x:" + robot.getX() + " y:" + robot.getY());
    }

}
