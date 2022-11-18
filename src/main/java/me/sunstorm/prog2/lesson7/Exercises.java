package me.sunstorm.prog2.lesson7;

import java.util.List;
import java.util.Scanner;

public class Exercises {

    public static void main(String[] args) {
        var e = new Exercises();
        e.linkedListTest();
    }

    public void readStuff() {
        var scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) System.out.println(scanner.nextInt());
            else if (scanner.next().equals("q")) break;
            else System.out.println("invalid input, write only numbers or q to quit");
        }
    }

    public <E extends Number> long countWithProperty(List<E> data) {
        return data.stream().filter(n -> n.intValue() % 2 == 0).count();
    }

    public void linkedListTest() {
        var list = new MyLinkedList<String>();
        list.add("asd");
        list.add("xddd");
        list.add("hello");
        list.add("inwogiwngr");
        list.add("inwogi");
        list.add("qwet");
        list.add("pi3h");
        list.forEach(System.out::println);
    }
}
