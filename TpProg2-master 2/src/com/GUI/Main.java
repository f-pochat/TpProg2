package com.GUI;

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
    }
}
