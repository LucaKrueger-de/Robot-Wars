package com.btcag.bootcamp.APIconnectedGame.Views;

import java.util.Scanner;

public class Menu {
    public int settingsDisplay() {
        Scanner readIn = new Scanner(System.in);
        System.out.println("-------Settings:-------\n" +
                " 1. Get all Robots\n" +
                " 2. Get one Robot\n" +
                " 3. Get all Maps\n" +
                " 4. Get all games\n" +
                " 5. Exit\n" +
                " Enter your choice: \n" +
                "-------------------");
        return readIn.nextInt();
    }

    public int mainDisplay() {
        Scanner readIn = new Scanner(System.in);
        System.out.println("1. Start a Game \n" +
                " 2. Settings \n" +
                " 3. Exit \n");
        return readIn.nextInt();
    }

    public int gameDisplay() {
        Scanner readIn = new Scanner(System.in);
        System.out.println(" 1. Create a robot \n" +
                " 2. Create a game \n" +
                " 3. Join a game \n" +
                " 4. Back to main menu\n" +
                " Enter your choice: \n");
        return readIn.nextInt();
    }


}
