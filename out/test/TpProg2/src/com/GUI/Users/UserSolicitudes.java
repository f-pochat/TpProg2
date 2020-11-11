/*
 * Created by JFormDesigner on Wed Oct 21 20:01:43 ART 2020
 */

package com.GUI.Users;

import java.awt.event.*;
import com.GUI.LoginForm;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class UserSolicitudes extends JFrame {
    User usuario;
    DefaultListModel<String> listModel = new DefaultListModel<>();

    public UserSolicitudes() {
        initComponents();
    }

    private void aceptarActionPerformed(ActionEvent e) {
        // TODO add your code here
        if (!list1.isSelectionEmpty()){
            String selected = usuario.getSolicitudesdeContacto().get(list1.getSelectedIndex());
            usuario.addContact(selected);
            JFrame solicitudes = new UserSolicitudes();
            solicitudes.setVisible(true);
            solicitudes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            solicitudes.setResizable(false);
            this.setVisible(false);
        }
    }

    private void button3ActionPerformed(ActionEvent e) {
        // TODO add your code here
        JFrame menu = new UsersMain();
        menu.setVisible(true);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setResizable(false);
        this.setVisible(false);
    }

    private void rechazarActionPerformed(ActionEvent e) {
        // TODO add your code here
        if (!list1.isSelectionEmpty()){
            String selected = usuario.getSolicitudesdeContacto().get(list1.getSelectedIndex());
            usuario.rejectContact(selected);
            JFrame solicitudes = new UserSolicitudes();
            solicitudes.setVisible(true);
            solicitudes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            solicitudes.setResizable(false);
            this.setVisible(false);
        }
    }


    private void initComponents() {
        usuario = new User(LoginForm.tel);

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Ignacio Ferrari
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        list1 = new JList();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();

        //======== this ========
        setFont(new Font("Segoe UI", Font.PLAIN, 26));
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Solicitudes de Contactos");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 2f));
        label1.setHorizontalAlignment(SwingConstants.CENTER);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(list1);
        }

        //---- button1 ----
        button1.setText("Aceptar");
        button1.addActionListener(e -> aceptarActionPerformed(e));

        //---- button2 ----
        button2.setText("Rechazar");
        button2.addActionListener(e -> rechazarActionPerformed(e));

        //---- button3 ----
        button3.setText("Back");
        button3.addActionListener(e -> button3ActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(138, 138, 138)
                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                    .addGap(58, 58, 58)
                    .addComponent(button2, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(133, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(97, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 419, GroupLayout.PREFERRED_SIZE)
                            .addGap(82, 82, 82))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(button3)
                            .addGap(61, 61, 61))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE)
                            .addGap(157, 157, 157))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(button3)
                    .addGap(12, 12, 12)
                    .addComponent(label1)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button2, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
                    .addGap(22, 22, 22))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        for (String str:usuario.getSolicitudesdeContacto()){
            listModel.addElement("  " + str);
        }
        list1.setModel(listModel);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Ignacio Ferrari
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JList list1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
