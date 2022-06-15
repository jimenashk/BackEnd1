public class ApiVuelo {

    public Vuelo busqueda(Vuelo vuelo, String fechaIda, String fechaRegreso, String origen, String destino ){
        if(vuelo.getFechaIda().compareTo(fechaIda)==0 && vuelo.getFechaRegreso().compareTo(fechaRegreso)==0 && vuelo.getOrigen().compareTo(origen)==0&&vuelo.getDestino().compareTo(destino)==0){
            return vuelo;
        }
        else{
            return null;
        }
    }
}

