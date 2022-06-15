package com.dh.integradora.controller;
//esta clase es el nexo que se encarga d comunicarse con la vista
// y con el modelo dnd estan los datos

import com.dh.integradora.dominio.Paciente;
import com.dh.integradora.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    private PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }
    //*metodo q se invoque cuando debams
    //resolver una solicitud desde el navegador-
    //**usamos esta anotacion para indicar que este metodo
    //DEBE ejecutarse cada vez q reciba una solicitud a traves de index

    @GetMapping("/index")
    public String traerPaciente(Model model, @RequestParam("email") String email){
        Paciente paciente = pacienteService.buscarXEmail(email);
        if(paciente == null) return "no se encontro paciente con ese email";

        model.addAttribute("nombre", paciente.getNombre());
        model.addAttribute("apellido", paciente.getApellido());
        return "index";

    }
    @PostMapping
    public Paciente  registrarPaciente(@RequestBody Paciente paciente){
        return pacienteService.guardar(paciente);

    }
    @PostMapping
    public Paciente actualizarPaciente(@RequestBody Paciente paciente){
        return pacienteService.actualizar(paciente);
    }

    @GetMapping("/{id}")
    public Paciente buscarPaciente(@PathVariable int id){
        return pacienteService.buscar(id);
    }

    @DeleteMapping("/{id}")
    public String eliminarPaciente(@PathVariable int id){
        String resp = "ERROR en el Id ingresado";
        if (pacienteService.buscar(id)!=null) {
            pacienteService.eliminar(id);
            resp = "Se elimino el paciente con id= " + id;
        }

        return resp;
    }

    @GetMapping
    public List<Paciente> buscarPaciente(){
        return pacienteService.listarPacientes();
    }

}
