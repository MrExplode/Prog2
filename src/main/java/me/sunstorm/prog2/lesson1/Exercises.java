package me.sunstorm.prog2.lesson1;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Spliterators;
import java.util.stream.StreamSupport;

@Slf4j
@SuppressWarnings("unused")
public class Exercises {

    public static void main(String[] args) {
        //exercise1();
        //exercise2();
        exercise3();
    }

    private static void exercise1() {
        var exercise1 = "First Lesson";
        for (int i = 0; i < exercise1.length(); i++) {
            log.info("{}\t{}", i, exercise1.charAt(i));
        }
    }
    private static void exercise2() {
        var exercise2 = "My name is John Doe";
        var search = "o";
        for (String word : exercise2.split(" ")) {
            if (word.contains(search)) {
                log.info("Found '{}' in '{}'", search, word);
                break;
            }
        }
    }

    private static void exercise3() {
        int prev = 0;
        int current = 1;
        while (prev < 100) {
            int temp = prev + current;
            prev = current;
            current = temp;
            log.info("{}", current);
        }
    }
}
