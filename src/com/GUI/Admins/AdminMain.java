/*
 * Created by JFormDesigner on Sun Oct 04 15:23:05 ART 2020
 */

package com.GUI.Admins;

import com.GUI.Sintomas.Sintomas;
import com.GUI.Sintomas.SistemaDeControl;
import com.GUI.Users.User;
import com.ReadersWriter.UserWriterReader;

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

    private void button3ActionPerformed(ActionEvent e) {
        JFrame usuariosBloqueados = new UsuariosBloqueados();
        usuariosBloqueados.setVisible(true);
        usuariosBloqueados.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        usuariosBloqueados.setResizable(false);
        this.setVisible(false);
    }

    private void button4ActionPerformed(ActionEvent e) {
        String telefono = JOptionPane.showInputDialog("Ingrese el telefono del usuario:");
        if (!UserWriterReader.containsTel(telefono)){
            JOptionPane.showMessageDialog(null,"El telefono ingresado no pertenece a un usuario registrado");
            return;
        }
        User usuario = new User(telefono);
        if (usuario.isBloqued()){
            JOptionPane.showMessageDialog(null,"El usuario ya esta bloqueado");
            return;
        }
        usuario.bloquearUsuario(telefono);
        JOptionPane.showMessageDialog(null,"Usuario "+telefono+" bloqueado con exito");
    }

    private void initComponents() {
        Admin administrador = new Admin(AdminLogin.tel);

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - seba adaro
        label5 = new JLabel();
        label2 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        scrollPane1 = new JScrollPane();
        list1 = new JList();
        button3 = new JButton();
        button4 = new JButton();

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

        //---- button3 ----
        button3.setText("Usuarios bloqueados");
        button3.addActionListener(e -> button3ActionPerformed(e));

        //---- button4 ----
        button4.setText("Bloquear un usuario");
        button4.addActionListener(e -> button4ActionPerformed(e));

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
                                .addComponent(button1, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)
                                .addComponent(button3, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)
                                .addComponent(button4, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)
                                .addComponent(button2, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE))))
                    .addGap(138, 138, 138))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(104, 104, 104)
                            .addComponent(label5)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addContainerGap(122, Short.MAX_VALUE)
                            .addComponent(label2)
                            .addGap(18, 18, 18)))
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(button1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(button2)
                            .addGap(12, 12, 12)
                            .addComponent(button4)
                            .addGap(19, 19, 19)
                            .addComponent(button3, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)))
                    .addGap(107, 107, 107))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - seba adaro
    private JLabel label5;
    private JLabel label2;
    private JButton button1;
    private JButton button2;
    private JScrollPane scrollPane1;
    private JList list1;
    private JButton button3;
    private JButton button4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
