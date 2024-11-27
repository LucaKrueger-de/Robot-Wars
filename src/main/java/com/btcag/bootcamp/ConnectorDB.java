package com.btcag.bootcamp;

import java.sql.*;
import java.sql.ResultSet;
import java.util.Scanner;


public class ConnectorDB {
    private static final String URL = "jdbc:sqlite:C:/Users/LUKRUEGE/OneDrive - BTC AG/Desktop/SQL Tools/Bootcamp2024.db";
    static Scanner readIn = new Scanner(System.in);


    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL);
            System.out.println("Verbindung zur SQLite-Datenbank hergestellt.");
        } catch (SQLException e) {
            System.out.println("Verbindung zur SQLite-Datenbank fehlgeschlagen.");
            e.printStackTrace();
        }
        return conn;
    }

    public static void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS User (" + "id INTEGER PRIMARY KEY AUTOINCREMENT, " + "username TEXT NOT NULL, " + "password TEXT NOT NULL);";
        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabelle 'User' wurde erfolgreich erstellt.");
        } catch (SQLException e) {
            System.out.println("Fehler beim Erstellen der Tabelle 'User'.");
            e.printStackTrace();
        }
    }

    public static void insertUser(String username, String password) {
        String sql = "INSERT INTO User(username, password) VALUES(?, ?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            System.out.println("Gebe deinen Benutzernamen ein:");
            username = readIn.nextLine();
            System.out.println("Geben Sie ein Passwort ein:");
            password = readIn.nextLine();
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
            System.out.println("User erfolgreich eingefügt.");
        } catch (SQLException e) {
            System.out.println("Fehler beim Einfügen des Users.");
            e.printStackTrace();
        }
    }

    public static void selectAllUsers() {
        String sql = "SELECT * FROM User";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + "\t" +
                        "Username: " + rs.getString("username") + "\t" +
                        "Password: " + rs.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println("Fehler beim Abrufen der Users.");
            e.printStackTrace();
        }
    }


    public static void selectUserExist(String username, String password) {
        System.out.println("Geben Sie Ihren Benutzernamen ein:");
        username = readIn.nextLine();
        System.out.println("Geben Sie ein Passwort ein:");
        password = readIn.nextLine();
        String sql = "SELECT * FROM User WHERE username = ? AND password = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            if (rs.isBeforeFirst()) {
                System.out.println("Shalom!"+username);
            } else {
                System.out.println("Benutzername oder Passwort falsch!");
            }


        } catch (SQLException e) {
            System.out.println("Error");
            e.printStackTrace();
        }


    }


    public static void main(String[] args) {
        connect();
        //createTable();
        //insertUser("","");
        //selectUserExist("", "");
        selectAllUsers();
    }
}

