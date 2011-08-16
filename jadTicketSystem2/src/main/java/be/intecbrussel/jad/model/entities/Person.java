package be.intecbrussel.jad.model.entities;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Person implements Entitable {
	
	@Id
	private Long id;
	
	@Basic(optional = true)
    private String firstname;

    @Basic(optional = true)
    private String lastname;

    @Basic(optional = false)
    private String username;

    @Basic(optional = false)
    private String password;

    private String email;
    private Boolean mustChangePassword;
    
    @Override
    public abstract Long getId();
    
    @Override
	public abstract void setId(Long id);
    
	@Override
	public boolean isNew() {
		return this.id == null;
	}

	
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public Boolean getMustChangePassword() {
        return mustChangePassword;
    }

    public void setMustChangePassword(Boolean mustChangePassword) {
        this.mustChangePassword = mustChangePassword;
    }
   
}
