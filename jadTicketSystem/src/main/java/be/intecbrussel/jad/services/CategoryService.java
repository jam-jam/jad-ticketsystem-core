package be.intecbrussel.jad.services;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.intecbrussel.jad.model.entities.Category;


/**
 *
 * @author Huseyin
 */
@Service ("categoryService")
@Transactional
public class CategoryService  {

	@Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    public CategoryService() {
        super();
    }
	public void add(Category cat) {
		//logger.debug("Adding new user");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Save
		session.save(cat);
	}    
	public List<Category> getAll() {
		//logger.debug("Retrieving all users");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Create a Hibernate query
		Query query = session.createQuery("FROM  Category");
		
		// Retrieve all
		return  query.list();
	}
	public Category get( Long id ) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing person first
		Category cat = (Category) session.get(Category.class, id);
		
		return cat;
	}
	public void edit(Category cat) {
		//logger.debug("Editing existing user");
		
		// Retrieve session from Hibernate
		System.out.println("in edit cat...");
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing person via id
		Category existingCat = (Category) session.get(Category.class, cat.getId());
		System.out.println("getting the ticket...");
		System.out.println("existing ticket description : "+existingCat.getDescription());
		
		// Assign updated values to this account
		existingCat.setName(cat.getName());
		existingCat.setDescription(cat.getDescription());
		System.out.println("existing ticket new description : " +existingCat.getDescription());


		// Save updates
		session.save(existingCat);
		System.out.println("Category edited");
	}
	public void delete(Long id) {
		//logger.debug("Deleting existing user");
		
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		// Retrieve existing person first
		Category cat  = (Category) session.get(Category.class, id);
		
		// Delete 
		session.delete(cat);
	}	
}
