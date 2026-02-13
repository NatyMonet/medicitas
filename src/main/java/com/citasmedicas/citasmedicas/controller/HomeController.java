package com.citasmedicas.citasmedicas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.citasmedicas.citasmedicas.repository.CitaRepository;
import java.util.List;
import com.citasmedicas.citasmedicas.model.Cita;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.Optional;

@Controller

public class HomeController {
    private final CitaRepository citaRepository;

    public HomeController(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }
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
    //5 método - Ver lista de citas
    @GetMapping("/ver-citas")
    public String verCitas(Model model) {
        List<Cita> citas = citaRepository.findAll();
        model.addAttribute("citas", citas);
        return "ver_citas.html";
    }


//6 método - Cancelar cita (NUEVO - Módulo 4)
@PostMapping("/cancelar-cita/{id}")
public String cancelarCita(@PathVariable Long id, RedirectAttributes redirectAttributes) {
    try {
        // Buscar la cita por ID
        Optional<Cita> citaOpcional = citaRepository.findById(id);

        if (citaOpcional.isPresent()) {
            // Si existe, la eliminamos
            citaRepository.deleteById(id);
            redirectAttributes.addFlashAttribute("mensaje", "Cita cancelada exitosamente");
            redirectAttributes.addFlashAttribute("tipoMensaje", "success");
        } else {
            redirectAttributes.addFlashAttribute("mensaje", "La cita no existe");
            redirectAttributes.addFlashAttribute("tipoMensaje", "error");
        }

    } catch (Exception e) {
        redirectAttributes.addFlashAttribute("mensaje", "Error al cancelar la cita: " + e.getMessage());
        redirectAttributes.addFlashAttribute("tipoMensaje", "error");
    }

    return "redirect:/ver-citas";
}// ← Esta llave cierra el método cancelarCita
}// ← Esta llave cierra la clase HomeController


