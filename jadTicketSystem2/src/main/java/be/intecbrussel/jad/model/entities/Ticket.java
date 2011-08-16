package be.intecbrussel.jad.model.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author alig
 */
@Entity
@Table(name="tbTicket", schema = "TicketSystemDB")
public class Ticket implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private String response;
    private Boolean solved;
    private String contact;//it is a end user
    private String employee;
    
    @Temporal(TemporalType.DATE)
    private Date submitDate;
    private Date solvedDate;
    private Long waitingTime;

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date datum) {
        this.submitDate = datum;
    }

    
    @ManyToOne
    private Category category;

    public Ticket() {
    }   

    public Ticket(String description, String response, Boolean solved, String contact, String employee, String title) {
        this.title = title;
        this.description = description;
        this.response = response;
        this.solved = solved;
        this.contact = contact;
        this.employee = employee;
    }

    public Ticket(String description, String contact, String title) {
        this.title = title;
        this.description = description;
        this.contact = contact;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Boolean getSolved() {
        return solved;
    }

    public void setSolved(Boolean solved) {
        this.solved = solved;
    }

    public Date getSolvedDate() {
        return solvedDate;
    }

    public void setSolvedDate(Date datumSolution) {
        this.solvedDate = datumSolution;
    }

    public Long getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(Long waitingTime) {
        this.waitingTime = waitingTime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
       // TODO: Warning - this method won't work in the case the id fields are not set

        if (!(object instanceof Ticket)) {
            return false;
        }
        Ticket other = (Ticket) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "Ticket{" + "id=" + id + "title=" + title + "description=" + description + "response=" + response + "solved=" + solved + "contact=" + contact + "employee=" + employee + '}';
    }
   


}
