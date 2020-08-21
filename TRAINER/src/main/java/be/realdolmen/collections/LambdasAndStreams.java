package be.realdolmen.collections;

import be.realdolmen.zoo.domain.Bear;
import be.realdolmen.zoo.domain.Person;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LambdasAndStreams {

    public static void main(String[] args) throws Exception {
        Predicate<Integer> integerPredicate = number -> number >= 100;

        List<Integer> integers = Arrays.asList(5, 51, 100, 564, 65, 651, 651, 65, 651, 65);
        integers.stream().filter(integerPredicate).forEach(System.out::println);

        Optional<Integer> optionalInteger = integers.stream().filter(integer -> integer == 65).findAny();

        if (optionalInteger.isPresent()) {
            System.out.println("found !!");
        }

        optionalInteger.ifPresent(integer -> System.out.println("found " + integer));

//        Integer foundNumber = optionalInteger.orElseThrow(() -> new Exception("not found"));
//        System.out.println(foundNumber);

        System.out.println("-----");
        Integer integer = optionalInteger.orElse(0);
        System.out.println(integer);
        // System.out.println(optionalInteger.get());

        System.out.println("-------");
        //15.1 Count lower case
        String text = "SUPERCALIFRAGILISTicEXPIALIDOCIOUS";
        System.out.println(text
                .chars()
                .filter(Character::isLowerCase)
                .count());

        int counter2 = 0;
        text.chars().forEach(System.out::println);
        System.out.println(counter2);

        int counter = 0;
        for (char c : text.toCharArray()) {
            if (Character.isLowerCase(c)) {
                counter++;
            }
        }
        System.out.println("lowercase letters " + counter);

        System.out.println("-----");


        IntStream range = IntStream.range(50, 53);
        OptionalInt reduce = range
                .reduce((left, right) -> {
                    return left + right;
                });

        System.out.println(reduce.getAsInt());


        ArrayList<Integer> collect = integers.stream().filter(integer1 -> integer1 < 10).collect(Collectors.toCollection(ArrayList::new));
        Integer[] i = {10,20,30};
        System.out.println(collect);
//        Stream.of(i);

        System.out.println("-----");
        Arrays.stream(i).filter(integer1 -> integer1 < 20).forEach(System.out::println);

        List<Integer> numbers = new ArrayList<>();
        for (int a = 0; a < 10; a++) {
            numbers.add((int) (Math.random() * 10));
        }

        List<Integer> filteredList = numbers.stream().filter(number -> number <= 5 && number >= 1).collect(Collectors.toList());

        filteredList.stream().forEach(System.out::println);

        System.out.println("---sorted---");

        filteredList.stream().sorted().forEach(System.out::println);

        System.out.println("---avg---");

        System.out.println(filteredList.stream()
                .mapToInt(value -> value).average()
                .getAsDouble());

        System.out.println("---Als je wat van beren leren kan---");

        List<Bear> bears = new ArrayList<>();

        Bear bear = new Bear("Baloe");
        Bear bear1 = new Bear("Elias");
        Bear bearDub = new Bear("Elias");
        Bear bear2 = new Bear("Timo");

        bears = Arrays.asList(bear, bear1, bear2, bearDub);

        List<Person> people = bears
                .stream()
                .map(bearElement -> new Person(bearElement.getName()))
                .collect(Collectors.toList());

        people.stream().forEach(Person::print);
        System.out.println("---Find Elias---");

        Optional<Person> person1 = people
                .stream()
                .filter(person -> person.getName()
                        .equals("Elias")).findFirst();

        person1.ifPresent(System.out::println);

        System.out.println("---The end---");

    }
}
