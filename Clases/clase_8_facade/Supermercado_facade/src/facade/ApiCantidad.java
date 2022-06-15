package facade;

public class ApiCantidad {

    public int descuentoXCantidad(int cuantos){
        //logica del negocio
        int resp = 0;
        if (cuantos>11){
            resp = 15;

        }
        return  resp;
    }
}
