package Model;

/**
 * The Drill class represents a type of Lesson that includes a time limit.
 * It extends the Lesson class and adds a time limit attribute.
 */
public class Drill extends Lesson {
    private int timeLim;

    /**
     * Constructs a new Drill object with the specified lesson ID, name, info, flashcard list, and time limit.
     *
     * @param lessonID the unique identifier for the lesson
     * @param lessonName the name of the lesson
     * @param lessonInfo additional information about the lesson
     * @param flashcardList an array of Flashcard objects associated with the lesson
     * @param timeLim the time limit for the drill in minutes
     */
    public Drill(int lessonID, String lessonName, String lessonInfo, Flashcard[] flashcardList, int timeLim) {
        super(lessonID, lessonName, lessonInfo, flashcardList);
        this.timeLim = timeLim;
    }

    /**
     * Returns the time limit for the drill.
     *
     * @return the time limit in minutes
     */
    public int getTimeLim() {
        return timeLim;
    }

    /**
     * Sets the time limit for the drill.
     *
     * @param timeLim the new time limit in minutes
     */
    public void setTimeLim(int timeLim) {
        this.timeLim = timeLim;
    }
}
