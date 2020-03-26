package ip;

import java.time.LocalDate;

public class Task {

    String taskDescription;
    LocalDate dueDate;
    String category;
    String status;

    public Task(String taskDescription, LocalDate dueDate, String category, String status) {
        this.taskDescription = taskDescription;
        this.dueDate = dueDate;
        this.category = category;
        this.status = status;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return  "" + getTaskDescription() + "-*-" + getDueDate() + "-*-" + getCategory() +"-*-" +getStatus();
    }

    public String toString2() {
        return  "Task description : " + getTaskDescription() + " " + "DueDate :" + getDueDate() + " " + "Category : " + getCategory() +" " + "Status : "+getStatus();
    }
}

