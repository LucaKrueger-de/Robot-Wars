package com.btcag.bootcamp.Views;

import com.btcag.bootcamp.Services.MoveDirection;

import java.util.Scanner;

public class MovementView {
    public static MoveDirection display(String username) {
        System.out.println("<----------------->");
        System.out.println(username + " Bitte gib die Richtung an, in die sich der Roboter bewegen soll.");
        System.out.println("[N] | [S] | [O] | [W]");
        System.out.println("<----------------->");

        Scanner readIn = new Scanner(System.in);

        MoveDirection direction;
        do {
            direction = MoveDirection.fromUserInput(
                    readIn.next().toLowerCase().charAt(0)
            );
        } while (null == direction);

        return direction;
    }





}
