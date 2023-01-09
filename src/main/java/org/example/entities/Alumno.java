package org.example.entities;

import jakarta.persistence.*;
import org.checkerframework.checker.units.qual.C;

import java.io.Serializable;

@Entity
@Table(name = "alumnos")
public class Alumno implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 30)
    private String nombre;
    @Column(name = "primer_apellido", length = 30)
    private String primerApellido;
    @Column(name = "segundo_apellido", length = 30)
    private String segundoApellido;
    @Column(unique = true, length = 9)
    private String nia;
    @Column(unique = true, length = 9)
    private String telefono;
    //Falta los modulos a los que asiste el alumno.
}
