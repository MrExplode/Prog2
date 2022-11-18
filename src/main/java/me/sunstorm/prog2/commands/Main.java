package me.sunstorm.prog2.commands;

import me.sunstorm.prog2.commands.data.StudentManager;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        var sm = new StudentManager();
        var commandManager = new CommandManager(sm);
        var scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            commandManager.handleCommand(scanner.nextLine());
        }
    }
}
