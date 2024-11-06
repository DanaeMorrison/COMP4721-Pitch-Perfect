package Model;
/**
 * @author Danae Morrison
 * @version 1.0
 **/


public class Lesson {
    private int lessonID;
    private String lessonInfo;
    private Flashcard[] flashcardList;

    public Lesson(int lessonID, String lessonInfo, Flashcard[] flashcardList) {
        this.lessonID = lessonID;
        this.lessonInfo = lessonInfo;
        this.flashcardList = flashcardList;
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
}