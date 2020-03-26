package ip;

import java.time.LocalDate;

/**
 * This is a task lists class using which the user can add, edit, delete his todo tasks
 *
 * @author Viji Radhakrishnan
 * @version 1.0
 */
public class TaskList {

    FileAccess fileAccess;
    LoadArrayList loadArrayList;

    public TaskList() {
        loadArrayList = new LoadArrayList();
    }

    public void addTask(Task task) {

        //To add the new task in the arrayList
        loadArrayList.arrayList.add(task);

        //To save the modified arrayList into the file
        fileAccess = new FileAccess();
        fileAccess.save(loadArrayList.arrayList);
    }

    public void editTask(Task selected, int editField, String newValue) {

        switch (editField) {
            case 1:
                selected.setTaskDescription(newValue);
                System.out.println("Task Description is updated");
                break;
            case 2:
                LocalDate dueDate1 = LocalDate.parse(newValue);
                selected.setDueDate(dueDate1);
                System.out.println("Due date is updated");
                break;
            case 3:
                selected.setCategory(newValue);
                System.out.println("Task Category is updated");
                break;
            case 4:
                selected.setStatus(newValue);
                System.out.println("Task Status is updated");
                break;
        }

        fileAccess = new FileAccess();
        fileAccess.save(loadArrayList.arrayList);
        // fileAccess.save();
        // saveFile();
        //   System.out.println("Please check the updated details...");
        //  System.out.println(selected.toString2());
    }

    public void printTasks() {

        for (int i = 0; i < loadArrayList.arrayList.size(); i++) {
            System.out.println("Task Index (" + i + ") :" + " " + loadArrayList.arrayList.get(i));
        }

    }

    public void removeTask(int index) {
        //  printTasks();
        // System.out.println("Enter the index");
        // int index = Integer.parseInt(scanner.nextLine());
        fileAccess = new FileAccess();

        loadArrayList.arrayList.remove(index);
        //saveFile();

        fileAccess.save(loadArrayList.arrayList);
        // System.out.println("Result from TaskList class -- removed");
    }

}





