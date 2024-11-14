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
        System.out.println("Parser created");
    }

    @Override
    public void run() {
        System.out.println("Searching for input)");
        ButtonComponent button;
        String input;
        int updateIterations = 500;
        int index = 0;
        inputIDs = ui.getParsables();
        while (running) {
            //every updateIterations checks for inputIDs, update the list of inputIDs
            if(index == updateIterations)
            {
                System.out.println("updating inputIDs");
                index = 0;
                inputIDs = ui.getParsables();
            }
            for (int id : inputIDs) {
                button = (ButtonComponent) ui.getViewComponent(id);
                if (button.hasMessage()) {
                    input = button.getMessage();
                    System.out.println("Received message: "+input);
                    parse(input);
                }
            }

            try {
                // Sleep briefly to prevent excessive CPU usage in the loop
                Thread.sleep(1); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore interrupted status
            }
            index++;
        }
        System.out.println("No longer receiving input");
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
            int[] notes = new int[args.length-1];
            for(int i=0; i<args.length-1; i++)
            {
                notes[i] = Integer.valueOf(args[i+1]);
            }
            controller.playNote(notes);
        } else
        {
            //commnd not recognized, find some standard way to handle appropriately.
        }
    }
}
