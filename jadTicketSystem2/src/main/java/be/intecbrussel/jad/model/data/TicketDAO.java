package be.intecbrussel.jad.model.data;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import javax.persistence.metamodel.SingularAttribute;

import be.intecbrussel.jad.model.entities.Ticket;

/**
 *
 * @author AliG
 */
public class TicketDAO extends GenericDAO<Ticket> {

    
    public TicketDAO() {
        super(Ticket.class);
    }

    @Override
    public List<Ticket> findByStringAttribute(String attribute, String value) {
        //crateing criteria
        CriteriaBuilder cb = getEm().getCriteriaBuilder();
        CriteriaQuery<Ticket> cq = cb.createQuery(Ticket.class);

        //Creating metamodel, entity and attribute of corsponding attribute name
        Metamodel m = getEm().getMetamodel();
        EntityType<Ticket> Ticket_ = m.entity(Ticket.class);
        SingularAttribute<Ticket, String> att = Ticket_.getDeclaredSingularAttribute(attribute, String.class);

        //createing our where clause
        Root<Ticket> root = cq.from(Ticket.class);
        cq.where(cb.like(root.get(att).as(String.class), value));

        //Executing our query
        TypedQuery<Ticket> tq = getEm().createQuery(cq);
        return tq.getResultList();
    }
    	
}
