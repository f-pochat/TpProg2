/*
 * Created by JFormDesigner on Tue Oct 06 15:21:46 ART 2020
 */

package com.GUI.Users;

import com.GUI.LoginForm;
import com.txt.UserWriterReader;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class RegisterUser extends JFrame {
    public RegisterUser() {
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        JFrame mainLogin = new LoginForm();
        mainLogin.setVisible(true);
        mainLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainLogin.setResizable(false);
        this.setVisible(false);
    }

    private void button3ActionPerformed(ActionEvent e) {
        // Si el telefono y el cuil son solo numeros
        if(telField.getText().matches("-?\\d+(\\.\\d+)?") && cuilField.getText().matches("-?\\d+(\\.\\d+)?")){
            //Si users.txt contiene ese tel
            if (UserWriterReader.containsTel(telField.getText())){
                JOptionPane.showMessageDialog(null, "Telefono ya registrado");
                //Si users.txt contiene ese cuil
            }else if(UserWriterReader.containsCuil(cuilField.getText())){
                JOptionPane.showMessageDialog(null, "CUIL ya registrado");
                //Sino escribir y registrar ese usuario y entrar
            }else{
                UserWriterReader.addUser(telField.getText(),cuilField.getText());
                JFrame usersMain = new UsersMain();
                usersMain.setVisible(true);
                usersMain.setResizable(false);
                usersMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.setVisible(false);
            }
            //Sino salta el mensaje
        }else{
            JOptionPane.showMessageDialog(null, "Telefono y/o Cuil solo con numeros");
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Ignacio Ferrari
        label3 = new JLabel();
        telField = new JTextField();
        label4 = new JLabel();
        cuilField = new JTextField();
        label5 = new JLabel();
        button1 = new JButton();
        button3 = new JButton();

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
        button1.setText("Atras");
        button1.setFont(new Font("Doctor Glitch", Font.PLAIN, 12));
        button1.addActionListener(e -> button1ActionPerformed(e));

        //---- button3 ----
        button3.setText("Registarse");
        button3.setFont(new Font("Doctor Glitch", Font.PLAIN, 12));
        button3.addActionListener(e -> button3ActionPerformed(e));

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
                    .addContainerGap(210, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(label5)
                            .addGap(220, 220, 220))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(button1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(button3)
                            .addGap(185, 185, 185))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(95, 95, 95)
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
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1)
                        .addComponent(button3))
                    .addGap(59, 59, 59))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Ignacio Ferrari
    private JLabel label3;
    private JTextField telField;
    private JLabel label4;
    private JTextField cuilField;
    private JLabel label5;
    private JButton button1;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
