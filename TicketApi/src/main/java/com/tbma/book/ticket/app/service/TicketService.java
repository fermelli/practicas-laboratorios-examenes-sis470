package com.tbma.book.ticket.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tbma.book.ticket.app.dao.TicketDao;
import com.tbma.book.ticket.app.entities.Ticket;

@Service
public class TicketService {

	@Autowired
	TicketDao ticketDao;

	public Ticket createTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		return ticketDao.save(ticket);
	}

	public Ticket getTicketById(Integer ticketId) {
		return ticketDao.findOne(ticketId);
	}

	public Iterable<Ticket> getAllTickets() {
		return ticketDao.findAll();
	}

	public void deleteTicket(Integer ticketId) {
		ticketDao.delete(ticketId);
	}

	public Ticket updateTicket(int ticketId, String email) {
		Ticket ticket = ticketDao.findOne(ticketId);
		ticket.setEmail(email);
		return ticketDao.save(ticket);
	}

}
