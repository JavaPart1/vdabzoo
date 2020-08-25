package be.realdolmen.zoo.domain;

import java.util.List;

public class Ticket extends BaseEntity{

    private double originalPrice;
    private double reductionPrice;

    private List<Visitor> visitors;

    public Ticket() {
    }

    public Ticket(double originalPrice) {
        this.originalPrice = originalPrice;
    }



    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double price) {
        this.originalPrice = price;
    }

    public List<Visitor> getVisitors() {
        return visitors;
    }

    public void setVisitors(List<Visitor> visitors) {
        this.visitors = visitors;
    }

    public double getReductionPrice() {
        return reductionPrice;
    }

    public void setReductionPrice(double reductionPrice) {
        this.reductionPrice = reductionPrice;
    }
}
