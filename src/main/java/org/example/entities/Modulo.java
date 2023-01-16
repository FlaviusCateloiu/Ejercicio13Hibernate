package org.example.entities;

import jakarta.persistence.*;
import org.checkerframework.checker.units.qual.C;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "modulos")
public class Modulo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 30, unique = true)
    private String nombre;
    private String curso;
    private int horas;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Profesor profesor;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Alumno> alumnos;

    public Modulo() {
    }

    public Modulo(String nombre, String curso, int horas) {
        this.nombre = nombre;
        this.curso = curso;
        this.horas = horas;
    }

    public Modulo(String nombre, String curso, int horas, Profesor profesor) {
        this.nombre = nombre;
        this.curso = curso;
        this.horas = horas;
        this.profesor = profesor;
    }

    public Modulo(String nombre, String curso, int horas, Profesor profesor, Set<Alumno> alumnos) {
        this.nombre = nombre;
        this.curso = curso;
        this.horas = horas;
        this.profesor = profesor;
        this.alumnos = alumnos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Set<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Set<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    @Override
    public String toString() {
        return "Modulo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", curso='" + curso + '\'' +
                ", horas=" + horas +
                ", profesor=" + profesor +
                ", alumnos=" + alumnos +
                '}';
    }

    public void anyadirAlumno(Alumno alumno) {
        this.alumnos.add(alumno);
        alumno.getModulos().add(this);
    }

    public void eliminarAlumno(Alumno alumno) {
        this.alumnos.remove(alumno);
        alumno.getModulos().remove(this);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Modulo modulo = (Modulo) o;
        return Objects.equals(this.nombre, modulo.nombre);
    }
}
