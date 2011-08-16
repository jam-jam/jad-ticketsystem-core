package be.intecbrussel.jad.model.data;

import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import javax.persistence.metamodel.SingularAttribute;

import be.intecbrussel.jad.model.entities.Category;

/**
 *
 * @author Huseyin
 */
public class CategoryDAO extends GenericDAO {

    public CategoryDAO () {
        super(Category.class);
    }

    @Override
    public List<Category> findByStringAttribute(String attribute, String value) {
        //crateing criteria
        CriteriaBuilder cb = getEm().getCriteriaBuilder();
        CriteriaQuery<Category> cq = cb.createQuery(Category.class);

        //Creating metamodel, entity and attribute of corsponding attribute name
        Metamodel m = getEm().getMetamodel();
        EntityType<Category> Ticket_ = m.entity(Category.class);
        SingularAttribute<Category, String> att = Ticket_.getDeclaredSingularAttribute(attribute, String.class);

        //createing our where clause
        Root<Category> root = cq.from(Category.class);
        cq.where(cb.like(root.get(att).as(String.class), value));

        //Executing our query
        TypedQuery<Category> tq = getEm().createQuery(cq);
        return tq.getResultList();
    }
}
