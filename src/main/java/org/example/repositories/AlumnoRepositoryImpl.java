package org.example.repositories;

import jakarta.persistence.OptimisticLockException;
import jakarta.persistence.PersistenceException;
import org.example.entities.Alumno;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class AlumnoRepositoryImpl implements Repository<Alumno> {
    private SessionFactory sf = HibernateUtil.getSessionFactory();
    private Session s = sf.openSession();
    @Override
    public Alumno create(Alumno alumno) {
        s.getTransaction().begin();
        try {
            s.persist(alumno);
        } catch (PersistenceException e) {
            System.err.println("*******Error ha surgido un problema intentelo de nuevo.*******");
        }
        s.getTransaction().commit();
        return alumno;
    }

    @Override
    public Optional<Alumno> read(int id) {
        s.getTransaction().begin();
        Alumno alumno = s.get(Alumno.class, id);
        s.getTransaction().commit();
        return Optional.ofNullable(alumno);
    }

    @Override
    public List<Alumno> readAll() {
        s.getTransaction().begin();
        List<Alumno> alumnos = s.createSelectionQuery("from Alumno", Alumno.class).list();
        s.getTransaction().commit();
        return alumnos;
    }

    @Override
    public Alumno update(Alumno alumno) {
        s.getTransaction().begin();
        s.merge(alumno);
        s.getTransaction().commit();
        return alumno;
    }

    @Override
    public void delete(Alumno alumno) {
        s.getTransaction().begin();
        try {
            s.remove(alumno);
            s.getTransaction().commit();
        } catch (OptimisticLockException e) {
            System.err.println("*******Error no se puede borrar un Alumno que no existe.*******");
        }
    }

    public void close() {
        s.close();
        sf.close();
    }
}
