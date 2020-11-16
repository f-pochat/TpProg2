package com.GUI.Sintomas.Tests;

import com.GUI.Sintomas.Sintomas;
import com.GUI.Sintomas.SistemaDeControl;
import org.junit.*;

import static org.junit.Assert.*;

public class SintomasTester {

    public static final String TOS = "tos";
    public static final String FIEBRE = "fiebre";
    public static final String DOLOR_DE_GARGANTA = "dolorDeGarganta";

    Sintomas listaDeSintomas = new Sintomas();

    @Test
    public void Test_001AgregarYPresentarSintomas(){

        listaDeSintomas.addSintoma(FIEBRE);
        listaDeSintomas.addSintoma(TOS);
        listaDeSintomas.addSintoma(DOLOR_DE_GARGANTA);

        listaDeSintomas.addCaso(FIEBRE);
        listaDeSintomas.addCaso(FIEBRE);
        listaDeSintomas.addCaso(TOS);

        listaDeSintomas.writeSintomas();

        assertEquals(5,listaDeSintomas.size());

        assertFalse(listaDeSintomas.getCantidadDeCasos(FIEBRE)==listaDeSintomas.getCantidadDeCasos(TOS));

    }


    @Test
    public void Test_002SintomaYaExiste(){

        listaDeSintomas.addSintoma(FIEBRE);
        assertEquals(5,listaDeSintomas.size());



    }
    @Test
    public void Test_003Borte(){

        SistemaDeControl sist = new SistemaDeControl();
        sist.brote("fiebre",20);
        sist.brote("tos",14);
        sist.brote("dolorDeGarganta",0);

    }

}
