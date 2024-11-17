// Source code is decompiled from a .class file using FernFlower decompiler.
package Controller;

import Model.AnswerProcessor;
import Model.AudioHandler;
import Model.Flashcard;
import Model.Lesson;
import Model.Drill;
import Model.Model;
import View.UI;
import View.ViewComponent;

import java.io.IOException;
import javafx.stage.Stage;
import javax.sound.midi.MidiUnavailableException;
import java.util.ArrayList;

public class Controller {
    private String activity;
    private UI ui;
    private AudioHandler audio;
    private MidiInputHandler midiInputHandler;
    private AnswerProcessor answerProcessor;
    private LessonViewer lessonViewer;
    private DrillViewer drillViewer;
    private CommandParser commandParser;
    private ArrayList<Integer> parsables;
    private MenuViewer menuViewer;
    // private int unitSelectionID;
    private Model model;

    private boolean check;
    private int currentFlashcardIndex;
    private Flashcard[] flashcards;
    private ArrayList<Flashcard> incorrectAnswers;

    /**
     * Constructs a Controller with the given primary stage.
     *
     * @param primaryStage the primary stage
     * @throws IOException            if an I/O error occurs
     * @throws MidiUnavailableException if the MIDI device is unavailable
     */
    public Controller(Stage primaryStage) throws IOException, MidiUnavailableException {
        ui = new UI(primaryStage);
        audio = new AudioHandler();
        lessonViewer = new LessonViewer(ui);
        drillViewer = new DrillViewer(ui);
        midiInputHandler = new MidiInputHandler(this);
        model = new Model();
        answerProcessor = new AnswerProcessor();
        System.out.println("Creating commandParser");
        commandParser = new CommandParser(this, ui);
        parsables = new ArrayList<>();
        System.out.println("Creating menuViewer");
        menuViewer = new MenuViewer(this, ui, model.getUnits());
    }

    /**
     * Loads the menu based on the given command.
     *
     * @param command the command to load the menu
     */
    public void loadMenu(String command) {
        System.out.println("Controller sending command: " + command);
        menuViewer.loadMenu(command);
    }

    /**
     * Retrieves the CommandParser instance.
     *
     * @return the commandParser instance used by the controller.
     */
    public CommandParser getParser() {
        return commandParser;
    }

    /**
     * Adds a parsable ID to the list of parsables and updates the command parser with the new list of IDs.
     *
     * @param parsableID the ID of the parsable to be added
     */
    public void addParsable(int parsableID) {
        parsables.add(parsableID);
        commandParser.updateInputIDs(parsables);
    }

    /**
     * Retrieves a lesson by its ID and starts the lesson.
     *
     * @param lessonID the ID of the lesson to retrieve
     */
    public void getLesson(int lessonID) {
        Lesson currentLesson = model.getLesson(lessonID);
        startLesson(currentLesson);
    }

    /**
     * Initializes the lesson activity.
     */
    private void startLesson(Lesson lesson) {
        flashcards = lesson.getFlashcards();
        currentFlashcardIndex = 0;

        activity = "Lesson";
        lessonViewer.initializeLesson();
        answerProcessor.setFlashcard(flashcards[currentFlashcardIndex]);
        lessonViewer.loadFlashcard(flashcards[currentFlashcardIndex]);
    }

    /**
     * Retrieves a drill by its ID and starts the lesson.
     *
     * @param lessonID the ID of the drill to retrieve
     */
    public void getDrill(int drillID) {
        Drill currentDrill = model.getDrill(drillID);
        startDrill(currentDrill);
    }

    /**
     * Starts a drill activity with the given drill.
     *
     * @param drill the drill to start
     */
    private void startDrill(Drill drill) {
        flashcards = drill.getFlashcards();
        currentFlashcardIndex = 0;

        activity = "Drill";
        drillViewer.initializeDrill();
        incorrectAnswers = new ArrayList<Flashcard>();
        drillViewer.startTimer(drill.getTimeLim());
        answerProcessor.setFlashcard(flashcards[currentFlashcardIndex]);
        drillViewer.loadFlashcard(flashcards[currentFlashcardIndex]);
    }

    /**
     * Stops the controller and cleans up resources.
     */
    public void stop() {
        // Clean up resources
        if (midiInputHandler != null) {
            midiInputHandler.close();
        }
        if (audio != null) {
            audio.close();
        }
        System.out.println("LessonViewer stopped.");
    }

    /**
     * Handles the note on event.
     *
     * @param note     the MIDI note number
     * @param velocity the velocity of the note
     */
    public void onNoteOn(int note, int velocity) {
        audio.noteOn(note, velocity);
        answerProcessor.noteOn(note);
    }

    /**
     * Handles the note off event.
     *
     * @param note the MIDI note number
     */
    public void onNoteOff(int note) {
        audio.noteOff(note);
        check = answerProcessor.noteOff(note);
        if (check) {
            if (activity.equals("Lesson")) {
                int[] input = answerProcessor.getInput();
                boolean answer = answerProcessor.checkAnswer();
                lessonViewer.loadFeedback(flashcards[currentFlashcardIndex], input, answer);
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    System.out.println("Error");
                }
                lessonViewer.closeFeedback();
                if (answer) {
                    moveToNextFlashcard();
                }
            }

            if (activity.equals("Drill")) {
                boolean answer = answerProcessor.checkAnswer();
                if (!answer) {
                    incorrectAnswers.add(flashcards[currentFlashcardIndex]);
                }
                moveToNextFlashcard();
            }
        }
    }

    /**
     * Moves to the next flashcard in the sequence. Depending on the current activity,
     * it will load the next flashcard into the appropriate viewer (lesson or drill).
     * If the end of the flashcards is reached, it will handle the completion of the
     * activity. For lessons, it will print "Lesson Complete!" and close the lesson viewer.
     * For drills, it will print "Drill Complete!", close the drill viewer, and if there
     * are any incorrect answers, it will start a review session with those flashcards.
     */
    private void moveToNextFlashcard() {
        if (currentFlashcardIndex < flashcards.length - 1) {
            currentFlashcardIndex++;
            answerProcessor.setFlashcard(flashcards[currentFlashcardIndex]);
            if (activity.equals("Lesson")) {
                lessonViewer.loadFlashcard(flashcards[currentFlashcardIndex]);
            }
            if (activity.equals("Drill")) {
                drillViewer.loadFlashcard(flashcards[currentFlashcardIndex]);
            }
        } else {
            if (activity.equals("Lesson")) {
                System.out.println("Lesson Complete!");
                lessonViewer.close();
                //menuViewer.loadMenu("showUnitSelection 0");
                menuViewer.loadMenu("showLessonComplete 0");
            }
            if (activity.equals("Drill")) {
                System.out.println("Drill Complete!");
                drillViewer.close();
                if (!incorrectAnswers.isEmpty()) {
                    Flashcard[] wrongAnswers = new Flashcard[incorrectAnswers.size()];
                    for (int i = 0; i < incorrectAnswers.size(); i++) {
                        wrongAnswers[i] = incorrectAnswers.get(i);
                    }
                    Lesson review = new Lesson(1, "Review Drill", "Review Session", wrongAnswers);
                    menuViewer.updateDrillCompleteScreen(review);
                    //startLesson(review);
                    menuViewer.loadMenu("showDrillComplete 0");
                } else {
                    menuViewer.loadMenu("showLessonComplete 0");
                }
                //menuViewer.loadMenu("showDrillComplete 0");
            }
        }
    }

    
    /**
     * Closes the view component with the specified ID.
     *
     * @param viewComponentID the ID of the view component to be closed
     * @return true if the view component was successfully hidden, false otherwise
     */
    public boolean close(int viewComponentID) {
        ViewComponent obj = ui.getViewComponent(viewComponentID);
        boolean hidden = closeHelper(obj);
        return hidden;
    }

    /**
     * Recursively hides the given ViewComponent and its child components if all child components are hidden.
     *
     * @param obj the ViewComponent to be checked and potentially hidden
     * @return true if the given ViewComponent is null or all its child components are hidden, false otherwise
     */
    private boolean closeHelper(ViewComponent obj) {
        if (obj == null) {
            return true;
        }
        ViewComponent[] components = obj.getComponents();
        boolean allHidden = true;
        for (ViewComponent component : components) {
            if (!closeHelper(component)) {
                allHidden = false;
            }
        }
        if (allHidden) {
            obj.setHidden(true);
        }
        return obj.getHidden();
    }
}
