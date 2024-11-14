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
public class Controller {
    private UI ui;
    CommandParser commandParser;
    private AudioComponent audio;

    public Controller(Stage primaryStage) throws IOException, MidiUnavailableException {
        System.out.println("Controller created. Creating UI...");
        ui = new UI(primaryStage);
        commandParser = new CommandParser(this, ui);
        createLessonView();
        audio = ui.getAudioComponent();
    }

    /**
     * private void initState(File stateFile) throws IOException
     * {
     * //Intended to later include reloading state of users progress, not
     * //worrying about this for now and will just get it to init model and
     * //some viewComponents
     * 
     * BufferedReader input = new BufferedReader(stateFile);
     * String currLine = input.readLine();
     * //assumes stateFile ends with "EOF"
     * while(currLine != "EOF")
     * {
     * 
     * }
     * }
     **/

    public UI getUI() {
        return ui;
    }

    public CommandParser getParser() {
        return commandParser;
    }

    private void createKeyboard() {
        int startX = 0;
        int startY = 0;
        int totalWidth = 600;
        int totalHeight = 300;
        int keyWidth = totalWidth / 12;

        int[] backgroundCords = new int[4];
        backgroundCords[0] = startX;
        backgroundCords[1] = totalWidth;
        backgroundCords[2] = startY;
        backgroundCords[3] = totalHeight;
        int backGroundID = ui.createViewComponent("rectangle");
        ui.getViewComponent(backGroundID).updateXY(backgroundCords);

        int[] keyCords = new int[4];
        keyCords[0] = startX;
        keyCords[1] = keyWidth;
        keyCords[2] = startY;
        keyCords[3] = totalHeight;
        int[] keyIDs = new int[12];
        for (int i = 0; i < 12; i++) {
            keyIDs[i] = ui.createViewComponent("button");
            ui.getViewComponent(keyIDs[i]).updateXY(keyCords);
            keyCords[0] += keyWidth;
            keyCords[1] += keyWidth;
        }
    }

    private void createLessonView(/* Lesson lesson */) {
        // Setting up flashcard
        System.out.println("getHere");
        // Setting up clef
        int[] clefChords = { 170, 1190, 0, 800 };
        int clefID = ui.createViewComponent("image");
        ui.getViewComponent(clefID).updateXY(clefChords);
        ImageComponent clef = (ImageComponent) ui.getViewComponent(clefID);

        // Setting up hands
        int[] leftHandChords = { 155, 355, 600, 800 };
        int leftHandID = ui.createViewComponent("image");
        ui.getViewComponent(leftHandID).updateXY(leftHandChords);
        ImageComponent leftHand = (ImageComponent) ui.getViewComponent(leftHandID);

        int[] rightHandChords = { 995, 1195, 600, 800 };
        int rightHandID = ui.createViewComponent("image");
        ui.getViewComponent(rightHandID).updateXY(rightHandChords);
        ImageComponent rightHand = (ImageComponent) ui.getViewComponent(rightHandID);
        System.out.println("setup");

        // Setting up notes
        int[] noteIDs = new int[4];
        noteIDs[0] = ui.createViewComponent("image");
        ImageComponent note1 = (ImageComponent) ui.getViewComponent(noteIDs[0]);

        noteIDs[1] = ui.createViewComponent("image");
        ImageComponent note2 = (ImageComponent) ui.getViewComponent(noteIDs[1]);

        noteIDs[2] = ui.createViewComponent("image");
        ImageComponent note3 = (ImageComponent) ui.getViewComponent(noteIDs[2]);

        noteIDs[3] = ui.createViewComponent("image");
        ImageComponent note4 = (ImageComponent) ui.getViewComponent(noteIDs[3]);

        ImageComponent[] notes = { note1, note2, note3, note4 };

        Flashcard f1 = new Flashcard(1, new int[] {40, 47, 52, 60}, 'B', 'R');
        loadFlashcard(clef, notes, leftHand, rightHand, f1);
    }

    private void loadFlashcard(ImageComponent clef, ImageComponent[] notes, ImageComponent leftHand,
            ImageComponent rightHand, Flashcard flashcard) {
        NotePositioning noteCoords = new NotePositioning();
        for (ImageComponent note : notes) {
            note.setHidden(true);
        }
        if (flashcard.getClef() == 'T') {
            clef.changeImage("/Assets/trebleStaff.png");
            System.out.println("Trebble");
        }
        if (flashcard.getClef() == 'B') {
            clef.changeImage("/Assets/bassStaff.png");
        }

        if (flashcard.getHand() == 'L') {
            leftHand.changeImage("/Assets/leftHandFilled.png");
            rightHand.changeImage("/Assets/rightHandBlank.png");
        }
        if (flashcard.getHand() == 'R') {
            leftHand.changeImage("/Assets/leftHandBlank.png");
            rightHand.changeImage("/Assets/rightHandFilled.png");
        }
        for (int i = 0; i < flashcard.getAnswer().length; i++) {
            int[] noteCoordsArray = noteCoords.getNotePosition(flashcard.getAnswer()[i], flashcard.getClef());
            notes[i].updateXY(noteCoordsArray);
            notes[i].setHidden(false);
        }
    }

    public void playNote(int[] notes) {
        audio.playSound(notes);
    }
}
