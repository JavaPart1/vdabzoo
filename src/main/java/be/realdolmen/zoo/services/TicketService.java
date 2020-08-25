package be.realdolmen.zoo.services;

import be.realdolmen.zoo.domain.Ticket;
import be.realdolmen.zoo.domain.Visitor;
import be.realdolmen.zoo.repository.jdbc.TicketRepository;

import static be.realdolmen.zoo.util.Helper.loadPropertiesFile;

public class TicketService {
    private TicketRepository ticketRepository = new TicketRepository();

    public void addTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    public double calculateReductionPriceForVisitorType(Visitor visitor) {
        Ticket ticket = visitor.getTicket();
        switch (visitor.getVisitorType()) {
            case ADULT:
                return ticket.getOriginalPrice() - (ticket.getOriginalPrice() * Double.parseDouble(loadPropertiesFile().getProperty("reduction.adult")));
            case CHILD:
                return ticket.getOriginalPrice() - (ticket.getOriginalPrice() * Double.parseDouble(loadPropertiesFile().getProperty("reduction.child")));
            case HANDICAP:
                return ticket.getOriginalPrice() - (ticket.getOriginalPrice() * Double.parseDouble(loadPropertiesFile().getProperty("reduction.handicap")));
            default:
                return ticket.getOriginalPrice();
        }
    }

    String test() { // for testing private or package private methods
        System.out.println("test");
        return "iets";
    }

    public Ticket findTicketById(int id){
        return ticketRepository.findById(id);
    }
}
