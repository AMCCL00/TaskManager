package com.company;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Menu {

    Scanner input = new Scanner(System.in);
    ArrayList<Task> completed = new ArrayList<Task>();
    ArrayList<Task> incomplete = new ArrayList<Task>();
    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH/mm/ss");

    protected void mainMenu(){
        //The menu for the program
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
        switch(input.nextLine()){
            case "1":
                    //add
                    Task task = new Task("","","");
                    addTask(task);
                    mainMenu();
                    break;
            case "2":
                //remove
                System.out.println("What task would you like to remove?");
                listIncomplete();
                removeTask(input.nextInt());
                mainMenu();
                break;
            case "3":
                //List all
                listAll();
                mainMenu();
                break;
            case "4":
                //list incomplete
                listIncomplete();
                mainMenu();
                break;
            case "5":
                //list completed
                listCompleted();
                mainMenu();
                break;
            case "6":
                //mark a task complete
                System.out .println("Which task would you like to complete?");
                listIncomplete();
                completeATask(input.nextInt());
                mainMenu();
                break;
            case "7":
                //Edit
                System.out.println("Select a task you would like to edit.");
                listIncomplete();
                taskEdit(input.nextInt());
                mainMenu();
                break;
            case "8":
                //View details
                System.out.println("Which task would you like to see the details of?");
                listIncomplete();
                viewTaskDetails(input.nextInt());
                mainMenu();
                break;
            case "9":
                //exit
                System.exit(12321);
                break;
            default:
                input.nextLine();
                System.out.println("Please enter one of the given options.");
                mainMenu();
            }
    }

    private void addTask(Task task) {
        //adding a task to lists
        incomplete.add(task);
        System.out.println("What is the title of your Task.");
        task.setTitle(input.nextLine());
        System.out.println("What is the due date of your task.");
        task.setDueDate(input.nextLine());
        System.out.println("What are you doing in your task?");
        task.setDetails(input.nextLine());

    }
    protected void removeTask(int index){
        //remove a task from lists
        index--;
        incomplete.remove(index);
        System.out.println("This task has been successful removed.");
    }
    protected void listAll(){
        //show all lists
        System.out.println("All of your current tasks are: ");
        for(int i = 0; i < incomplete.size(); i++){
            Task task = incomplete.get(i);
            System.out.println((i + 1) + ". " + task.getTitle());
        }
        for(int x = 0; x < completed.size(); x++){
            Task task = completed.get(x);
            System.out.println((incomplete.size() + x + 1) + ". " + task.getTitle());
        }
    }
    protected void listIncomplete(){
        //show incomplete list
        if(incomplete.size() == 0){
            System.out.println("You have no incomplete tasks.\n");
            mainMenu();
        }else {
            System.out.println("Your incomplete tasks are: ");
            for (int i = 0; i < incomplete.size(); i++) {
                Task task = incomplete.get(i);
                System.out.println((i + 1) + ". " + task.getTitle());
            }
        }
    }
    protected void listCompleted(){
        //show completed list
        if (completed.size() == 0){
            System.out.println("You have no completed tasks. \n");
        }else {
            System.out.println("Your completed tasks are: ");
            for (int i = 0; i < completed.size(); i++) {
                Task task = completed.get(i);
                System.out.println((i + 1) + ". " + task.getTitle());
            }
        }
    }
    protected void completeATask(int index){
        //switch a task from incomplete to complete
        index--;
        Task task = incomplete.get(index);

        completed.add(task);

        Calendar calendar = Calendar.getInstance();
        System.out.println("Your task was completed on " + dateFormat.format(calendar.getTime()));

        incomplete.remove(index);

    }
    protected void taskEdit(int index) {
        //edits a task
        index--;
        input.nextLine();
        System.out.println("What would you like to change the Title to?");
        incomplete.get(index).setTitle(input.nextLine());
        System.out.println("What would you like to change the due date of this item to? MM/dd/yyyy");
        incomplete.get(index).setDueDate(input.nextLine());
        System.out.println("What are the details of your task?");
        incomplete.get(index).setDetails(input.nextLine());
    }
    protected void viewTaskDetails(int index){
        //view the details of a task
        index--;
        input.nextLine();
        Task task = incomplete.get(index);
        System.out.println("The title of this task is " + task.getTitle() + ". The due date of this task is " + task.getDueDate() +
                ", and the details are, " + task.getDetails() + ".");
    }
}
