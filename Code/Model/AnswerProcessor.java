package Model;

import java.util.HashSet;

/**
 * The MenuViewer class is responsible for managing and displaying menus in the
 * UI.
 * It initializes menus for units and lessons, handles menu loading and closing,
 * and manages the visibility of menu components.
 */
public class AnswerProcessor {
    private HashSet<Integer> currentNotes;
    private HashSet<Integer> input;
    private Flashcard currentFlashcard;

    /**
     * Constructor to initialize the AnswerProcessor.
     * Initializes the currentNotes and input sets.
     */
    public AnswerProcessor() {
        currentNotes = new HashSet<Integer>();
        input = new HashSet<Integer>();
    }

    /**
     * Gets the input notes as an array of integers.
     *
     * @return an array of integers representing the input notes.
     */
    public int[] getInput() {
        int[] userInput = new int[input.size()];

        int i = 0;
        for (Integer note : input) {
            userInput[i] = note;
            i++;
        }
        // toArray() method converts the set to array
        return userInput;
    }

    /**
     * Sets the flashcard for answer checking.
     *
     * @param flashcard the flashcard to be set.
     */
    public void setFlashcard(Flashcard flashcard) {
        this.currentFlashcard = flashcard;
    }

    /**
     * Adds a note to the current notes and input when a key is pressed.
     *
     * @param note the note to be added.
     */
    public void noteOn(int note) {
        currentNotes.add(note);
        input.add(note);
    }

    /**
     * Removes a note from the current notes when a key is released.
     *
     * @param note the note to be removed.
     * @return true if all notes are released, false otherwise.
     */
    public boolean noteOff(int note) {
        currentNotes.remove(note);
        if (currentNotes.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * Checks if the current notes match the flashcard answer.
     *
     * @return true if the answer is correct, false otherwise.
     */
    public boolean checkAnswer() {
        if (currentFlashcard == null) {
            System.out.println("No flashcard set for validation.");
            return false;
        }
        int[] answer = currentFlashcard.getAnswer();
        boolean correct = true;

        for (int note : answer) {
            if (!input.contains(note)) {
                correct = false;
            } else {
                input.remove(note);
            }
        }

        boolean rightAnswer = (correct && input.isEmpty());
        if (rightAnswer) {
            System.out.println("Correct Answer");
        } else {
            System.out.println("Incorrect Answer");
        }
        input.clear();

        return rightAnswer;
    }
}
