package com.btcag.bootcamp.APIconnectedGame.Services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class GetRequest {
    protected static String baseURL = "https://eumth8x973.execute-api.eu-central-1.amazonaws.com/prod/";
    protected static String getRobotURL = "api/robots";
    protected static String getMapURL = "api/maps";
    protected static String getGameURL = "api/games";
    private static String mapId = "dab4e423-20b4-4ca5-b5e0-4fe960277ea0";

    public static void getAllBots() throws IOException {
        URL url = new URL(baseURL + getRobotURL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        System.out.println(content);
        connection.disconnect();

    }

    public static void getAllGames() throws IOException {
        URL url = new URL(baseURL + getGameURL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        System.out.println(content);
        connection.disconnect();

    }

    public static void getOneRobot() throws IOException {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter BOT-ID: ");
        String userID = reader.nextLine();
        URL url = new URL(baseURL + getRobotURL + "/robot/" + userID);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        System.out.println(content);
        connection.disconnect();
    }

    public static void getAllMaps() throws IOException {
        URL url = new URL(baseURL + getMapURL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        System.out.println(content);
        connection.disconnect();

    }



}
