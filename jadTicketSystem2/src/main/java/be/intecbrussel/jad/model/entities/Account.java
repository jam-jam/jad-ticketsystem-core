package be.intecbrussel.jad.model.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private String firstname;

	@Basic(optional = true)
	private String lastname;

	@Basic(optional = false)
	private String username;

	//@Basic(optional = false)
	private String password;

	private String email;
	private Boolean mustChangePassword;
	private Boolean isSuspended;
	private Boolean isSystem;
	private Boolean isAdministrator;
	private Date memberSince;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Account() {
	}

	public Account(String username, String password) {
		setUsername(username);
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
		return String.format("%s [%d]", getUsername(), getId());
	}

	public boolean isNew() {
		return this.id == null;
	}
}
