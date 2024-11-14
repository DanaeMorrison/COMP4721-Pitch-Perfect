package Controller;
import Model.*;
import View.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.File;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import javax.sound.midi.*;



/**
 * For now, making this very bare bones to work with UI
 */
public class Controller
{
    private UI ui;
    CommandParser commandParser;
    private AudioComponent audio;

    public Controller(Stage primaryStage) throws IOException, MidiUnavailableException
    {
        System.out.println("Controller created. Creating UI...");
        ui = new UI(primaryStage);
        commandParser = new CommandParser(this, ui);
        createLessonView();
        audio = ui.getAudioComponent();
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
        // Setting up flashcard
        
        // Setting up clef
        int[] clefChords = {10, 1030, 10, 910};
        int clefID = ui.createViewComponent("image");
        ui.getViewComponent(clefID).updateXY(clefChords);
        ImageComponent clef = (ImageComponent) ui.getViewComponent(clefID);
        
        // Setting up hands
        int[] leftHandChords = {100, 250, 600, 750};
        int leftHandID = ui.createViewComponent("image");
        ui.getViewComponent(leftHandID).updateXY(leftHandChords);
        ImageComponent leftHand = (ImageComponent) ui.getViewComponent(leftHandID);
        
        int[] rightHandChords = {1000, 1150, 700, 750};
        int rightHandID = ui.createViewComponent("image");
        ui.getViewComponent(rightHandID).updateXY(rightHandChords);
        ImageComponent rightHand = (ImageComponent) ui.getViewComponent(rightHandID);
        
        // Setting up notes
        int[] noteChords= {300, 400, 300, 400};
        int[] noteIDs = new int[4];
        noteIDs[0] = ui.createViewComponent(clefID, "image", noteChords);
        ImageComponent note1 = (ImageComponent) ui.getViewComponent(noteIDs[0]);
        note1.changeImage("/Assets/wholeNote");
        
        noteIDs[1] = ui.createViewComponent(clefID, "image", noteChords);
        ImageComponent note2 = (ImageComponent) ui.getViewComponent(noteIDs[1]);
        note2.changeImage("/Assets/wholeNote");
        
        noteIDs[2] = ui.createViewComponent(clefID, "image", noteChords);
        ImageComponent note3 = (ImageComponent) ui.getViewComponent(noteIDs[2]);
        note3.changeImage("/Assets/wholeNote");
        
        noteIDs[3] = ui.createViewComponent(clefID, "image", noteChords);
        ImageComponent note4 = (ImageComponent) ui.getViewComponent(noteIDs[3]);
        note4.changeImage("/Assets/wholeNote");
        
        Flashcard f1 = new Flashcard(1, new int[] {60}, 'B', 'L');
        loadFlashcard(clef, leftHand, rightHand, f1);
        
        
        

        
        
    }
        
    private void loadFlashcard(ImageComponent clef, ImageComponent leftHand, ImageComponent rightHand, Flashcard flashcard){
        if (flashcard.getClef() == 'T'){
            clef.changeImage("/Assets/trebleStaff.png");
        } 
        if (flashcard.getClef() == 'B'){
            clef.changeImage("/Assets/bassStaff.png");
        }
        
        if (flashcard.getHand() == 'L'){
            leftHand.changeImage("/Assets/leftHandFilled.png");
            rightHand.changeImage("/Assets/rightHandBlank.png");
        }
        if (flashcard.getHand() == 'R'){
            leftHand.changeImage("/Assets/leftHandBlank.png");
            rightHand.changeImage("/Assets/rightHandFilled.png");
        }
        
        for (int note : flashcard.getAnswer()){
            
        }
    }

    private void playNote(int[] notes) {
        audio.playSound(notes);
    }
}
