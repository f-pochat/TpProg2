package com.GUI.Sintomas.Tests;

import com.GUI.Sintomas.Sintomas;
import com.GUI.Sintomas.SistemaDeControl;
import org.junit.*;

import static org.junit.Assert.*;

public class SintomasTester {

    public static final String TOZ = "toz";
    public static final String FIEBRE = "fiebre";
    public static final String DOLOR_DE_GARGANTA = "dolorDeGarganta";

    @Test
    public void Test_001AgregarYPresentarSintomas(){

        Sintomas listaDeSintomas = new Sintomas();
        listaDeSintomas.addSintoma(FIEBRE);
        listaDeSintomas.addSintoma(TOZ);
        listaDeSintomas.addSintoma(DOLOR_DE_GARGANTA);

        listaDeSintomas.addCaso(FIEBRE);
        listaDeSintomas.addCaso(FIEBRE);
        listaDeSintomas.addCaso(TOZ);

        listaDeSintomas.writeSintomas();
        listaDeSintomas.clearSintomas();
        listaDeSintomas.readSintomas();

        assertEquals(3,listaDeSintomas.size());

        assertFalse(listaDeSintomas.getCantidadDeCasos(FIEBRE)==listaDeSintomas.getCantidadDeCasos(TOZ));

    }

    @Test
    public void Test_002Borte(){

        SistemaDeControl sist = new SistemaDeControl();
        sist.brote("fiebre",10);
        sist.brote("toz",5);
        sist.brote("dolorDeGarganta",20);

    }
}
