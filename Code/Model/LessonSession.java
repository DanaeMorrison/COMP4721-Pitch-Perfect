package Model;

/**
 * @author Danae Morrison
 * @version 1.0
 **/


public class LessonSession {
    private static final int EMPTYPROGRESSBAR = 0;

    public static void doLesson(Lesson lesson, User user) {
        Flashcard[] lessonFlashcards = lesson.getFlashcards();
        int numOfFlashcards = lessonFlashcards.length;
        int numFlashcardsCorrect = EMPTYPROGRESSBAR;
        float progress;


        for (int i = 0; i < numOfFlashcards; i++) {
            //Score currentFlashcardScore = user.getScore(lessonFlashcards[i].getID());
            Flashcard currentFlashcard = lessonFlashcards[i];
            int currentAnswer = currentFlashcard.getAnswer();
            // all of the parameters needed in order to generate the flashcard
            int currentImageID = currentFlashcard.getImageID();
            //controller gets these parameters and displays the flashcard
            
            while (!currentFlashcard.isCorrect()) {
                /** message sent to controller to clear the view of user's
                 * previous answer feedback and indicators of
                 * answer being incorrect (if any)
                 */ 

                // converted user input will go here
                int keyBoardinput = 0;
                //Let controller display user's input
                if (!isSubmissionCorrect(keyBoardinput, currentAnswer)) {
                    // Let controller send message to view that answer is incorrect
                    // This has a literal message, but it could also just alert the
                    // controller that a wrong answer was given, and the controller can
                    // have the view give visual cues to show that the answer is wrong
                    String text = lesson.incorrectSubmission();
                    // need a delay to keep the current view up before
                    // the user can try again
                    try {
                        Thread.sleep(4000);
                    }
                    catch(InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                } else {
                    currentFlashcard.setTrue();
                    numFlashcardsCorrect++;
                    progress = numFlashcardsCorrect/numOfFlashcards;
                    
                    // Let controller send message to view that answer is correct
                    // This has a literal message, but it could also just alert the
                    // controller that the right answer was given, and the controller can
                    // have the view give visual cues to show that the answer is right,
                    // including updating view's progress bar with new progress value 
                    String text = lesson.correctSubmission();
                    // need a delay to keep the current view up before
                    // the user can try new question or brought to "Lesson complete" page
                    try {
                        Thread.sleep(4000);
                    }
                    catch(InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
        // controller gets alert that lesson is complete
        String lessonComplete = lesson.lessonComplete();
        // resets all flashcards' isCorrect values to false.
        // potentially not needed if lesson's flashcards were not
        // changed through use of the lessonFlashcards variable assignment
        resetFlashcardsFalse(lessonFlashcards);
    }

    private static boolean isSubmissionCorrect(int keyboardInput, int flashcardAnswer) {
        return keyboardInput == flashcardAnswer;
    }

    private static void resetFlashcardsFalse(Flashcard[] lessonFlashcards) {
        for (int i = 0; i < lessonFlashcards.length; i++) {
            lessonFlashcards[i].setFalse();
        }
    }
}
