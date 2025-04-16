package com.alex.gordon.learn.java.functionalinterfaces;

import com.alex.gordon.learn.java.data.Student;
import com.alex.gordon.learn.java.data.StudentDataBase;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
    static Consumer<Student> c2 = (student ) -> System.out.println(student);
    static Consumer<Student> c3 = (s) -> System.out.print(s.getName() + " ");
    static Consumer<Student> c4 = (s) -> System.out.println(s.getActivities());

    public static void printName() {
        List<Student> studentlist = StudentDataBase.getAllStudents();
        studentlist.forEach(c2);
    }

    public static void prinNameAndActiviites() {
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach(c3.andThen(c4));  // consumer chaining
    }

    public static void prinNameAndActiviitesUsingCondition() {
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach(student -> {
            if(student.getGradeLevel() >= 3 && student.getGpa() >= 3.9) {
                c3.andThen(c4).andThen(c2).accept(student);
            }
        });
    }

    public static void main(String[] args) {

        Consumer<String> c1 = (s) -> System.out.println(s.toUpperCase());
        c1.accept("java8");

        printName();
        System.out.println();
        prinNameAndActiviites();
        System.out.println();
        prinNameAndActiviitesUsingCondition();
        System.out.println();
    }
}
