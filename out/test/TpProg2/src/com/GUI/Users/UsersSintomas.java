package com.GUI.Users;

import com.GUI.LoginForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class UsersSintomas extends JFrame {
    User usuario;
    DefaultListModel<String> listModel = new DefaultListModel<>();
    
    public UsersSintomas (){initComponents();}

    private void button2ActionPerformed(ActionEvent e) {

        if (!list1.isSelectionEmpty()){
            String selected = usuario.getSintomasPresentados().get(list1.getSelectedIndex());
            usuario.deleteSintoma(selected);
        }
        JFrame sintomas = new UsersSintomas();
        sintomas.setVisible(true);
        sintomas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sintomas.setResizable(false);
        this.setVisible(false);
    }

    private void backActionPerformed(ActionEvent e) {
        JFrame usersMain = new UsersMain();
        usersMain.setVisible(true);
        usersMain.setResizable(false);
        usersMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(false);
    }

    private void button1ActionPerformed(ActionEvent e) {
        String sintoma = JOptionPane.showInputDialog("Ingrese el nombre de su sintoma:");
        if (usuario.addSintoma(sintoma)){
            listModel.addElement("  " + sintoma);
            JOptionPane.showMessageDialog(null,"Sintoma agregado");
            list1.setModel(listModel);
        }
        
       
    }

    private void initComponents() {
        usuario = new User(LoginForm.tel);
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Fede Pocha
        label5 = new JLabel();
        button1 = new JButton();
        button4 = new JButton();
        button2 = new JButton();
        scrollPane1 = new JScrollPane();
        list1 = new JList();
        menu = new JPanel();

        //======== this ========
        setIconImage(null);
        setResizable(false);
        setTitle("TraceIT");
        var contentPane = getContentPane();

        //---- label5 ----
        label5.setText("Sintomas");
        label5.setFont(new Font("Doctor Glitch", Font.PLAIN, 26));

        //---- button1 ----
        button1.setText("Agregar sintoma");
        button1.addActionListener(e -> button1ActionPerformed(e));

        //---- button4 ----
        button4.setText("Back");
        button4.setFont(new Font("Doctor Glitch", Font.PLAIN, 12));
        button4.addActionListener(e -> backActionPerformed(e));

        //---- button2 ----
        button2.setText("Remover sintoma");
        button2.addActionListener(e -> button2ActionPerformed(e));

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(list1);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(237, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(label5)
                            .addGap(214, 214, 214))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(button4)
                            .addGap(34, 34, 34))))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(166, 166, 166)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(scrollPane1)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(button1)
                            .addGap(18, 18, 18)
                            .addComponent(button2)))
                    .addContainerGap(164, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addComponent(button4)
                    .addGap(48, 48, 48)
                    .addComponent(label5)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button2)
                        .addComponent(button1))
                    .addContainerGap(61, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());

        //======== menu ========
        {
            menu.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing.
            border. EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder. CENTER
            , javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font
            .BOLD ,12 ), java. awt. Color. red) ,menu. getBorder( )) ); menu. addPropertyChangeListener (
            new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r"
            .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

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

        for (String str:usuario.getSintomasPresentados()){
            listModel.addElement("  " + str);
        }
        list1.setModel(listModel);
    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Fede Pocha
    private JLabel label5;
    private JButton button1;
    private JButton button4;
    private JButton button2;
    private JScrollPane scrollPane1;
    private JList list1;
    private JPanel menu;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

