/**
 * @author Danae Morrison
 * @version 1.0
 **/

 import java.util.ArrayList;

 public class Model {
    // private Unit[] units;
    // private Lesson[] lessons;

    private ArrayList<Flashcard> flashcards = new ArrayList<>();
    private ArrayList<Flashcard> lessons = new ArrayList<>();
    private ArrayList<Flashcard> units = new ArrayList<>();

    private int[] flashcardIDs = {0, 2, 4};
    private int[] imageIDs = {0, 2, 4};
    private int[] answers = {0, 2, 4};
    private int[] pointValues = {0, 0, 0};

    public void initializeModel() {
        /** Alternative method:
         * I could use a key so that each lesson/drill/
         * review could contain a list of the integers/notes
         * it needs, and then the flashcards could be grabbed
         * when the key is referenced.
         */

        initializeFlashcards();
        // Lesson[] lessonsInner = {initializeLesson1()};
        // lessons = lessonsInner;
        initializeUnit1();

    }

    public Unit getUnit(int unitID) {
        return units.get(unitID);
    }

    private void initializeUnit1() {
        //Lesson lesson1 = initializeLesson1();
        //Lesson[] lessons = {lesson1};
        initializeLesson1();
        Lesson[] unit1Lessons = {lessons.get(0)};
        Unit unit1 = new Unit(1, unit1Lessons, "This first Unit contains 1 Lesson.");
        units.add(unit1);

    }

    /**
     * This method is a helper method to initialize the
     * contents of Lesson 1
     * @return a Lesson- the first lesson
     */
    private Lesson initializeLesson1Old() {
        Flashcard[] lesson1Flashcards = {flashcards.get(0), flashcards.get(1), flashcards.get(2)};
        Lesson lesson1 = new Lesson(1, "Hit the key you think matches with the note on the screen. Hit Submit to submit your answer.", lesson1Flashcards);
        return lesson1;
    }

    /**
     * This method is a helper method to initialize the
     * contents of Lesson 1
     */
    private void initializeLesson1() {
        Flashcard[] lesson1Flashcards = {flashcards.get(0), flashcards.get(1), flashcards.get(2)};
        Lesson lesson1 = new Lesson(1, "Hit the key you think matches with the note on the screen. Hit Submit to submit your answer.", lesson1Flashcards);
        lessons.add(lesson1);
    }

    private void initializeFlashcards() {
        for (int i = 0; i < flashcardIDs.length; i++) {
            Flashcard newFlashcard = new Flashcard(flashcardIDs[i], imageIDs[i], answers[i], pointValues[i]);
            flashcards.add(newFlashcard);
        }
    }

    /** Not sure yet where this method should be.
     * The controller should translate the keyboard input into an integer from
     * a mapping of notes to integers. The method compares this integer to
     * the answer held in a flashcard.
    */
    public boolean isSubmissionCorrect(int keyboardInput, int flashcardAnswer) {
        return keyboardInput == flashcardAnswer;
    }
 }