package com.GUI.Admins;

import com.GUI.Sintomas.Sintomas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Set;

public class AdminCasos extends JFrame {

    DefaultListModel<String> listModel = new DefaultListModel<>();
    HashMap casos;

    public AdminCasos() {
        initComponents();
        Sintomas listaDeSintomas = new Sintomas();
        listaDeSintomas.readSintomas();
        casos = listaDeSintomas.getSintomasYCasos();

        Set keys = casos.keySet();
        for (Object key : keys) {
            listModel.addElement("  " + key + ": "+casos.get(key));
        }
        list1.setModel(listModel);
    }

    private void backActionPerformed(ActionEvent e) {
        JFrame adminMain = new AdminMain();
        adminMain.setVisible(true);
        adminMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminMain.setResizable(false);
        this.setVisible(false);
    }

    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Ignacio Ferrari
        label5 = new JLabel();
        button2 = new JButton();
        list1 = new JList();

        //======== this ========
        setBackground(new Color(102, 204, 255));
        setIconImage(null);
        setTitle("TraceIT");
        var contentPane = getContentPane();

        //---- label5 ----
        label5.setText("Casos");
        label5.setFont(new Font("Doctor Glitch", Font.PLAIN, 26));

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
                    .addContainerGap(147, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label5)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(203, 203, 203)
                                    .addComponent(button2)))
                            .addGap(34, 34, 34))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(list1, GroupLayout.PREFERRED_SIZE, 374, GroupLayout.PREFERRED_SIZE)
                            .addGap(77, 77, 77))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addComponent(button2)
                    .addGap(43, 43, 43)
                    .addComponent(label5)
                    .addGap(18, 18, 18)
                    .addComponent(list1, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(72, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Ignacio Ferrari
    private JLabel label5;
    private JButton button2;
    private JList list1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
