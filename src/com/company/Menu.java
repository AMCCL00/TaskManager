package com.company;

import java.util.Scanner;

public class Menu {

    Scanner input = new Scanner(System.in);
    Manager manager = new Manager(this);
    Task task = new Task("", "", "");

    protected void mainMenu(){
        System.out.println("What would you like to do?\n" +
                "1. Add a Task.\n" +
                "2. Remove a Task.\n" +
                "3. See all Tasks.\n" +
                "4. See incomplete Tasks.\n" +
                "5. See completed Tasks.\n" +
                "6. Mark a Task as complete.\n" +
                "7. Edit a Task.\n" +
                "8. Select a Task and see the Details.\n" +
                "9. Exit.");
        try{
            switch(input.nextInt()){
                case 1:
                    //add
                    input.nextLine();
                    System.out.println("What task would you like to add?");
                    input.nextLine();
                    System.out.println("When does it need to be finished by?");
                    input.nextLine();
                    System.out.println("What needs to be done in this task?");
                    input.nextLine();
                    manager.addTask(task);
                    break;
                case 2:
                    //remove
                    input.nextLine();
                    System.out.println("What task would you like to remove?");
                    manager.listIncomplete();
                    input.nextInt();
                    manager.removeTask(input.nextInt());
                    break;
                case 3:
                    //List all
                    manager.listAll();
                case 4:
                    //list incomplete
                    manager.listIncomplete();
                    break;
                case 5:
                    //list completed
                    manager.listCompleted();
                    break;
                case 6:
                    //mark a task complete
                    break;
                case 7:
                    //Edit
                    break;
                case 8:
                    //View details
                    break;
                case 9:
                    //exit
                    System.exit(12321);
                    break;
                default:
                    input.nextLine();
                    System.out.println("Please enter one of the given options.");
                    mainMenu();
            }
        }catch (Exception e){
            input.nextLine();
            System.out.println("Please enter one of the given options.");
            mainMenu();
        }
    }
}
