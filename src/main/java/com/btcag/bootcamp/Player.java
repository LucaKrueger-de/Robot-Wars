package com.btcag.bootcamp;

import java.util.Scanner;

public class Player {
    String username;

    public Player() {
        getName();
    }

    public void getName() {
        Scanner readIn = new Scanner(System.in);
        String username;
        do {
            System.out.println("Geben Sie ihren Benutzernamen ein: ");
            username = readIn.nextLine();
        } while (username.length() < 3 || username.length() > 15);
        this.username = username;
    }
    public String getUsername() {
        return username;
    }

}


