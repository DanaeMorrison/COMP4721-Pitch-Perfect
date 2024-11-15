package Controller;

import Model.Flashcard;
import View.*;

public class LessonViewer {
    private UI ui;
    private NotePositioning noteCoords;
    private ImageComponent clef;
    private ImageComponent leftHand;
    private ImageComponent rightHand;
    private ImageComponent[] notes;
    private ImageComponent feedback;

    public LessonViewer(UI ui) {
        noteCoords = new NotePositioning();
        this.ui = ui;
    }

    public void initializeLesson() {
        // Setting up the flashcard
        int[] clefChords = { 170, 1190, 0, 800 };
        int clefID = ui.createViewComponent("image");
        ui.getViewComponent(clefID).updateXY(clefChords);
        clef = (ImageComponent) ui.getViewComponent(clefID);
        
        int[] leftHandChords = { 155, 355, 600, 800 };
        int leftHandID = ui.createViewComponent("image");
        ui.getViewComponent(leftHandID).updateXY(leftHandChords);
        leftHand = (ImageComponent) ui.getViewComponent(leftHandID);

        int[] rightHandChords = { 995, 1195, 600, 800 };
        int rightHandID = ui.createViewComponent("image");
        ui.getViewComponent(rightHandID).updateXY(rightHandChords);
        rightHand = (ImageComponent) ui.getViewComponent(rightHandID);

        int[] feedbackChords = { 1050, 1205, 300, 500 };
        int feedbackID = ui.createViewComponent("image");
        ui.getViewComponent(feedbackID).updateXY(feedbackChords);
        feedback = (ImageComponent) ui.getViewComponent(feedbackID);

        notes = new ImageComponent[8];
        for (int i = 0; i < notes.length; i++) {
            notes[i] = (ImageComponent) ui.getViewComponent(ui.createViewComponent("image"));
            notes[i].setHidden(true);
        }
    }

    public void loadFlashcard(Flashcard flashcard) {
        feedback.setHidden(true);
        clef.setHidden(false);
        leftHand.setHidden(false);
        rightHand.setHidden(false);

        for (int i = 0; i < notes.length; i++) {
            notes[i].setHidden(true);
        }

        for (int i = 0; i < flashcard.getAnswer().length; i++) {
            int[] noteCoordsArray = noteCoords.getNotePosition(flashcard.getAnswer()[i], flashcard.getClef());
            notes[i].updateXY(noteCoordsArray);
            notes[i].setHidden(false);
        }

        if (flashcard.getClef() == 'T') {
            clef.changeImage("/Assets/trebleStaff.png");
        } else if (flashcard.getClef() == 'B') {
            clef.changeImage("/Assets/bassStaff.png");
        }

        if (flashcard.getHand() == 'L') {
            leftHand.changeImage("/Assets/leftHandFilled.png");
            rightHand.changeImage("/Assets/rightHandBlank.png");
        } else if (flashcard.getHand() == 'R') {
            leftHand.changeImage("/Assets/leftHandBlank.png");
            rightHand.changeImage("/Assets/rightHandFilled.png");
        }
    }

    public void close() {
        feedback.setHidden(true);
        clef.setHidden(true);
        leftHand.setHidden(true);
        rightHand.setHidden(true);

        for (ImageComponent note : notes) {
            note.setHidden(true);
        }
    }

    public void loadFeedback(Flashcard flashcard, int[] input, Boolean answer) {
        if (input.length <=4){
            for (int i = 0; i < input.length; i++) {
                int[] noteCoordsArray = noteCoords.getNotePosition(input[i], flashcard.getClef());
                notes[i + 4].updateXY(new int[] {noteCoordsArray[0]+200, noteCoordsArray[1]+200, noteCoordsArray[2], noteCoordsArray[3]});
                notes[i + 4].setHidden(false);
            }
        }
        if (answer) {
            feedback.changeImage("/Assets/check.png");
        } else {
            feedback.changeImage("/Assets/cross.png");
        }
        
        feedback.setHidden(false);
    }

    public void closeFeedback() {
        feedback.setHidden(true);
        for (int i = 4; i < notes.length; i++) {
            notes[i].setHidden(true);
        }
    }
}
