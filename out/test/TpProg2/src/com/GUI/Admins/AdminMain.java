/*
 * Created by JFormDesigner on Sun Oct 04 15:23:05 ART 2020
 */

package com.GUI.Admins;

import com.GUI.Sintomas.Sintomas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * FedePochat
 */
public class AdminMain extends JFrame {
    public AdminMain() {
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e) {
        Sintomas listaDeSintomas = new Sintomas();
        listaDeSintomas.readSintomas();
        String sintoma = JOptionPane.showInputDialog("Ingrese el nombre de su sintoma:");
        listaDeSintomas.addSintoma(sintoma);
    }

    private void button2ActionPerformed(ActionEvent e) {
        JFrame adminCasos = new AdminCasos();
        adminCasos.setVisible(true);
        adminCasos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminCasos.setResizable(false);
        this.setVisible(false);
    }

    private void initComponents() {
        Admin administrador = new Admin(AdminLogin.tel);
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Ignacio Ferrari
        label5 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //---- label5 ----
        label5.setText("Administradores");
        label5.setFont(new Font("Doctor Glitch", Font.PLAIN, 26));

        //---- button1 ----
        button1.setText("Ingresar nuevo sintoma");
        button1.addActionListener(e -> {
			button1ActionPerformed(e);
		});

        //---- button2 ----
        button2.setText("Ver cantidad de casos");
        button2.addActionListener(e -> {
			button2ActionPerformed(e);
		});

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap(173, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(label5)
                            .addGap(173, 173, 173))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(button2, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
                                .addComponent(button1, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE))
                            .addGap(133, 133, 133))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(101, 101, 101)
                    .addComponent(label5)
                    .addGap(38, 38, 38)
                    .addComponent(button1)
                    .addGap(26, 26, 26)
                    .addComponent(button2)
                    .addContainerGap(189, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Ignacio Ferrari
    private JLabel label5;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
