public class AutenticationService {

    public boolean validarUsuarioYcontrasenia(Integer DNI, String contrasenia){
        boolean resp = false;

        if (DNI != null && contrasenia != null){
            resp = true;
        }
        return  resp;
    }
}
