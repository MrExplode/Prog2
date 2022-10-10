package me.sunstorm.prog2.lesson6;

import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

@Slf4j
public class Exercises {

    public static void main(String... args) {
        var inst = new Exercises();
        log.info("isPalindrome: {}", inst.isPalindrome("asdfgfdsa"));
        log.info("addition:\t\t{}", inst.performOperation("+", 5, 7));
        log.info("subtraction:\t{}", inst.performOperation("-", 10, 7));
        log.info("multiplication:\t{}", inst.performOperation("*", 5, 7));
        log.info("division:\t\t{}", inst.performOperation("/", 10, 2));
        log.info("power:\t\t\t{}", inst.performOperation("^", 2, 3));
        log.info("letter occurrence: {}", inst.countOccurrence('e', "elemental hero"));
        log.info("funny text: {}\n", inst.funnyText("almáskáposzta"));

        log.info("longest word: {}", inst.findLongestWord(List.of("a", "bb", "Debrecen", "alma", "házikó")));
        log.info("sum of elements: {}", inst.sumOfCollection(List.of(1, 2, 3, 4, 5)));
        log.info("filtered list: {}", inst.greaterThan(List.of(1, 2, 3, 4, 5), 3));
    }

    private boolean isPalindrome(String input) {
        return new StringBuilder(input).reverse().toString().equals(input);
    }

    public double performOperation(String sign, double first, double second) {
        BiFunction<Double, Double, Double> func = switch (sign) {
            case "+" -> Double::sum;
            case "-" -> (f, s) -> f - s;
            case "*" -> (f, s) -> f * s;
            case "/" -> (f, s) -> f / s;
            case "^" -> Math::pow;
            default -> (__, ___) -> 0d;
        };
        return func.apply(first, second);
    }

    public int countOccurrence(char letter, String text) {
        int count = 0;
        for (char c : text.toCharArray())
            if (c == letter) count++;
        return count;
    }

    public String funnyText(String text) {
        var builder = new StringBuilder();
        for (int i = 0; i < text.toCharArray().length; i++) {
            if (i % 2 == 0)
                builder.append(Character.toUpperCase(text.charAt(i)));
            else
                builder.append(text.charAt(i));
        }
        return builder.toString();
    }

    public String findLongestWord(List<String> words) {
        return words.stream().max(Comparator.comparing(String::length)).orElseThrow();
    }

    public int sumOfCollection(List<Integer> elements) {
        return elements.stream().mapToInt(Integer::intValue).sum();
    }

    public List<Integer> greaterThan(List<Integer> original, int min) {
        return original.stream().filter(i -> i > min).toList();
    }
}
