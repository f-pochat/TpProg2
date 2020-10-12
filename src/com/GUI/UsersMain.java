package com.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class UsersMain extends JFrame {
    public UsersMain() {initComponents();}

    private void button2ActionPerformed(ActionEvent e) {
        JFrame sintomas = new UsersSintomas();
        sintomas.setVisible(true);
        sintomas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sintomas.setResizable(false);
        this.setVisible(false);

    }

    private void button1ActionPerformed(ActionEvent e) {
        JFrame contacto = new UsersContacto();
        contacto.setVisible(true);
        contacto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contacto.setResizable(false);
        this.setVisible(false);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Ignacio Ferrari
        label5 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        menu = new JPanel();

        //======== this ========
        setIconImage(null);
        setResizable(false);
        setTitle("TraceIT");
        var contentPane = getContentPane();

        //---- label5 ----
        label5.setText("Ciudadanos");
        label5.setFont(new Font("Doctor Glitch", Font.PLAIN, 26));

        //---- button1 ----
        button1.setText("Indicar contacto estrecho");
        button1.setFont(new Font("Doctor Glitch", Font.PLAIN, 12));
        button1.addActionListener(e -> {
            button1ActionPerformed(e);
        });

        //---- button2 ----
        button2.setText("Presencia de sintomas");
        button1.setFont(new Font("Doctor Glitch", Font.PLAIN, 12));
        button2.addActionListener(e -> {
            button2ActionPerformed(e);
        });

        //---- button3 ----
        button3.setText("Mapa");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(174, 174, 174)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(button3, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button2, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(147, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(236, Short.MAX_VALUE)
                    .addComponent(label5)
                    .addGap(214, 214, 214))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(94, 94, 94)
                    .addComponent(label5)
                    .addGap(49, 49, 49)
                    .addComponent(button1)
                    .addGap(18, 18, 18)
                    .addComponent(button2)
                    .addGap(18, 18, 18)
                    .addComponent(button3)
                    .addContainerGap(145, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());

        //======== menu ========
        {
            menu.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new
            javax.swing.border.EmptyBorder(0,0,0,0), "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e",javax
            .swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java
            .awt.Font("Dialo\u0067",java.awt.Font.BOLD,12),java.awt
            .Color.red),menu. getBorder()));menu. addPropertyChangeListener(new java.beans.
            PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("borde\u0072".
            equals(e.getPropertyName()))throw new RuntimeException();}});

            GroupLayout menuLayout = new GroupLayout(menu);
            menu.setLayout(menuLayout);
            menuLayout.setHorizontalGroup(
                menuLayout.createParallelGroup()
                    .addGap(0, 600, Short.MAX_VALUE)
            );
            menuLayout.setVerticalGroup(
                menuLayout.createParallelGroup()
                    .addGap(0, 440, Short.MAX_VALUE)
            );
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Ignacio Ferrari
    private JLabel label5;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JPanel menu;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
