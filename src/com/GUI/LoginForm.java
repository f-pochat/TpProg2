/*
 * Created by JFormDesigner on Sun Oct 04 14:29:35 ART 2020
 */

package com.GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
/**
 * FedePochat
 */
public class LoginForm extends JFrame {
    public LoginForm() {
        initComponents();
    }

    //Boton de entrar por ahora se entra con Tel: 1234 y CUIL: 5678
    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        if(telField.getText().equals("1234") && cuilField.getText().equals("5678")){
            JFrame mainScene = new MainPage();
            mainScene.setVisible(true);
            mainScene.setResizable(false);
            mainScene.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setVisible(false);
        }else{
            JOptionPane.showMessageDialog(null, "Tel y/o Cuil Incorrecto");
        }

    }

    //Boton para ir al Login de Admin
    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
        JFrame adminLog = new AdminLogin();
        adminLog.setVisible(true);
        adminLog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminLog.setResizable(false);
        this.setVisible(false);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label3 = new JLabel();
        telField = new JTextField();
        label4 = new JLabel();
        cuilField = new JTextField();
        label5 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setBackground(new Color(102, 204, 255));
        setIconImage(null);
        setTitle("TraceIT");
        var contentPane = getContentPane();

        //---- label3 ----
        label3.setText("Telefono");
        label3.setFont(new Font("Doctor Glitch", Font.PLAIN, 12));

        //---- label4 ----
        label4.setText("CUIL");
        label4.setFont(new Font("Doctor Glitch", Font.PLAIN, 12));

        //---- label5 ----
        label5.setText("TraceIT");
        label5.setFont(new Font("Doctor Glitch", Font.PLAIN, 26));

        //---- button1 ----
        button1.setText("Entrar");
        button1.setFont(new Font("Doctor Glitch", Font.PLAIN, 12));
        button1.addActionListener(e -> button1ActionPerformed(e));

        //---- button2 ----
        button2.setText("Admin");
        button2.setFont(new Font("Doctor Glitch", Font.PLAIN, 12));
        button2.addActionListener(e -> button2ActionPerformed(e));

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
                        .addComponent(telField, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                        .addComponent(cuilField, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                    .addContainerGap(167, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(264, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(label5)
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
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(telField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label4)
                        .addComponent(cuilField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(80, 80, 80)
                    .addComponent(button1)
                    .addGap(59, 59, 59))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel label3;
    private JTextField telField;
    private JLabel label4;
    private JTextField cuilField;
    private JLabel label5;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


}
