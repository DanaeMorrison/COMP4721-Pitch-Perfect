package Model;

public class Drill extends Lesson {
    private int timeLim;

    public Drill(int lessonID, String lessonInfo, Flashcard[] flashcardList, int timeLim) {
        super(lessonID, lessonInfo, flashcardList);
        this.timeLim = timeLim;
    }

    public int getTimeLim() {
        return timeLim;
    }

    public void setTimeLim(int timeLim) {
        this.timeLim = timeLim;
    }
}
