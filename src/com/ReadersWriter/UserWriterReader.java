package com.ReadersWriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

/**
 * FedePochat & SebaAdaro
 */
public class UserWriterReader {
    //Escribe en el archivo users.txt y agrega el tel y el cuil
    public static void addUser(String tel, String cuil) {
        try{
            FileWriter fileWriter = new FileWriter("users.txt",true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(tel + "," + cuil+ ",0," +"\n");
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        }catch (Exception e){
            System.out.println(e);
        }

    }
    //Lee y se fija si el archivo users.txt ya contiene ese tel
    public static boolean containsTel(String tel){
        Map users = readTelandCuil();
        if(users.containsKey(tel)){
            return true;
        }else{
            return false;
        }
    }
    //Lee y se fija si el archivo users.txt ya contiene ese cuil
    public static boolean containsCuil(String cuil){
        Map users = readTelandCuil();
        if(users.containsValue(cuil)){
            return true;
        }else{
            return false;
        }
    }
    //Lee el archivo users.txt y se fija si el tel existe y concide con el cuil
    public static boolean findTelandCuil(String tel, String cuil){
        Map users = readTelandCuil();
        if(users.containsKey(tel) && users.get(tel).equals(cuil)) {
            return true;
        }else{
            return false;
        }
    }

    public static int readNumOfContacts(String tel){
        try{
            ArrayList<ArrayList<String>> users = readFile();
            ArrayList<String> tels = new ArrayList<>();
            for (List<String> list : users){
                tels.add(list.get(0));
            }
            //Cast de String a Int
            return Integer.parseInt(users.get(tels.indexOf(tel)).get(2));
        }catch (Exception e){
            System.out.println(e);
            return 0;
        }
    }

    public static Map readTelandCuil(){
        try {
            FileReader fileReader = new FileReader("users.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            Map users = new HashMap<String, String>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                users.put(data[0], data[1]);
            }
            fileReader.close();
            return users;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    //Escribe en la linea de tel el contenido al final
    public static void addContact(String tel, String content){
        ArrayList<ArrayList<String>> users = readFile();
        ArrayList<String> tels = new ArrayList<>();
        for (List<String> list : users){
            tels.add(list.get(0));
        }
        if (tels.contains(tel)) {
            ArrayList<String> listDelTel = users.get(tels.indexOf(tel));
            listDelTel.add(content);
            int newNumofContacts = Integer.parseInt(listDelTel.get(2))+1;
            listDelTel.set(2, String.valueOf(newNumofContacts));
            try{
                FileWriter fileWriter = new FileWriter("users.txt");
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                for (int i = 0; i < users.size(); i++) {
                    for (String str: users.get(i)){
                        bufferedWriter.append(str + ",");
                    }
                    bufferedWriter.append("\n");
                }
                bufferedWriter.flush();
                bufferedWriter.close();
                fileWriter.close();
            }catch (Exception e){
                System.out.println(e);
            }
        }else{
            return;
        }
    }

    //Lee el archivo y lo devuelve como un arraylist de arraylists
    private static ArrayList<ArrayList<String>> readFile(){
        try {
            FileReader fileReader = new FileReader("users.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            ArrayList<ArrayList<String>> user = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                List<String> content = Arrays.asList(line.split(","));
                ArrayList<String> cont = new ArrayList<>(content);
                user.add(cont);
            }
            fileReader.close();
            return user;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    public static boolean containsContact(String tel, String contact){
        ArrayList<ArrayList<String>> users = readFile();
        ArrayList<String> tels = new ArrayList<>();
        for (List<String> list : users){
            tels.add(list.get(0));
        }
        ArrayList<String> listDelTel = users.get(tels.indexOf(tel));
        if(listDelTel.get(2).equals("0")){
            return false;
        }else{
            for (int i = 0; i < Integer.parseInt(listDelTel.get(2)); i++) {
                if (listDelTel.get(3+i).equals(contact)){
                    return true;
                }
            }
        }
        return false;
    }

}
