package be.intecbrussel.jad.services;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.intecbrussel.jad.model.data.TicketDAO;
import be.intecbrussel.jad.model.entities.Account;
import be.intecbrussel.jad.model.entities.Ticket;


/**
 *
 * @author AliG
 */
@Service("ticketService")
@Transactional
public class TicketService  {

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

	public void add(Ticket ticket) {
		//logger.debug("Adding new user");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Save
		System.out.println("before");
		session.save(ticket);
		System.out.println("after");
	}
	public List<Ticket> getAll() {
		//logger.debug("Retrieving all users");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a Hibernate query
		Query query = session.createQuery("FROM  Ticket");
		
		// Retrieve all
		return  query.list();
	}
}