package me.sunstorm.prog2.commands;

import me.sunstorm.prog2.commands.cmd.impl.AddStudentCommand;
import me.sunstorm.prog2.commands.cmd.Command;
import me.sunstorm.prog2.commands.cmd.impl.ListStudentsCommand;
import me.sunstorm.prog2.commands.cmd.impl.RemoveStudentCommand;
import me.sunstorm.prog2.commands.data.StudentManager;
import me.sunstorm.prog2.commands.menu.Menu;

import java.util.*;

public class CommandManager {
    private final Map<String, Command> commands = new HashMap<>();
    private final Map<String, Menu> menus = new HashMap<>();
    private Menu activeMenu = null;

    public CommandManager(StudentManager sm) {
        registerCommand(new ListStudentsCommand(sm));

        //registerMenu(new Menu("book", List.of(new AddStudentCommand(sm), new RemoveStudentCommand(sm))));
        //registerMenu(new Menu("bookshelf", Collections.emptyList()));
    }

    public void registerCommand(Command c) {
        commands.put(c.getName(), c);
    }

    public void registerMenu(Menu m) {
        menus.put(m.getName(), m);
    }

    public void handleCommand(String rawLine) {
        var data = Arrays.asList(rawLine.split(" "));
        if (data.size() == 0) return;

        if (activeMenu != null) {
            if (rawLine.startsWith("quit")) {
                activeMenu = null;
                return;
            }
            activeMenu.handle(rawLine);
            System.out.print(activeMenu.getName() + " > ");
            return;
        }

        if (rawLine.startsWith("help")) {
            System.out.println("Parancsok:");
            commands.keySet().forEach(System.out::println);
            System.out.println("\nMenük:");
            menus.keySet().forEach(System.out::println);
            return;
        }

        if (commands.containsKey(data.get(0))) {
            var command = commands.get(data.get(0));
            try {
                command.execute(new ArrayList<>(data).subList(1, data.size()));
            } catch (Exception e) {
                System.out.println("Hiba történt a parancs végrehajtása közben: " + command.getName());
                e.printStackTrace();
            }
        } else if (menus.containsKey(data.get(0)) && activeMenu == null) {
            activeMenu = menus.get(data.get(0));
            System.out.print(activeMenu.getName() + " > ");
        } else {
            System.out.println("Ismeretlen menü / parancs!");
        }
    }
}
