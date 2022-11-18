package me.sunstorm.prog2.commands.cmd.impl;

import me.sunstorm.prog2.commands.cmd.Command;
import me.sunstorm.prog2.commands.data.Student;
import me.sunstorm.prog2.commands.data.StudentManager;

import java.util.List;

public class AddStudentCommand extends Command {
    private final StudentManager studentManager;

    public AddStudentCommand(StudentManager sm) {
        super("add");
        studentManager = sm;
    }

    @Override
    public void execute(List<String> arguments) throws Exception {
        if (arguments.size() != 4) {
            System.out.println("Hibás parancs!");
            return;
        }
        var name = arguments.get(0) + arguments.get(1);
        var kod = arguments.get(2);
        var course = arguments.get(3);
        studentManager.addStudent(new Student(name, kod, course));
        System.out.println("Tanuló hozzáadva!");
    }
}
