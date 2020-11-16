package com.GUI.Users.Tests;

import com.GUI.Sintomas.SistemaDeControl;
import com.GUI.Users.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class UserTester {

    @Test
    public void Test001_UserCanPresentSymptoms(){

        User unUsuario = new User("1157670618");
        User otroUsuario = new User("1");

        Assert.assertEquals(2,unUsuario.getSintomasPresentados().size());
        Assert.assertEquals(2,otroUsuario.getSintomasPresentados().size());

    }

    @Test
    public void Test002_UserCanSendAndAcceptSolicitudes(){

        User unUsuario = new User("1157670618");

        User otroUsuario = new User("1");

        unUsuario.addContact("1");
        otroUsuario.addContact("1157670618");

    }

    @Test
    public void Test003_Brote(){
        User usuario1157670618 = new User("1157670618");

        User usuario5678 = new User("5678");

        User otroUsuario2 = new User("1");
        otroUsuario2.addContact("2");

        User usuario1234 = new User("1234");

        User usuario2 = new User("2");
        otroUsuario2.addContact("1");
        otroUsuario2.addContact("3");

        User usuario3 = new User("3");
        otroUsuario2.addContact("2");

        usuario1157670618.addSintoma("fiebre");
        usuario5678.addSintoma("fiebre");
        otroUsuario2.addSintoma("fiebre");
        usuario1234.addSintoma("fiebre");
        usuario2.addSintoma("fiebre");
        usuario3.addSintoma("fiebre");

    }

    @Test
    public void Test004_QuieroVerSiSorteaElHashmap(){

        SistemaDeControl prueba = new SistemaDeControl("1");

        HashMap<String,Integer> mapaPrueba = new HashMap<>();

        mapaPrueba.put("5",5);
        mapaPrueba.put("4",4);
        mapaPrueba.put("2",2);
        mapaPrueba.put("1",1);
        mapaPrueba.put("8",8);

        mapaPrueba = prueba.sortByValue(mapaPrueba);

        System.out.println(mapaPrueba.toString());

        Assert.assertEquals(5,mapaPrueba.size());
    }
}
