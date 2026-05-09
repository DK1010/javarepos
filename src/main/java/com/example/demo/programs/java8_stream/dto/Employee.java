package com.example.demo.programs.java8_stream.dto;

public class Employee {
    String name;
    String id;
    int age;
    long salary;

    public Employee(String n,String i,int a,long s){
        this.name=n;
        this.id=i;
        this.age=a;
        this.salary=s;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public long getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
