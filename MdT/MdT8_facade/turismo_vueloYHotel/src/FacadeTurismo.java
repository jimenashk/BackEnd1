public class FacadeTurismo {

    private ApiHotel apiHotel;
    private ApiVuelo apiVuelo;

    public FacadeTurismo() {
        this.apiHotel = new ApiHotel();
        this.apiVuelo = new ApiVuelo();
    }

    public void busqueda(String origen, String ciudad, String fechaIda, String fechaRegreso){
        Hotel hotel = new Hotel(fechaIda, fechaRegreso, ciudad);
        Vuelo vuelo = new Vuelo(fechaIda, fechaRegreso, origen, ciudad);
        if (apiHotel.busqueda(hotel,fechaIda,fechaRegreso,ciudad) != null && apiVuelo.busqueda(vuelo,fechaIda,fechaRegreso,origen,ciudad)!=null){
            System.out.println("Hotel: "+hotel+" | Vuelo: "+vuelo);
        }
        else{
            System.out.println("No hay hoteles ni vuelos disponibles de acuerdo a tu busqueda");
        }
    }
}
