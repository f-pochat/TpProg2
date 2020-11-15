package com.GUI.Admins;

import com.GUI.LoginForm;
import com.GUI.Users.User;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.awt.*;
import java.awt.event.ActionEvent;

public class UsuariosBloqueados extends JFrame {

    User usuario;
    DefaultListModel<String> listModel = new DefaultListModel<>();

    public UsuariosBloqueados() {
        initComponents();

        usuario = new User(LoginForm.tel);

        for (String str:usuario.getusuariosBloqueados()){
            listModel.addElement("  " + str);
        }
        list1.setModel(listModel);

    }

    private void rechazarActionPerformed(ActionEvent e) {
        if (!list1.isSelectionEmpty()){
            String selected = usuario.getusuariosBloqueados().get(list1.getSelectedIndex());
            usuario = new User(selected);
            usuario.sumarContactoRechazado(selected,-1); // Lo que hace es settear la cantidad de rechazos en 0
            usuario.desbloquearUsuario();
            JFrame bloqueos = new UsuariosBloqueados();
            bloqueos.setVisible(true);
            bloqueos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            bloqueos.setResizable(false);
            this.setVisible(false);
        }
    }

    private void button3ActionPerformed(ActionEvent e) {
        JFrame adminMain = new AdminMain();
        adminMain.setVisible(true);
        adminMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminMain.setResizable(false);
        this.setVisible(false);
    }

    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void list1ValueChanged(ListSelectionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Ignacio Ferrari
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        list1 = new JList();
        button2 = new JButton();
        button3 = new JButton();

        //======== this ========
        setFont(new Font("Segoe UI", Font.PLAIN, 26));
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Usuarios bloqueados:");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 2f));
        label1.setHorizontalAlignment(SwingConstants.CENTER);

        //======== scrollPane1 ========
        {

            //---- list1 ----
            list1.addListSelectionListener(e -> list1ValueChanged(e));
            scrollPane1.setViewportView(list1);
        }

        //---- button2 ----
        button2.setText("Desbloquear usuario");
        button2.addActionListener(e -> {
			rechazarActionPerformed(e);
			button2ActionPerformed(e);
		});

        //---- button3 ----
        button3.setText("Back");
        button3.addActionListener(e -> button3ActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
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
                            .addGap(157, 157, 157))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(button2, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE)
                            .addGap(134, 134, 134))))
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
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                    .addComponent(button2, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                    .addGap(22, 22, 22))
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
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
