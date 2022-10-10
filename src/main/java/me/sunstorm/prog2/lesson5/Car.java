package me.sunstorm.prog2.lesson5;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Car implements Comparable<Car> {
    private int year;
    private int mileage;
    private int price;

    @Override
    public int compareTo(Car o) {
        int yearResult = year - o.getYear();
        return yearResult == 0 ? mileage - o.getMileage() : yearResult;
    }
}
