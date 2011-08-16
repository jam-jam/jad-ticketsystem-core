package be.intecbrussel.jad.services;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.intecbrussel.jad.model.entities.Account;


/**
 *
 * @author ZI
 *
 * Service for processing Users
 * 
 */
@Service("accountService")
@Transactional
public class AccountService{

	//protected static Logger logger = Logger.getLogger("JadTicketSystem");
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;

    /**
	 * Retrieves all accounts
	 * 
	 * @return a list of accounts
	 */
	public List<Account> getAll() {
		//logger.debug("Retrieving all users");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a Hibernate query
		Query query = session.createQuery("FROM  Account");
		
		// Retrieve all
		return  query.list();
	}
	
	/**
	 * Retrieves a single person
	 */
	public Account get( Long id ) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing person first
		Account user = (Account) session.get(Account.class, id);
		
		return user;
	}
	/**
	 * Adds a new person
	 */
	public void add(Account user) {
		//logger.debug("Adding new user");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Save
		session.save(user);
	}
	
	/**
	 * Deletes an existing person
	 * @param id the id of the existing person
	 */
	public void delete(Long id) {
		//logger.debug("Deleting existing user");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing person first
		Account user = (Account) session.get(Account.class, id);
		
		// Delete 
		session.delete(user);
	}
	
	/**
	 * Edits an existing person
	 */
	public void edit(Account user) {
		//logger.debug("Editing existing user");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing person via id
		Account existingUser = (Account) session.get(Account.class, user.getId());
		
		// Assign updated values to this account
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());


		// Save updates
		session.save(existingUser);
	}
}
