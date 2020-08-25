package be.realdolmen.zoo.domain;

import java.time.LocalDate;

public class Bear extends Animal {
    private LocalDate dateOfBirth;

    public Bear(String name) {
        super(name);
    }

    public Bear() {
    }

    // if you want to use the builder pattern in Animal class
//    Bear(Builder builder) { // because i'm using the builder pattern
//        super(builder);
//    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }



}
