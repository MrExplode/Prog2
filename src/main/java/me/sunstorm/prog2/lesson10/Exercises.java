package me.sunstorm.prog2.lesson10;

public class Exercises {

    // WOO HOOO STREAMS FINALLY
    public static void main(String[] args) {
        var service = new UserStreamService();
        service.getFemaleUsers().forEach(System.out::println);
        service.getOldUsers().forEach(System.out::println);
    }
}
