public class Usuario {
    private int id;
    private String tipoUsuario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Usuario(int id, String tipoUsuario) {
        this.id = id;
        this.tipoUsuario = tipoUsuario;

    }

}
