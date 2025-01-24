package com.btcag.bootcamp.APIconnectedGame.Views;

import java.util.Scanner;

public class Menu {
    public int display(){
        Scanner readIn = new Scanner(System.in);

        System.out.println("-------Menu:-------\n" +
                " 1. Get all Robots\n" +
                " 2. Get one Robot\n" +
                " 3. Get all Maps\n" +
                " 4. Create a Robot\n" +
                " 5. Create a Game\n" +
                " 6. Get all games\n" +
                " 7. Join a Game\n" +
                " 8. Exit\n" +
                "-------------------");
        return readIn.nextInt();
    }


}
