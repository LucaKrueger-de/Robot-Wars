package com.btcag.bootcamp.OldVersions;

import java.util.Scanner;

public class Player {
    String username;
    Scanner readIn = new Scanner(System.in);
    int x, y;

    public Player(String username) {
        this.username = username;
        this.x = x;
        this.y = y;
    }


    public String getName() {
        while (username.length() > 15 || username.length() < 3) {
            System.out.println("Geben Sie einen Benutzernamen ein: ");
            username = readIn.nextLine();
        }
        return username;
    }
}




