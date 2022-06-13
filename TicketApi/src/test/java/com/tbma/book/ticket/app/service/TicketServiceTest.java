package com.tbma.book.ticket.app.service;

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

import com.tbma.book.ticket.app.dao.TicketDao;
import com.tbma.book.ticket.app.entities.Ticket;

@RunWith(MockitoJUnitRunner.class)
public class TicketServiceTest {
	@Mock
	private TicketDao ticketDao;
	@InjectMocks
	private TicketService ticketService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testCreateTicket() {
		Ticket ticket = Data.getTicket();
		Mockito.when(ticketDao.save(ticket)).thenReturn(ticket);
		assertEquals(ticket, ticketService.createTicket(ticket));
	}

	@Test
	public void testGetTicketById() {
		Ticket ticket = Data.getTicket();
		Integer tickeId = 1;
		Mockito.when(ticketDao.findOne(tickeId)).thenReturn(ticket);
		assertEquals(ticket.getTicketId(), ticketService.getTicketById(tickeId).getTicketId());
	}

	@Test
	public void testGetAllTickets() {
		Iterable<Ticket> tickets = Data.getTickets();
		Mockito.when(ticketDao.findAll()).thenReturn(tickets);
		assertEquals(tickets, ticketService.getAllTickets());
	}

	@Test
	public void testDeleteTicket() {
		ticketService.deleteTicket(anyInt());
		Mockito.verify(ticketDao).delete(anyInt());
	}

	@Test
	public void testUpdateTicket() {
		Ticket ticket = Data.getTicket();
		String newEmail = "newemail@gmail.com";
		Mockito.when(ticketDao.findOne(1)).thenReturn(ticket);
		ticket.setEmail(newEmail);
		Mockito.when(ticketDao.save(ticket)).thenReturn(ticket);
		assertEquals(ticket.getEmail(), ticketService.updateTicket(1, newEmail).getEmail());
	}

}
