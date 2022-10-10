package me.sunstorm.prog2.lesson6.heroes;

import lombok.Getter;

import java.util.List;

@Getter
public class Mage extends Hero {
    private final double magicDamage;
    private final double power;

    public Mage(String name, int age, String gender, List<String> skills, double magicDamage, double power) {
        super(name, age, gender, skills);
        this.magicDamage = magicDamage;
        this.power = power;
    }
}
