package fr.isen;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.isen.models.Ticket;
import fr.isen.services.TicketService;
import fr.isen.services.impl.TicketServiceImpl;

import io.smallrye.mutiny.Uni;

import jakarta.ws.rs.core.MediaType;


import java.util.*;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;



import java.util.List;
@Path("/ticket")
public class TicketResource {

    private TicketService ticketService;

    public TicketResource( ) {
        this.ticketService = new TicketServiceImpl();
    }
    @GET
    public List<Ticket> list() {
        return this.ticketService.findTickets();
    }
    @GET
    @Path("/{id}")
    public Uni<Ticket> getById(int id) {

        return Uni.createFrom().item(new Ticket(1, "test"));
    }
    @GET
    @Path("/display.jsp")
    @Produces(MediaType.TEXT_HTML)
    public Map<String, Object> displayTickets() {
        List<Ticket> tickets = ticketService.findTickets();
        Map<String, Object> model = new HashMap<>();
        model.put("tickets", tickets);
        return model;
    }
//    @POST
//    public Set<Ticket> add(Ticket ticket) {
//
//        for (Ticket existingTicket : tickets) {
//            if (existingTicket.id == ticket.id && existingTicket.title.contentEquals(ticket.title)){
//                return tickets;
//            }
//        }
//        tickets.add(ticket);
//        return tickets;
//    }
//
//    @PUT
//
//    public Set<Ticket> update(Ticket ticket) {
//        for (Ticket existingTicket : tickets) {
//            if (existingTicket.id == ticket.id && existingTicket.title.contentEquals(ticket.title)){
//                existingTicket.title = ticket.title;
//                return tickets;
//            }
//        }
//        return tickets;
//    }
//
//
//    @DELETE
//    public Set<Ticket> delete(Ticket ticket) {
//        tickets.removeIf(existingFruit -> existingFruit.id == ticket.id && existingFruit.title.contentEquals(ticket.title));
//        return tickets;
//    }
//
//    public String name;
//    public String description;



}
