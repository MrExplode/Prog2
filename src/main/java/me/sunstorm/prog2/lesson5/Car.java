package me.sunstorm.prog2.lesson5;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Car {
    private int year;
    private int mileage;
    private int price;
}
