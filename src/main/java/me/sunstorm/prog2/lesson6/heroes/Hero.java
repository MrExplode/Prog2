package me.sunstorm.prog2.lesson6.heroes;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class Hero implements Comparable<Hero> {
    private final String name;
    private final int age;
    private final String gender;
    private final List<String> skills;

    @Override
    public int compareTo(Hero o) {
        return age - o.getAge();
    }
}
