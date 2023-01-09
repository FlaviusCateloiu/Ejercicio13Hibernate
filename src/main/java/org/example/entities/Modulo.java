package org.example.entities;

import jakarta.persistence.*;
import org.checkerframework.checker.units.qual.C;

import java.io.Serializable;

@Entity
@Table(name = "modulos")
public class Modulo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 30)
    private String nombre;
    @Column(length = 10)
    private String curso;
    @Column(name = "numero_horas_semanales")
    private int numeroHorasSemanales;
    //Faltan el profesor y los alumnos a los que se imparte el modulo.
}
