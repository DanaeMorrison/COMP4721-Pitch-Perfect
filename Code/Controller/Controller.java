// Source code is decompiled from a .class file using FernFlower decompiler.
package Controller;

import Model.AnswerProcessor;
import Model.AudioHandler;
import Model.Flashcard;
import Model.Lesson;
import View.UI;
import java.io.IOException;
import javafx.stage.Stage;
import javax.sound.midi.MidiUnavailableException;

public class Controller {
    private UI ui;
    private AudioHandler audio;
    private MidiInputHandler midiInputHandler;
    private AnswerProcessor answerProcessor;
    private LessonViewer lessonViewer;

    private boolean check;
    private int currentFlashcardIndex;
    private Flashcard[] flashcards;

    public Controller(Stage primaryStage) throws IOException, MidiUnavailableException {
        ui = new UI(primaryStage);
        audio = new AudioHandler();
        lessonViewer = new LessonViewer(ui);
        midiInputHandler = new MidiInputHandler(this);
        answerProcessor = new AnswerProcessor();

        Flashcard f1 = new Flashcard(1, new int[] { 60 }, 'T', 'R');
        Flashcard f2 = new Flashcard(2, new int[] { 64, 67 }, 'T', 'R');
        Flashcard f3 = new Flashcard(3, new int[] { 48 }, 'B', 'L');

        flashcards = new Flashcard[] { f1, f2, f3 };
        currentFlashcardIndex = 0;

        lessonViewer.initializeLesson();
        answerProcessor.setFlashcard(flashcards[currentFlashcardIndex]);
        lessonViewer.loadFlashcard(flashcards[currentFlashcardIndex]);
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
            moveToNextFlashcard();
        }
    }

    private void moveToNextFlashcard() {
        if (currentFlashcardIndex < flashcards.length - 1) {
            currentFlashcardIndex++;
            answerProcessor.setFlashcard(flashcards[currentFlashcardIndex]);
            lessonViewer.loadFlashcard(flashcards[currentFlashcardIndex]);
        } else {
            System.out.println("Lesson Complete!");
            answerProcessor.setFlashcard(null);
            lessonViewer.closeFlashcard();
            //stop();
        }
    }
}
