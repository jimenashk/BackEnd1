package com.company;

public class Circulo extends FiguraGeometrica{

    private Double radio;

    public Circulo(String nombre, Double radio) {
        super(nombre);
        this.radio = radio;
    }

    @Override
    public String calculoPerimetro() {
        return "El perimetro de " + this.getNombre() + " es " + Math.PI * (radio * radio) + " unidades";    }
}
