package com.GUI.Sintomas;

import com.GUI.Users.User;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class SistemaDeControl extends JFrame {

    DefaultListModel<String> listModel = new DefaultListModel<>();
    private ArrayList<String> sintomasCoincidentesConContactos = new ArrayList<>();
    private ArrayList<String> contactosVerificados = new ArrayList<>();
    private ArrayList<String> posibleBroteHabilitado = new ArrayList<>(); // Sirve por si hay 3 contaggios, pero todavia no hay 5 casos. Cuando haya 5 casos, dispara brote
    private String tel;
    private Sintomas listaDeSintomas = new Sintomas();
    private HashMap<String,Integer> SintomasYCasos = new HashMap();


    public SistemaDeControl(String tel) { // Lo usan los users
        User thisUser = new User(tel);
        sintomasCoincidentesConContactos = thisUser.getSintomasCoincidentesConContactos();
        contactosVerificados = thisUser.getContactosEstrechos();
        this.tel = tel;
        VerificarSiHayBrote(thisUser);

    }

    public SistemaDeControl(){ // Lo usan los admins
        OrdenarCasos("brotes.txt");
        SintomasYCasos = readBrotes();
        SintomasYCasos = sortByValue(SintomasYCasos);
    }



    public HashMap<String,Integer> getSintomasYCasos() {
        return SintomasYCasos;
    }

    private void VerificarSiHayBrote(User thisUser) { //verifica si hay un contacto de grado 2
        for (int i = 0; i < contactosVerificados.size(); i++) {
            User anotherUser = new User(contactosVerificados.get(i));
            if (anotherUser.getSintomasCoincidentesConContactos().contains(sintomasCoincidentesConContactos.get(i))) {
                PosibleBrote(sintomasCoincidentesConContactos.get(i));
                posibleBroteHabilitado.add(sintomasCoincidentesConContactos.get(i));
            } else if (posibleBroteHabilitado.contains(sintomasCoincidentesConContactos.get(i))){
                PosibleBrote(sintomasCoincidentesConContactos.get(i));
            }
        }
    }

    private void PosibleBrote(String str) { //chequea si el sintoma str presenta mas de 5 casos, donde se convierte en brote
        Sintomas listaDeSintomas = new Sintomas();
        if (listaDeSintomas.getCantidadDeCasos(str) >= 5) {
            brote(str, listaDeSintomas.getCantidadDeCasos(str));
        }
    }

    private HashMap<String, Integer> readBrotes() { //lee los brotes existentes

        String line;
        HashMap<String, Integer> casos = new HashMap<>();

        try {

            FileReader fileReader = new FileReader("brotes.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                casos.put(data[0], Integer.valueOf(data[1]));
            }

            bufferedReader.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return casos;
    }

    public void brote(String str, int cantidadDeCasos) { //Hace un anuncio sobre los brotes existentes

        System.out.println("Hay brote de: "+str);

        try {
            FileWriter fileWriter = new FileWriter("brotes.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(str + "," + cantidadDeCasos + "\n");

            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();

            OrdenarCasos("brotes.txt");

        } catch (Exception e) {
            System.out.println(e);
        }
    }


    private void OrdenarCasos(String fileName) { //ordena los casos de los brotes y reescribe el .txt

        HashMap<String,Integer> sobreescribirBrotes = new HashMap<>();

        String line;

        try {

            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                sobreescribirBrotes.put(data[0], Integer.valueOf(data[1]));
            }

            bufferedReader.close();

            sobreescribirBrotes = sortByValue(sobreescribirBrotes);


            PrintWriter writer = new PrintWriter(fileName); // Limpio la pagina
            writer.print("");
            writer.close();

            FileWriter fileWriter = new FileWriter(fileName, true);
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
        Collections.reverse(list); // La pone de mayor a menor


        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
}

