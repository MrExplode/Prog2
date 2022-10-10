package me.sunstorm.prog2.lesson6.heroes;

import lombok.Getter;

import java.util.List;

@Getter
public class Tank extends Hero {
    private final double health;
    private final double armor;

    public Tank(String name, int age, String gender, List<String> skills, double health, double armor) {
        super(name, age, gender, skills);
        this.health = health;
        this.armor = armor;
    }
}
