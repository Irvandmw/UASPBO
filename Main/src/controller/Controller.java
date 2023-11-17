/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Games;
import view.GameList;
import view.Login;

/**
 *
 * @author Irvan
 */
public class Controller {
    static DatabaseHandler conn = new DatabaseHandler();
    
    public void login(String inputEmail, String inputPassword) {
            conn.connect();
            String sql = "SELECT * FROM Users WHERE email=? AND password=?";
            try (PreparedStatement stmt = conn.con.prepareStatement(sql)) {
                stmt.setString(1, inputEmail);
                stmt.setString(2, inputPassword);

            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    new GameList();
                } else {
                    // Login failed
                    JOptionPane.showMessageDialog(null, "Login failed. Incorrect email or password.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            // Tambahkan penanganan kesalahan lebih lanjut sesuai kebutuhan
        } finally {
            conn.disconnect();
        }
    }
    
    public ArrayList<Games> getAllGames() {
        ArrayList<Games> gamesList = new ArrayList<>();
        conn.connect();
        String sql = "SELECT * FROM Games";
        try (PreparedStatement preparedStatement = conn.con.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String genre = resultSet.getString("genre");
                int price = resultSet.getInt("price");

                Games game = new Games(id, name, genre, price);
                gamesList.add(game);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gamesList;
    }
}
