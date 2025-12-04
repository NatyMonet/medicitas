package com.citasmedicas.citasmedicas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class HomeController {
    //1 método - Mostrar página principal
    @GetMapping("/*")
    public String home(Model model) {
        return "index";
    }
    //2 método - Procesar formulario de citas
    @PostMapping("/agendar")
    public String agendarCita(@RequestParam String nombre, @RequestParam String cedula, @RequestParam String especialidad, @RequestParam String fecha, Model model ) {
        model.addAttribute("nombre", nombre);
        model.addAttribute("cedula", cedula);
        model.addAttribute("especialidad", especialidad);
        model.addAttribute("fecha", fecha);
        return "confirmacion";
    }
    //3 método - Mostrar formulario de registro
    @GetMapping("/registro")
    public String mostrarRegistro(Model model) {
        return "registro";
    }

        //4 método - Procesar registro de paciente
            @PostMapping("/registrar")
            public String registrarPaciente(
                @RequestParam String nombre,
                @RequestParam String cedula,
                @RequestParam String fechaNacimiento,
                @RequestParam String telefono,
                @RequestParam String correo,
                Model model) {

            model.addAttribute("nombre", nombre);
            model.addAttribute("cedula", cedula);
            model.addAttribute("fechaNacimiento", fechaNacimiento);
            model.addAttribute("telefono", telefono);
            model.addAttribute("correo", correo);

            return "registro_confirmacion";
        }
    }
