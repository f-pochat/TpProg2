package com.GUI.Users;

import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;
import javax.swing.*;

import com.GUI.LoginForm;
import com.ReadersWriter.UserWriterReader;


public class UsersContacto extends JFrame implements PropertyChangeListener {
    public UsersContacto (){
        initComponents();
    }


    private void backActionPerformed(ActionEvent e) {
        JFrame usersMain = new UsersMain();
        usersMain.setVisible(true);
        usersMain.setResizable(false);
        usersMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(false);
    }

    int count = 0; // ver     public void propertyChange(PropertyChangeEvent event) para entender su uso

    private void button1ActionPerformed(ActionEvent e) {
        count = 1;
        CalendarWindow calendarWindow = new CalendarWindow();
        calendarWindow.addPropertyChangeListener(this);
        InicioTxt.setValue(new Date());
        calendarWindow.setUndecorated(true);
        calendarWindow.setLocation(InicioTxt.getLocationOnScreen().x,(InicioTxt.getLocationOnScreen().y)+InicioTxt.getHeight());
        calendarWindow.setVisible(true);

    }

    private void button2ActionPerformed(ActionEvent e) {
        count = 2;
        CalendarWindow calendarWindow2 = new CalendarWindow();
        calendarWindow2.addPropertyChangeListener(this);
        FinTxt.setValue(new Date());
        calendarWindow2.setUndecorated(true);
        calendarWindow2.setLocation(FinTxt.getLocationOnScreen().x,(FinTxt.getLocationOnScreen().y)+FinTxt.getHeight());
        calendarWindow2.setVisible(true);
    }


    private void InformarBttActionPerformed(ActionEvent e) {
        User usuario = new User(LoginForm.tel,LoginForm.cuil);
        try{
            Date inicio = (Date) InicioTxt.getValue();
            Date fin = (Date) FinTxt.getValue();
            if (inicio.compareTo(fin)>0 || InicioTxt.getText().length()==0 || FinTxt.getText().length()==0){
                JOptionPane.showMessageDialog(null, "Ingrese dos fechas validas");
                return;
            }
        } catch (NullPointerException ne){
            JOptionPane.showMessageDialog(null, "Ingrese dos fechas validas");
            return;
        }
        if(UserWriterReader.containsContact(usuario.getTel(),TelTxt.getText())) {
            JOptionPane.showMessageDialog(null, "Contacto ya registrado");
            return;
        }else {
            if (UserWriterReader.containsTel(TelTxt.getText())) {
                JOptionPane.showMessageDialog(null, "Solicitud de encuentro enviada");
                // Lo agrega al archivo
                UserWriterReader.addContact(usuario.getTel(), TelTxt.getText());
                return;
            } else {
                JOptionPane.showMessageDialog(null, "Numero inexistente");
                return;
            }
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Ignacio Ferrari
        ContactoLbl = new JLabel();
        BackBtt = new JButton();
        TelTxt = new JTextField();
        TelLbl = new JLabel();
        label2 = new JLabel();
        InicioBtt = new JButton();
        InicioTxt = new JFormattedTextField();
        label6 = new JLabel();
        button2 = new JButton();
        FinLbl = new JLabel();
        FinTxt = new JFormattedTextField();
        InformarBtt = new JButton();

        //======== this ========
        setIconImage(null);
        setResizable(false);
        setTitle("TraceIT");
        var contentPane = getContentPane();

        //---- ContactoLbl ----
        ContactoLbl.setText("Contacto estrecho");
        ContactoLbl.setFont(new Font("Doctor Glitch", Font.PLAIN, 26));

        //---- BackBtt ----
        BackBtt.setText("Back");
        BackBtt.setFont(new Font("Doctor Glitch", Font.PLAIN, 12));
        BackBtt.addActionListener(e -> {
			backActionPerformed(e);
		});

        //---- TelLbl ----
        TelLbl.setText("Telefono");

        //---- InicioBtt ----
        InicioBtt.setText("Selec");
        InicioBtt.addActionListener(e -> button1ActionPerformed(e));

        //---- label6 ----
        label6.setText("Inicio");
        label6.setFont(new Font("Doctor Glitch", Font.PLAIN, 21));

        //---- button2 ----
        button2.setText("Selec");
        button2.addActionListener(e -> button2ActionPerformed(e));

        //---- FinLbl ----
        FinLbl.setText("Fin");
        FinLbl.setFont(new Font("Doctor Glitch", Font.PLAIN, 21));

        //---- InformarBtt ----
        InformarBtt.setText("Informar");
        InformarBtt.addActionListener(e -> {
			InformarBttActionPerformed(e);
		});

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap(44, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(BackBtt)
                            .addGap(34, 34, 34))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(InicioTxt, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
                                .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                                    .addGap(60, 60, 60)
                                    .addComponent(label6)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(InicioBtt, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                                    .addComponent(FinTxt, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button2, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                                    .addGap(56, 56, 56))
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                    .addComponent(FinLbl)
                                    .addGap(154, 154, 154))))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)
                            .addGap(144, 144, 144))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(ContactoLbl)
                            .addGap(180, 180, 180))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(TelLbl, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(TelTxt, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
                            .addGap(170, 170, 170))))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(220, 220, 220)
                    .addComponent(InformarBtt, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 240, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addComponent(BackBtt)
                    .addGap(22, 22, 22)
                    .addComponent(ContactoLbl)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(TelTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(TelLbl))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(FinLbl)
                        .addComponent(label6))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, 16, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(InicioTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(InicioBtt)
                        .addComponent(button2)
                        .addComponent(FinTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(InformarBtt, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                    .addGap(20, 20, 20))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    @Override
    public void propertyChange(PropertyChangeEvent event) {

        //get the selected date from the calendar2 control and set it to the text field
        if (event.getPropertyName().equals("selectedDate")) {
            java.util.Calendar cal = (java.util.Calendar) event.getNewValue();
            Date selDate = cal.getTime();
            if (count==1) {
                InicioTxt.setValue(selDate); // Si el contador esta en 1, es porque se apreto el primer boton
                // No se me ocurrio otra forma de hacerlo
            } else if (count==2) {
                FinTxt.setValue(selDate); //Si esta en otro valor (2 si o si) esta en el segundo
            }
        }

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Ignacio Ferrari
    private JLabel ContactoLbl;
    private JButton BackBtt;
    private JTextField TelTxt;
    private JLabel TelLbl;
    private JLabel label2;
    private JButton InicioBtt;
    private JFormattedTextField InicioTxt;
    private JLabel label6;
    private JButton button2;
    private JLabel FinLbl;
    private JFormattedTextField FinTxt;
    private JButton InformarBtt;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
