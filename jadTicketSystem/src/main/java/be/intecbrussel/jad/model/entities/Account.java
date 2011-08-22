package be.intecbrussel.jad.model.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.print.attribute.standard.DateTimeAtCompleted;

/**
 * 
 * @author ZI
 */
@Entity
@Table(name = "tbAccount", schema = "TicketSystemDB")
// @NamedQueries({
// @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
// @NamedQuery(name = "User.findByUserId", query =
// "SELECT u FROM User u WHERE u.userId = :userId"),
// @NamedQuery(name = "User.findByUserName", query =
// "SELECT u FROM User u WHERE u.username = :name"),
// @NamedQuery(name = "User.findB,yPassword", query =
// "SELECT u FROM User u WHERE u.password = :password"),
// @NamedQuery(name = "User.findByUserNameAndPassword", query =
// "SELECT u FROM User u WHERE u.username = :name AND u.password = :password"),
// @NamedQuery(name = "User.findByBirthdate", query =
// "SELECT u FROM User u WHERE u.birthdate = :birthdate"),
// @NamedQuery(name = "User.findByEmail", query =
// "SELECT u FROM User u WHERE u.email = :email"),
// @NamedQuery(name = "User.findByIsSuspended", query =
// "SELECT u FROM User u WHERE u.isSuspended = :isSuspended"),
// @NamedQuery(name = "User.findByMustChangePassword", query =
// "SELECT u FROM User u WHERE u.mustChangePassword = :mustChangePassword"),
// @NamedQuery(name = "User.findByIsSystem", query =
// "SELECT u FROM User u WHERE u.isSystem = :isSystem"),
// @NamedQuery(name = "User.findByIsAdministrator", query =
// "SELECT u FROM User u WHERE u.isAdministrator = :isAdministrator")})
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	private Long id;

	@Basic(optional = true)
	private String firstName;

	@Basic(optional = true)
	private String lastName;

	@Basic(optional = false)
	private String userName;

	//@Basic(optional = false)
	private String password;

	@Basic(optional = false)
	private String email;
	
	private Boolean mustChangePassword= true;
	
	private Boolean isSuspended = false;
	private Boolean isSystem = false;
	private Boolean isAdministrator= false;
	
	@Temporal(TemporalType.DATE)
	private Date memberSince = new Date();
	private String comments;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstname) {
		this.firstName = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastname) {
		this.lastName = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String username) {
		this.userName = username;
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

	public Boolean getIsAdministrator() {
		return isAdministrator;
	}

	public void setIsAdministrator(Boolean isAdministrator) {
		this.isAdministrator = isAdministrator;
	}

	public Boolean getIsSuspended() {
		return isSuspended;
	}

	public void setIsSuspended(Boolean isSuspended) {
		this.isSuspended = isSuspended;
	}

	public Boolean getIsSystem() {
		return isSystem;
	}

	public void setIsSystem(Boolean isSystem) {
		this.isSystem = isSystem;
	}

	public Date getMemberSince() {
		return memberSince;
	}


	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Account() {
	}

	public Account(String username, String password) {
		setUserName(username);
		setPassword(password);
	}

	@Override
	public int hashCode() {
		int hash = 97;
		hash += (getId() != null ? getId().hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Account)) {
			return false;
		}
		Account other = (Account) object;
		if ((this.getId() == null && other.getId() != null)
				|| (this.getId() != null && !this.getId().equals(other.getId()))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return String.format("%s [%d]", getUserName(), getId());
	}

	public boolean isNew() {
		return this.id == null;
	}
}
