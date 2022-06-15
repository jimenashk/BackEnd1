public class CheckFacade {

    //guarda en las variables una instancia de cada otra
    private AvionApi avionApi;
    private HotelApi hotelApi;

    //constructor que crea las instancias


    public CheckFacade() {
        this.avionApi = new AvionApi();
        this.hotelApi = new HotelApi();
    }

    //simplifica las busquedas de vuelo y hotel
    public void buscar(String fechaIda, String fechaVuelta, String origen, String destino) {
        avionApi.buscarVuelos(fechaIda, fechaVuelta, origen, destino);
        hotelApi.buscarHoteles(fechaIda, fechaVuelta, destino);
    }
}
