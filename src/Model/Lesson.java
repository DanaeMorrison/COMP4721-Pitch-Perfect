package Model;

/**
 * @author Danae Morrison
 * @version 1.1
 **/
/**
 * Represents a lesson containing flashcards.
 */
public class Lesson {
    private int lessonID;
    private String lessonInfo;
    private Flashcard[] flashcardList;
    private int lessonSize = 0;
    private String lessonName;

    /**
     * Constructs a new Lesson with the specified details.
     *
     * @param lessonID      the unique identifier for the lesson
     * @param lessonName    the name of the lesson
     * @param lessonInfo    information about the lesson
     * @param flashcardList the list of flashcards in the lesson
     */
    public Lesson(int lessonID, String lessonName, String lessonInfo, Flashcard[] flashcardList) {
        this.lessonID = lessonID;
        this.lessonInfo = lessonInfo;
        this.flashcardList = flashcardList;
        this.lessonName = lessonName;
        lessonSize = flashcardList.length;
    }

    // getters
    public String getName() {
        return lessonName;
    }

    public String getInfo() {
        return lessonInfo;
    }

    public Flashcard[] getFlashcards() {
        return flashcardList;
    }

    public int getLessonID() {
        return lessonID;
    }

    public int getLessonSize() {
        return lessonSize;
    }
}
