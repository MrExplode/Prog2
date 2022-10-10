package me.sunstorm.prog2.lesson6.heroes;

import lombok.Getter;

import java.util.List;

@Getter
public class Support extends Hero {
    private final double healingPower;
    private final double shieldPower;

    public Support(String name, int age, String gender, List<String> skills, double healingPower, double shieldPower) {
        super(name, age, gender, skills);
        this.healingPower = healingPower;
        this.shieldPower = shieldPower;
    }
}
