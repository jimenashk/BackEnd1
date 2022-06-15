public class Documento {

    private String contenido;
    private Integer tipo; //1=reservado, 2=secreto, 3=muy secreto

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Documento(String contenido, Integer tipo) {
        this.contenido = contenido;
        this.tipo = tipo;


    }
}
