package com.GUI.Users;

import com.GUI.Sintomas.Sintomas;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class UserTester {

    @Test
    public void Test001_UserCanPresentSintoms(){
        User unUsuario = new User("1157670618");
        unUsuario.addContact("1");

        User otroUsuario = new User("1");
        otroUsuario.addContact("1157670618");

        unUsuario.addSintoma("fiebre");
        unUsuario.addSintoma("toz");





    }
}
