package be.intecbrussel.jad.model.data;

import java.util.List;

/**
 *
 * @author alig
 */
public interface CRUDable<T> {
    public abstract  void create(T t);
    public abstract T read(long id);
    public abstract void update(T t);
    public abstract void delete(T t);
    public abstract List<T> findAll();
    public abstract int count();

}
