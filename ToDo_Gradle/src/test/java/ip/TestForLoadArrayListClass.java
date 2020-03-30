package ip;

import org.junit.Test;
import java.io.File;
import java.time.LocalDate;
import static org.junit.Assert.assertEquals;

public class TestForLoadArrayListClass {

    @Test
    public void TestToReadListFromFile() {

        File file = new File("TaskListTest");
        LoadArrayList loadArrayList = new LoadArrayList();

        int result = loadArrayList.arrayList.size();

        assertEquals(result, 4);
    }

    @Test
    public void TestToCheckAddTask() {

        LoadArrayList loadArrayList = new LoadArrayList();
        LocalDate localDate = null;

        Task task = new Task("Testing InProgress", localDate.parse("2020-03-30"), "jUnit", "Open");

        int initialArraySize = loadArrayList.arrayList.size();

        loadArrayList.arrayList.add(task);
        int LaterArraySize = loadArrayList.arrayList.size();

        assertEquals(LaterArraySize, initialArraySize+1);

    }
}

