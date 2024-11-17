package Model;

/**
 * Represents a score for a flashcard, including whether the answer was correct
 * and the attempt number.
 */
public class Score {
    private int flashcardID;
    private boolean isCorrect;
    private int attemptNumber;

    /**
     * Gets the flashcard ID.
     * 
     * @return the flashcard ID.
     */
    public int getFlashcard() {
        return flashcardID;
    }

    /**
     * Sets whether the answer is correct.
     * 
     * @param isCorrect true if the answer is correct, false otherwise.
     */
    public void setIsCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    /**
     * Gets whether the answer is correct.
     * 
     * @return true if the answer is correct, false otherwise.
     */
    public boolean getIsCorrect() {
        return isCorrect;
    }

    /**
     * Gets the attempt number.
     * 
     * @return the attempt number.
     */
    public int getAttemptNumber() {
        return attemptNumber;
    }
}
