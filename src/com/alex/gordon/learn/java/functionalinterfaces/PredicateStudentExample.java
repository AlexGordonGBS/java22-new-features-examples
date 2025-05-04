package com.alex.gordon.learn.java.functionalinterfaces;

import com.alex.gordon.learn.java.data.Student;
import com.alex.gordon.learn.java.data.StudentDataBase;

import java.util.List;
import java.util.function.Predicate;

public class PredicateStudentExample {

    static Predicate<Student>  p1 = (s) -> s.getGradeLevel() >= 3;
    static Predicate<Student>  p2 = (s) -> s.getGpa() >= 3.9;

    public static void filterStudentsByGradeLevel()  {
        List<Student> studentList = StudentDataBase.getAllStudents();
        System.out.println("filterStudentsByGradeLevel");
        studentList.forEach((student) -> {
            if (p1.test(student)) {
                System.out.println(student);
            }
        });
    }

    public static void filterStudentsByGpa()  {
        List<Student> studentList = StudentDataBase.getAllStudents();
        System.out.println("filterStudentsByGPa");
        studentList.forEach((student) -> {
            if (p2.test(student)) {
                System.out.println(student);
            }
        });
    }

    public static void filterStudentsByGradeLevelOrGpa()  {
        List<Student> studentList = StudentDataBase.getAllStudents();
        System.out.println("filterStudentsByGradeLevelOrGpa");
        studentList.forEach((student) -> {
            if (p1.or(p2).test(student)) {
                System.out.println(student);
            }
        });
    }

    public static void main(String[] args) {
        filterStudentsByGradeLevel();
        filterStudentsByGpa();
        filterStudentsByGradeLevelOrGpa();
    }
}
