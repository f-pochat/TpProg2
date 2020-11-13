package com.GUI.Sintomas;

import java.io.*;
import java.util.*;

public class Sintomas {

    private final Map<String, Integer> SintomasYCasos = new HashMap();

    public Sintomas() {
        readSintomas();
    }


    public void addSintoma(String name) {
        try {
            if (SintomasYCasos.containsKey(name.toLowerCase())) {
                System.out.println("El sintoma ya existe");
                return;
            } else
                SintomasYCasos.put(name.toLowerCase(), 0);
            writeSintomas();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int addCaso(String name) {

        int number = getCantidadDeCasos(name.toLowerCase());
        if (number == -1) {
            return -1;
        } else
            SintomasYCasos.replace(name.toLowerCase(), ++number);
        writeSintomas();
        return ++number;

    }

    public List getListadeSintomas() {

        List listaDeSintomas = new ArrayList();
        Set keys = SintomasYCasos.keySet();
        for (Object key : keys) {
            listaDeSintomas.add(key);
        }
        return listaDeSintomas;
    }

    public int getCantidadDeCasos(String name) {
        try {
            for (int i = 0; i < SintomasYCasos.size(); i++) {
                if (SintomasYCasos.containsKey(name.toLowerCase())) {
                    Integer number = (Integer) SintomasYCasos.get(name);
                    return number;
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Sintoma no encontrado");
        return -1;
    }

    public void writeSintomas() {
        try {

            PrintWriter writer = new PrintWriter("sintomas.txt");
            writer.print("");
            writer.close();

            FileWriter fileWriter = new FileWriter("sintomas.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            Set keys = SintomasYCasos.keySet();
            for (Object key : keys) {
                bufferedWriter.write(key + "," + SintomasYCasos.get(key) + "\n");
            }

            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();


        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void readSintomas() {

        String line;

        try {

            FileReader fileReader = new FileReader("sintomas.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                SintomasYCasos.put(data[0], Integer.parseInt(data[1]));

            }

            bufferedReader.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void writeSintomasOfAnUser(String tel, ArrayList<String> sintomasPresentados) {
        try {

            PrintWriter writer = new PrintWriter("SintomasDeUsers" + File.separator + tel + ".txt");
            writer.print("");
            writer.close();


            FileWriter fileWriter = new FileWriter("SintomasDeUsers" + File.separator + tel + ".txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (int i = 0; i < sintomasPresentados.size(); i++) {
                bufferedWriter.write(sintomasPresentados.get(i) + "\n");
            }

            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public void clearSintomas() {
        SintomasYCasos.clear();
    }

    public int size() {
        return SintomasYCasos.size();
    }

    public void restarUnCaso(String selected) {
        int numeroCasosSelected = SintomasYCasos.get(selected);
        SintomasYCasos.replace(selected, (numeroCasosSelected - 1));
    }
}
