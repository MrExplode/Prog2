package me.sunstorm.prog2.lesson8.heroes;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Tank extends Hero {
    private double shield;

    public Tank(String name, String nickname, int age, boolean isGood, double shield) {
        super(name, nickname, age, isGood);
        this.shield = shield;
    }

    @Override
    public void fillFromString(String raw) {
        super.fillFromString(raw);
        var data = raw.split(";");
        try {
            shield = Double.parseDouble(data[4]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("invalid shield", e);
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Shield: " + shield;
    }
}
