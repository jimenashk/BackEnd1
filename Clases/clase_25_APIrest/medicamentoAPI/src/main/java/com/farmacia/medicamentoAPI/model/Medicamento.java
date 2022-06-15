package com.farmacia.medicamentoAPI.model;

public class Medicamento {

    private Integer id;
    private String nombre;
    private String laboratorio;
    private Integer cantidad;
    private Double precio;
    private Integer codigoNumerico;

    /*usar 2 constructores porque a veces no vamos a tener el id, porque yo no lo voy a tener
    asi evito el setter. sobrecargo un metodo y varia lfirma con respecto
        al otro constructor (dif d cantidad d parametros)*/

    //constructor incluyendo el ID
    public Medicamento(Integer id, String nombre, String laboratorio, Integer cantidad, Double precio, Integer codigoNumerico) {
        this.id = id;
        this.nombre = nombre;
        this.laboratorio = laboratorio;
        this.cantidad = cantidad;
        this.precio = precio;
        this.codigoNumerico = codigoNumerico;
    }
    //constructor SIN ID

    public Medicamento(String nombre, String laboratorio, Integer cantidad, Double precio, Integer codigoNumerico) {
        this.nombre = nombre;
        this.laboratorio = laboratorio;
        this.cantidad = cantidad;
        this.precio = precio;
        this.codigoNumerico = codigoNumerico;
    }

    //metodo string para luego ver la info
    @Override
    public String toString() {
        return "Medicamento: " +
                "id: " + id +
                "\t\n-Nombre: " + nombre  +
                "\t\n-laboratorio: " + laboratorio +
                "\t\n-cantidad: " + cantidad  +
                "\t\n-precio: $" + precio ;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public Integer getCodigoNumerico() {
        return codigoNumerico;
    }
}
