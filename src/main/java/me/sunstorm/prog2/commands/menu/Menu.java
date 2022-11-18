package me.sunstorm.prog2.commands.menu;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.sunstorm.prog2.commands.cmd.Command;

import java.util.List;

@Getter
@AllArgsConstructor
public class Menu {
    private final String name;
    private final List<Command> commands;
    private final Menu parentMenu;

    public void handle(String input) {

    }
}
