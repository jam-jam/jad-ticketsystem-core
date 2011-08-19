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
	public Ticket get( Long id ) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing person first
		Ticket ticket = (Ticket) session.get(Ticket.class, id);
		
		return ticket;
	}
	public void edit(Ticket ticket) {
		//logger.debug("Editing existing user");
		
		// Retrieve session from Hibernate
		System.out.println("in edit ticket...");
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing person via id
		Ticket existingTicket = (Ticket) session.get(Ticket.class, ticket.getId());
		System.out.println("getting the ticket...");
		System.out.println("existing ticket description : "+existingTicket.getDescription());
		
		// Assign updated values to this account
		existingTicket.setTitle(ticket.getTitle());
		existingTicket.setDescription(ticket.getDescription());
		System.out.println("existing ticket new description : " +existingTicket.getDescription());
//		existingTicket.setCategory(ticket.getCategory());
//		existingTicket.setContact(ticket.getContact());
//		existingTicket.setEmployee(ticket.getEmployee());
//		existingTicket.setResponse(ticket.getResponse());
		existingTicket.setSolvedDate(ticket.getSolvedDate());
//		existingTicket.setWaitingTime(ticket.getWaitingTime());

		// Save updates
		session.save(existingTicket);
		System.out.println("Ticket edited");
	}
	public void delete(Long id) {
		//logger.debug("Deleting existing user");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing person first
		Ticket ticket  = (Ticket) session.get(Ticket.class, id);
		
		// Delete 
		session.delete(ticket);
	}
}
