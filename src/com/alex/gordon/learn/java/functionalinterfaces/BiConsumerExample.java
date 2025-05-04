package com.alex.gordon.learn.java.functionalinterfaces;

import com.alex.gordon.learn.java.data.Student;
import com.alex.gordon.learn.java.data.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerExample {

    public static void nameAndActivities()  {
        BiConsumer<String, List<String>> biConsumer = (name, activities) -> System.out.println(name + " : " + activities);
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach(student -> biConsumer.accept(student.getName(), student.getActivities()));
    }

    public static void main(String[] args) {

        BiConsumer<String, String> biConcumer = (a,b) -> {
            System.out.println("a:" + a + " , b:" + b );
        };

        biConcumer.accept("java7", "java8");

        BiConsumer<Integer, Integer> multiply = (a,b) -> {
            System.out.println("multiplication is: " + (a*b));
        };
        BiConsumer<Integer, Integer> devide = (a,b) -> {
            System.out.println("division is: " + (a/b));
        };
        BiConsumer<Integer, Integer> substruct = (a,b) -> {
            System.out.println("substruction is: " + (a - b));
        };
        multiply.andThen(devide).andThen(substruct).accept(10,5);

        nameAndActivities();



    }

}
