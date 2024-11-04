/**
 * @author Danae Morrison
 * @version 1.0
 **/


public class Flashcard {
    private int flashcardID;
    private int imageID;
    private int answer;
    private int pointValue;

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
}
