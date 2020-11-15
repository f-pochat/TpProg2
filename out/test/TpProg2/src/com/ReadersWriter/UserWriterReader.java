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
    private ArrayList<ArrayList<String>> contenido;
    public UserWriterReader(){
        contenido = readFile();
    }

    private ArrayList<ArrayList<String>> readFile(){
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
            System.out.println(e + "A");
            return null;
        }
    }

    public ArrayList<String> telsList(){
        ArrayList<String> tels = new ArrayList<>();
        for (List<String> list : getContenido()){
            tels.add(list.get(0));
        }
        return tels;
    }

    public ArrayList<ArrayList<String>> getContenido() {
        return contenido;
    }

    //Lee y se fija si el archivo users.txt ya contiene ese tel
    public boolean containsTel(String tel){
        Map users = readTelandCuil();
        if(users.containsKey(tel)){
            return true;
        }else{
            return false;
        }
    }
    //Lee y se fija si el archivo users.txt ya contiene ese cuil
    public boolean containsCuil(String cuil){
        Map users = readTelandCuil();
        if(users.containsValue(cuil)){
            return true;
        }else{
            return false;
        }
    }

    public Map readTelandCuil(){
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

    public void writeFile(ArrayList<ArrayList<String>> contentOfFile){
        try {
            FileWriter fileWriter = new FileWriter("users.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line;
            for (int i = 0; i < contentOfFile.size()-1;i++){
                for (int j = 0; j < contentOfFile.get(i).size();j++){
                    bufferedWriter.write(contentOfFile.get(i).get(j) + ",");
                }
                bufferedWriter.write(contentOfFile.get(i).get(contentOfFile.size()-1));
            }
        }catch (Exception e){
            System.out.println(e + "A");
        }
    }

}
