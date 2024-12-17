package com.btcag.bootcamp.Models;

public class Obstacles {
    int x;
    int y;
    char symbol;

    public Obstacles(int x, int y) {
        this.x = x;
        this.y = y;
        this.symbol = '#';
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }


    public void setObstacle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean checkCollision(Robot robot, Obstacles obstacles) {
        if (isColliding(robot, obstacles)) {
            return true;
        } else {
            return false;
        }


    }
public boolean isColliding(Robot robot, Obstacles obstacles) {
        return robot.getX()==obstacles.getX() && robot.getY()==obstacles.getY();
}
}
