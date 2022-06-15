import java.util.ArrayList;
import java.util.List;

public class CuentaService {

    List<Cuenta> lista_cuentas;

    public CuentaService() {
        lista_cuentas = new ArrayList<>();

    }

    public void addCuenta(Cuenta cuenta) {
        lista_cuentas.add(cuenta);
    }

    public Cuenta getCuenta(Integer DNI) {
        Cuenta resp = null;
        for (Cuenta cue : lista_cuentas) {
            if (cue.getIndetificacionusuario() == DNI) {
                resp = cue;
            }
        }
            return resp;
        }

    }



