package be.intecbrussel.jad.controllers;

import java.io.Serializable;
import java.util.List;

import be.intecbrussel.jad.model.entities.Category;
import be.intecbrussel.jad.model.entities.Ticket;
import be.intecbrussel.jad.services.TicketService;

/**
 *
 * @author alig
 */
public class TicketManagementBean implements Serializable {

    List<Ticket> ticketList;
    Ticket ticket;
    String solutionDescription;
    long ticketIdDelete;
    String ticketTitleDelete;

    public TicketManagementBean() {
        this.ticket = new Ticket();
        this.ticket.setCategory(new Category());
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public String getSolutionDescription() {
        return solutionDescription;
    }

    public void setSolutionDescription(String solutionDescription) {
        this.solutionDescription =
                solutionDescription;
    }

    public String newTicket() {
        try {
            //GenericService<Ticket> service = new GenericService<Ticket>();
            TicketService service = new TicketService();
            service.create(ticket);
            ticketList = service.findAll();
            this.ticket = new Ticket();
            return "success";
        } catch (RuntimeException re) {
            return "failure";
        }
    }

    public String genList() {
        TicketService service = new TicketService();
        ticketList = service.findAll();
        return "success";
    }

    public String solution(Long id) {
        TicketService service = new TicketService();
        this.ticket = service.read(id);
        if (ticket == null) {
            return "failed";
        } else {            
            return "success";
        }

    }

    public String actionSolution(Long id) {
        TicketService service = new TicketService();
        this.ticket = service.read(id);
        this.solutionDescription = this.ticket.getResponse();
        if (ticket == null) {
            return "failed";
        } else {
            return "success";
        }
    }

    public long getTicketIdDelete() {
        return ticketIdDelete;
    }

    public void setTicketIdDelete(long ticketIdDelete) {
        this.ticketIdDelete = ticketIdDelete;
    }

    public String getTicketTitleDelete() {
        return ticketTitleDelete;
    }

    public void setTicketTitleDelete(String ticketTitleDelete) {
        this.ticketTitleDelete = ticketTitleDelete;
    }
    

//niet vergeten getters en setters te maken
    public String newSolution(long id) {
        TicketService service = new TicketService();
        this.ticket.setResponse(this.solutionDescription);
        this.ticket.setSolved(Boolean.TRUE);
        service.update(ticket);
        this.genList();
        return "solutionsuccess";
    }
         public String deleteTicket() {
        try {
            //GenericService<Ticket> service = new GenericService<Ticket>();
            TicketService service = new TicketService();
            service.delete(ticket);
            ticketList = service.findAll();
            this.ticket = new Ticket();
            return "success";
        } catch (RuntimeException re) {
            return "failure";
        }
    }
    public String goToDeletePage(long id) {
        try {
            this.ticketIdDelete = id;

            return "gotodeletepage";
        } catch (RuntimeException re) {
            return "failure";
        }
    }
}
