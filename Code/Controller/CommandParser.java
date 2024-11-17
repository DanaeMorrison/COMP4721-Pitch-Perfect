package Controller;
import java.util.ArrayList;
import View.UI;
import View.Keyboard;
import View.ButtonComponent;

import View.UI;
import javafx.scene.web.HTMLEditorSkin.Command;
import javax.lang.model.util.ElementScanner14;

public class CommandParser implements Runnable{
    Controller controller;
    UI ui;
    ArrayList<Integer> inputIDs;
    ArrayList<Keyboard> keyboards;
    private volatile boolean running = true;

    public CommandParser(Controller controller, UI ui)
    {
        this.controller = controller;
        this.ui = ui;
        inputIDs = new ArrayList<>();
        keyboards = new ArrayList<>();
        System.out.println("Parser created");
    }
    
    public void updateInputIDs(ArrayList<Integer> parsables)
    {
        System.out.println("parsable added");
        this.inputIDs = parsables;
    }
    public void addKeyboard(Keyboard keyboard)
    {
        System.out.println("Keyboard added");
        keyboards.add(keyboard);
    }

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
                    System.out.println("Received message: "+input);
                    parse(input);
                }
            }
            for (Keyboard keyboard : keyboards)
            {
                if(keyboard.hasMessage())
                {
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
        } else if(args[0].equals("toggleKeys"))
        {
            //of format: playNote (followed by some number of notes to combine)
            int[] notes = new int[args.length-1];
            for(int i=0; i<args.length-1; i++)
            {
                notes[i] = Integer.valueOf(args[i+1]);
            }
            // controller.toggleKeys(notes);
        } else if(args[0].equals("showUnitSelection") || args[0].equals("showLessonSelection"))
        {
          controller.loadMenu(command);
        } else if (args[0].equals("loadLesson")) {
            controller.close(Integer.parseInt(args[2]));
            controller.getLesson(Integer.parseInt(args[1]));
        } else
        {
            //commnd not recognized, find some standard way to handle appropriately.
        }
    }
}
