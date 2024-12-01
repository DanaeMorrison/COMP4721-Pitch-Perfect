package Controller;

import Model.Flashcard;
import View.*;
import javafx.scene.paint.Color;

/**
 * The LessonViewer class is responsible for managing the visual components of a
 * lesson.
 * It initializes, loads, and updates various image components such as clef,
 * hands, notes, and feedback.
 * The class interacts with the UI to create and manipulate these components
 * based on the data provided by flashcards.
 */
public class LessonViewer {
    private UI ui;
    private NoteMapping noteCoords;
    private ImageComponent clef;
    private ImageComponent leftHand;
    private ImageComponent rightHand;
    private ImageComponent[] notes;
    private ImageComponent feedback;
    private RectangleComponent progressbarBackground;
    private RectangleComponent progressbar;

    // change to appropriate value
    private int[] menuSize;
    private int numFlashcardsInLesson;

    /**
     * Constructs a LessonViewer object.
     *
     * @param ui the UI instance to be associated with this LessonViewer
     */
    public LessonViewer(UI ui) {
        noteCoords = new NoteMapping();
        this.ui = ui;
        menuSize = new int[] { 0, ui.getScreenWidth(), 0, ui.getScreenHeight() };
        numFlashcardsInLesson = 0;
    }

    /**
     * Initializes the lesson by setting up various image components such as clef,
     * left hand, right hand, feedback, and notes. Each component is created,
     * positioned, and initially hidden.
     */
    public void initializeLesson() {
        clef = createImageComponent(new int[] { 170, 0, 0, 0 });
        leftHand = createImageComponent(new int[] { 155, 0, 600, 0 });
        rightHand = createImageComponent(new int[] { 995, 0, 600, 0 });
        feedback = createImageComponent(new int[] { 1050, 0, 300, 0 });
        progressbarBackground = createRectangleComponent(
                new int[] { menuSize[0] + 100, menuSize[1] - 200, menuSize[2] - 100, 100 }, Color.GREY);
        progressbar = createRectangleComponent(new int[] { menuSize[0] + 100, 0, menuSize[2] - 100, 100 }, Color.GREEN);

        notes = new ImageComponent[8];
        for (int i = 0; i < notes.length; i++) {
            notes[i] = createImageComponent(new int[] { 0, 0, 0, 0 });
        }
    }

    /**
     * Creates an ImageComponent with the specified coordinates.
     *
     * @param coords the coordinates for the ImageComponent
     * @return the created ImageComponent
     */
    private ImageComponent createImageComponent(int[] coords) {
        int id = ui.createViewComponent("image");
        ui.getViewComponent(id).updateXY(coords);
        ImageComponent component = (ImageComponent) ui.getViewComponent(id);
        component.setHidden(true);
        return component;
    }

    /**
     * Creates a RectangleComponent with the specified coordinates and color.
     *
     * @param coords the coordinates for the RectangleComponent
     * @param color  the color for the RectangleComponent
     * @return the created RectangleComponent
     */
    private RectangleComponent createRectangleComponent(int[] coords, Color color) {
        int id = ui.createViewComponent("rectangle");
        ui.getViewComponent(id).updateXY(coords);
        RectangleComponent component = (RectangleComponent) ui.getViewComponent(id);
        component.setColor(color);
        component.setHidden(true);
        return component;
    }

    /**
     * Loads the flashcard data into the lesson viewer.
     *
     * @param flashcard the flashcard object containing the data to be loaded
     */
    public void loadFlashcard(Flashcard flashcard) {
        int[] feedbackChords = { 1050, 1205, 300, 500 };
        feedback.setXY(feedbackChords);
        feedback.setHidden(true);

        int[] clefChords = { 170, 1190, 0, 800 };
        clef.setXY(clefChords);

        int[] leftHandChords = { 155, 355, 600, 800 };
        leftHand.setXY(leftHandChords);

        int[] rightHandChords = { 995, 1195, 600, 800 };
        rightHand.setXY(rightHandChords);

        for (int i = 0; i < notes.length; i++) {
            notes[i].setHidden(true);
        }

        for (int i = 0; i < flashcard.getAnswer().length; i++) {
            int[] noteCoordsArray = noteCoords.getCoordinates(flashcard.getAnswer()[i], flashcard.getClef());
            // notes[i].updateXY(noteCoordsArray);
            notes[i].setXY(noteCoordsArray);
            // check to see if the note needs a ledger line
            // we'll need some class/method that does this check against maybe a hashmap
            // with values that need a ledger line

            String path = noteCoords.getImagePath(flashcard.getAnswer()[i], flashcard.getClef());
            notes[i].changeImage(path);

            notes[i].setHidden(false);
        }
        if (flashcard.getClef() == 'T') {
            clef.changeImage("/Assets/trebleStaff.png");
        } else if (flashcard.getClef() == 'B') {
            clef.changeImage("/Assets/bassStaff.png");
        }
        clef.setHidden(false);

        if (flashcard.getHand() == 'L') {
            leftHand.changeImage("/Assets/leftHandFilled.png");
            rightHand.changeImage("/Assets/rightHandBlank.png");
        } else if (flashcard.getHand() == 'R') {
            leftHand.changeImage("/Assets/leftHandBlank.png");
            rightHand.changeImage("/Assets/rightHandFilled.png");
        }
        leftHand.setHidden(false);
        rightHand.setHidden(false);
        progressbarBackground.setHidden(false);
        progressbar.setHidden(false);
    }

    /**
     * Resets the progress bar to its default state.
     *
     * @param numFlashCards the number of flashcards in the lesson
     */
    public void resetProgressbar(int numFlashCards) {
        System.out.println("Resetting progress bar");
        // set to default
        int[] progressbarChords = { menuSize[0] + 100, 0, menuSize[2] - 100, 100 };
        progressbar.updateXY(progressbarChords);
        numFlashcardsInLesson = numFlashCards;
    }

    /**
     * Increases the progress bar based on the number of flashcards in the lesson.
     */
    public void increaseProgressbar() {
        int[] progressbarChords = progressbar.getXY();
        int desiredStart = menuSize[0] + 100;
        int desiredEnd = menuSize[1] - 100;
        int lengthIncrease = (desiredEnd - desiredStart) / numFlashcardsInLesson;
        if ((progressbarChords[1] + lengthIncrease) > (desiredEnd - desiredStart)) {
            progressbarChords[1] = desiredEnd - desiredStart;
        } else {
            progressbarChords[1] += lengthIncrease;
        }
        System.out.println("Resizing progress bar by :" + String.valueOf(progressbarChords[1]));
        progressbar.updateXY(progressbarChords);
    }

    /**
     * Closes the lesson viewer by hiding all visual components.
     * This method hides the feedback, clef, left hand, and right hand components.
     * Additionally, it iterates through all note components and hides each one.
     */
    public void close() {
        feedback.setHidden(true);
        clef.setHidden(true);
        leftHand.setHidden(true);
        rightHand.setHidden(true);
        progressbarBackground.setHidden(true);
        progressbar.setHidden(true);

        for (ImageComponent note : notes) {
            note.setHidden(true);
        }
    }

    /**
     * Loads feedback for a given flashcard based on user input and the correctness
     * of the answer.
     *
     * @param flashcard The flashcard object containing the musical note
     *                  information.
     * @param input     An array of integers representing the user's input notes.
     * @param answer    A Boolean indicating whether the user's answer is correct
     *                  (true) or incorrect (false).
     */
    public void loadFeedback(Flashcard flashcard, int[] input, Boolean answer) {
        if (input.length <= 4) {
            for (int i = 0; i < input.length; i++) {
                int[] noteCoordsArray = noteCoords.getCoordinates(input[i], flashcard.getClef());
                if (noteCoordsArray != null) {
                    notes[i + 4].updateXY(new int[] { noteCoordsArray[0] + 200, noteCoordsArray[1] + 200,
                            noteCoordsArray[2], noteCoordsArray[3] });
                    String path = noteCoords.getImagePath(input[i], flashcard.getClef());
                    notes[i + 4].changeImage(path);
                    notes[i + 4].setHidden(false);
                }
            }
        }
        if (answer) {
            increaseProgressbar();
            feedback.changeImage("/Assets/check.png");
        } else {
            feedback.changeImage("/Assets/cross.png");
        }

        feedback.setHidden(false);
    }

    /**
     * Closes the feedback section by hiding the feedback element and all notes
     * starting from the fourth index.
     * 
     * This method sets the visibility of the feedback element to hidden and
     * iterates through the notes array starting from the fourth element,
     * setting each note's visibility to hidden.
     */
    public void closeFeedback() {
        feedback.setHidden(true);
        for (int i = 4; i < notes.length; i++) {
            notes[i].setHidden(true);
        }
    }
}
