package com.GUI.Users;

import com.GUI.SistemaDeControl;
import com.GUI.Sintomas.Sintomas;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class User {

    private String tel;
    private String cuil;
    private ArrayList<String> content;
    //private ArrayList<String> sintomas = new ArrayList<>();
    private ArrayList<String> contactosEstrechos = new ArrayList<>();


    private ArrayList<String> sintomasCoincidentesConContactos = new ArrayList<>();

    private final ArrayList<String> sintomasPresentados = new ArrayList();


    public ArrayList<String> getSintomasPresentados() {
        return sintomasPresentados;
    }


    public User(String tel) {

        if (telsList().contains(tel)){
            this.tel = tel;
            content = readArray();
            cuil = content.get(1);
            if (!getContent().get(2).equals("0")){
                for (int i = 0;i < Integer.parseInt(getContent().get(2));i++){
                    contactosEstrechos.add(content.get(3+i));
                }
            }
        }


        try{

            File file2 = new File ("SintomasDeUsers" + File.separator + tel+".txt");
            file2.createNewFile();
            readSintomasPresentados();
            contactosConSintoma();

        } catch (Exception e){
            System.out.println(e.getMessage());
        }


    }

    public User(String tel,String cuil){
        this.tel = tel;
        this.cuil = cuil;
        addUser(tel,cuil);
    }

    public void addUser(String tel, String cuil) {
        try{
            FileWriter fileWriter = new FileWriter("users.txt",true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write( tel + "," + cuil+ ",0,");
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        }catch (Exception e){
            System.out.println(e);
        }

    }
    public String getTel() {
        return tel;
    }



    public ArrayList<String> getContent() {
        return content;
    }
    public ArrayList<String> getContactosEstrechos(){
        return contactosEstrechos;
    }

    public String getCuil() {
        return cuil;
    }

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
            System.out.println(e + "A");
            return null;
        }
    }

    public ArrayList<String> readArray(){
        try {
            ArrayList<ArrayList<String>> users = readFile();
            return users.get(telsList().indexOf(getTel()));
        }catch (Exception e){
            System.out.println(e + "B");
            return null;
        }
    }

    public ArrayList<String> telsList(){
        ArrayList<String> tels = new ArrayList<>();
        for (List<String> list : readFile()){
            tels.add(list.get(0));
        }
        return tels;
    }

    public boolean matchesCuil(String enteredCuil){
        return enteredCuil.equals(cuil);
    }

    public boolean containsContact(String contact){
        if(getContent().get(2).equals("0")){
            return false;
        }else{
            for (int i = 0; i < Integer.parseInt(getContent().get(2)); i++) {
                if (getContent().get(3+i).equals(contact)){
                    return true;
                }
            }
        }
        return false;
    }

    //Escribe en la linea de tel el contenido al final
    public void addContact(String contact){
            content.add(contact);
            int newNumofContacts = Integer.parseInt(content.get(2))+1;
            content.set(2, String.valueOf(newNumofContacts));
            try{
                ArrayList<ArrayList<String>> users = readFile();
                users.set(telsList().indexOf(getTel()),content);
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
                System.out.println(e + "C");
            }
    }

    /*Estas 3 funciones dividen a los contactos en verificados o pendientes (no aceptada la solicitud)
      Contains me se fija si un usuario, me tiene entre sus contactos, si me tiene, es verificado, si no me tiene todavia no acepto la solicitud.
      Si el me tiene pero yo no, se agrega a getSolicitudes de Contacto
     */
    public boolean containsMe(String tel){
        User otroUsuario = new User(tel);
        return otroUsuario.getContactosEstrechos().contains(getTel());
    }

    public ArrayList<String> getVerificadoContactos(){
        ArrayList<String> contactosVerificados = new ArrayList<>();
        for (String str: getContactosEstrechos()){
            if (containsMe(str)){
                contactosVerificados.add(str);
            }
        }
        return contactosVerificados;
    }

    public ArrayList<String> getPendienteContactos(){
        ArrayList<String> contactosPendiente = new ArrayList<>();
        for (String str: getContactosEstrechos()){
            if (!containsMe(str)){
                contactosPendiente.add(str);
            }
        }
        return contactosPendiente;
    }

    public ArrayList<String> getSolicitudesdeContacto(){
        ArrayList<String> solicitudes = new ArrayList<>();
        for (String str : telsList()){
            if (containsMe(str) && !getContactosEstrechos().contains(str)){
                solicitudes.add(str);
            }
        }
        return solicitudes;
    }

    public void rejectContact(String otherUserTel){
        User otherUser = new User(otherUserTel);
        otherUser.getContent().remove(getTel());
        int newNumofContacts = Integer.parseInt(otherUser.getContent().get(2)) - 1;
        otherUser.getContent().set(2, String.valueOf(newNumofContacts));
        try{
            ArrayList<ArrayList<String>> users = otherUser.readFile();
            users.set(telsList().indexOf(otherUser.getTel()),otherUser.getContent());
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
            System.out.println(e + "C");
        }
    }

    public boolean addSintoma(String sintoma) {

        Sintomas listaDeSintomas = new Sintomas();
        listaDeSintomas.readSintomas();

        int casoN = listaDeSintomas.addCaso(sintoma);
        if (casoN == -1) {
            JOptionPane.showMessageDialog(null,"Sintoma no encontrado");
            return false;
        } else
            System.out.println("Sintoma agregado");
            sintomasPresentados.add(sintoma);
            listaDeSintomas.writeSintomasOfAnUser(tel,sintomasPresentados);
            SistemaDeControl newSistemaDeControl = new SistemaDeControl(tel);

            return true;
    }

    public void deleteSintoma(String selected) {
        for (int i = 0; i <sintomasPresentados.size() ; i++) {
            if (sintomasPresentados.get(i).equals(selected)){
                sintomasPresentados.remove(i);
            }
        }
        Sintomas listaDeSintomas = new Sintomas();
        listaDeSintomas.writeSintomasOfAnUser(tel,sintomasPresentados);
        listaDeSintomas.restarUnCaso(selected);
    }

    public void contactosConSintoma() {

        String line;
        int counter;
        String sintomasDelContacto;

        try {

            for (int i = 0; i <contactosEstrechos.size() ; i++) {

                sintomasDelContacto="";
                counter=0;

                FileReader fileReader = new FileReader("SintomasDeUsers" + File.separator + contactosEstrechos.get(i)+".txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                line = bufferedReader.readLine();

                while (line!=null){

                    counter++;
                    sintomasDelContacto = line + "," + sintomasDelContacto;

                    for (int j = 0; j <sintomasPresentados.size() ; j++) {
                        if (line.equals(sintomasPresentados.get(j))){
                            sintomasCoincidentesConContactos.add(sintomasPresentados.get(i));
                        }
                    }

                    line = bufferedReader.readLine();
                }

                if (counter>=2){
                    JOptionPane.showMessageDialog(null, "El telefono: " + contactosEstrechos.get(i) + " con quien tuviste contacto, presento los siguientes sintomas: " + sintomasDelContacto, "A CUIDARSE!", JOptionPane.INFORMATION_MESSAGE);
                }

                bufferedReader.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    private void readSintomasPresentados() {

        String line;

        try {

            FileReader fileReader = new FileReader("SintomasDeUsers" + File.separator + tel+".txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
               sintomasPresentados.add(line);
            }

            bufferedReader.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public ArrayList<String> getSintomasCoincidentesConContactos() {
        return sintomasCoincidentesConContactos;
    }
}
