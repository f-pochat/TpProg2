package com.GUI;

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
    private Sintomas listaDeSintomas = new Sintomas();
    private HashMap<String,Integer> SintomasYCasos = new HashMap();


    public SistemaDeControl(String tel) { // Lo usan los users
        User thisUser = new User(tel);
        sintomasCoincidentesConContactos = thisUser.getSintomasCoincidentesConContactos();
        contactosVerificados = thisUser.getContactosEstrechos();
        this.tel = tel;
        VerificarSiHayBrote(thisUser);

    }

    public HashMap<String,Integer> getSintomasYCasos() {
        return SintomasYCasos;
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
            SumarCasos(str,true);
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


    private void SumarCasos(String str, boolean necesitaSobreescribir) { // Como el metodo ordenar y el sumar un caso son parecidos, los meti los dos aca, diferenciandolos por un boolean

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
}

