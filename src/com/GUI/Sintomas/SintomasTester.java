package com.GUI.Sintomas;

import org.junit.*;

import static org.junit.Assert.*;

public class SintomasTester {

    public static final String TOZ = "toz";
    public static final String FIEBRE = "fiebre";
    public static final String DOLOR_DE_GARGANTA = "dolorDeGarganta";

    @Test
    public void Test_001(){

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
}
