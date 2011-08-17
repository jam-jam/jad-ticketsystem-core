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
// @RequestMapping(value="tick")
public class TicketController {

	@Resource(name = "ticketService")
	private TicketService ticketService;

	@RequestMapping(method = RequestMethod.GET, value = "ticket")
	public String toReg() {
		System.out.println("in toReg");
		return "user";
	}

	@RequestMapping(method = RequestMethod.GET, value = "newTicket")
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

	@RequestMapping(value = "sendToDb")
	public String putInDB(@ModelAttribute("ticketForm") Ticket ticket,
			BindingResult br) {

		ticket.setSubmitDate(new Date());
		ticketService.add(ticket);
		System.out.println(ticket.getTitle());
		return "newTicketConfirmed";
	}

	@RequestMapping(value = "ticketlist")
	public String goToTicketList(Model model) {
		List<Ticket> ticketList = ticketService.getAll();
		model.addAttribute("tickets", ticketList);
		System.out.println(ticketList.size());
		return "ticketlist";
	}

	@RequestMapping(method = RequestMethod.GET, value = "editTicket")
	public String editTicket(@RequestParam("aidi") Long id, Model model, @ModelAttribute("testForm")Ticket tick) {
		System.out.println("In edit Ticket mensen");
		Ticket ticket = ticketService.get(id);
		System.out.println(ticket.getTitle());
		model.addAttribute("ticketToEdit", ticket);
		return "editTicket";

	}

	@RequestMapping(value = "/test")
	public String leavemealone(@ModelAttribute("testForm") Ticket ticket,
			BindingResult br) {

		return "please";
	}
}
