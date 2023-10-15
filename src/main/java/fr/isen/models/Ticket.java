package fr.isen.models;

import java.util.Date;

public class Ticket {
    public Ticket() {
    }
    public Ticket(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int id=-1;
    public String title;
    public String description;
    Date create_date= new Date();
    Date update_date= new Date();
    enum TicketImpact {
        Blocking,
        Major,
        Minor
    }
    enum TicketStatus{
        Open,
        InProgress,
        Closed
    }
    int id_creator_user;
    int id_computer_concerned;
    String requirement_type;
    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
