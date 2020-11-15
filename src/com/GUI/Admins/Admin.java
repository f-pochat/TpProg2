package com.GUI.Admins;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Admin {
    private String username;
    private String password;

    public Admin(String username) {
        this.username = username;
        password = userAndPass().get(username);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean matchesPassword(String password){ //chequea si conciden el nombre de usuario y la contraseña
       return password.equals(getPassword());
    }

    public Map<String,String> userAndPass(){ //lee el archivo de admins
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
            return admins;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
}
