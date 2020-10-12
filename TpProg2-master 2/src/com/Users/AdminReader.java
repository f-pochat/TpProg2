package com.Users;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
/**
 * FedePochat & SebaAdaro
 */
public class AdminReader {
    //Lee el archivo admin.txt y se fija si el usuario existe y concide con la contrasena
    public static boolean findUserandPassword(String user, String password){
        try{
            FileReader fileReader = new FileReader("admin.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            Map admins = new HashMap<String,String>();
            String line;
            while ((line = bufferedReader.readLine()) != null){
                String[] data = line.split(",");
                admins.put(data[0],data[1]);
            }
            fileReader.close();
            if(admins.containsKey(user) && admins.get(user).equals(password)) {
                return true;
            }else{
                return false;
            }

        }catch(Exception e){
            System.out.println(e);
            return false;
        }

    }
}
