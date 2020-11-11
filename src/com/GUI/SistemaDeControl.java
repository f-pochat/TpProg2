package com.GUI;

import java.awt.*;
import java.awt.event.*;
import com.GUI.Sintomas.Sintomas;
import com.GUI.Users.User;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import net.miginfocom.swing.*;

public class SistemaDeControl extends JFrame {

    DefaultListModel<String> listModel = new DefaultListModel<>();
    private ArrayList<String> verificadoContactos = new ArrayList<>();
    private ArrayList<String> sintomasPresentados = new ArrayList<>();
    private HashMap<String, String> usuariosConSintomas;
    private String tel;
    Sintomas listaDeSintomas = new Sintomas();


    public SistemaDeControl(ArrayList<String> verificadoContactos, ArrayList<String> sintomasPresentados, String tel) {
        this.verificadoContactos = verificadoContactos;
        this.sintomasPresentados = sintomasPresentados;
        this.tel = tel;
        VerificarContacto();
    }

    public void VerificarContacto() {

        String line;

        try {

            FileReader fileReader = new FileReader("Contactos" + File.separator + tel+".txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            User esteUsuario = new User(tel);

            while ((line = bufferedReader.readLine()) != null) {

                String[] data = line.split(",");
                for (int i = 0; i <sintomasPresentados.size() ; i++) {
                    for (int j = 1; j <data.length; j++) {
                        if (sintomasPresentados.get(i).equals(data[i])) {
                            User contagiado = new User(data[0]);
                            usuariosConSintomas.put(data[0], data[i]);
                            esteUsuario.setFueContagiado(true);
                            if (contagiado.fueContagiado()==true){
                                hayUnBrote(data[i]);
                            }
                        }
                    }
                }
            }
        } catch (Exception e){
            System.out.println( e.getMessage());
        }

    }

    private void hayUnBrote(String str) {
        listModel.addElement("  " + str);
        list1.setModel(listModel);
        System.out.println("Brote");

    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void backActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Ignacio Ferrari
        label5 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        scrollPane1 = new JScrollPane();
        list1 = new JList();
        label3 = new JLabel();

        //======== this ========
        setIconImage(null);
        setResizable(false);
        setTitle("TraceIT");
        var contentPane = getContentPane();

        //---- label5 ----
        label5.setText("Control");
        label5.setFont(new Font("Doctor Glitch", Font.PLAIN, 26));

        //---- button1 ----
        button1.setText("Agregar sintoma");
        button1.addActionListener(e -> button1ActionPerformed(e));

        //---- button2 ----
        button2.setText("Remover sintoma");

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(list1);
        }

        //---- label3 ----
        label3.setText("Telefono");
        label3.setFont(new Font("Doctor Glitch", Font.PLAIN, 12));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(290, Short.MAX_VALUE)
                    .addComponent(label5)
                    .addGap(214, 214, 214))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(166, 166, 166)
                            .addComponent(button1)
                            .addGap(18, 18, 18)
                            .addComponent(button2))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(32, 32, 32)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(108, 108, 108)
                            .addComponent(label3)))
                    .addContainerGap(133, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(106, 106, 106)
                    .addComponent(label5)
                    .addGap(33, 33, 33)
                    .addComponent(label3)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button2)
                        .addComponent(button1))
                    .addContainerGap(68, Short.MAX_VALUE))
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
    private JScrollPane scrollPane1;
    private JList list1;
    private JLabel label3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

