public class Serie implements ISerie {

    public Serie(){

    }

    @Override
    public String getSerie(String nombre){
        return "www." + nombre + ".com";

    }
}



