package me.sunstorm.prog2.lesson8;

import lombok.SneakyThrows;
import me.sunstorm.prog2.lesson8.heroes.Damage;
import me.sunstorm.prog2.lesson8.heroes.Hero;
import me.sunstorm.prog2.lesson8.heroes.Support;
import me.sunstorm.prog2.lesson8.heroes.Tank;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Exercises {

    public static void main(String[] args) {
        var i = new Exercises();
        i.parseTest();
    }

    @SneakyThrows
    public void parseTest() {
        List<Hero> heroes = new ArrayList<>();
        var lines = Files.readAllLines(Path.of(System.getenv("heroes.path")));
        lines.removeIf(l -> l.startsWith("ROLE;"));
        lines.forEach(l -> {
            Hero h = switch (l.split(";")[0]) {
                case "DPS" -> new Damage();
                case "SUPPORT" -> new Support();
                case "TANK" -> new Tank();
                default -> new Support();
            };
            h.fillFromString(l.replaceFirst("\\w+;", ""));
            heroes.add(h);
        });
        heroes.forEach(System.out::println);
    }
}
