package be.intecbrussel.jad.model.data;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

/**
 * If you don't live for something, you will die for nothing
 * @author alig
 */
public class GenericDAO<T> implements CRUDable<T> {

    private static EntityManagerFactory emf;
    private EntityManager em;
    private Class<T> entityClass;

    static {
        emf = Persistence.createEntityManagerFactory("ticketsystem");
    }

//    public GenericDAO() {
//        this.em = emf.createEntityManager();
//    }
    public GenericDAO(Class<T> entityClass) {
        this.em = emf.createEntityManager();
        this.entityClass = entityClass;
    }

    @Override
    public void create(T t) {
        getEm().persist(t);
    }

    @Override
    public T read(long id) {
        return getEm().find(entityClass, id);

    }

    @Override
    public void update(T t) {
        getEm().merge(t);
    }

    @Override
    public void delete(T t) {
        getEm().remove(t);
    }

    @Override
    public List findAll() {
        //return getEm().createQuery("from "+entityClass.getName()+"").getResultList();
        CriteriaBuilder cb = getEm().getCriteriaBuilder();
        CriteriaQuery<T> cq = getEm().getCriteriaBuilder().createQuery(entityClass);
        Root<T> root = cq.from(entityClass);
        TypedQuery<T> tq = getEm().createQuery(cq);
        return getEm().createQuery(cq).getResultList();
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public Class<T> getEntityClass() {
        return entityClass;
    }

    public void setEntityClass(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public List<T> findByStringAttribute(String attribute, String value) {
        //crateing criteria
        CriteriaBuilder cb = getEm().getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(entityClass);

        //Creating metamodel, entity and attribute of corsponding attribute name
        Metamodel m = getEm().getMetamodel();
        EntityType<T> et_ = m.entity(entityClass);

        //createing our where clause
        Root<T> root = cq.from(entityClass);
        cq.where(cb.like(root.get(et_.getSingularAttribute(attribute)).as(String.class), value));

        //Executing our query
        TypedQuery<T> tq = getEm().createQuery(cq);
        return tq.getResultList();
    }

    @Override
    public int count() {
        CriteriaQuery cq = getEm().getCriteriaBuilder().createQuery();
        Root<T> rt = cq.from(entityClass);
        cq.select(getEm().getCriteriaBuilder().count(rt));
        Query q = getEm().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

}
