package com.GUI.Users;

import com.GUI.Sintomas.SistemaDeControl;
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
    private ArrayList<String> usuariosBloqueados = new ArrayList<>();
    private HashMap<String,Integer> contactosYRechazos = new HashMap<>();

    private boolean bloqueado;


    private ArrayList<String> sintomasCoincidentesConContactos = new ArrayList<>();

    private final ArrayList<String> sintomasPresentados = new ArrayList();


    public ArrayList<String> getSintomasPresentados() {
        return sintomasPresentados;
    }


    public User(String tel) { //chequea si la persona ya esta registrado solo con el telefono

        if (telsList().contains(tel)) {
            this.tel = tel;
            content = readArray();
            cuil = content.get(1);
            if (!getContent().get(2).equals("0")) {
                for (int i = 0; i < Integer.parseInt(getContent().get(2)); i++) {
                    contactosEstrechos.add(content.get(3 + i));
                }
            }
        }


        try {

            readSintomasPresentados();
            readUsuariosBloqueados();
            readCantDeRechazos();

            if (usuariosBloqueados.contains(tel)){
                bloqueado =true;
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }



    public User(String tel, String cuil) {
        this.tel = tel;
        this.cuil = cuil;
        addUser(tel, cuil);
    }

    public void setBloqueo(){
        bloqueado =false;
    }

    public boolean isBloqued(){
        return bloqueado;
    }

    public void addUser(String tel, String cuil) { //agrega un usuario al .txt de user registrandolo
        try {
            FileWriter fileWriter = new FileWriter("users.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(tel + "," + cuil + ",0,");
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public String getTel() {
        return tel;
    }


    public ArrayList<String> getContent() {
        return content;
    }

    public ArrayList<String> getContactosEstrechos() {
        return contactosEstrechos;
    }

    public String getCuil() {
        return cuil;
    }

    private static ArrayList<ArrayList<String>> readFile() { //lee el archivo y te devuelve un arraylist con todos los users
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
        } catch (Exception e) {
            System.out.println(e + "A");
            return null;
        }
    }

    public ArrayList<String> readArray() { //lee el array de users y devuelve el indice de donde se ubica el usuario
        try {
            ArrayList<ArrayList<String>> users = readFile();
            return users.get(telsList().indexOf(getTel()));
        } catch (Exception e) {
            System.out.println(e + "B");
            return null;
        }
    }

    public ArrayList<String> telsList() { // devuelve la lista de todos los telefonos registrados
        ArrayList<String> tels = new ArrayList<>();
        for (List<String> list : readFile()) {
            tels.add(list.get(0));
        }
        return tels;
    }

    public boolean matchesCuil(String enteredCuil) {  //Se fija si el cuil le corresponde a ese telefono
        return enteredCuil.equals(cuil);
    }

    public boolean containsContact(String contact) { // Cuenta la cantidad de contactos que tuvo esa persona
        if (getContent().get(2).equals("0")) {
            return false;
        } else {
            for (int i = 0; i < Integer.parseInt(getContent().get(2)); i++) {
                if (getContent().get(3 + i).equals(contact)) {
                    return true;
                }
            }
        }
        return false;
    }

    //Escribe en la linea de tel el contenido al final
    public void addContact(String contact) {
        content.add(contact);
        int newNumofContacts = Integer.parseInt(content.get(2)) + 1;
        content.set(2, String.valueOf(newNumofContacts));
        try {
            ArrayList<ArrayList<String>> users = readFile();
            users.set(telsList().indexOf(getTel()), content);
            FileWriter fileWriter = new FileWriter("users.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < users.size(); i++) {
                for (String str : users.get(i)) {
                    bufferedWriter.append(str + ",");
                }
                bufferedWriter.append("\n");
            }
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (Exception e) {
            System.out.println(e + "C");
        }
    }

    /*Estas 3 funciones dividen a los contactos en verificados o pendientes (no aceptada la solicitud)
      Contains me se fija si un usuario, me tiene entre sus contactos, si me tiene, es verificado, si no me tiene todavia no acepto la solicitud.
      Si el me tiene pero yo no, se agrega a getSolicitudes de Contacto
     */
    public boolean containsMe(String tel) {
        User otroUsuario = new User(tel);
        return otroUsuario.getContactosEstrechos().contains(getTel());
    }

    public ArrayList<String> getVerificadoContactos() {
        ArrayList<String> contactosVerificados = new ArrayList<>();
        for (String str : getContactosEstrechos()) {
            if (containsMe(str)) {
                contactosVerificados.add(str);
            }
        }
        return contactosVerificados;
    }

    public ArrayList<String> getPendienteContactos() {
        ArrayList<String> contactosPendiente = new ArrayList<>();
        for (String str : getContactosEstrechos()) {
            if (!containsMe(str)) {
                contactosPendiente.add(str);
            }
        }
        return contactosPendiente;
    }

    public ArrayList<String> getSolicitudesdeContacto() {
        ArrayList<String> solicitudes = new ArrayList<>();
        for (String str : telsList()) {
            if (containsMe(str) && !getContactosEstrechos().contains(str)) {
                solicitudes.add(str);
            }
        }
        return solicitudes;
    }

    public void rejectContact(String otherUserTel) { //Rejecta un contacto estrecho
        User otherUser = new User(otherUserTel);
        sumarContactoRechazado(otherUserTel,0);
        otherUser.getContent().remove(getTel());
        int newNumofContacts = Integer.parseInt(otherUser.getContent().get(2)) - 1;
        otherUser.getContent().set(2, String.valueOf(newNumofContacts));
        try {
            ArrayList<ArrayList<String>> users = otherUser.readFile();
            users.set(telsList().indexOf(otherUser.getTel()), otherUser.getContent());
            FileWriter fileWriter = new FileWriter("users.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < users.size(); i++) {
                for (String str : users.get(i)) {
                    bufferedWriter.append(str + ",");
                }
                bufferedWriter.append("\n");
            }
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (Exception e) {
            System.out.println(e + "C");
        }
    }


    public boolean addSintoma(String sintoma) { //agrega un sintoma

        Sintomas listaDeSintomas = new Sintomas();

        int casoN = listaDeSintomas.addCaso(sintoma);
        if (casoN == -1) {
            JOptionPane.showMessageDialog(null, "Sintoma no encontrado");
            return false;
        } else
            System.out.println("Sintoma agregado");
        sintomasPresentados.add(sintoma);
        listaDeSintomas.writeSintomasOfAnUser(tel, sintomasPresentados);
        SistemaDeControl newSistemaDeControl = new SistemaDeControl(tel);

        return true;
    }

    public void deleteSintoma(String selected) { //borra un sintoma del usuario
        for (int i = 0; i < sintomasPresentados.size(); i++) {
            if (sintomasPresentados.get(i).equals(selected)) {
                sintomasPresentados.remove(i);
            }
        }
        Sintomas listaDeSintomas = new Sintomas();
        listaDeSintomas.writeSintomasOfAnUser(tel, sintomasPresentados);
        listaDeSintomas.restarUnCaso(selected);
    }

    public ArrayList contactosConSintoma() { //Da un aviso de los sintomas de las personas con las cuales estuviste en contacto

        String line;
        int counter;
        String sintomasDelContacto;
        ArrayList aviso = new ArrayList();

        try {

            for (int i = 0; i < contactosEstrechos.size(); i++) {

                sintomasDelContacto = "";
                counter = 0;

                FileReader fileReader = new FileReader("SintomasDeUsers" + File.separator + contactosEstrechos.get(i) + ".txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                line = bufferedReader.readLine();

                while (line != null) {

                    counter++;
                    sintomasDelContacto = line + "," + sintomasDelContacto;

                    for (int j = 0; j < sintomasPresentados.size(); j++) {
                        if (line.equals(sintomasPresentados.get(j))) {
                            sintomasCoincidentesConContactos.add(sintomasPresentados.get(i));
                        }
                    }

                    line = bufferedReader.readLine();
                }

                if (counter >= 2) {
                    aviso.add("El telefono: " + contactosEstrechos.get(i) + " con quien tuviste contacto, presento los siguientes sintomas: " + sintomasDelContacto);
                }

                bufferedReader.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return aviso;
    }


    private void readSintomasPresentados() { //lee los sintomas presentados por el usuario

        String line;

        try {

            FileReader fileReader = new FileReader("SintomasDeUsers" + File.separator + tel + ".txt");
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

    public void bloquearUsuario(Object key) {

        try {

            FileWriter fileWriter = new FileWriter("UsuariosBloqueados.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(key.toString());
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void desbloquearUsuario (){

        bloqueado =false;
        ArrayList<String> sobreescribirBloqueados = new ArrayList<>();

        String line;

        try {

            FileReader fileReader = new FileReader("UsuariosBloqueados.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                if (!line.equals(tel)){
                    sobreescribirBloqueados.add(line);
                }
            }

            bufferedReader.close();

            PrintWriter writer = new PrintWriter("UsuariosBloqueados.txt"); // Limpio la pagina
            writer.print("");
            writer.close();

            FileWriter fileWriter = new FileWriter("UsuariosBloqueados.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (int i = 0; i <sobreescribirBloqueados.size() ; i++) {
                bufferedWriter.write(sobreescribirBloqueados.get(i));
            }

            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void readUsuariosBloqueados() {
        try {

            FileReader fileReader = new FileReader("UsuariosBloqueados.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                usuariosBloqueados.add(line);
            }
            fileReader.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<String> getusuariosBloqueados() {
        return usuariosBloqueados;
    }

    public void sumarContactoRechazado(String otherUserTel,int numberOfRechazos) {

        if (numberOfRechazos==0){
            numberOfRechazos = contactosYRechazos.get(otherUserTel);
        }
        contactosYRechazos.replace(otherUserTel,++numberOfRechazos);

        try {

            PrintWriter writer = new PrintWriter("CantDeRechazos.txt"); // Limpio la pagina
            writer.print("");
            writer.close();

            FileWriter fileWriter = new FileWriter("CantDeRechazos.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            Set keys = contactosYRechazos.keySet();
            for (Object key : keys) {
                    bufferedWriter.write(key + "," + contactosYRechazos.get(key) + "\n");
            }

            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void readCantDeRechazos() {
        try {
            FileReader fileReader = new FileReader("CantDeRechazos.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                contactosYRechazos.put(data[0], Integer.valueOf(data[1]));
                if (Integer.valueOf(data[1])>=5 && !usuariosBloqueados.contains(data[0])){
                    bloquearUsuario(data[0]);
                }
            }

            fileReader.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }




}
