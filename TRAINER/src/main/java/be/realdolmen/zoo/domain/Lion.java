package be.realdolmen.zoo.domain;

public class Lion extends Animal {

    // if you want to use the builder pattern in Animal class
//    protected Lion(Builder builder) {
//        super(builder);
//    }

    public String makeSound() {
        return "raaaaauw";
    }

    public Lion() {

    }

}
