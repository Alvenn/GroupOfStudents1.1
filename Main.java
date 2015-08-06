package com.gmail.alvenn89;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Group group = new Group();
        Scanner sc = new Scanner(System.in);

        int stop = 0;
        while(stop < 1) {
            System.out.println("load - load from file");
            System.out.println("save - save to file");
            System.out.println("sort - sort by second name");
            System.out.println("print - print list of group");
            System.out.println("add - add student to group");
            System.out.println("search - search by second name");
            System.out.println("exit - stop program");
            String comand = sc.nextLine();

            switch (comand) {
                case "load":
                    System.out.println("Input file name");
                    group.readFromFile(sc.nextLine());
                    break;
                case "save":
                    group.saveToFile();
                    break;
                case "sort":
                    group.sort();
                    break;
                case "print":
                    group.printInfo();
                    break;
                case "add":
                    try{
                        group.interactiveAdding();
                    }
                    catch(OversizeAddingException e){
                        System.out.println("Group is full");
                    }
                    break;
                case "search":
                    System.out.println("Input second name");
                    group.searchBySecondName(sc.nextLine());
                    break;
                case "exit":
                    stop = 1;
                    break;
            }
        }
        sc.close();
    }
}
