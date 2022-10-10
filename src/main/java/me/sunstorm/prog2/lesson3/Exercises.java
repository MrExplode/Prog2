package me.sunstorm.prog2.lesson3;

import java.util.*;

public class Exercises {

    public static void main(String[] args) {
        var e = new Exercises();
        e.exercise1();
    }

    private void exercise1() {
        List<Student> list1 = new ArrayList<>();
//        list1.add(new Student("Béla", "bela@unideb.hu", "06301234567", 18, 190, 85));
//        list1.add(new Student("Peti", "peti@unideb.hu", "06301234567", 19, 186, 76));
//        list1.add(new Student("Anna", "anna@unideb.hu", "06301234567", 22, 170, 60));
//        list1.add(new Student("Klári", "klari@unideb.hu", "06301234567", 21, 192, 82));
        list1.sort(Comparator.comparingInt(Student::getAge));
        list1.forEach(System.out::println);
    }

    public void exercise2() {
        List<Student> students = new ArrayList<>();
        Map<Integer, List<Student>> gradeMap = new HashMap<>();
        students.forEach(s -> {
           //gradeMap.put(s)
        });
    }
}
