package me.sunstorm.prog2.lesson8.heroes;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Support extends Hero {
    private int healing;

    public Support(String name, String nickname, int age, boolean isGood, int healing) {
        super(name, nickname, age, isGood);
        this.healing = healing;
    }

    @Override
    public void fillFromString(String raw) {
        super.fillFromString(raw);
        var data = raw.split(";");
        try {
            healing = Integer.parseInt(data[4]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("invalid healing", e);
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Healing: " + healing;
    }
}
