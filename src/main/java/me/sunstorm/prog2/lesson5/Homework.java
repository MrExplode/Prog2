package me.sunstorm.prog2.lesson5;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class Homework {
    private final List<Car> cars;

    public List<Car> getByYear(int year) {
        return cars.stream().filter(c -> c.getYear() == year).toList();
    }

    public List<Car> getByMileage(int min, int max) {
        return cars.stream().filter(c -> c.getMileage() >= min && c.getMileage() <= max).toList();
    }

    public List<Car> getCheaper(int price) {
        return cars.stream().filter(c -> c.getPrice() < price).toList();
    }
}
