package com.GUI;

import com.GUI.Users.User;
import com.ReadersWriter.UserWriterReader;

import javax.swing.*;
/**
 * FedePochat
 */

public class Main {
    public static void main(String[] args) {
        JFrame frame = new LoginForm();
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        ImageIcon img = new ImageIcon("src/com/GUI/images/austral.png");
        frame.setIconImage(img.getImage());


    }
}
