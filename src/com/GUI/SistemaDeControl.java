package com.GUI;

import java.awt.*;
import java.awt.event.*;
import com.GUI.Sintomas.Sintomas;
import com.GUI.Users.User;

import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class SistemaDeControl extends JFrame {

    DefaultListModel<String> listModel = new DefaultListModel<>();
    private ArrayList<String> sintomasCoincidentesConContactos = new ArrayList<>();
    private ArrayList<String> contactosVerificados = new ArrayList<>();
    private ArrayList<String> posibleBroteHabilitado = new ArrayList<>(); // Sirve por si hay 3 contaggios, pero todavia no hay 5 casos. Cuando haya 5 casos, dispara brote
    private String tel;
    Sintomas listaDeSintomas = new Sintomas();


    public SistemaDeControl(String tel) {
        User thisUser = new User(tel);
        sintomasCoincidentesConContactos = thisUser.getSintomasCoincidentesConContactos();
        contactosVerificados = thisUser.getContactosEstrechos();
        this.tel = tel;
        VerificarSiHayBrote(thisUser);
    }

    private void VerificarSiHayBrote(User thisUser) {
        for (int i = 0; i < contactosVerificados.size(); i++) {
            User anotherUser = new User(contactosVerificados.get(i));
            if (anotherUser.getSintomasCoincidentesConContactos().contains(sintomasCoincidentesConContactos.get(i)) || posibleBroteHabilitado.contains(sintomasCoincidentesConContactos.get(i))) {
                PosibleBrote(sintomasCoincidentesConContactos.get(i));
                posibleBroteHabilitado.add(sintomasCoincidentesConContactos.get(i));
            }
        }
    }

    private void PosibleBrote(String str) {
        int casosDelBrote = readBrotes(str);
        if (casosDelBrote != 0 ){
            ordenarOSumarCasos(str,true);
            return;
        }
        Sintomas listaDeSintomas = new Sintomas();
        if (listaDeSintomas.getCantidadDeCasos(str) >= 5) {
            brote(str, listaDeSintomas.getCantidadDeCasos(str));
        }
    }

    private int readBrotes(String str) {

        String line;

        try {

            FileReader fileReader = new FileReader("brotes.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);


            line = bufferedReader.readLine();

            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equals(str)){
                    return Integer.parseInt(data[1]);
                }
            }

            bufferedReader.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return 0;
    }

    private void brote(String str, int cantidadDeCasos) {

        System.out.println("Hay brote de: "+str);

        try {
            FileWriter fileWriter = new FileWriter("brotes.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(str + "," + cantidadDeCasos + "\n");

            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }


    private void ordenarOSumarCasos(String str, boolean necesitaSobreescribir) { // Como el metodo ordenar y el sumar un caso son parecidos, los meti los dos aca, diferenciandolos por un boolean

        HashMap<String,Integer> sobreescribirBrotes = new HashMap<>();

        String line;

        try {

            FileReader fileReader = new FileReader("brotes.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            line = bufferedReader.readLine();

            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equals(str) && necesitaSobreescribir){
                    sobreescribirBrotes.put(data[0], Integer.valueOf(data[1])+1);
                } else
                    sobreescribirBrotes.put(data[0], Integer.valueOf(data[1]));
            }

            bufferedReader.close();

            sobreescribirBrotes = sortByValue(sobreescribirBrotes);


            PrintWriter writer = new PrintWriter("brotes.txt"); // Limpio la pagina
            writer.print("");
            writer.close();

            FileWriter fileWriter = new FileWriter("brotes.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            Set keys = sobreescribirBrotes.keySet();
            for (Object key : keys) {
                bufferedWriter.write(key + "," + sobreescribirBrotes.get(key) + "\n");

            }

            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();



        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
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

