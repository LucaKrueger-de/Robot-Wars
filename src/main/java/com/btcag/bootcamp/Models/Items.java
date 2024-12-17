package com.btcag.bootcamp.Models;

import java.util.Random;

public class Items {
    String effectName;
    int period;
    int x;
    int y;
    int value;
    char symbol;

    public Items(String effectName, int period, int x, int y, int value) {
        this.effectName = effectName;
        this.period = period;
        this.x = x;
        this.y = y;
        this.value = value;
        this.symbol = '?';
    }

    public int getValue() {
        return value;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String effectName() {
        return effectName;
    }


    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public void setPosition(int x,int y){
        this.x = x;
        this.y = y;
    }

}
