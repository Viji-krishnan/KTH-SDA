package ip;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class is used to store the array list of tasks in a text file
 *
 * @author Viji Radhakrishnan
 * @version 1.0
 */

public class FileAccess {

    File file = new File("TaskList.txt");

    /**
     *
     * @param arrayList This list contains the data to be written in the file
     */

    public void save(ArrayList<Task> arrayList) {
        try {

            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (Task task : arrayList) {
                bufferedWriter.write(task.toString() + "\n");
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

