package com.btcag.bootcamp.APIconnectedGame;

import com.btcag.bootcamp.APIconnectedGame.Services.GetRequest;
import com.btcag.bootcamp.APIconnectedGame.Services.PostRequest;
import com.btcag.bootcamp.APIconnectedGame.Views.Menu;

import java.io.IOException;
import java.util.Scanner;

public class HTTPRequest {
    static Menu menu = new Menu();
    static PostRequest post = new PostRequest();
    static GetRequest get = new GetRequest();
    static Scanner readIn = new Scanner(System.in);


    public static void main(String[] args) throws IOException {
        boolean running = true;
        do {
            int userChoice = menu.mainDisplay();
            if (userChoice == 1) {
                boolean gameRunning = true;
                while (gameRunning) {
                    System.out.println("Starting a Game....\n ");
                    int userChoice2 = menu.gameDisplay();
                    if (userChoice2 == 1) {
                        System.out.println("Creating a robot....\n ");
                        post.createNewRobot();
                    } else if (userChoice2 == 2) {
                        System.out.println("Creating new game...\n ");
                        post.createNewGame();
                    } else if (userChoice2 == 3) {
                        System.out.println("Joining game...\n ");
                        post.joinGame();
                    } else if (userChoice2 == 4){
                            System.out.println("Back to main menu...\n ");
                            gameRunning = false;
                    }else {
                        System.out.println("Invalid choice!\n ");
                    }
                }
            } else if (userChoice == 2) {
                System.out.println("Settings.....\n ");
                boolean gameRunning = true;
                while (gameRunning) {
                    int userChoice3 = menu.settingsDisplay();
                    if (userChoice3 == 1) {
                        System.out.println("Getting all robots....\n ");
                        get.getAllBots();
                    } else if (userChoice3 == 2) {
                        System.out.println("Getting one robot....\n ");
                        get.getOneRobot();
                    } else if (userChoice3 == 3) {
                        System.out.println("Getting all maps....\n ");
                        get.getAllMaps();
                    } else if (userChoice3 == 4) {
                        System.out.println("Getting all games....\n ");
                        get.getAllGames();
                    } else if (userChoice3 == 5) {
                        System.out.println("Exiting....\n ");
                        gameRunning = false;
                    } else {
                        System.out.println("Invalid choice. Please try again.");
                    }
                }

            } else if (userChoice == 3) {
                System.out.println("Exiting....\n ");
                running = false;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }while(running);
    }
}






