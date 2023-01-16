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
    private String calle;
    @Column(length = 6)
    private int numero;
    @Column(name = "nombre_poblacion")
    private String nombrePoblacion;
    private String provincia;
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @PrimaryKeyJoinColumn
    private Profesor profesor;

    public Direccion() {
    }

    public Direccion(String calle, int numero, String nombrePoblacion, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.nombrePoblacion = nombrePoblacion;
        this.provincia = provincia;
    }

    public Direccion(String calle, int numero, String nombrePoblacion, String provincia, Profesor profesor) {
        this.calle = calle;
        this.numero = numero;
        this.nombrePoblacion = nombrePoblacion;
        this.provincia = provincia;
        this.profesor = profesor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombrePoblacion() {
        return nombrePoblacion;
    }

    public void setNombrePoblacion(String nombrePoblacion) {
        this.nombrePoblacion = nombrePoblacion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    @Override
    public String toString() {
        return "Direccion{" +
                "id=" + id +
                ", calle='" + calle + '\'' +
                ", numero=" + numero +
                ", nombrePoblacion='" + nombrePoblacion + '\'' +
                ", provincia='" + provincia + '\'' +
                '}';
    }
}
