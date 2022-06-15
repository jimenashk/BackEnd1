public class ApiHotel {


    public Hotel busqueda(Hotel hotel, String fechaEntrada, String fechaSalida, String ciudad){
        if(hotel.getFechaEntrada().compareTo(fechaEntrada)==0 && hotel.getFechaSalida().compareTo(fechaSalida)==0 && hotel.getCiudad().compareTo(ciudad)==0){
            return hotel;
        }
        else{
            return null;
        }
    }
}

