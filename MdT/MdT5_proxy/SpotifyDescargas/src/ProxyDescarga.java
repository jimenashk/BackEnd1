public class ProxyDescarga implements DescargaSpotify {

    private ServicioDescarga servicioDescarga = new ServicioDescarga();

    @Override
    public void descargar(Usuario usuario, String cancion) {
        if (esPremium(usuario)){
            servicioDescarga.descargar(usuario, cancion);
        } else {
            System.out.println("Usuario ID: " + usuario.getId() + " no puede descargar " + cancion + ", porque no es usuario Premium :( ");
        }
    }

    private boolean esPremium(Usuario usuario){
        return usuario.getTipoUsuario().equalsIgnoreCase("premium");
    }
}
