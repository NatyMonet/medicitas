package com.citasmedicas.citasmedicas.model;

import jakarta.persistence.*;
//Clase que representa a un médico en el sistema de citas médicas.
//Esta clase utiliza JPA para mapear la tabla de médicos en la base de datos.

// @author Natalia Mejia
//@version 1.0

@Entity
@Table(name= "medico")
public class Medico {

    //Atributos y métodos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombres;
    private String apellidos;
    private String especialidades;
    private String telefono;
    private String correo;
    public Medico() {
    }
    //Métodos

    //Primero

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //Segundo
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    //Tercero
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(String especialidades) {
        this.especialidades = especialidades;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    //Cuarto
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}





