package Parcial.model;

public class Odontologo {

    private Integer id;
    private String nombre;
    private String apellido;
    private String numeroMatricula;

    public Odontologo(Integer id, String nombre, String apellido, String numeroMatricula) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroMatricula = numeroMatricula;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(String numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    @Override
    public String toString() {
        return "Odontologo: " +
                "\t\n-Id: " + id +
                "\t\n-Nombre: " + nombre +
                "\t\n-Apellido: " + apellido +
                "\t\n-NumeroMatricula: " + numeroMatricula;
    }
}
