package ip;

import java.time.LocalDate;

/**
 * This is a task lists class using which the user can add, edit, delete his todo tasks
 *
 * @author Viji Radhakrishnan
 * @version 1.0
 */
public class TaskList {

    private FileAccess fileAccess;
    LoadArrayList loadArrayList;

    public TaskList() {
        loadArrayList = new LoadArrayList();
    }

    /**
     * @param task The new task details which the user wants to add it
     */
    public void addTask(Task task) {

        //To add the new task in the arrayList
        loadArrayList.arrayList.add(task);

        //To save the modified arrayList into the file
        fileAccess = new FileAccess();
        fileAccess.save(loadArrayList.arrayList);
    }

    /**
     *
     * @param selected The chosen task index which the user wants to edit
     * @param editField The chosen task field among TaskDescription, DueDate, Category or Status
     * @param newValue The new string value entered by the user
     */
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
    }

    public void printTasks() {

        for (int i = 0; i < loadArrayList.arrayList.size(); i++) {
            System.out.println("Task Index (" + i + ") :" + " " + loadArrayList.arrayList.get(i));
        }
    }

    /**
     * @param index The index of the TaskList which the user wants to delete
     */
    public void removeTask(int index) {

        fileAccess = new FileAccess();

        loadArrayList.arrayList.remove(index);

        fileAccess.save(loadArrayList.arrayList);
    }

}





