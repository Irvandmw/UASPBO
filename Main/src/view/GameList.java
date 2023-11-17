/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.Controller;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Games;

/**
 *
 * @author Irvan
 */
public class GameList {
    public GameList(){
        viewGameList();
    }
    
    private void viewGameList(){
        Controller controller = new Controller();
        JFrame frame = new JFrame("Game List");
        frame.setSize(400,720);
        JButton transaksiButton = new JButton("Transaksi");
        transaksiButton.setBounds(170, 15, 100, 30);
        transaksiButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                
            }
        });
        frame.add(transaksiButton);
        chooseGames(controller.getAllGames(), frame);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true); 
        
    }
    
    public void chooseGames(ArrayList<Games> games, JFrame frame) {
        JPanel listGame = new JPanel(new GridLayout(0, 2));
        for (Games game : games) {
            listGame.add(new JTextField("Name: " + game.getName()));
            listGame.add(new JTextField("Genre: " + game.getGenre()));
            listGame.add(new JTextField("Price: " + String.valueOf(game.getPrice())));
            JButton buyButton = new JButton("Buy");

            buyButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                   
                }
            });
            listGame.add(buyButton);
        }
        frame.getContentPane().add(listGame);
        frame.revalidate(); 
    }
}
