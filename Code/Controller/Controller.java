package Controller;
import Model.*;
import View.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.File;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * For now, making this very bare bones to work with UI
 */
public class Controller
{
    private UI ui;
    CommandParser commandParser;

    public Controller(Stage primaryStage, File stateFile) throws IOException
    {
        System.out.println("Controller created. Creating UI...");
        ui = new UI(primaryStage);
        //commandParser = new CommandParser(this, ui);
        createKeyboard();
    }
    /**
    private void initState(File stateFile) throws IOException
    {
        //Intended to later include reloading state of users progress, not
        //worrying about this for now and will just get it to init model and
        //some viewComponents
        
        BufferedReader input = new BufferedReader(stateFile);
        String currLine = input.readLine();
        //assumes stateFile ends with "EOF"
        while(currLine != "EOF")
        {
            
        }
    }
    **/
    
    public UI getUI()
    {
        return ui;
    }
    public CommandParser getParser()
    {
        return commandParser;
    }

    private void createKeyboard()
    {
        int startX=0;
        int startY=0;
        int totalWidth=600;
        int totalHeight=300;
        int keyWidth = totalWidth/12;

        int[] backgroundCords = new int[4];
        backgroundCords[0]=startX;
        backgroundCords[1]=totalWidth;
        backgroundCords[2]=startY;
        backgroundCords[3]=totalHeight;
        int backGroundID = ui.createViewComponent("rectangle");
        ui.getViewComponent(backGroundID).updateXY(backgroundCords);
    
        int[] keyCords = new int[4];
        keyCords[0]=startX;
        keyCords[1]=keyWidth;
        keyCords[2]=startY;
        keyCords[3]=totalHeight;
        int[] keyIDs = new int[12];
        for(int i=0; i<12; i++)
        {
            keyIDs[i] = ui.createViewComponent("button");
            ui.getViewComponent(keyIDs[i]).updateXY(keyCords);
            keyCords[0]+=keyWidth;
            keyCords[1]+=keyWidth;
        }
    }    
    private void createLessonView(/*Lesson lesson*/){
        // Setting up background
        int[] backgroundCords = {0,1200,0,1000}; 
        int backGroundID = ui.createViewComponent("rectangle");
        ui.getViewComponent(backGroundID).updateXY(backgroundCords);
        
        // Setting up flashcard
        int[] clefChords = {0, 1020, 0, 900};
        int clefID = ui.createViewComponent("image");
        ui.getViewComponent(clefID).updateXY(clefChords);
        ImageComponent clef = (ImageComponent) ui.getViewComponent(clefID);
        
        Flashcard f1 = new Flashcard(1, new int[] {60}, 'T', 'L');
        loadFlashcard(clef, f1);
        
        
        
        
    }
        
    private void loadFlashcard(ImageComponent image, Flashcard flashcard){
        if (flashcard.getClef() == 'T'){
            image.changeImage("Team-1/Code/Assets/trebleStaff.png");
        } 
        if (flashcard.getClef() == 'B'){
            image.changeImage("Team-1/Code/Assets/bassStaff.png");
        }
    }
}
