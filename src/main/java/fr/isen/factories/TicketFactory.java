package fr.isen.factories;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.isen.models.Ticket;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicketFactory {
    static TicketFactory instance = null;
    public static TicketFactory getInstance(){
        if(instance == null){
            instance =  new TicketFactory();
        }
        return instance;
    }
    public List<Ticket> getTicketMock(){
        List<Ticket> tickets = new ArrayList<Ticket>();
        tickets.add(new Ticket(1,"TEst"));
        tickets.add(new Ticket(2,"TEst 2"));
        return tickets;
    }
    public  List<Ticket> getTicketFromJsonFile(){
        List<Ticket> tickets = new ArrayList<>();
        try{
            ObjectMapper mapper = new ObjectMapper();
            URL res = this.getClass().getClassLoader().getResource("Tickets.json");
            File file = new File(res.getFile());
            tickets = Arrays.asList(mapper.readValue(file, Ticket[].class));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return tickets;
    }

}