package com.clinicaDental.paciente2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class PacienteController {
    @GetMapping("/index")
    public String welcome(Model model) {
        model.addAttribute("nombre", "Equipo 1 (⊙_◎) ");
        return "index";

        
    }
}