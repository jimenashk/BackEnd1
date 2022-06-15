package com.company;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FiguraGeometricaTest {

    Circulo circulo;
    Cuadrado cuadrado;

    @BeforeEach
    void doBefore() {
        circulo = new Circulo("circulo", 3.0);
        cuadrado = new Cuadrado("cuadrado", 2.0);

    }

        @Test
        void getNombre(){
        assertEquals("circulo", circulo.getNombre());
        assertEquals("cuadrado", cuadrado.getNombre());

    }

    @Test
    void calculoPerimetro(){
        assertEquals("El perimetro de circulo es 28.274333882308138 unidades", circulo.calculoPerimetro());
        assertEquals("El perimetro de cuadrado es de 4.0 unidades", cuadrado.calculoPerimetro());
    }
}
