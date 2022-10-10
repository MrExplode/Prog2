package me.sunstorm.prog2.lesson5;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Person {
    private String name;
    private String sex;
    private int age;
    private double height;
    private double weight;
}
