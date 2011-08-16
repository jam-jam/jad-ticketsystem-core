package be.intecbrussel.jad.controllers;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import be.intecbrussel.jad.model.entities.Account;
import be.intecbrussel.jad.services.AccountService;

/**
 *
 * @author ZI
 *
 * Handles and retrieves account request
 */

@Controller
@RequestMapping("/account")
public class AccountController {

//protected static Logger logger = Logger.getLogger("controller");
	
	@Resource(name="accountService")
	private AccountService userService;
	
	/**
	 * Handles and retrieves all users and show it in a JSP page
	 * 
	 * @return the name of the JSP page
	 */
    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public String getUsers(Model model) {
    	
    	//logger.debug("Received request to show all users");
    	
    	// Retrieve all users by delegating the call to AccountService
    	List<Account> users = userService.getAll();
    	
    	// Attach persons to the Model
    	model.addAttribute("users", users);
    	
    	// This will resolve to /WEB-INF/jsp/userslist.jsp
    	return "userslist";
	}
    
    /**
     * Retrieves the add page
     * 
     * @return the name of the JSP page
     */
    @RequestMapping(value = "/users/add", method = RequestMethod.GET)
    public String getAdd(Model model) {
    	//logger.debug("Received request to show add page");
    
    	// Create new Account and add to model
    	// This is the formBackingOBject
    	model.addAttribute("userAttribute", new Account());

    	// This will resolve to /WEB-INF/jsp/adduser.jsp
    	return "addUser";
	}
 
    /**
     * Adds a new user by delegating the processing to AccountService.
     * Displays a confirmation JSP page
     * 
     * @return  the name of the JSP page
     */
    @RequestMapping(method = RequestMethod.POST)
    public String add(@ModelAttribute("userAttribute") Account user) {
		//logger.debug("Received request to add new user");
		
    	// The "userAttribute" model has been passed to the controller from the JSP
		
    	System.out.println("inserting the new user from AC");
		// Call AccountService to do the actual insert
		userService.add(user);
		
		System.out.println("New user inserted from AC");

    	// This will resolve to /WEB-INF/jsp/addeduser.jsp
		return "addedUser";
	}
    
    /**
     * Deletes an existing user by delegating the processing to AccountService.
     * Displays a confirmation JSP page
     * 
     * @return  the name of the JSP page
     */
    @RequestMapping(value = "/users/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(value="id", required=true) Long id, 
    										Model model) {
   
		//logger.debug("Received request to delete existing user");
		
		// Call AccountService to do the actual deleting
		userService.delete(id);
		
		// Add id reference to Model
		model.addAttribute("id", id);
    	
    	// This will resolve to /WEB-INF/jsp/deleteduser.jsp
		return "deleteduser";
	}
    
    /**
     * Retrieves the edit page
     * 
     * @return the name of the JSP page
     */
    @RequestMapping(value = "/users/edit", method = RequestMethod.GET)
    public String getEdit(@RequestParam(value="id", required=true) Long id,  
    										Model model) {
    	//logger.debug("Received request to show edit page");
    
    	// Retrieve existing user and add to model
    	model.addAttribute("userAttribute", userService.get(id));
    	
    	// This will resolve to /WEB-INF/jsp/edituser.jsp
    	return "edituser";
	}
    
    /**
     * Edits an existing user by delegating the processing to AccountService.
     * Displays a confirmation JSP page
     * 
     * @return  the name of the JSP page
     */
    @RequestMapping(value = "/users/edit", method = RequestMethod.POST)
    public String saveEdit(@ModelAttribute("userAttribute") Account user, 
    										   @RequestParam(value="id", required=true) Long id, 
    												Model model) {
    	//logger.debug("Received request to update user");
    
    	// The "userAttribute" model has been passed to the controller from the JSP
    	
    	// We manually assign the id because we disabled it in the JSP page
    	// When a field is disabled it will not be included in the ModelAttribute
    	user.setId(id);
    	
    	// Delegate to PersonService for editing
    	userService.edit(user);
    	
    	// Add id reference to Model
		model.addAttribute("id", id);
		
    	// This will resolve to /WEB-INF/jsp/editeduser.jsp
		return "editeduser";
	}
    

//    private static String hashMD5IfNecessary(String password) {
//        return !"^[a-f0-9]{32}$".matches(password) ? JsfUtil.hashMD5(password) : password;
//    }
 
}
