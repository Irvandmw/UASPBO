/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Login {
   
    public Login(){
        inputLoginScreen();
    }
 
    private void inputLoginScreen(){
        Controller controller = new Controller();
        JFrame frameCari = new JFrame("Login");
        frameCari.setSize(400, 200);
        Controller con = new Controller();
        
        JLabel labelEmail = new JLabel("Email : ");
        JTextField inputEmail = new JTextField();
        labelEmail.setBounds(10, 15, 200, 30);
        inputEmail.setBounds(150, 15, 200, 30);
        
        JLabel labelPassword = new JLabel("Password : ");
        JPasswordField inputPassword = new JPasswordField(20);
        labelPassword.setBounds(10, 50, 200, 30);
        inputPassword.setBounds(170, 50, 200, 30);
        
        JButton buttonLogin = new JButton("Login");
        buttonLogin.setBounds(150, 100, 100, 30);
        
        buttonLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                controller.login(inputEmail.getText(),inputPassword.getText());
            }
        });
        
        frameCari.add(labelEmail);
        frameCari.add(inputEmail);
        frameCari.add(labelPassword);
        frameCari.add(inputPassword);
        frameCari.add(buttonLogin);
        frameCari.setLocationRelativeTo(null);
        frameCari.setLayout(null);
        frameCari.setVisible(true);
    }
    
}
