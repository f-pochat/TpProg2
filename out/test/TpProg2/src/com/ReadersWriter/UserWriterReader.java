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
    //PREGUNTAR EN CLASE DE CONSULTA SI SE PUEDE USAR STATIC AHI

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
