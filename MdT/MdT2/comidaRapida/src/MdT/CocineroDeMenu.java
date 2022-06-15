package MdT;

public abstract class CocineroDeMenu {
    public String preparar(Menu menu){
        String resp = "Iniciando el armado del menu.\n";
        resp= resp+ armar(menu);
        resp=resp+ "El precio del menu es: " + calcularPrecio(menu);
        return resp;
    }
    protected abstract String armar(Menu menu);
    protected abstract double calcularPrecio(Menu menu);
}
