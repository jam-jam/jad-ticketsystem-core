package be.intecbrussel.jad.controllers;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import be.intecbrussel.jad.model.entities.Account;
import be.intecbrussel.jad.model.entities.Ticket;
import be.intecbrussel.jad.services.TicketService;

@Controller
 @RequestMapping(value="/tickets")
public class TicketController {

	@Resource(name = "ticketService")
	private TicketService ticketService;

	@RequestMapping(method = RequestMethod.GET, value = "ticket")
	public String toReg() {
		System.out.println("in toReg");
		return "user";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/ticket/add")
	public String toNewTicket(@ModelAttribute("ticketForm") Ticket ticket) {
		System.out.println("in toReg");
		return "newticket";
	}

	@RequestMapping(method = RequestMethod.GET, value = "newUser")
	public String addAccount(Model model) {
		System.out.println("prepare to create a new user");
		model.addAttribute("userAttribute", new Account());

		return "addUser";
	}


	
	@ModelAttribute("categoryList")
	public String[] getCheckboses() {
		return new String[] { "Scherm", "Hardware", "Toetsenbord" };
	}

	@RequestMapping(method = RequestMethod.POST, value = "/ticket/add")
	public String putInDB(@ModelAttribute("ticketForm") Ticket ticket,
			BindingResult br) {

		ticket.setSubmitDate(new Date());
		ticketService.add(ticket);
		return "newTicketConfirmed";
	}

	@RequestMapping(value = "/ticket/list")
	public String goToTicketList(Model model) {
		List<Ticket> ticketList = ticketService.getAll();
		model.addAttribute("tickets", ticketList);
		System.out.println(ticketList.size());
		return "ticketlist";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/ticket/edit")
	public String editTicket(@RequestParam("aidi") Long id, Model model, @ModelAttribute("ticketToEdit")Ticket ticket) {
		ticket = ticketService.get(id);
		model.addAttribute("ticketToEdit",ticket);
		System.out.println(ticket.getTitle());
		System.out.println("Id1 : " + ticket.getId());
		
		
		return "editTicket";

	}

	@RequestMapping(method= RequestMethod.POST, value = "/ticket/edit")
	public String saveEditedTicket(@ModelAttribute("ticketToEdit") Ticket ticket,BindingResult br,@RequestParam("aido")Long id,Model model) {
		System.out.println(ticket.getDescription());
		ticket.setId(id);
		System.out.println("Id2 : "+ticket.getId());
		ticketService.edit(ticket);
		goToTicketList(model);
		return "ticketlist";
	}
	@RequestMapping(value="/ticket/delete")
	public String deleteTicket(@ModelAttribute("ticketToEdit")Ticket ticket,@RequestParam("aidi")Long id, Model model){
		ticket.setId(id);
		System.out.println("Deleting id :"+ticket.getId());
		ticketService.delete(ticket.getId());
		goToTicketList(model);
		return "ticketlist";
	}
}
