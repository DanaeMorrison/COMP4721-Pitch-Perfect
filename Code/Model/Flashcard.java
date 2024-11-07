package Model;
/**
 * @author Danae Morrison
 * @version 1.0
 **/


public class Flashcard {
    private int flashcardID;
    private int imageID;
    private int answer;
    private int pointValue;

    // will be used during lessons and drills to determine
    // if a user has answered the flashcard correctly
    private boolean isCorrect;
    // potentially a float value with the specific location
    // on an image component the whole note should be placed?
    // Or have the controller translate the answer value of the
    // flashcard to a float value that the image component can use
    // for placement?

    public Flashcard(int flashcardID, int imageID, int answer, int pointValue) {
        this.flashcardID = flashcardID;
        this.imageID = imageID;
        this.answer = answer;
        this.pointValue = pointValue;
    }

    public int getID() {
        return flashcardID;
    }

    public int getImageID() {
        return imageID;
    }

    public int getAnswer() {
        return answer;
    }

    public int getPointValue() {
        return pointValue;
    }

    public void setFalse() {
        this.isCorrect = false;
    }

    public void setTrue() {
        this.isCorrect = true;
    }

    public boolean isCorrect() {
        return isCorrect;
    }
}
