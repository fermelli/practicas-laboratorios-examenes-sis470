package com.tbma.book.ticket.app;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.tbma.book.ticket.app.entities.Ticket;
import com.tbma.book.ticket.app.service.TicketService;

@SpringBootApplication
public class TicketApi {

	public static void main(String[] args) {
		//SpringApplication.run(TicketBookingManagementAppApplication.class, args);
		ConfigurableApplicationContext context = SpringApplication.run(TicketApi.class, args);
		TicketService ticketservice = context.getBean("ticketService", TicketService.class);
		
		Ticket ticket = new Ticket();
		ticket.setTicketId(1);
		ticket.setBookingDate(new Date());
		ticket.setEmail("juan.perez@gmail.com");
		ticket.setPassengerName("Juan Perez");
		ticket.setSourceStation("Sucre");
		ticket.setDestStation("Potosi");
		ticketservice.createTicket(ticket);
	}
}
