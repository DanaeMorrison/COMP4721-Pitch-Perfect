package Model;

/**
 * @author Danae Morrison
 * @version 1.1
 **/

public class Lesson {
    private int lessonID;
    private String lessonInfo;
    private Flashcard[] flashcardList;
    private int lessonSize = 0;
    private String lessonName;

    public Lesson(int lessonID, String lessonName, String lessonInfo, Flashcard[] flashcardList) {
        this.lessonID = lessonID;
        this.lessonInfo = lessonInfo;
        this.flashcardList = flashcardList;
        this.lessonName = lessonName;
        lessonSize = flashcardList.length;
    }

    public String getName()
    {
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
