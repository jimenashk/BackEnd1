package facade;

public class ApiProducto {
    public int descuentoXProducto(Producto unProducto){
        int resp = 0;
        if (unProducto.getTipo().equals("latas")){
            resp = 10;
        }
        return  resp;
    }
}
