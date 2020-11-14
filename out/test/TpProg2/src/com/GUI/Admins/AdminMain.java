/*
 * Created by JFormDesigner on Sun Oct 04 15:23:05 ART 2020
 */

package com.GUI.Admins;

import com.GUI.Sintomas.Sintomas;
import com.GUI.Sintomas.SistemaDeControl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Set;

/**
 * FedePochat
 */
public class AdminMain extends JFrame {
    public AdminMain() {

        initComponents();

        DefaultListModel<String> listModel = new DefaultListModel<>();
        SistemaDeControl sistema = new SistemaDeControl();
        HashMap casos = sistema.getSintomasYCasos();

        try {

            Set keys = casos.keySet();
            for (Object key : keys) {
                listModel.addElement("  " + key + ": " + casos.get(key));
            }
            list1.setModel(listModel);
        } catch (NullPointerException e){
            System.out.println(e.getMessage());
        }


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
        label2 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        scrollPane1 = new JScrollPane();
        list1 = new JList();

        //======== this ========
        var contentPane = getContentPane();

        //---- label5 ----
        label5.setText("Administradores");
        label5.setFont(new Font("Doctor Glitch", Font.PLAIN, 26));

        //---- label2 ----
        label2.setText("Brotes");

        //---- button1 ----
        button1.setText("Agregar sinoma");
        button1.addActionListener(e -> button1ActionPerformed(e));

        //---- button2 ----
        button2.setText("Ver casos por sintoma");
        button2.addActionListener(e -> button2ActionPerformed(e));

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(list1);
        }

        list1.setModel(new AbstractListModel<String>() {
            String[] values = {
                    "Contactos"
            };
            @Override
            public int getSize() { return values.length; }
            @Override
            public String getElementAt(int i) { return values[i]; }
        });
        scrollPane1.setViewportView(list1);

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(33, 33, 33)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(label2, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(90, 90, 90)
                            .addComponent(label5))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(38, 38, 38)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(button2, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)
                                .addComponent(button1, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE))))
                    .addGap(138, 138, 138))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(104, 104, 104)
                            .addComponent(label5)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addContainerGap(130, Short.MAX_VALUE)
                            .addComponent(label2)
                            .addGap(18, 18, 18)))
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(button1)
                            .addGap(32, 32, 32)
                            .addComponent(button2)
                            .addGap(190, 190, 190))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
                            .addGap(123, 123, 123))))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Ignacio Ferrari
    private JLabel label5;
    private JLabel label2;
    private JButton button1;
    private JButton button2;
    private JScrollPane scrollPane1;
    private JList list1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
