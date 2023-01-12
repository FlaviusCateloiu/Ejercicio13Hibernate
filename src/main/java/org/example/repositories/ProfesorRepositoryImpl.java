package org.example.repositories;

import org.example.entities.Profesor;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class ProfesorRepositoryImpl implements Repository<Profesor> {
    private SessionFactory sf = HibernateUtil.getSessionFactory();
    private Session s = sf.openSession();
    @Override
    public Profesor create(Profesor profesor) {
        s.getTransaction().begin();
        s.persist(profesor);
        s.getTransaction().commit();
        return profesor;
    }

    @Override
    public Optional<Profesor> read(int id) {
        s.getTransaction().begin();
        Profesor profesor = s.get(Profesor.class, id);
        s.getTransaction().commit();
        return Optional.ofNullable(profesor);
    }

    @Override
    public List<Profesor> readAll() {
        s.getTransaction().begin();
        List<Profesor> profesores = s.createSelectionQuery("from Profesor ", Profesor.class).list();
        s.getTransaction().commit();
        return profesores;
    }

    @Override
    public Profesor update(Profesor profesor) {
        s.getTransaction().begin();
        s.merge(profesor);
        s.getTransaction().commit();
        return profesor;
    }

    @Override
    public void delete(Profesor profesor) {
        s.getTransaction().begin();
        s.remove(profesor);
        s.getTransaction().commit();
    }

    public void close() {
        s.close();
        sf.close();
    }
}
