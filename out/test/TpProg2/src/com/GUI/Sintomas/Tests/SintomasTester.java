package com.GUI.Sintomas.Tests;

import com.GUI.Sintomas.Sintomas;
import com.GUI.Sintomas.SistemaDeControl;
import org.junit.*;

import static org.junit.Assert.*;

public class SintomasTester {

    public static final String TOZ = "toz";
    public static final String FIEBRE = "fiebre";
    public static final String DOLOR_DE_GARGANTA = "dolorDeGarganta";

    Sintomas listaDeSintomas = new Sintomas();

    @Test
    public void Test_001AgregarYPresentarSintomas(){

        listaDeSintomas.addSintoma(FIEBRE);
        listaDeSintomas.addSintoma(TOZ);
        listaDeSintomas.addSintoma(DOLOR_DE_GARGANTA);

        listaDeSintomas.addCaso(FIEBRE);
        listaDeSintomas.addCaso(FIEBRE);
        listaDeSintomas.addCaso(TOZ);

        listaDeSintomas.writeSintomas();

        assertEquals(3,listaDeSintomas.size());

        assertFalse(listaDeSintomas.getCantidadDeCasos(FIEBRE)==listaDeSintomas.getCantidadDeCasos(TOZ));

    }


    @Test
    public void Test_002SintomaYaExiste(){

        listaDeSintomas.addSintoma(FIEBRE);
        assertEquals(3,listaDeSintomas.size());



    }
    @Test
    public void Test_003Borte(){

        SistemaDeControl sist = new SistemaDeControl();
        sist.brote("fiebre",10);
        sist.brote("toz",5);
        sist.brote("dolorDeGarganta",20);

    }

}
