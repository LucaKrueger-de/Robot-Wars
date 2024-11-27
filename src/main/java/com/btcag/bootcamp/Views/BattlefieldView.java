package com.btcag.bootcamp.Views;

import com.btcag.bootcamp.Models.Battlefield;
import com.btcag.bootcamp.Models.Robot;

public class BattlefieldView {
    public static void display(Battlefield battlefield,String username,char userAvatar) {
        System.out.println();
        System.out.println("/"+username +" Ihr Avatar: "+userAvatar+"\\");
        printHeaderRow(battlefield.getWidth());
        for (char[] row : battlefield.getMap()) {
            printRow(row,"║", "║");
        }
        printLastRow(battlefield.getWidth());
    }

    private static void printHeaderRow(int width) {
        printEmptyRow(width, "╔", "═", "╗");
    }

    private static void printLastRow(int width) {
        printEmptyRow(width,"╚", "═", "╝");
    }

    private static void printEmptyRow(int width, String start, String main, String end) {
        System.out.print(start);
        int columnCount = 0;
        while (columnCount < width) {
            System.out.print(main);
            columnCount++;
        }
        System.out.println(end);
    }

    private static void printRow(char[] row, String start,  String end) {
        System.out.print(start);
        for (char field : row) {
            System.out.print(field);
        }
        System.out.println(end);
    }
}



