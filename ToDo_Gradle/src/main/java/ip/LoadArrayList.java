package ip;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * This class is to load the initial array list by reading the file content
 * This will be executed whenever the application starts
 *
 * @author Viji Radhakrishnan
 * @version 1.0
 */
public class LoadArrayList {

    ArrayList<Task> arrayList;
    File file;

    public LoadArrayList() {

        arrayList = readListFromFile();
    }

    public ArrayList<Task> readListFromFile() {
        file = new File("TaskList.txt");
        arrayList = new ArrayList<>();

        LocalDate localDate = null;

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String[] fields;
            Task task;
            String line = bufferedReader.readLine();

            while (line != null) {

                fields = line.split("-\\*-");
                task = new Task(fields[0], localDate.parse(fields[1]), fields[2], fields[3]);
                arrayList.add(task);
                // System.out.println(line);
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

}


