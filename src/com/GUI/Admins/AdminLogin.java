/*
 * Created by JFormDesigner on Sun Oct 04 15:18:15 ART 2020
 */

package com.GUI.Admins;

import com.GUI.LoginForm;
import com.txt.AdminReader;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * FedePochat
 */
public class AdminLogin extends JFrame {
    public AdminLogin() {
        initComponents();
    }

    //Se fija si existe ese usuario en admin.txt
    private void button1ActionPerformed(ActionEvent e) {
        String passwordString = new String(passwordField.getPassword());
        if(AdminReader.findUserandPassword(userField.getText(),passwordString)){
            JFrame adminMain = new AdminMain();
            adminMain.setVisible(true);
            adminMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            adminMain.setResizable(false);
            this.setVisible(false);
            //Sino salta el mensaje
        }else{
            JOptionPane.showMessageDialog(null, "Usuario y/o Contraseña incorrecta");
        }
    }

    //Boton para volver a el Login normal
    private void backActionPerformed(ActionEvent e) {
        // TODO add your code here
        JFrame mainLogin = new LoginForm();
        mainLogin.setVisible(true);
        mainLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainLogin.setResizable(false);
        this.setVisible(false);
    }

    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Ignacio Ferrari
        label3 = new JLabel();
        userField = new JTextField();
        label4 = new JLabel();
        label5 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        passwordField = new JPasswordField();

        //======== this ========
        setBackground(new Color(102, 204, 255));
        setIconImage(null);
        setTitle("TraceIT");
        var contentPane = getContentPane();

        //---- label3 ----
        label3.setText("Usuario");
        label3.setFont(new Font("Doctor Glitch", Font.PLAIN, 12));

        //---- label4 ----
        label4.setText("Contrasena");
        label4.setFont(new Font("Doctor Glitch", Font.PLAIN, 12));

        //---- label5 ----
        label5.setText("TraceIT");
        label5.setFont(new Font("Doctor Glitch", Font.PLAIN, 26));

        //---- button1 ----
        button1.setText("Entrar");
        button1.setFont(new Font("Doctor Glitch", Font.PLAIN, 12));
        button1.addActionListener(e -> {
			button1ActionPerformed(e);
			button1ActionPerformed(e);
		});

        //---- button2 ----
        button2.setText("Back");
        button2.setFont(new Font("Doctor Glitch", Font.PLAIN, 12));
        button2.addActionListener(e -> {
			button2ActionPerformed(e);
			backActionPerformed(e);
		});

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(201, 201, 201)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label3)
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(label4)
                            .addGap(25, 25, 25)))
                    .addGap(31, 31, 31)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(userField, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                        .addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                    .addContainerGap(145, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(283, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(label5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(220, 220, 220))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(button2)
                            .addGap(34, 34, 34))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(button1)
                            .addGap(237, 237, 237))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addComponent(button2)
                    .addGap(30, 30, 30)
                    .addComponent(label5)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(userField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label4)
                            .addGap(86, 86, 86)
                            .addComponent(button1))
                        .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(59, 59, 59))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Ignacio Ferrari
    private JLabel label3;
    private JTextField userField;
    private JLabel label4;
    private JLabel label5;
    private JButton button1;
    private JButton button2;
    private JPasswordField passwordField;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
