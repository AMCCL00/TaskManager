package com.company;

import java.util.Scanner;

public class Menu {

    Scanner input = new Scanner(System.in);
    Manager manager = new Manager(this);

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
                    Task task = new Task("", "", "");
                    manager.addTask(task);
                    mainMenu();
                    break;
                case 2:
                    //remove
                    input.nextLine();
                    System.out.println("What task would you like to remove?");
                    manager.listIncomplete();
                    manager.removeTask(input.nextInt());
                    mainMenu();
                    break;
                case 3:
                    //List all
                    manager.listAll();
                    mainMenu();

                case 4:
                    //list incomplete
                    manager.listIncomplete();
                    mainMenu();
                    break;
                case 5:
                    //list completed
                    manager.listCompleted();
                    mainMenu();
                    break;
                case 6:
                    //mark a task complete
                    input.nextLine();
                    System.out .println("Which task would you like to complete?");
                    manager.listIncomplete();
                    manager.completeATask(input.nextInt());
                    mainMenu();
                    break;
                case 7:
                    //Edit
                    input.nextLine();
                    System.out.println("Select a task you would like to edit.");
                    manager.listIncomplete();
                    String indexString =input.nextLine();
                    int index = Integer.parseInt(indexString);
                    manager.taskEdit(index);
                    mainMenu();
                    break;
                case 8:
                    //View details
                    input.nextLine();
                    System.out.println("Which task would you like to see the details of?");
                    manager.listIncomplete();
                    String indexString2 = input.nextLine();
                    int index2 = Integer.parseInt(indexString2);
                    manager.viewTaskDetails(index2);
                    mainMenu();
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
