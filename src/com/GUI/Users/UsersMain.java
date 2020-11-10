package com.GUI.Users;

import com.GUI.LoginForm;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class UsersMain extends JFrame {
    DefaultListModel<String> listModel = new DefaultListModel<>();
    DefaultListModel<String> listModel2 = new DefaultListModel<>();
    public UsersMain() {
        initComponents();

    }

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

    private void solicitudActionPerformed(ActionEvent e) {
        // TODO add your code here
        JFrame solicitudes = new UserSolicitudes();
        solicitudes.setVisible(true);
        solicitudes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        solicitudes.setResizable(false);
        this.setVisible(false);
    }

    private void initComponents() {
        User usuario = new User(LoginForm.tel);
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label5 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        list1 = new JList<>();
        label2 = new JLabel();
        label3 = new JLabel();
        scrollPane2 = new JScrollPane();
        list2 = new JList<>();
        button4 = new JButton();
        menu = new JPanel();

        //======== this ========
        setIconImage(null);
        setResizable(false);
        setTitle("TraceIT");
        var contentPane = getContentPane();

        //---- label5 ----
        label5.setText("Ciudadanos");
        label5.setFont(new Font("Segoe UI", Font.PLAIN, 26));

        //---- button1 ----
        button1.setText("Indicar contacto estrecho");
        button1.addActionListener(e -> button1ActionPerformed(e));

        //---- button2 ----
        button2.setText("Presencia de sintomas");
        button2.addActionListener(e -> button2ActionPerformed(e));

        //---- button3 ----
        button3.setText("Mapa");

        //---- label1 ----
        label1.setText("Text");

        //======== scrollPane1 ========
        {

            //---- list1 ----
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
        }

        //---- label2 ----
        label2.setText("Contactos Estrechos");

        //---- label3 ----
        label3.setText("Contactos Pendientes");

        //======== scrollPane2 ========
        {

            //---- list2 ----
            list2.setModel(new AbstractListModel<String>() {
                String[] values = {
                    "Contactos"
                };
                @Override
                public int getSize() { return values.length; }
                @Override
                public String getElementAt(int i) { return values[i]; }
            });
            scrollPane2.setViewportView(list2);
        }

        //---- button4 ----
        button4.setText("Solicitudes de Contactos");
        button4.addActionListener(e -> solicitudActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(248, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
                            .addGap(34, 34, 34))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(label5)
                            .addGap(216, 216, 216))))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label3, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                                .addComponent(label2, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 31, Short.MAX_VALUE)))
                            .addGap(26, 26, 26))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)))
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(button3, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button2, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button4, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE))
                    .addGap(104, 104, 104))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addComponent(label1)
                    .addGap(23, 23, 23)
                    .addComponent(label5)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(label2)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(label3)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(button1)
                            .addGap(18, 18, 18)
                            .addComponent(button4)
                            .addGap(18, 18, 18)
                            .addComponent(button2)
                            .addGap(27, 27, 27)))
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button3))
                    .addContainerGap(34, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());

        //======== menu ========
        {
            menu.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder(
            0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder
            . BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt. Color.
            red) ,menu. getBorder( )) ); menu. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .
            beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

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
        if (usuario.getTel() != null){
            label1.setText(String.valueOf("Bienvenido, " + usuario.getTel()));
        }else{
            label1.setText("");
        }

        for (String str:usuario.getVerificadoContactos()){
            listModel.addElement("  " + str);
        }
        list1.setModel(listModel);

        for (String str:usuario.getPendienteContactos()){
            listModel2.addElement("  " + str);
        }
        list2.setModel(listModel2);

        

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel label5;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JList<String> list1;
    private JLabel label2;
    private JLabel label3;
    private JScrollPane scrollPane2;
    private JList<String> list2;
    private JButton button4;
    private JPanel menu;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
