package com.GUI.Users;

import com.GUI.Sintomas.SistemaDeControl;
import com.GUI.Sintomas.Sintomas;
import com.ReadersWriter.UserWriterReader;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class User {

    //Declaracion de variables
    private String tel;
    private String cuil;
    private ArrayList<String> content;
    UserWriterReader userWR = new UserWriterReader();
    ArrayList<ArrayList<String>> contenido;
    private ArrayList<String> contactosEstrechos = new ArrayList<>();
    private ArrayList<String> sintomasCoincidentesConContactos = new ArrayList<>();
    private final ArrayList<String> sintomasPresentados = new ArrayList();

    //Constructores, se crea si existe el Usuario, si no, insertar con cuil
    public User(String tel) {

        if (userWR.telsList().contains(tel)){
            this.tel = tel;
            contenido = userWR.getContenido();
            content = readArray();
            cuil = content.get(1);
            if (!getContent().get(2).equals("0")){
                for (int i = 0;i < Integer.parseInt(getContent().get(2));i++){
                    contactosEstrechos.add(content.get(3+i));
                }
            }
        }

        try{
            readSintomasPresentados();
            contactosConSintoma();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
    public User(String tel,String cuil){
        this.tel = tel;
        this.cuil = cuil;
        contenido = userWR.getContenido();
        addUser(tel,cuil);
    }

    public void addUser(String tel, String cuil) {
        ArrayList<String> newUser = new ArrayList<>();
        newUser.add(tel);
        newUser.add(cuil);
        newUser.add("0");
        contenido.add(newUser);
        writeFile();
    }

    //Getters
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
    public ArrayList<String> getSintomasCoincidentesConContactos() {
        return sintomasCoincidentesConContactos;
    }
    public ArrayList<String> getSintomasPresentados() {
        return sintomasPresentados;
    }

    //Toma el contenido de ese usuario en la lectura del Arraylist
    public ArrayList<String> readArray(){
        return contenido.get(userWR.telsList().indexOf(getTel()));
    }

    public boolean matchesCuil(String enteredCuil){
        return enteredCuil.equals(cuil);
    }

    //Si el usuario tiene a otro de contacto
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
            contenido.set(userWR.telsList().indexOf(getTel()),content);
            //writeFile();
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
        for (String str : userWR.telsList()){
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
        contenido.set(userWR.telsList().indexOf(otherUser.getTel()),otherUser.getContent());
        writeFile();
    }

    public void writeFile(){
        userWR.writeFile(contenido);
    }

    public boolean addSintoma(String sintoma) {

        Sintomas listaDeSintomas = new Sintomas();

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
}
