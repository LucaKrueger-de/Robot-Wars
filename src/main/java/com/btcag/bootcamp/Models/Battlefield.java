package com.btcag.bootcamp.Models;

import java.util.Arrays;
import java.util.Random;

public class Battlefield {
    private final int width;
    private final int height;
    private final char[][] map;


    public Battlefield(int width, int height) {
        this.map = new char[height][width];
        this.width = width;
        this.height = height;
        this.initializeMap();

    }

    private void initializeMap() {
        for (char[] row : map) {
            Arrays.fill(row, ' ');
        }
    }

    public char getField(int x, int y) {
        return map[y - 1][x - 1];
    }

    public void setField(int x, int y, char field) {
        map[y-1][x-1] = field;
    }

    public int getWidth() {
        return width;
    }

    public char[][] getMap() {
        return map;
    }



    public boolean isValidField(int x, int y) {
        return x > 0 && x <= width && y > 0 && y <= height;
    }


}






