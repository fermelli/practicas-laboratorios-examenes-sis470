package com.tbma.book.ticket.app.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.tbma.book.ticket.app.entities.Ticket;
import com.tbma.book.ticket.app.service.Data;
import com.tbma.book.ticket.app.service.TicketService;

@RunWith(MockitoJUnitRunner.class)
public class TicketControllerTest {
	@Mock
	private TicketService ticketService;
	@InjectMocks
	private TicketController ticketController;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testCreateTicket() {
		Ticket ticket = Data.getTicket();
		Mockito.when(ticketService.createTicket(ticket)).thenReturn(ticket);
		Ticket createdTicket = ticketController.createTicket(ticket);
		assertEquals(ticket.getPassengerName(), createdTicket.getPassengerName());
	}

	@Test
	public void testGetTicketById() {
		Ticket ticket = Data.getTicket();
		Mockito.when(ticketService.getTicketById(anyInt())).thenReturn(ticket);
		Ticket retrievedTicket = ticketController.getTicketById(anyInt());
		assertEquals(retrievedTicket.getPassengerName(), ticket.getPassengerName());
	}

	@Test
	public void testGetAllTickets() {
		Iterable<Ticket> tickets = Data.getTickets();
		Mockito.when(ticketService.getAllTickets()).thenReturn(tickets);
		Iterable<Ticket> retrievedTickets = ticketController.getAllTickets();
		assertEquals(retrievedTickets, tickets);
	}

	@Test
	public void testDeleteTicket() {
		ticketController.deleteTicket(anyInt());
		Mockito.verify(ticketService).deleteTicket(anyInt());
	}

	@Test
	public void testUpdateTicket() {
		Ticket ticket = Data.getTicket();
		String newEmail = "newemail@gmail.com";
		Mockito.when(ticketService.updateTicket(1, newEmail)).thenReturn(ticket);
		Ticket updatedTicket = ticketController.updateTicket(1, newEmail);
		assertEquals(ticket.getEmail(), updatedTicket.getEmail());
	}

}
