package me.sunstorm.prog2.commands.cmd.impl;

import me.sunstorm.prog2.commands.cmd.Command;
import me.sunstorm.prog2.commands.data.StudentManager;

import java.util.List;

public class ListStudentsCommand extends Command {
    private final StudentManager studentManager;

    public ListStudentsCommand( StudentManager sm) {
        super("list");
        studentManager = sm;
    }

    @Override
    public void execute(List<String> arguments) throws Exception {
        System.out.println("List of students:");
        System.out.println(studentManager.getStudents());
    }
}