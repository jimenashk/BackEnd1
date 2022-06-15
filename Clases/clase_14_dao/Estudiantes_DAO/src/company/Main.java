package company;

import company.daos.EstudianteDaoH2;
import company.entidades.Estudiante;
import company.servicios.EstudianteService;

public class Main {
    public static void main(String[] args) {
        Estudiante estudiante = new Estudiante();

        estudiante.setId(1L);
        estudiante.setNombre("Maria");
        estudiante.setApellido("Molina");

        EstudianteService estudianteService = new EstudianteService();
        //estrategia de persistencia, es decir DAO
        estudianteService.setEstudianteIDao(new EstudianteDaoH2());
       //guardar estudiante q acabo d crear en linea 11
        estudianteService.guardarEstudiante(estudiante);




    }
}
