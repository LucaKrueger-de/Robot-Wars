package com.btcag.bootcamp.BaseGame.Models;

public class Robot {
    private String name;
    private int x;
    private int y;
    private final String symbol;
    private int range;
    private int damage;
    private int movementRate;
    private int hp;

    public Robot(String name, int x, int y, char symbol) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.symbol = String.valueOf(symbol);
        this.range = 1;
        this.damage = 1;
        this.movementRate = 1;
        this.hp = 1;
    }

    public int gettingDamage(int damage) {
        return hp -= damage;
    }


    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getMovementRate() {
        return movementRate;
    }

    public void setMovementRate(int movementRate) {
        this.movementRate = movementRate;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public String getName() {
        return name;
    }


    public void setName(){
        this.name = name;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public String getSymbol() {
        return symbol;
    }

}