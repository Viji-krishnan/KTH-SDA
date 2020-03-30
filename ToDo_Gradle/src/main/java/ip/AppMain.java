package ip;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This is a ToDo application which is used to store the user's task lists
 *
 * @author Viji Radhakrishnan
 * @version 1.0
 */
public class AppMain {

    // Main method to run the program
    public static void main(String[] args) throws IOException {

        UserInterface ui = new UserInterface();
        ui.welcome();
        ui.userChoice();
        ui.nextAction();
    }
}
