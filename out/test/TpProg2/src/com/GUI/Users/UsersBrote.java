package com.GUI.Users;

import com.GUI.Sintomas.SistemaDeControl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Set;

public class UsersBrote extends JFrame {

        public UsersBrote() {
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

        private void button3ActionPerformed(ActionEvent e) {
            JFrame menu = new UsersMain();
            menu.setVisible(true);
            menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            menu.setResizable(false);
            this.setVisible(false);
        }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Ignacio Ferrari
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        list1 = new JList();
        button3 = new JButton();

        //======== this ========
        setFont(new Font("Segoe UI", Font.PLAIN, 26));
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Brotes");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 2f));
        label1.setHorizontalAlignment(SwingConstants.CENTER);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(list1);
        }

        //---- button3 ----
        button3.setText("Back");
        button3.addActionListener(e -> button3ActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
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
                    .addContainerGap(96, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Ignacio Ferrari
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JList list1;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
