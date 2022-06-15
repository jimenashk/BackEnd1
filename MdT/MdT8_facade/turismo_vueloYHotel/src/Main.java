public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel("20220525","20220601","Bogota");
       Vuelo vuelo = new Vuelo("20220525","20220601","Cordoba","Mendoza");

        FacadeTurismo facadeTurismo = new FacadeTurismo();
        facadeTurismo.busqueda("Cordoba","Mendoza","20220525","20220601");
    }
}


