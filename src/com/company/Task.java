package com.company;

import java.util.Scanner;

public class Task {
    private String title;
    private String dueDate;
    private String details;
    Scanner input = new Scanner(System.in);

    public Task(String title, String dueDate, String details) {
        this.title = title;
        this.dueDate = dueDate;
        this.details = details;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
