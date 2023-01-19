package org.example.repositories;

import jakarta.persistence.OptimisticLockException;
import jakarta.persistence.PersistenceException;
import org.example.entities.Modulo;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class ModuloRepositoryImpl implements Repository<Modulo> {
    private SessionFactory sf = HibernateUtil.getSessionFactory();
    private Session s = sf.openSession();
    @Override
    public Modulo create(Modulo modulo) {
        s.getTransaction().begin();
        try {
            s.persist(modulo);
        } catch (PersistenceException e) {
            System.err.println("*******Error ha surgido un problema intentelo de nuevo.*******");
        }
        s.getTransaction().commit();
        return modulo;
    }

    @Override
    public Optional<Modulo> read(int id) {
        s.getTransaction().begin();
        Modulo modulo = s.get(Modulo.class, id);
        s.getTransaction().commit();
        return Optional.ofNullable(modulo);
    }

    @Override
    public List<Modulo> readAll() {
        s.getTransaction().begin();
        List<Modulo> modulos = s.createSelectionQuery("from Modulo ", Modulo.class).list();
        s.getTransaction().commit();
        return modulos;
    }

    @Override
    public Modulo update(Modulo modulo) {
        s.getTransaction().begin();
        s.merge(modulo);
        s.getTransaction().commit();
        return modulo;
    }

    @Override
    public void delete(Modulo modulo) {
        s.getTransaction().begin();
        try {
            s.remove(modulo);
            s.getTransaction().commit();
        } catch (OptimisticLockException e) {
            System.err.println("*******Error no se puede borrar un Modulo que no existe.*******");
        }
    }

    public void close() {
        s.close();
        sf.close();
    }
}
