package org.example;

import org.checkerframework.checker.units.qual.A;
import org.example.entities.*;
import org.example.repositories.*;

import java.util.Optional;

public class App {
    public static void main( String[] args ) {
        Alumno alum1 = new Alumno("Manolo", "Lucas", "Picos", "98742332D", "978453453");
        Alumno alum2 = new Alumno("Ismael", "Bizmal", "Tipus", "92743423D", "948543234");
        Alumno alum3 = new Alumno("Roberto", "Raul", "Rodriguez", "11232343D", "789234657");
        Alumno alumError = new Alumno("Roberto", "Gaul", "Rodriguez", "11232343D", "789234653");

        Direccion d1 = new Direccion("Bolivares", 45, "Burriana", "Castellon");

        Profesor p1 = new Profesor("Pepe", "Antonio", "Manteca", "876423432", d1);

        Modulo m1 = new Modulo("Matematicas", "3ESO", 8, p1);
        m1.anyadirAlumno(alum1);
        Modulo m2 = new Modulo("Fisica y Quimica", "4ESO", 6, p1);
        m2.anyadirAlumno(alum3);
        Modulo m3 = new Modulo("Educacion Fisica", "1ESO", 3, p1);
        m3.anyadirAlumno(alumError);

        ModuloRepositoryImpl modulos = new ModuloRepositoryImpl();

        System.out.println("\nAntes de crear Modulos -----");
        System.out.println(m1);
        System.out.println(m2);
        System.out.println(m3);

        System.out.println("\nInserción y lectura Modulos ------ ");
        modulos.create(m1);
        modulos.create(m2);
        modulos.create(m3);
        modulos.readAll().forEach(System.out::println);

        System.out.println("\nLeer por id Modulos ------ ");
        Optional<Modulo> m3copia = modulos.read(m3.getId());
        if (m3copia.isPresent())
            System.out.println(m3copia);
        else
            System.out.println("El id del modulo no existe");

        System.out.println("\nLeer por id que no existe------ ");
        Optional<Modulo> pilotoNoExiste = modulos.read(4);
        if (pilotoNoExiste.isPresent())
            System.out.println(pilotoNoExiste);
        else
            System.out.println("El id del piloto no existe");

        System.out.println("\nTras actualizar, lectura Modulos ------ ");
        m2.setCurso("1BAT");
        modulos.update(m2);
        System.out.println(m2);

        System.out.println("\nBorrado y lectura Modulos ------ ");
        modulos.delete(m3);
        modulos.readAll().forEach(System.out::println);

        modulos.close();
    }
}
