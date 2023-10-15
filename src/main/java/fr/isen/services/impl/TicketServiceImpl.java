package fr.isen.services.impl;
import fr.isen.factories.TicketFactory;
import fr.isen.models.Ticket;
import fr.isen.services.TicketService;

import java.util.List;

public class TicketServiceImpl implements TicketService{
    public List<Ticket> findTickets() {
        return TicketFactory.getInstance().getTicketFromJsonFile();
    }

    @Override
    public Ticket getTicketById(int id) {
        return null;
    }

    @Override
    public Ticket updateTicket(int icid, Ticket ticket) {
        return null;
    }

    @Override
    public int addTicket(Ticket ticket) {
        return 0;
    }

    @Override
    public void deleteTicket(Ticket ticket) {

    }

}
