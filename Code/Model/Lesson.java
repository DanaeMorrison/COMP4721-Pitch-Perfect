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

    public String incorrectSubmission() {
        return "Your answer is incorrect. Try again";
    }

    public String correctSubmission() {
        return "Your answer is correct";
    }

    public String lessonComplete() {
        return "You have completed the lesson";
    }
}
