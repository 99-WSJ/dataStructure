package test.basis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @program: Src
 * @description: comparable、comparator
 * @author: wsj
 * @create: 2024-06-19 12:17
 **/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student implements Comparable<Student> {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Student other) {
        return this.age - other.age; // 按年龄排序
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + "}";
    }
}

public class ComparableDemo {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 23));
        students.add(new Student("Bob", 21));
        students.add(new Student("Charlie", 25));

        Collections.sort(students);

        for (Student student : students) {
            System.out.println(student);
        }
    }
}

