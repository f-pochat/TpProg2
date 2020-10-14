package com.ReadersWriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
/**
 * FedePochat & SebaAdaro
 */
public class UserWriterReader {
    //Escribe en el archivo users.txt y agrega el tel y el cuil
    public static void addUser(String tel, String cuil) {
        try{
            FileWriter fileWriter = new FileWriter("users.txt",true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(tel + "," + cuil+"\n");
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
}
