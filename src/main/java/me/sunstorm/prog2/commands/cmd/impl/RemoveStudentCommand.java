package me.sunstorm.prog2.commands.cmd.impl;

import me.sunstorm.prog2.commands.cmd.Command;
import me.sunstorm.prog2.commands.data.StudentManager;

import java.util.List;

public class RemoveStudentCommand extends Command {
    private final StudentManager studentManager;

    public RemoveStudentCommand(StudentManager sm) {
        super("remove");
        studentManager = sm;
    }

    @Override
    public void execute(List<String> arguments) throws Exception {

    }
}
