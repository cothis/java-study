package day017.linkedlist;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListMain {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        list.add("hello");
        list.add("world");
        list.addFirst("haha");
        list.addLast("hoho");

        Iterator<String> it = list.iterator();

        while(it.hasNext()) {
            String value = it.next();
            System.out.println("it:" + value);
        }

    }
}
