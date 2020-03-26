package ip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * This class is used to get the input from the user using Keyboard Scanner Class
 *
 * @author Viji Radhakrishnan
 * @version 1.0
 */

public class UserInterface {

    // LoadArrayList loadArrayList = new LoadArrayList();
    TaskList taskList;
    Task task;
    Scanner scanner = new Scanner(System.in);
    InputStreamReader ir = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(ir);
    LocalDate dueDate;

    //This is the Welcome message when the user starts the application
    public void welcome() {
        System.out.println(">> Welcome to the ToDo Application");
        System.out.println(">> You have X tasks todo and Y tasks are done!");
        System.out.println(">> Pick an option:");
        System.out.println(">> (1) Show Task List (by date or project)");
        System.out.println(">> (2) Add New Task");
        System.out.println(">> (3) Edit/Update Task");
        System.out.println(">> (4) Delete Task");
        System.out.println(">> ");
    }

    //This is the user choice to select among view tasks, add, edit or delete it
    public void userChoice() throws IOException {
        taskList = new TaskList();

        System.out.println("Please make a choice among 1 - List Task, 2 - Add Task, 3 - Edit Task, 4 - Delete Task");

        int choice = Integer.parseInt(br.readLine());
        if (choice == 1) {

            System.out.println("Kindly check the below list of tasks");
            System.out.println("-------------------------------------");
            System.out.println("Task Index:  " + "Task Description: " + "-*-" + "DueDate: " + "-*-" + "Category" + "-*-" + "Status");
            taskList.printTasks();
            System.out.println("-------------------------------------");

        } else if (choice == 2) {

            System.out.println("Kindly provide the task description, due date and category");
            System.out.println("Enter the Task Description ...");
            // String taskDescription = scanner.nextLine();
            String taskDescription = br.readLine();

            System.out.println("Enter the lead time to finish the task in the following format yyyy-mm-dd");

            String dueDateTemp = scanner.nextLine();
            LocalDate dueDate = LocalDate.parse(dueDateTemp);

            System.out.println("Enter the Category of the Task ...");
            String category = scanner.nextLine();
            System.out.println("***************************");

            task = new Task(taskDescription, dueDate, category, "Open");
            taskList.addTask(task);
            System.out.println("The task details has been saved");

        } else if (choice == 3) {

            System.out.println("Kindly choose the task index which do you want to to edit");
            taskList.printTasks();
            System.out.println("-------------------------------------------------");
            //int index = Integer.parseInt(scanner.nextLine());
            int index = scanner.nextInt();
            //  System.out.println("Enter the index");
            // Task selected = loadArrayList.arrayList.get(index);
            Task selected = taskList.loadArrayList.arrayList.get(index);

            System.out.println(selected.toString2());

            System.out.println("Which field do you want to edit, Type 1 for Task Description, Type 2 for DueDate, ");
            System.out.println("Type 3 for Category & Type 4 for Status");
            int editField = scanner.nextInt();
            System.out.println("-------------------------------------------------");

            System.out.println("Enter the new Value");
            // String newValue = scanner.next();
            String newValue = br.readLine();
            System.out.println("-------------------------------------------------");

            taskList.editTask(selected, editField, newValue);
            System.out.println("Please check the updated details...");
            System.out.println(selected.toString2());

        } else if (choice == 4) {

            taskList.printTasks();
            System.out.println("-------------------------------------------------");
            System.out.println("Kindly enter the task index which do you want to delete");
            // int index = Integer.parseInt(scanner.nextLine());
            int index = scanner.nextInt();
            taskList.removeTask(index);
            System.out.println("Task has been removed successfully");

        }else{
            System.out.println("Invalid Input : The choice must be among 1 to 4 ");
        }
    }

    public void nextAction() throws IOException {
        System.out.println("Do you want to continue ? Type Yes OR No");
        String str = br.readLine().toLowerCase();

        String yes = "yes";
        if (str.contains(yes)) {
            userChoice();
            nextAction();
        } else {
            System.out.println("Thanks for your visit");
        }
    }

}