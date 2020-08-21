package be.realdolmen.collections;


import java.util.*;

public class Linked_List {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<String>();
        List<String> stringList = new ArrayList<String>();
        linkedList.add("test1");
        linkedList.add("test2");
        linkedList.add("test3");
        linkedList.add("test4");
        System.out.println(linkedList.getLast());
        ListIterator<String> listIterator = linkedList.listIterator(2);
        System.out.println("next element " + listIterator.next());
        System.out.println("next element " + listIterator.next());
        System.out.println("previous " +listIterator.previous());

        stringList.add("test1");
        stringList.add("test2");
        stringList.add("test3");
        System.out.println(stringList.get(1));
    }
}
