package be.intecbrussel.jad.services;


import java.util.List;

import be.intecbrussel.jad.model.data.CRUDable;
import be.intecbrussel.jad.model.data.GenericDAO;

/**
 *
 * @author alig
 */
public class GenericService<T> implements CRUDable<T> {

    GenericDAO<T> dao;

    public GenericService(Class<T> entityClass) {
        dao = new GenericDAO<T>(entityClass);
    }

    protected GenericService() {
    }

    @Override
    public void create(T t) {
        try {
            begin();
            dao.create(t);
            commit();
        } catch (RuntimeException re) {
            re.printStackTrace();
            rollback();
            throw new RuntimeException();
        }
    }

    @Override
    public T read(long id) {
        return dao.read(id);
    }

    @Override
    public void update(T t) {
        try {
            begin();
            dao.update(t);
            commit();
        } catch (RuntimeException re) {
            re.printStackTrace();
            rollback();
        }
    }

    @Override
    public void delete(T t) {
        try {
            begin();
            dao.delete(t);
            commit();
        } catch (RuntimeException re) {
            re.printStackTrace();
            rollback();
        }
    }

    @Override
    public List<T> findAll() {
        return dao.findAll();
    }

    @Override
    public int count(){
        return dao.count();
    }

    public GenericDAO<T> getDao() {
        return dao;
    }

    public void setDao(GenericDAO<T> dao) {
        this.dao = dao;
    }

    public void rollback() {
        dao.getEm().getTransaction().rollback();
    }

    public void commit() {
        dao.getEm().getTransaction().commit();
    }

    public void begin() {
        dao.getEm().getTransaction().begin();
    }
}
