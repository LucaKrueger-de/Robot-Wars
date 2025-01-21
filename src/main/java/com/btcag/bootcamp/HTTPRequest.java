package com.btcag.bootcamp;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class HTTPRequest {
    protected static String baseURL = "https://82rvkz5o22.execute-api.eu-central-1.amazonaws.com/prod/";
    protected static String getRobotURL = "api/robots";
    protected static String getMapURL = "api/maps";
    protected static String postRobotURL = "api/robots/robot";
    protected static String postGameURL = "api/games/game";

    public static void main(String[] args) throws IOException {
        String gameId = "d2d0b803-955d-4367-8fdd-c8c3f94fecbb";
        createNewGame(gameId);
    }

    //............................................Gibt alle Roboter aus..................................................

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

    //............................................Gibt einen Roboter aus..................................................

    public static void getOneRobot() throws IOException {
        Scanner reader = new Scanner(System.in);
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

    //............................................Gibt alle Maps aus..................................................


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

    public static void createNewRobot(Bot bot) throws IOException {
        URL url = new URL(baseURL + postRobotURL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setUseCaches(false);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");


        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", bot.name);
        jsonObject.put("health", bot.health);
        jsonObject.put("attackDamage", bot.attackDamage);
        jsonObject.put("attackRange", bot.attackRange);
        jsonObject.put("movementRate", bot.movementRate);
        String jsonInputString = jsonObject.toString();

        // .......JSON-Daten an die Verbindung senden
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }
        System.out.println(jsonInputString);
        // ........Antwort der API lesen
        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);
    }

    public static void createNewGame(String gameId) throws IOException {

        URL url = new URL(baseURL + postGameURL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setUseCaches(false);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");


        JSONObject jsonObject = new JSONObject();
        jsonObject.put("mapId", gameId);
        String jsonInputString = jsonObject.toString();

        // .......JSON-Daten an die Verbindung senden
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }
        System.out.println(jsonInputString);
        // ........Antwort der API lesen
        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);
    }

}




class Bot {
    String name;
    int health;
    int attackDamage;
    int attackRange;
    int movementRate;

    public Bot(String name, int health, int attackDamage, int attackRange, int movementRate) {
        this.name = name;
        this.health = health;
        this.attackDamage = attackDamage;
        this.attackRange = attackRange;
        this.movementRate = movementRate;
    }


}



