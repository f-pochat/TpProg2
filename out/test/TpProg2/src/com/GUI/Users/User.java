package com.GUI.Users;

import com.GUI.SistemaDeControl;
import com.GUI.Sintomas.Sintomas;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class User {

    private boolean fueContagiado = false;
    private String tel;
    private String cuil;
    private ArrayList<String> content;
    //private ArrayList<String> sintomas = new ArrayList<>();
    private ArrayList<String> contactosEstrechos = new ArrayList<>();
    private HashMap<String,String> contactosConSintomas = new HashMap<>();

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

            File file = new File ("Contactos" + File.separator + tel+".txt");
            file.createNewFile();

            File file2 = new File ("Sintomas" + File.separator + tel+".txt");
            file2.createNewFile();
            readSintomasPresentados();

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
            SistemaDeControl newSistemaDeControl = new SistemaDeControl(getVerificadoContactos(),sintomasPresentados,tel);
            avisarContactos(getVerificadoContactos(),sintomasPresentados);

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
    }


    private void avisarContactos(ArrayList verificadoContactos, List listaDeSintomas) {
        String allSimpthoms = "";
        for (int i = 0; i <listaDeSintomas.size() ; i++) {
            allSimpthoms = allSimpthoms + ","+listaDeSintomas.get(i);
        }
        System.out.println(allSimpthoms);
        try {
            for (int i = 0; i <verificadoContactos.size() ; i++) {

                FileWriter fileWriter = new FileWriter("Contactos" +File.separator+ verificadoContactos.get(i) + ".txt");
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(tel+allSimpthoms+"\n");
                bufferedWriter.flush();
                bufferedWriter.close();
                fileWriter.close();
            }

        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void TieneContactosConSintomas() {

        String line;

        try {
            FileReader fileReader = new FileReader("Contactos" + File.separator + tel+".txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                System.out.println(data.length);
                String allSintoms = "";
                for (int i = 1; i < data.length; i++) {
                    allSintoms = allSintoms + "," + data[i];
                }
                if (data.length <= 1) {
                    return;
                }
                JOptionPane.showMessageDialog(null, "El telefono: " + data[0] + " con quien tuviste contacto, presento los siguientes sintomas: " + allSintoms, "A CUIDARSE!", JOptionPane.INFORMATION_MESSAGE);
                contactosConSintomas.put(data[0],allSintoms);
            }

            bufferedReader.close();

            PrintWriter writer = new PrintWriter(tel + ".txt");
            writer.print("");
            writer.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean fueContagiado (){
        return fueContagiado;
    }

    public void setFueContagiado(boolean fueContagiado) {
        this.fueContagiado = fueContagiado;
    }


    private void readSintomasPresentados() {

        String line;

        try {

            FileReader fileReader = new FileReader("Sintomas" + File.separator + tel+".txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
               sintomasPresentados.add(line);
            }

            bufferedReader.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
