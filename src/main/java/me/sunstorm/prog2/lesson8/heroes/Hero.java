package me.sunstorm.prog2.lesson8.heroes;

import lombok.*;

import java.util.Objects;

@Getter
@Setter(AccessLevel.PROTECTED)
@NoArgsConstructor
@AllArgsConstructor
public abstract class Hero {
    private String name;
    private String nickname;
    private int age;
    private boolean isGood;

    public void fillFromString(String raw) {
        var data = raw.split(";");
        setName(data[0]);
        setNickname(data[2].isEmpty() ? null : data[2]);
        try {
            setAge(Integer.parseInt(data[1]));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("invalid age", e);
        }
        setGood(data[3].equals("true"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hero hero = (Hero) o;
        return age == hero.age && isGood == hero.isGood && Objects.equals(name, hero.name) && Objects.equals(nickname, hero.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, nickname, age, isGood);
    }

    @Override
    public String toString() {
        return "Class: " + getClass().getSimpleName() + ", Name: " + name + ", Age: " + age + ", Nickname: " + (nickname == null ? "none" : nickname) + ", isGood: " + isGood;
    }
}
