package fr.isen.services;

import fr.isen.models.Ticket;

import java.util.List;

public interface TicketService {
    List<Ticket> findTickets();
    Ticket getTicketById(int id);
    Ticket updateTicket(int icid, Ticket ticket);
    int addTicket(Ticket ticket);
    void deleteTicket(Ticket ticket);


}
