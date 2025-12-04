package com.citasmedicas.citasmedicas.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

//Clase que representa una cita médica en el sistema.
//Esta clase utiliza JPA para mapear la tabla de citas en la base de datos.

// @author Natalia Mejia
// @version 1.0

@Entity
@Table(name = "cita")
public class Cita {
    //Creación de atributos y métodos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;
    private LocalTime hora;
    private String motivo;
    private Long idPaciente;
    private Long idMedico;

    //Métodos de creación getter y setter

    public Cita() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
    //Segundo atributo

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    // Tercer atributo

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }
//Cuarto atributo

    public Long getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Long idMedico) {
        this.idMedico = idMedico;
    }
}






