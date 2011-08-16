package be.intecbrussel.jad.controllers;


import be.intecbrussel.jad.model.entities.Account;
import be.intecbrussel.jad.services.AccountService;
import be.intecbrussel.jad.utils.JsfUtil;


import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

/**
 *
 * @author ZI
 */

@ManagedBean (name="userManagedBean")
@SessionScoped
public class AccountController implements Serializable {

    private Account currentUser;
    private DataModel userList = null;
    private int selectedUserIndex;

    public AccountController() {
    }

    public AccountService getService(){
        return new AccountService();
    }

    public Account getSelected() {
        if (currentUser == null) {
            currentUser = new Account();
            selectedUserIndex = -1;
        }
        return currentUser;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
       currentUser = (Account) getUserList().getRowData();
        selectedUserIndex = getUserList().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        currentUser = new Account();
        selectedUserIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            AccountService service = new AccountService();
            currentUser.setPassword(hashMD5IfNecessary(currentUser.getPassword()));
            service.create(currentUser);
            JsfUtil.addSuccessMessage("User was successfully created");
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, "A persistence error occurred during user creation process.");
            return null;
        }
    }

    public String prepareEdit() {
        currentUser = (Account) getUserList().getRowData();
        selectedUserIndex = getUserList().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            AccountService service = new AccountService();
            currentUser.setPassword(hashMD5IfNecessary(currentUser.getPassword()));
            service.update(currentUser);
            JsfUtil.addSuccessMessage("User was successfully updated.");
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, "A persistence error occurred during update user operation.");
            return null;
        }
    }

    public String delete() {
        currentUser = (Account) getUserList().getRowData();
        selectedUserIndex = getUserList().getRowIndex();
        performDelete();
        recreateModel();
        return "List";
    }

    public String deleteAndView() {
        performDelete();
        recreateModel();
        updateCurrentUser();
        if (selectedUserIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDelete() {
        try {
            AccountService service = new AccountService();
            service.delete(currentUser);
            JsfUtil.addSuccessMessage("User was successfully deleted.");
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, "A persistence error occurred during delete user operation.");
        }
    }

    private void updateCurrentUser() {
        AccountService service = new AccountService();

        int count = service.count();
        if (selectedUserIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedUserIndex = count-1;
        }
        if (selectedUserIndex >= 0) {
            currentUser = service.findAll().get(0);
        }
    }

    private static String hashMD5IfNecessary(String password) {
        return !"^[a-f0-9]{32}$".matches(password) ? JsfUtil.hashMD5(password) : password;
    }


    public DataModel getUserList() {
        if (userList == null) {
            userList = createDataModel();
        }
        return userList;
    }

    private void recreateModel() {
        userList = null;
    }

    public DataModel createDataModel() {
        AccountService service = new AccountService();
        return new ListDataModel(service.findAll());
    }

        public SelectItem[] getItemsAvailableSelectMany() {
            AccountService service = new AccountService();
        return JsfUtil.getSelectItems(service.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        AccountService service = new AccountService();
        return JsfUtil.getSelectItems(service.findAll(), true);
    }

    @FacesConverter(forClass=Account.class)
    public static class UserControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            AccountController controller = (AccountController)facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "userManagedBean");
            return controller.getService().read(new Long(getKey(value)));
        }

        java.lang.String getKey(String value) {
            java.lang.String key;
            key = value;
            return key;
        }

        String getStringKey(java.lang.String value) {
            StringBuffer sb = new StringBuffer();
            sb.append(value);
            return sb.toString();
        }

        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Account) {
                Account u = (Account) object;
                return getStringKey(u.getUsername());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: "+AccountController.class.getName());
            }
        }

    }

}
