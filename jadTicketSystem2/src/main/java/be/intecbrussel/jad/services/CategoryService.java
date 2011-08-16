package be.intecbrussel.jad.services;

import be.intecbrussel.jad.model.data.CategoryDAO;
import be.intecbrussel.jad.model.entities.Category;


/**
 *
 * @author Huseyin
 */
public class CategoryService extends GenericService<Category> {

    CategoryDAO categoryDAO;

    public CategoryService() {
        super();
        dao = new CategoryDAO();
        this.categoryDAO = (CategoryDAO) dao;
    }
}
