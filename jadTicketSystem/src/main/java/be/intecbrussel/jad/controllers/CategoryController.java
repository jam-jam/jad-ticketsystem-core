package be.intecbrussel.jad.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import be.intecbrussel.jad.model.entities.Category;
import be.intecbrussel.jad.services.CategoryService;

/**
 *
 * @author Huseyin
 */
@Controller
@RequestMapping("/categories")
public class CategoryController implements Serializable {
	@Resource (name="categoryService")
	private CategoryService cs;
	@RequestMapping(method=RequestMethod.GET, value="/category/add")
	
	public String toNewCat(@ModelAttribute("catForm")  Category cat) {
		return "addCategory";
	}
	@RequestMapping(method = RequestMethod.POST, value = "/category/add")
	public String putInDB(@ModelAttribute("catForm") Category cat,
			BindingResult br) {
		cs.add(cat);
		return "addedCategory";
	}	
	@RequestMapping(method = RequestMethod.GET, value = "/category/list")
	public String gotoList (Model model){
	List <Category> categoryList = cs.getAll();
	model.addAttribute("categoryList", categoryList);
	return "categoryList";
	}
}
   
