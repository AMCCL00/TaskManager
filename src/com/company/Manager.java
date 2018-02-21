package com.company;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Manager {
    private final Menu menu;
    ArrayList<Task> completed = new ArrayList<Task>();
    ArrayList<Task> incomplete = new ArrayList<Task>();
    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH/mm/ss");
    Scanner input = new Scanner(System.in);


    public Manager(Menu menu) {
        this.menu = menu;
    }

    protected void addTask(Task task) {
        //adding a task to lists
        incomplete.add(task);
        menu.mainMenu();

    }
    protected void removeTask(int index){
        //remove a task from lists
        index--;
        incomplete.remove(index);
        System.out.println("This task has been successful removed.");
        menu.mainMenu();
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
        menu.mainMenu();
    }
    protected void listIncomplete(){
        //show incomplete list
        if(incomplete.size() == 0){
            System.out.println("You have no incomplete tasks.\n");
        }else {
            System.out.println("Your incomplete tasks are: ");
            for (int i = 0; i < incomplete.size(); i++) {
                Task task = incomplete.get(i);
                System.out.println((i + 1) + ". " + task.getTitle());
            }
        }
        menu.mainMenu();
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
        menu.mainMenu();
    }
    protected void completeATask(int index){
        //switch a task from incomplete to complete
        index--;
        Task task = incomplete.get(index);

        completed.add(task);

        Calendar calendar = Calendar.getInstance();
        System.out.println("Your task was completed on " + dateFormat.format(calendar.getTime()));

        incomplete.remove(index);
        menu.mainMenu();

    }
    protected void taskEdit(int index) {
        //edits a task
        index--;
//      incomplete.set(index,input.nextLine());
//      incomplete.set(index, " ");
    }
    protected void viewTaskDetails(int index){
        //view the details of a task
        index--;
        for(int i = 0; i < incomplete.size(); i++){
            Task task = incomplete.get(i);
            System.out.println("The title of this task is " + task.getTitle() + ". The due date of this task is " + dateFormat.format(task.getDueDate()) +
                    ", and the details are, " + task.getDetails() + ".");
        }

    }
}
