package me.sunstorm.prog2.lesson8.heroes;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Damage extends Hero {
    private double damage;

    public Damage(String name, String nickname, int age, boolean isGood, double damage) {
        super(name, nickname, age, isGood);
        this.damage = damage;
    }

    @Override
    public void fillFromString(String raw) {
        super.fillFromString(raw);
        var data = raw.split(";");
        try {
            damage = Integer.parseInt(data[4]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("invalid damage", e);
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Damage: " + damage;
    }
}
