package me.sunstorm.prog2.commands.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentManager {
    private final List<Student> students = new ArrayList<>();

    public void addStudent(Student s) {
        students.add(s);
    }

    public void removeStudent(String neptunCode) {
        students.removeIf(s -> s.getNeptunCode().equals(neptunCode));
    }

    public List<Student> getStudents() {
        return Collections.unmodifiableList(students);
    }
}
