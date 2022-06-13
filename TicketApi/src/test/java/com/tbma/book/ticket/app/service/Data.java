package com.tbma.book.ticket.app.service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.tbma.book.ticket.app.entities.Ticket;

public class Data {

	public static Ticket getTicket() {
		Ticket ticket = new Ticket();
		ticket.setPassengerName("Luis Fernando Salgado Miguez");
		ticket.setSourceStation("Sucre");
		ticket.setDestStation("La Paz");
		ticket.setBookingDate(new Date());
		ticket.setEmail("luisfernandosalgadomiguez@gmail.com");
		return ticket;
	}
	
	public static Iterable<Ticket> getTickets() {
		Ticket ticket1 = new Ticket();
		ticket1.setPassengerName("Luis Fernando Salgado Miguez");
		ticket1.setSourceStation("Sucre");
		ticket1.setDestStation("La Paz");
		ticket1.setBookingDate(new Date());
		ticket1.setEmail("luisfernandosalgadomiguez@gmail.com");
		
		Ticket ticket2 = new Ticket();
		ticket2.setPassengerName("Juan Perez");
		ticket2.setSourceStation("La Paz");
		ticket2.setDestStation("Potosi");
		ticket2.setBookingDate(new Date());
		ticket2.setEmail("juanperez@gmail.com");
		
		Ticket ticket3 = new Ticket();
		ticket3.setPassengerName("Ana Chavez");
		ticket3.setSourceStation("La Paz");
		ticket3.setDestStation("Santa Cruz");
		ticket3.setBookingDate(new Date());
		ticket3.setEmail("anachavez@gmail.com");
		List<Ticket> tickets = Arrays.asList(ticket1, ticket2, ticket3);
		return tickets;
	}

}
