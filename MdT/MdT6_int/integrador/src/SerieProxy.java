public class SerieProxy implements ISerie{


    private Integer cantVistas;
    private Serie serie;

    public SerieProxy(){
        cantVistas = 0;
        this.serie = new Serie();
    }

    @Override
    public String getSerie(String nombreSerie) throws SerieNoHabilitadaException{
        if (cantVistas < 5){
            this.cantVistas += 1;
            System.out.println(this.serie.getSerie(nombreSerie));
            return this.serie.getSerie(nombreSerie);
        } else throw new SerieNoHabilitadaException("Llegaste al maximo de reproducciones");

    }}
