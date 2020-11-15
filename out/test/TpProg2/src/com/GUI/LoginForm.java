/*
 * Created by JFormDesigner on Sun Oct 04 14:29:35 ART 2020
 */

package com.GUI;

import com.GUI.Admins.AdminLogin;
import com.GUI.Users.RegisterUser;
import com.GUI.Users.User;
import com.GUI.Users.UsersMain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * FedePochat
 */
public class LoginForm extends JFrame {

    public LoginForm() {
        initComponents();
    }
    public static String tel;
    public static String cuil;
    private ArrayList avisoALosContactos = new ArrayList();


    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        //Se fija si existe ese usuario en users.txt
        User usuario = new User(telField.getText());
        if(usuario.matchesCuil(cuilField.getText())){
            tel = telField.getText();
            avisoALosContactos = usuario.contactosConSintoma();
            for (int i = 0; i <avisoALosContactos.size() ; i++) {
                JOptionPane.showMessageDialog(null,avisoALosContactos.get(i), "A CUIDARSE!", JOptionPane.INFORMATION_MESSAGE);
            }
            JFrame usersMain = new UsersMain();
            usersMain.setVisible(true);
            usersMain.setResizable(false);
            usersMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setVisible(false);
            //Sino salta el mensaje
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

    private void button3ActionPerformed(ActionEvent e) {
        // TODO add your code here
        JFrame registerScene = new RegisterUser();
        registerScene.setVisible(true);
        registerScene.setResizable(false);
        registerScene.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        button1.setText("Entrar");
        button1.setFont(new Font("Doctor Glitch", Font.PLAIN, 12));
        button1.addActionListener(e -> button1ActionPerformed(e));

        //---- button2 ----
        button2.setText("Admin");
        button2.setFont(new Font("Doctor Glitch", Font.PLAIN, 12));
        button2.addActionListener(e -> button2ActionPerformed(e));

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
                    .addContainerGap(203, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(label5)
                            .addGap(220, 220, 220))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(button2)
                            .addGap(34, 34, 34))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(button1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(button3)
                            .addGap(185, 185, 185))))
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
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel label3;
    private JTextField telField;
    private JLabel label4;
    private JTextField cuilField;
    private JLabel label5;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public String getTel (){ // Lo uso en UsersContacto
        return tel;
    }

}
