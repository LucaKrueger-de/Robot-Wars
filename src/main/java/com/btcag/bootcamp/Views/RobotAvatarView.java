package com.btcag.bootcamp.Views;

import java.util.Scanner;

public class RobotAvatarView {
    public static char display() {
        System.out.println("===============AVATAR============");
        System.out.println(" Wählen Sie ein Symbol als Avatar für ");
        System.out.println("=================================");
        System.out.println("1 - Δ");
        System.out.println("2 - ▲");
        System.out.println("3 - ♣");
        System.out.println("4 - ♠");
        System.out.println("5 - ♥");
        System.out.println("=================================");

        Scanner readIn = new Scanner(System.in);
        System.out.println("Ihre Wahl: ");
        boolean avatar = true;
        String userAvatar = "";

        while (avatar) {
            userAvatar = readIn.nextLine();
            switch (userAvatar) {
                case "1":
                    userAvatar = "Δ";
                    avatar = false;
                    break;
                case "2":
                    userAvatar = "▲";
                    avatar = false;
                    break;
                case "3":
                    userAvatar = "♣";
                    avatar = false;
                    break;
                case "4":
                    userAvatar = "♠";
                    avatar = false;
                    break;
                case "5":
                    userAvatar = "♥";
                    avatar = false;
                    break;
                default:
                    System.out.println("Ungültige Avatarauswahl!");
                    break;
            }
        }
        return userAvatar.charAt(0);


    }

}
