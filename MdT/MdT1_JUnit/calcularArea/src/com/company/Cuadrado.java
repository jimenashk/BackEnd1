package com.company;

public class Cuadrado extends FiguraGeometrica{

    private Double lado;

    public Cuadrado(String nombre, Double lado) {
        super(nombre);
        this.lado = lado;
    }

    @Override
    public String calculoPerimetro() {
        return "El perimetro de " + this.getNombre() + " es de " + Math.pow(lado, lado) + " unidades";
    }
    }

