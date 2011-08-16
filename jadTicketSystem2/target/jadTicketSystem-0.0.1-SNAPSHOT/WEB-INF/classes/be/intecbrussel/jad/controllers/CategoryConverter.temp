package be.intecbrussel.jad.controllers;

import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import be.intecbrussel.jad.model.entities.Category;

/**
 *
 * @author jamale
 */
public class CategoryConverter implements Converter {
    List<Category> categoryList;

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        for(Category c : categoryList){
            if(c.getName().equalsIgnoreCase(value))return c;
        }
        return new Category();
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return ((Category) value).getName();
    }
}
