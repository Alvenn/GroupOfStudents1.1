package com.gmail.alvenn89;

import java.util.Formatter;

public class Student extends Human implements Comparable {
    private String recordBook;
    private Group group;

    public Student(String firstName, String secondName, int age, String recordBook, Group group) {
        super(firstName, secondName, age);
        this.recordBook = recordBook;
        this.group = group;
    }

    public Student(String firstName, String secondName, int age) {
        super(firstName, secondName, age);
        this.recordBook = "";
        this.group = null;
    }

    public String getRecordBook() {
        return recordBook;
    }

    public void setRecordBook(String recordBook) {
        this.recordBook = recordBook;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Student(){
    }

    @Override
    public void printInfo() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return String.format("%-12s %-12s %-3s %-10s %-10s",
                this.getSecondName(), this.getFirstName(), this.getAge(), this.recordBook, this.group);
    }

    @Override
    public int compareTo(Object o) {
        Student tmp = (Student)o;
        return (this.getSecondName().compareTo(tmp.getSecondName()));
    }
}
