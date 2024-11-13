package Model;

/**
 * @author Danae Morrison
 * @version 1.1
 **/

public class Flashcard {
    private int flashcardID;
    private int[] answer;
    private String clef;
    private char hand;

    // will be used during lessons and drills to determine
    // if a user has answered the flashcard correctly
    // potentially a float value with the specific location
    // on an image component the whole note should be placed?
    // Or have the controller translate the answer value of the
    // flashcard to a float value that the image component can use
    // for placement?

    public Flashcard(int flashcardID, int[] answer, String clef, char hand) {
        this.flashcardID = flashcardID;
        this.answer = answer;
        this.clef = clef;
        this.hand = hand;
    }

    public int getID() {
        return flashcardID;
    }

    public char getHand() {
        return hand;
    }

    public int[] getAnswer() {
        return answer;
    }

    public String getClef() {
        return clef;
    }
}
