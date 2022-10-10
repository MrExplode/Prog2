package me.sunstorm.prog2.lesson5;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

@Slf4j
public class Exercises {

    public static void main(String[] args) {
        var inst = new Exercises();
        //inst.scannerExercise();
        inst.fileExercise();
        inst.fordCSV();
        inst.personCSV();
    }

    public void scannerExercise() {
        var s = new Scanner(System.in);
        List<Integer> intList = new ArrayList<>();
        while (s.hasNext()) {
            if (s.hasNextInt()) intList.add(s.nextInt());
            else break;
        }
        System.out.println("Rendezett értékek:");
        intList.stream().sorted().forEach(i -> System.out.print(i + " "));
        System.out.println();
    }

    public void fileExercise() {
        var sys32 = new File("C:\\Windows\\System32");
        var files = sys32.listFiles();
        if (files == null) throw new RuntimeException("huh?");
        Arrays.stream(files)
                .filter(File::isFile)
                .sorted(Comparator.comparing(File::length).reversed())
                .limit(10)
                .forEach(f -> log.info("Name: {} length: {} mb", f.getName(), f.length() / 1000000d));
    }

    @SneakyThrows
    public void fordCSV() {
        var raw = Files.readAllLines(Path.of(System.getenv("ford.path")));
        raw.removeIf(s -> s.startsWith("\"Year\","));

        List<Car> cars = new ArrayList<>();
        raw.forEach(line -> {
            var data = line.split(",\\s+");
            if (data.length != 3) return;
            cars.add(new Car(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])));
        });
        cars.forEach(System.out::println);
    }

    @SneakyThrows
    public void personCSV() {
        var raw = Files.readAllLines(Path.of(System.getenv("person.path")));
        raw.removeIf(s -> s.startsWith("\"Name\","));

        List<Person> persons = new ArrayList<>();
        raw.forEach(line -> {
            var data = line.split(",\\s+");
            if (data.length != 5) return;
            persons.add(
                new Person(
                        data[0].replace("\"", ""),
                        data[1].replace("\"", ""),
                        Integer.parseInt(data[2]),
                        Double.parseDouble(data[3]),
                        Double.parseDouble(data[4])
                )
            );
        });
        persons.forEach(System.out::println);
    }
}
