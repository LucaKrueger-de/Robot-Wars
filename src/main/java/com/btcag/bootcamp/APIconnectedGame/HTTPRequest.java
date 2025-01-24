package com.btcag.bootcamp.APIconnectedGame;

import com.btcag.bootcamp.APIconnectedGame.Services.GetRequest;
import com.btcag.bootcamp.APIconnectedGame.Services.PostRequest;
import com.btcag.bootcamp.APIconnectedGame.Views.Menu;

import java.io.IOException;
import java.util.Scanner;

public class HTTPRequest {
    public static void main(String[] args) throws IOException {
        Menu menu = new Menu();
        PostRequest post = new PostRequest();
        GetRequest get = new GetRequest();
        Scanner readIn = new Scanner(System.in);
        boolean running = true;
        do {
            int userChoice = menu.display();
            if (userChoice == 1) {
                System.out.println("Getting all robots....\n ");
                get.getAllBots();
            } else if (userChoice == 2) {
                System.out.println("Getting one robot....\n ");
                get.getOneRobot();
            } else if (userChoice == 3) {
                System.out.println("Getting all maps....\n");
                get.getAllMaps();
            } else if (userChoice == 4) {
                System.out.println("Creating a robot....\n ");
                post.createNewRobot();
            } else if (userChoice == 5) {
                System.out.println("Creating a game....\n ");
                 post.createNewGame();
            } else if (userChoice == 6) {
                System.out.println("Getting all games....\n ");
                get.getAllGames();
            } else if (userChoice == 7) {
                System.out.println("Joining game....\n ");
                post.joinGame();
            } else if (userChoice == 8) {
                System.out.println("Exiting game.... ");
                running = false;
            } else {
                System.out.println("Invalid user choice. Please try again....");
            }
            if (running) {
                System.out.println();
                System.out.println("Back to main menu? YES [1] NO [2]....\n");
                int returnChoice = readIn.nextInt();
                if (returnChoice != 1) {
                    System.out.println("Exiting game....");
                    running = false;
                }
            }
        } while (running);
    }
}




