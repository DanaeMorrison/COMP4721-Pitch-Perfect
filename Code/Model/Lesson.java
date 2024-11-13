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

    public Lesson(int lessonID, String lessonInfo, Flashcard[] flashcardList) {
        this.lessonID = lessonID;
        this.lessonInfo = lessonInfo;
        this.flashcardList = flashcardList;
        lessonSize = flashcardList.length;
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
