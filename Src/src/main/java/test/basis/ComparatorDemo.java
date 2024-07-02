package test.basis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @program: Src
 * @description: comparator
 * @author: wsj
 * @create: 2024-06-19 12:22
 **/


class Student1 {
    private String name;
    private int age;

    public Student1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + "}";
    }
}

class AgeComparator implements Comparator<Student1> {
    @Override
    public int compare(Student1 s1, Student1 s2) {
        return s1.getAge() - s2.getAge(); // 按年龄排序
    }
}

class NameComparator implements Comparator<Student1> {
    @Override
    public int compare(Student1 s1, Student1 s2) {
        return s1.getName().compareTo(s2.getName()); // 按名字排序
    }
}

public class ComparatorDemo {
    public static void main(String[] args) {
        List<Student1> students = new ArrayList<>();
        students.add(new Student1("Alice", 23));
        students.add(new Student1("Bob", 21));
        students.add(new Student1("Charlie", 25));

        Collections.sort(students, new AgeComparator());
        System.out.println("Sort by age:");
        for (Student1 student : students) {
            System.out.println(student);
        }

        Collections.sort(students, new NameComparator());
        System.out.println("Sort by name:");
        for (Student1 student : students) {
            System.out.println(student);
        }
    }
}
