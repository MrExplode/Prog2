package me.sunstorm.prog2.lesson2;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;

@Slf4j
public class Exercises {

    public static void main(String[] args) {
        var instance = new Exercises();
        instance.first();
        log.info("======================\n");
        instance.fizzbuzz();
        log.info("======================\n");
        log.info("isPrime: {}", instance.isPrime(97243));
        log.info("======================\n");
        instance.fibonacci(100);
        log.info("======================\n");
        log.info("gcd of 759 and 583: {}", instance.gcd(759, 583));
        log.info("======================\n");
        log.info("palindrome: {}", instance.palindrome("asdfghgfdsa"));
        log.info("======================\n");
        log.info("section: {}", instance.getSection("The quick brown fox jumps over the lazy dog"));
    }

    public void first() {
        IntStream.range(0, 100).forEach(System.out::println);
    }

    public void fizzbuzz() {
        IntStream.range(0, 100).forEach(i -> {
            String message = null;
            if (i % 3 == 0 && i % 5 == 0)
                message = "FizzBuzz";
            else if (i % 3 == 0)
                message = "Fizz";
            else if (i % 5 == 0)
                message = "Buzz";
            if (message != null)
                log.info("{} {}",i, message);
        });
    }

    public boolean isPrime(int num) {
        for (int i = 2; i < num / 2; i++) {
            if (num % i != 0) return false;
        }
        return true;
    }

    public void fibonacci(int limit) {
        int prev = 0;
        int current = 1;
        while (prev < limit) {
            int temp = prev + current;
            prev = current;
            current = temp;
            log.info("{}", current);
        }
    }

    public double gcd(int num, int num2) {
        if (num2 == 0) {
            return num;
        }
        return gcd(num2, num % num2);
    }

    public boolean palindrome(String word) {
        var b = new StringBuilder();
        for (int i = word.length() - 1; i >= 0; i--) {
            b.append(word.charAt(i));
        }

        return b.toString().equals(word);
    }

    public String getSection(String from) {
        int start = from.indexOf("a");
        if (start == -1) return "";
        return from.substring(start, Math.min(start + 3, from.length()));
    }
}
