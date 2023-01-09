package org.example.entities;

import jakarta.persistence.*;
import org.checkerframework.checker.units.qual.C;

import java.io.Serializable;
@Entity
@Table(name = "alumnos")
public class Direccion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 200)
    private String calle;
    private int numero;
    @Column(name = "nombre_poblacion")
    private String nombrePoblacion;
    private String provincia;
}
