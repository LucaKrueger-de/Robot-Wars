package com.btcag.bootcamp.APIconnectedGame.Services;

import com.btcag.bootcamp.APIconnectedGame.Models.Bot;
import com.btcag.bootcamp.APIconnectedGame.Views.BotSkillPoints;
import com.btcag.bootcamp.BaseGame.Views.RobotNameView;
import org.json.JSONObject;
  
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class PostRequest {

    protected static String baseURL = "https://eumth8x973.execute-api.eu-central-1.amazonaws.com/prod/";
    protected static String postRobotURL = "api/robots/robot";
    protected static String postGameURL = "api/games/game/";
    private static String mapId = "dab4e423-20b4-4ca5-b5e0-4fe960277ea0";
    private static String playerId = "";

    //............................................Erstellt einen neuen Roboter..................................................

    public static void createNewRobot() throws IOException {
        URL url = new URL(baseURL + postRobotURL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setUseCaches(false);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");

        String robotName = RobotNameView.display();
        Bot robot = new Bot(robotName);
        BotSkillPoints skillPoints = new BotSkillPoints();
        skillPoints.displaySkillPoints(robot);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", robotName);
        jsonObject.put("health", robot.getHealth());
        jsonObject.put("attackDamage", robot.getAttackDamage());
        jsonObject.put("attackRange", robot.getAttackRange());
        jsonObject.put("movementRate", robot.getMovementRate());
        String jsonInputString = jsonObject.toString();

        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }
        System.out.println(jsonInputString);
        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);
    }

    //............................................Erstellt ein neues Spiel..................................................

    public static void createNewGame() throws IOException {
        System.out.println("Enter Map-ID: ");
        Scanner gameId = new Scanner(System.in);
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

        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }
        System.out.println(jsonInputString);
        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);
    }

    //........................................ Join-Game.................................................................

    public static void joinGame() throws IOException {
        System.out.println("Enter Game ID: ");
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter your robot ID: ");
        Scanner robotId = new Scanner(System.in);
        String gameId = reader.nextLine();
        URL url = new URL(baseURL + postGameURL + gameId + "/join");


        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setDoOutput(true);
        con.setDoInput(true);
        con.setUseCaches(false);
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Accept", "application/json");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("robotId", robotId);

        String jsonInputString = jsonObject.toString();

        try (OutputStream os = con.getOutputStream()) {
            byte[] input = jsonObject.toString().getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        System.out.println(jsonInputString);
        int code = con.getResponseCode();
        System.out.println(code);

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            JSONObject responseObject = new JSONObject(response.toString());
            playerId = responseObject.getString("playerId");
            System.out.println("Player ID: " + playerId);
        } catch (IOException e) {
            try (BufferedReader errorReader = new BufferedReader(
                    new InputStreamReader(con.getErrorStream(), "utf-8"))) {
                StringBuilder errorResponse = new StringBuilder();
                String errorLine;
                while ((errorLine = errorReader.readLine()) != null) {
                    errorResponse.append(errorLine.trim());
                }
                System.err.println("Error Response Body: " + errorResponse.toString());
            }
        }


    }


}
