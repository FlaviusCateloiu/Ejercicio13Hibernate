package org.example;

import org.example.entities.*;
import org.example.repositories.ModuloRepositoryImpl;
import org.example.repositories.ProfesorRepositoryImpl;

import java.util.Optional;

public class App {
    public static void main( String[] args ) {
        Profesor p1 = new Profesor("Pepe", "Antonio", "Manteca", "876423432");

        Modulo m1 = new Modulo("Matematicas", "3ESO", 8, p1);
        Modulo m2 = new Modulo("Fisica y Quimica", "4ESO", 6, p1);
        Modulo m3 = new Modulo("Educacion Fisica", "1ESO", 3, p1);

        ModuloRepositoryImpl modulos = new ModuloRepositoryImpl();

        System.out.println("\nAntes de crear-----");
        System.out.println(m1);
        System.out.println(m2);
        System.out.println(m3);

        System.out.println("\nInserción y lectura ------ ");
        modulos.create(m1);
        modulos.create(m2);
        modulos.create(m3);
        modulos.readAll().forEach(System.out::println);

        System.out.println("\nLeer por id ------ ");
        Optional<Modulo> m3copia = modulos.read(m3.getId());
        if (m3copia.isPresent())
            System.out.println(m3copia);
        else
            System.out.println("El id del piloto no existe");

        System.out.println("\nLeer por id que no existe------ ");
        Optional<Modulo> pilotoNoExiste = modulos.read(4);
        if (pilotoNoExiste.isPresent())
            System.out.println(pilotoNoExiste);
        else
            System.out.println("El id del piloto no existe");

        System.out.println("\nTras actualizar, lectura ------ ");
        m2.setCurso("1BAT");
        modulos.update(m2);
        System.out.println(m2);

        System.out.println("\nBorrado y lectura ------ ");
        modulos.delete(m3);
        modulos.readAll().forEach(System.out::println);

        modulos.close();
    }
}
