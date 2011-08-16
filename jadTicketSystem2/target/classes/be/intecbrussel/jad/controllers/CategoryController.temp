package be.intecbrussel.jad.controllers;

import java.io.Serializable;
import java.util.List;

import be.intecbrussel.jad.model.entities.Category;
import be.intecbrussel.jad.services.CategoryService;

/**
 *
 * @author Huseyin
 */
public class CategoryController implements Serializable {
    List<Category> categorylist;
    Category category;
    CategoryConverter converter = new CategoryConverter();
    CategoryService service = new CategoryService();

    public CategoryController(){
    this.category = new Category();
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Category> getCategorylist() {
        return categorylist;
    }

    public void setCategorylist(List<Category> categorylist) {
        this.categorylist = categorylist;
    }
   

    public String newCategory() {
        try {
            //GenericService<Ticket> service = new GenericService<Ticket>();
          // CategoryService service = new CategoryService();
            service.create(category);

            categorylist = service.findAll();
            converter.setCategoryList(categorylist);

            this.category = new Category();
            return "success";
        } catch (RuntimeException re) {
            return "failure";
        }
    }
    public String genList(){
        //CategoryService service = new CategoryService();
         categorylist = service.findAll();
         converter.setCategoryList(categorylist);
        return "success1";
    }
    public String  solution(Long id){
        //CategoryService service = new CategoryService();
        this.category = service.read(id);
        if(category == null)
            return "failed";
        else
            return "success";

    }

    public CategoryConverter getConverter() {
        return converter;
    }

    public void setConverter(CategoryConverter converter) {
        this.converter = converter;
    }

    public String editCategory() {
        try {
            
            service.update(category);
        } catch (RuntimeException re) {
            return "failed";
        }
        return "success";
    }


    public String deleteCategory() {
        try {
            //CategoryService service = new CategoryService();
            service.delete(category);
            categorylist = service.findAll();
            this.category = new Category();
              return "successdelete";
        } catch (RuntimeException re) {
            return "failed";
        }
      
    }

    public String trickMethods(Category category){
        this.category = category;
        return "success";
    }
}
