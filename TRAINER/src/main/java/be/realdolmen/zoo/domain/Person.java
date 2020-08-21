package be.realdolmen.zoo.domain;

public class Person extends BaseEntity{
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void print(Person person){
        System.out.println(person.toString());
    }

    @Override
    public String toString() {
        return "name=" + name;
    }
}
