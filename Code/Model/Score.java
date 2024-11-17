package Model;

public class Score {
    private int flashcardID;
    private boolean isCorrect;
    private int attemptNumber;

    public int getFlashcard() {
        return flashcardID;
    }

    public void setIsCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    public boolean getIsCorrect() {
        return isCorrect;
    }

    public int getAttemptNumber() {
        return attemptNumber;
    }
}
