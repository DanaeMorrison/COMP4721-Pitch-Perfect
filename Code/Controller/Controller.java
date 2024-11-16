// Source code is decompiled from a .class file using FernFlower decompiler.
package Controller;

import Model.AnswerProcessor;
import Model.AudioHandler;
import Model.Flashcard;
import Model.Lesson;
import Model.Drill;
import Model.Model;
import View.UI;
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
    private Model model;

    private boolean check;
    private int currentFlashcardIndex;
    private Flashcard[] flashcards;
    private ArrayList<Flashcard> incorrectAnswers;

    public Controller(Stage primaryStage) throws IOException, MidiUnavailableException {
        ui = new UI(primaryStage);
        audio = new AudioHandler();
        lessonViewer = new LessonViewer(ui);
        drillViewer = new DrillViewer(ui);
        midiInputHandler = new MidiInputHandler(this);
        answerProcessor = new AnswerProcessor();
        System.out.println("Creating commandParser");
        commandParser = new CommandParser(this, ui);
        parsables = new ArrayList<>();
        System.out.println("Creating menuViewer");
        menuViewer = new MenuViewer(this, ui, model.getUnits());


        Flashcard f1 = new Flashcard(1, new int[] { 60 }, 'T', 'R');
        Flashcard f2 = new Flashcard(2, new int[] { 64, 67 }, 'T', 'R');
        Flashcard f3 = new Flashcard(3, new int[] { 48 }, 'B', 'L');

        Drill l1 = new Drill(1, "drill1", "Basic Lesson", new Flashcard[] { f1, f2, f3 }, 120);
        
        lessonViewer.initializeLesson();
        lessonViewer.close();
        drillViewer.initializeDrill();
        drillViewer.close();
        
        
        startDrill(l1);
    }
        
    public void loadMenu(String command)
    {
        System.out.println("Controller sending command: "+command);
        menuViewer.loadMenu(command);
    }

    public CommandParser getParser()
    {
        return commandParser;
    }
    
    public void addParsable(int parsableID)
    {
        parsables.add(parsableID);
        commandParser.updateInputIDs(parsables);
    }

    private void startLesson(Lesson lesson){        
        flashcards = lesson.getFlashcards();
        currentFlashcardIndex = 0;
        
        activity = "Lesson";
        answerProcessor.setFlashcard(flashcards[currentFlashcardIndex]);
        lessonViewer.loadFlashcard(flashcards[currentFlashcardIndex]);
    }
    
    private void startDrill(Drill drill){
        flashcards = drill.getFlashcards();
        currentFlashcardIndex = 0;
    
        activity = "Drill";
        incorrectAnswers = new ArrayList<Flashcard>();
        drillViewer.startTimer(drill.getTimeLim());
        answerProcessor.setFlashcard(flashcards[currentFlashcardIndex]);
        drillViewer.loadFlashcard(flashcards[currentFlashcardIndex]);
    }
    
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

    public void onNoteOn(int note, int velocity) {
        audio.noteOn(note, velocity);
        answerProcessor.noteOn(note);
    }

    public void onNoteOff(int note) {
        audio.noteOff(note);
        check = answerProcessor.noteOff(note);
        if (check){
            if (activity.equals("Lesson")){
                int[] input = answerProcessor.getInput();
                boolean answer = answerProcessor.checkAnswer();
                lessonViewer.loadFeedback(flashcards[currentFlashcardIndex], input, answer);
                try{
                    Thread.sleep(500);
                } catch (Exception e){
                    System.out.println("Error");
                }
                lessonViewer.closeFeedback(); 
                if (answer){
                    moveToNextFlashcard();
                }
            }
            
            if(activity.equals("Drill")){
                boolean answer = answerProcessor.checkAnswer();
                if (!answer){
                    incorrectAnswers.add(flashcards[currentFlashcardIndex]);
                }
                moveToNextFlashcard();
            }
        }
    }

    private void moveToNextFlashcard() {
        if (currentFlashcardIndex < flashcards.length - 1) {
            currentFlashcardIndex++;
            answerProcessor.setFlashcard(flashcards[currentFlashcardIndex]);
            if (activity.equals("Lesson")){
                lessonViewer.loadFlashcard(flashcards[currentFlashcardIndex]);
            }
            if (activity.equals("Drill")){
                drillViewer.loadFlashcard(flashcards[currentFlashcardIndex]);
            }
        } else {
            if (activity.equals("Lesson")){
                System.out.println("Lesson Complete!");
                lessonViewer.close();
            }
            if (activity.equals("Drill")){
                System.out.println("Drill Complete!");
                drillViewer.close();
                if (!incorrectAnswers.isEmpty()){
                    Flashcard[] wrongAnswers = new Flashcard[incorrectAnswers.size()];
                    for (int i=0; i< incorrectAnswers.size(); i++){
                        wrongAnswers[i] = incorrectAnswers.get(i);
                    }
                    Lesson review = new Lesson(1, "drillReview", "Review Session", wrongAnswers);
                    startLesson(review);
                }
            }
        }
    }
}
