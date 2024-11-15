package Model;

import java.util.HashSet;

public class AnswerProcessor {
    private HashSet<Integer> currentNotes;
    private HashSet<Integer> input;
    private Flashcard currentFlashcard;

    public AnswerProcessor() {
        currentNotes = new HashSet<Integer>();
        input = new HashSet<Integer>();
    }

    public int[] getInput() {
        int[] userInput = new int[input.size()]; 
        
        int i = 0;
        for (Integer note: input){
            userInput[i] = note;
            i++;
        }
        // toArray() method converts the set to array 
        return userInput;
    }

    // Set the flashcard for answer checking
    public void setFlashcard(Flashcard flashcard) {
        this.currentFlashcard = flashcard;
    }

    // Add a note when a key is pressed
    public void noteOn(int note) {
        currentNotes.add(note);
        input.add(note);
    }

    // Remove a note when a key is released
    public boolean noteOff(int note) {
        currentNotes.remove(note);
        if (currentNotes.isEmpty()) {
            return true;
        } 
        return false;
    }

    // Check if the current notes match the flashcard answer
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
