package model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    String id;
    List<Ticket> ticketList;

    public Customer(String id) {
        this.id = id;
        this.ticketList = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }
}
