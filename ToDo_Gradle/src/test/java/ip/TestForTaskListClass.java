package ip;

import org.junit.Test;
import java.io.File;
import java.time.LocalDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestForTaskListClass {

    /**
     * This class is to test the TaskList class methods
     *
     * @version 1.0
     * @author vijikrishnan
     */

    @Test
    public void testForRemoveTaskMethod() {

        TaskList taskList = new TaskList();
        int initialArraySize = taskList.loadArrayList.arrayList.size();

        taskList.removeTask(2);

        int result = taskList.loadArrayList.arrayList.size();

        assertNotEquals(result, initialArraySize);

    }

    @Test
    public void testForAddTaskMethod(){

        TaskList taskList1 = new TaskList();
        LocalDate localDate = null;
        int initialArraySize = taskList1.loadArrayList.arrayList.size();

        Task newTask = new Task("Testing InProgress", localDate.parse("2020-03-30"), "jUnit", "Open");
        taskList1.addTask(newTask);

        int result = taskList1.loadArrayList.arrayList.size();

        assertNotEquals(result, initialArraySize);

    }

}
