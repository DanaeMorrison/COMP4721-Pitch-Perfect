package Controller;

import java.util.ArrayList;
import View.UI;
import View.Keyboard;
import View.ButtonComponent;
import Model.Lesson;

import View.UI;
import javafx.scene.web.HTMLEditorSkin.Command;
import javax.lang.model.util.ElementScanner14;

/**
 * CommandParser is responsible for parsing and executing commands received from
 * UI components and keyboards.
 * It implements the Runnable interface to allow it to run in a separate thread.
 */
public class CommandParser implements Runnable {
    Controller controller;
    UI ui;
    ArrayList<Integer> inputIDs;
    ArrayList<Keyboard> keyboards;
    private volatile boolean running = true;

    /**
     * Constructs a CommandParser with the specified controller and UI.
     * 
     * @param controller the controller to be used for executing commands
     * @param ui         the UI from which input components are retrieved
     */
    public CommandParser(Controller controller, UI ui) {
        this.controller = controller;
        this.ui = ui;
        inputIDs = new ArrayList<>();
        keyboards = new ArrayList<>();
        System.out.println("Parser created");
    }

    /**
     * Updates the list of input IDs that the parser should listen to.
     * 
     * @param parsables the list of input IDs to be updated
     */
    public void updateInputIDs(ArrayList<Integer> parsables) {
        System.out.println("parsable added");
        this.inputIDs = parsables;
    }

    /**
     * Adds a keyboard to the list of keyboards that the parser should listen to.
     * 
     * @param keyboard the keyboard to be added
     */
    public void addKeyboard(Keyboard keyboard) {
        System.out.println("Keyboard added");
        keyboards.add(keyboard);
    }

    /**
     * The main execution method of the CommandParser. It continuously checks for
     * messages
     * from UI components and keyboards, and parses them if found.
     */
    @Override
    public void run() {
        System.out.println("Searching for input");
        ButtonComponent button;
        String input;
        while (running) {
            for (int id : inputIDs) {
                button = (ButtonComponent) ui.getViewComponent(id);
                if (button.hasMessage()) {
                    input = button.getMessage();
                    System.out.println("Received message: " + input);
                    parse(input);
                }
            }
            for (Keyboard keyboard : keyboards) {
                if (keyboard.hasMessage()) {
                    String message = keyboard.getMessage();
                    System.out.println("Interpretting " + message);
                    parse(message);
                }
            }

            try {
                // Sleep briefly to prevent excessive CPU usage in the loop
                Thread.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore interrupted status
            }

        }
        System.out.println("No longer receiving input");
    }

    /**
     * Stops the CommandParser from running.
     */
    public void stop() {
        running = false;
    }

    /**
     * Parses the given command string and executes the corresponding action.
     *
     * @param command the command string to parse and execute
     * 
     *                The command string should be in the format of a
     *                space-separated list of arguments.
     *                The first argument specifies the command type, and the
     *                subsequent arguments are
     *                the parameters for that command.
     * 
     *                Supported commands:
     *                - "displayComponent": (implementation needed)
     *                - "checkAnswer": (implementation needed)
     *                - "toggleKeys": followed by a list of integers representing
     *                notes to combine
     *                - "showUnitSelection": loads the unit selection menu
     *                - "showLessonSelection": loads the lesson selection menu
     *                - "loadLesson": followed by two integers, the first for the
     *                lesson ID and the second for the close command
     * 
     *                If the command is not recognized, it should be handled
     *                appropriately.
     */
    public void parse(String command) {
        String[] args = command.split(" ");

        switch (args[0]) {
            case "displayComponent":
                // implement
                break;
            case "checkAnswer":
                // implement
                break;
            case "showUnitSelection":
            case "showLessonSelection":
            case "showHomePage":
                controller.loadMenu(command);
                break;
            case "loadLesson":
                controller.close(Integer.parseInt(args[2]));
                Lesson lesson = controller.getLesson(Integer.parseInt(args[1]));
                controller.resetProgressbar(lesson.getLessonSize());
                break;
            case "loadDrill":
                controller.close(Integer.parseInt(args[2]));
                controller.getDrill(Integer.parseInt(args[1]));
                break;
            case "back":
                controller.loadMainMenu();
            // case "toggleKeys":
            // // of format: playNote (followed by some number of notes to combine)
            // int[] notes = new int[args.length - 1];
            // for (int i = 0; i < args.length - 1; i++) {
            // notes[i] = Integer.valueOf(args[i + 1]);
            // }
            // controller.toggleKeys(notes);
            default:
                // command not recognized, find some standard way to handle appropriately.
                break;
        }
    }
}
