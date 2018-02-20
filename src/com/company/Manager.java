package com.company;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Manager {
    private final Menu menu;
    ArrayList<Task> completed = new ArrayList<Task>();
    ArrayList<Task> incomplete = new ArrayList<Task>();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH/mm/ss");


    public Manager(Menu menu) {
        this.menu = menu;
    }

    protected void addTask(Task task) {
        incomplete.add(task);
        menu.mainMenu();

    }
    protected void removeTask(int index){
        index--;
        incomplete.remove(index);
        System.out.println("This task has been successful removed.");
        menu.mainMenu();
    }
    protected void listAll(){
        System.out.println("All of your current tasks are: ");
        for(int i = 0; i < incomplete.size(); i++){
            System.out.println((i + 1) + ". " + incomplete.get(i));
        }
        for(int x = 0; x < completed.size(); x++){
            System.out.println((incomplete.size() + x + 1) + ". " + completed.get(x));
        }
        menu.mainMenu();
    }
    protected void listIncomplete(){
        System.out.println("Your incomplete tasks are: ");
        for(int i = 0; i < incomplete.size(); i++){
            System.out.println((i + 1) + ". " + incomplete.get(i));
        }
        menu.mainMenu();
    }
    protected void listCompleted(){
        System.out.println("Your completed tasks are: ");
        for(int i = 0; i < completed.size(); i++){
            System.out.println((i + 1) + ". " + completed.get(i));
        }
        menu.mainMenu();
    }
}
