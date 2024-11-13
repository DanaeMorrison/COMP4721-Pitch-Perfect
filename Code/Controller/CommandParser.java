package Controller;
import java.util.ArrayList;
import View.UI;
import View.ButtonComponent;

import View.UI;
import javafx.scene.web.HTMLEditorSkin.Command;
import javax.lang.model.util.ElementScanner14;

public class CommandParser implements Runnable{
    Controller controller;
    UI ui;
    ArrayList<Integer> inputIDs;
    private volatile boolean running = true;

    public CommandParser(Controller controller, UI ui)
    {
        this.controller = controller;
        this.ui = ui;
        inputIDs = new ArrayList<>();
    }

    @Override
    public void run() {
        ButtonComponent button;
        String input;
        while (running) {
            for (int id : inputIDs) {
                button = (ButtonComponent) ui.getViewComponent(id);
                if (button.hasMessage()) {
                    input = button.getMessage();
                    parse(input);
                }
            }

            try {
                // Sleep briefly to prevent excessive CPU usage in the loop
                Thread.sleep(50); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore interrupted status
            }
        }
    }

    public void stop()
    {
        running = false;
    }

    /*
     * To extend the commands available, add onto switch statements your desired command string and then
     * use args by adding spaces to your command which contain meaningful info.
     */
    public void parse(String command)
    {
        String[] args = command.split(" ");

        if(args[0].equals("displayComponent"))
        {
            //implement
        } else if(args[0].equals("checkAnswer"))
        {
            //implement
        } else if(args[0].equals("playNote"))
        {
            //implement
        } else
        {
            //commnd not recognized, find some standard way to handle appropriately.
        }
    }
}
