package com.GUI.Users.Tests;

import com.GUI.Users.User;
import org.junit.Assert;
import org.junit.Test;

public class UserTester {

    @Test
    public void Test001_UserCanPresentSymptoms(){

        User unUsuario = new User("1157670618");

        User otroUsuario = new User("1");

        unUsuario.addSintoma("fiebre");
        unUsuario.addSintoma("toz");

        Assert.assertEquals(2,unUsuario.getSintomasPresentados().size());
        Assert.assertEquals(0,otroUsuario.getSintomasPresentados().size());

    }

    @Test
    public void Test002_UserCanSendAndAcceptSolicitudes(){

        User unUsuario = new User("1157670618");

        User otroUsuario = new User("1");

        unUsuario.addContact("1");

        otroUsuario.addContact("1157670618");

        Assert.assertEquals(1,otroUsuario.getVerificadoContactos().size());

    }

    @Test
    public void Test003_Brote(){
        User usuario1157670618 = new User("1157670618");

        User usuario5678 = new User("5678");

        User otroUsuario2 = new User("1");

        User usuario1234 = new User("1234");

        User usuario2 = new User("2");

        User usuario3 = new User("3");



        usuario1157670618.addSintoma("fiebre");
        usuario5678.addSintoma("fiebre");
        otroUsuario2.addSintoma("fiebre");
        usuario1234.addSintoma("fiebre");
        usuario2.addSintoma("fiebre");
        usuario3.addSintoma("fiebre");


    }
}
