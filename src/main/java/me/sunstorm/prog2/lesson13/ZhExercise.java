package me.sunstorm.prog2.lesson13;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class ZhExercise {

    public static void main(String[] args) {
        // visibility for classes
        // default private protected public

        // abstraction
        // abstract class
        //  - can't create instance
        //  - may have abstract methods (without method body)
        //  - extending classes must implement abstract methods (or declare themselves abstract too)

        // class hierarchy
        // extends, implements

        // iterator, iterable

        // error handling

        // dates
        // remember: using java.util.Date considered a crime against humanity and is punishable by death
        var localDate = LocalDate.now();
        System.out.println(localDate);
        // direct getters
        System.out.println(localDate.getYear());
        System.out.println(localDate.getDayOfMonth());
        // get using ChronoField
        System.out.println(localDate.get(ChronoField.YEAR));


    }
}
