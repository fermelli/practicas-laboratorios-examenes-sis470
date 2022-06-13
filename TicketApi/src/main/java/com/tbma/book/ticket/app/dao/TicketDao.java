package com.tbma.book.ticket.app.dao;

import org.springframework.data.repository.CrudRepository;
import com.tbma.book.ticket.app.entities.Ticket;


public interface TicketDao extends CrudRepository<Ticket, Integer> {
    Ticket findByEmail(String email);

}
