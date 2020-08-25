package be.realdolmen.zoo.domain;


import be.realdolmen.zoo.domain.enums.VisitorType;

import java.util.List;

public class Visitor extends BaseEntity{
    private VisitorType visitorType;
    private String name;
    private Ticket ticket; 
    private List<Address> address;

    public Visitor() {
    }

    public Visitor(String name, VisitorType visitorType){
        this.name = name;
        this.visitorType = visitorType;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public VisitorType getVisitorType() {
        return visitorType;
    }

    public void setVisitorType(VisitorType visitorType) {
        this.visitorType = visitorType;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }
}
