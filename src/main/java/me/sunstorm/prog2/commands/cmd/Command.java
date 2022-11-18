package me.sunstorm.prog2.commands.cmd;

import lombok.Getter;

import java.util.List;

@Getter
public abstract class Command {
    private final String name;

    public Command(String name) {
        this.name = name;
    }

    public abstract void execute(List<String> arguments) throws Exception;
}
