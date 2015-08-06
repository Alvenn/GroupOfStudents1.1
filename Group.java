package com.gmail.alvenn89;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Group  {
    private String groupName;
    private Student [] array = new Student[10];

    public Group(String groupName) {
        this.groupName = groupName;
    }

    public Group() {
        this.groupName = "";
    }

    public Student getStudent(int index) {
        return array[index];
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void searchBySecondName(String secondName){
        int count = 0;
        System.out.println("\nSearch results:");
        for (int i = 0; i < array.length ; i++) {

            try{
                if(secondName.equals(array[i].getSecondName())){
                    array[i].printInfo();
                    count++;
                }
            }
            catch (NullPointerException e){
            }
        }

        if(count == 0){
            System.out.println("Student not found");
        }
        System.out.println();
    }

    public void addStudent(Student student) throws OversizeAddingException{
        int stop = 0;
        for (int i = 0; stop < 1; i++) {
            try{
                if (array[i] == null) {
                    array[i] = student;
                    stop++;
                }
            }
            catch (ArrayIndexOutOfBoundsException e){
                throw new OversizeAddingException();
            }
        }
    }

    public void sort(){
        try{
            Arrays.sort(array);
        }
        catch (NullPointerException e){
        };
    }

    public void printInfo(){
        for (Student st : array) {
            if (st != null) {
                System.out.println(st);
            }
        }
        System.out.println();
    }

    public void interactiveAdding(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Input Second Name");
        String sn = sc.nextLine();
        System.out.println("Input First Name");
        String fn = sc.nextLine();
        System.out.println("Input recordBook number");
        String rb = sc.nextLine();
        System.out.println("Input age");
        int ag = sc.nextInt();
        addStudent(new Student(fn, sn, ag, rb, Group.this));
    }

    public void saveToFile(){
        File file = new File(getGroupName()+".txt");
        try{
            if(!file.exists()){
                file.createNewFile();
            }
        }
        catch (IOException e){
            System.out.println("Error with file creation");
        }

        try(PrintWriter pw = new PrintWriter(file)){
            for (Student student : array) {
                if (student != null) {
                    pw.println(student);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Saving complete");

    }

    public void readFromFile(String filename){
        try(BufferedReader br = new BufferedReader(new FileReader(filename))){
            String temp = "";
            for (int i = 0; (i < 10) && ((temp = br.readLine()) != null) ; i++) {
                String[] line = temp.split("\\s+");
                setGroupName(filename.substring(0, filename.length() - 4 ));
                array[i] = new Student(line[1], line[0], Integer.parseInt(line[2]), line[3], Group.this);
                System.out.println("Student " + i +" have read");
            }
        }
        catch (IOException e){
            System.out.println("Error in reading");
        }

    }

    @Override
    public String toString() {
        return groupName;
    }
}
