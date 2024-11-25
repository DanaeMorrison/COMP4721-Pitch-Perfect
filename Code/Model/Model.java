package Model;

import java.util.ArrayList;

/**
 * The Model class represents the data model for the application.
 * It contains units, lessons, and drills, and provides methods to access and
 * initialize them.
 * 
 * @author Danae Morrison
 * @version 1.1
 */
public class Model {
    private ArrayList<Unit> units;
    private ArrayList<Lesson> lessons;
    private ArrayList<Drill> drills;

    /**
     * Constructor for the Model class.
     * Initializes the units, lessons, and drills lists and calls initModel().
     */
    public Model() {
        units = new ArrayList<>();
        lessons = new ArrayList<>();
        drills = new ArrayList<>();
        initModel();
    }

    /**
     * Retrieves a unit by its ID.
     * 
     * @param unitID the ID of the unit to retrieve
     * @return the Unit object with the specified ID
     */
    public Unit getUnit(int unitID) {
        return units.get(unitID);
    }

    /**
     * Retrieves the list of all units.
     * 
     * @return an ArrayList of Unit objects
     */
    public ArrayList<Unit> getUnits() {
        return units;
    }

    /**
     * Gets the total number of units.
     * 
     * @return the total number of units.
     */
    public int getTotalUnits() {
        return units.size();
    }

    /**
     * Retrieves a lesson by its ID.
     * 
     * @param lessonID the ID of the lesson to retrieve
     * @return the Lesson object with the specified ID
     */
    public Lesson getLesson(int lessonID) {
        return lessons.get(lessonID);
    }

    /**
     * Retrieves the list of all lessons.
     * 
     * @return an ArrayList of Lesson objects
     */
    public ArrayList<Lesson> getLessons() {
        return lessons;
    }

    /**
     * Retrieves a drill by its ID.
     * 
     * @param drillID the ID of the lesson to retrieve
     * @return the Drill object with the specified ID
     */
    public Drill getDrill(int drillID) {
        return drills.get(drillID);
    }

    /**
     * Retrieves the list of all drills.
     * 
     * @return an ArrayList of Drill objects
     */
    public ArrayList<Drill> getDrills() {
        return drills;
    }

    /**
     * Initializes the model by setting up units and their respective lessons and
     * drills.
     */
    private void initModel() {
        initializeUnit1();
        initializeUnit2();
    }

    /**
     * Initializes Unit 1 with its lessons and drills.
     */
    private void initializeUnit1() {
        // UNIT 1: Note Identification
        Flashcard[] u1_l1 = new Flashcard[15];
        Flashcard[] u1_l2 = new Flashcard[15];
        Flashcard[] u1_l3 = new Flashcard[20];
        Flashcard[] u1_d1 = new Flashcard[6];

        Lesson[] unit1Lessons = new Lesson[3];
        Drill[] unit1Drills = new Drill[1];

        // Lesson 1: Treble Clef Note Identification
        u1_l1[0] = new Flashcard(0, new int[] { 60 }, new int[] { 0 }, 'T', 'R'); // Middle C
        u1_l1[1] = new Flashcard(1, new int[] { 62 }, new int[] { 2 }, 'T', 'R'); // D
        u1_l1[2] = new Flashcard(2, new int[] { 64 }, new int[] { 4 }, 'T', 'R'); // E
        u1_l1[3] = new Flashcard(3, new int[] { 65 }, new int[] { 5 }, 'T', 'R'); // F
        u1_l1[4] = new Flashcard(4, new int[] { 67 }, new int[] { 7 }, 'T', 'R'); // G
        u1_l1[5] = new Flashcard(5, new int[] { 72 }, new int[] { 12 }, 'T', 'R'); // C
        u1_l1[6] = new Flashcard(6, new int[] { 60 }, new int[] { 7 }, 'T', 'R'); // Middle C
        u1_l1[7] = new Flashcard(7, new int[] { 71 }, new int[] { 11 }, 'T', 'R'); // B
        u1_l1[8] = new Flashcard(8, new int[] { 69 }, new int[] { 9 }, 'T', 'R'); // A
        u1_l1[9] = new Flashcard(9, new int[] { 65 }, new int[] { 5 }, 'T', 'R'); // F
        u1_l1[10] = new Flashcard(10, new int[] { 67 }, new int[] { 7 }, 'T', 'R'); // G
        u1_l1[11] = new Flashcard(11, new int[] { 62 }, new int[] { 2 }, 'T', 'R'); // D
        u1_l1[12] = new Flashcard(12, new int[] { 69 }, new int[] { 9 }, 'T', 'R'); // A
        u1_l1[13] = new Flashcard(13, new int[] { 64 }, new int[] { 4 }, 'T', 'R'); // E
        u1_l1[14] = new Flashcard(14, new int[] { 72 }, new int[] { 12 }, 'T', 'R'); // C

        unit1Lessons[0] = new Lesson(0, "Lesson 1", "Introduction to Treble Clef Note Identification", u1_l1);
        lessons.add(unit1Lessons[0]);

        // Lesson 2: Bass Clef Note Identification
        u1_l2[0] = new Flashcard(0, new int[] { 53 }, new int[] { 5 }, 'B', 'L'); // F
        u1_l2[1] = new Flashcard(1, new int[] { 55 }, new int[] { 7 }, 'B', 'L'); // G
        u1_l2[2] = new Flashcard(2, new int[] { 57 }, new int[] { 9 }, 'B', 'L'); // A
        u1_l2[3] = new Flashcard(3, new int[] { 59 }, new int[] { 11 }, 'B', 'L'); // B
        u1_l2[4] = new Flashcard(4, new int[] { 60 }, new int[] { 0 }, 'B', 'L'); // Middle C
        u1_l2[5] = new Flashcard(5, new int[] { 48 }, new int[] { 12 }, 'B', 'L'); // C
        u1_l2[6] = new Flashcard(6, new int[] { 52 }, new int[] { 2 }, 'B', 'L'); // E
        u1_l2[7] = new Flashcard(7, new int[] { 55 }, new int[] { 0 }, 'B', 'L'); // G
        u1_l2[8] = new Flashcard(8, new int[] { 50 }, new int[] { 7 }, 'B', 'L'); // D
        u1_l2[9] = new Flashcard(9, new int[] { 48 }, new int[] { 5 }, 'B', 'L'); // C
        u1_l2[10] = new Flashcard(10, new int[] { 57 }, new int[] { 12 }, 'B', 'L'); // A
        u1_l2[11] = new Flashcard(11, new int[] { 59 }, new int[] { 9 }, 'B', 'L'); // B
        u1_l2[12] = new Flashcard(12, new int[] { 53 }, new int[] { 3 }, 'B', 'L'); // F
        u1_l2[13] = new Flashcard(13, new int[] { 43 }, new int[] { 2 }, 'B', 'L'); // G
        u1_l2[14] = new Flashcard(14, new int[] { 47 }, new int[] { 0 }, 'B', 'L'); // B

        unit1Lessons[1] = new Lesson(1, "Lesson 2", "Bass Clef Note Identification", u1_l2);
        lessons.add(unit1Lessons[1]);

        // Lesson 3: Mixed Treble and Bass Clef Notes
        u1_l3[0] = new Flashcard(0, new int[] { 60 }, new int[] { 0 }, 'T', 'R'); // Middle C (Treble)
        u1_l3[1] = new Flashcard(1, new int[] { 57 }, new int[] { 0 }, 'T', 'R'); // A (Treble)
        u1_l3[2] = new Flashcard(2, new int[] { 52 }, new int[] { 4 }, 'B', 'L'); // E (Bass)
        u1_l3[3] = new Flashcard(3, new int[] { 47 }, new int[] { 3 }, 'B', 'L'); // B (Bass)
        u1_l3[4] = new Flashcard(4, new int[] { 65 }, new int[] { 7 }, 'T', 'R'); // F (Treble)
        u1_l3[5] = new Flashcard(5, new int[] { 74 }, new int[] { 5 }, 'T', 'R'); // D (Treble)
        u1_l3[6] = new Flashcard(6, new int[] { 60 }, new int[] { 0 }, 'B', 'L'); // Middle C (Bass) //
        u1_l3[7] = new Flashcard(7, new int[] { 45 }, new int[] { 0 }, 'B', 'L'); // A (Bass)
        u1_l3[8] = new Flashcard(8, new int[] { 76 }, new int[] { 4 }, 'T', 'R'); // E (Treble)
        u1_l3[9] = new Flashcard(9, new int[] { 79 }, new int[] { 3 }, 'T', 'R'); // G (Treble)
        u1_l3[10] = new Flashcard(10, new int[] { 59 }, new int[] { 7 }, 'T', 'R'); // B (Bass)
        u1_l3[11] = new Flashcard(11, new int[] { 40 }, new int[] { 5 }, 'B', 'L'); // E (Bass)
        u1_l3[12] = new Flashcard(12, new int[] { 60 }, new int[] { 0 }, 'T', 'R'); // Middle C (Treble)
        u1_l3[13] = new Flashcard(13, new int[] { 43 }, new int[] { 0 }, 'B', 'L'); // F (Bass)
        u1_l3[14] = new Flashcard(14, new int[] { 64 }, new int[] { 4 }, 'T', 'R'); // E (Treble)
        u1_l3[15] = new Flashcard(15, new int[] { 46 }, new int[] { 3 }, 'B', 'L'); // A (Bass)
        u1_l3[16] = new Flashcard(16, new int[] { 67 }, new int[] { 7 }, 'T', 'R'); // G (Treble)
        u1_l3[17] = new Flashcard(17, new int[] { 48 }, new int[] { 5 }, 'B', 'L'); // C (Bass)
        u1_l3[18] = new Flashcard(18, new int[] { 60 }, new int[] { 0 }, 'T', 'R'); // Middle C (Treble)
        u1_l3[19] = new Flashcard(19, new int[] { 43 }, new int[] { 0 }, 'B', 'L'); // F (Bass)

        unit1Lessons[2] = new Lesson(2, "Lesson 3", "Mixed Treble and Bass Clef Notes", u1_l3);
        lessons.add(unit1Lessons[2]);

        // Drill 1: Mixed Clefs
        u1_d1[0] = new Flashcard(0, new int[] { 60 }, new int[] { 0 }, 'T', 'R'); // Middle C
        u1_d1[1] = new Flashcard(0, new int[] { 64 }, new int[] { 4 }, 'T', 'R'); // E
        u1_d1[2] = new Flashcard(0, new int[] { 67 }, new int[] { 7 }, 'T', 'R'); // G
        u1_d1[3] = new Flashcard(0, new int[] { 43 }, new int[] { 0 }, 'B', 'L'); // F
        u1_d1[4] = new Flashcard(0, new int[] { 46 }, new int[] { 3 }, 'B', 'L'); // A
        u1_d1[5] = new Flashcard(0, new int[] { 48 }, new int[] { 5 }, 'B', 'L'); // C
        unit1Drills[0] = new Drill(0, "Drill 1", "Mixed Clef Drill", u1_d1, 180);
        drills.add(unit1Drills[0]);

        Unit unit1 = new Unit(1, "Unit 1", "Note Identification", unit1Lessons, unit1Drills);
        units.add(unit1);
    }

    /**
     * Initializes Unit 2 with its lessons and drills.
     */
    private void initializeUnit2() {
        // UNIT 2: Chord Identification
        Flashcard[] u2_l1 = new Flashcard[3];
        Flashcard[] u2_l2 = new Flashcard[3];
        Flashcard[] u2_l3 = new Flashcard[4];
        Flashcard[] u2_d1 = new Flashcard[4];

        Lesson[] unit2Lessons = new Lesson[3];
        Drill[] unit2Drills = new Drill[1];

        // Lesson 1: Major Chord Identification
        u2_l1[0] = new Flashcard(0, new int[] { 60, 64, 67 }, new int[] { 0, 4, 7 }, 'T', 'R'); // C Major
        u2_l1[1] = new Flashcard(0, new int[] { 65, 69, 72 }, new int[] { 5, 9, 0 }, 'T', 'R'); // F Major
        u2_l1[2] = new Flashcard(0, new int[] { 62, 66, 69 }, new int[] { 2, 6, 9 }, 'T', 'R'); // D Major
        unit2Lessons[0] = new Lesson(3, "Lesson 1", "Major Chord Identification", u2_l1);
        lessons.add(unit2Lessons[0]);

        // Lesson 2: Minor Chord Identification
        u2_l2[0] = new Flashcard(0, new int[] { 60, 63, 67 }, new int[] { 0, 3, 7 }, 'T', 'R'); // C Minor
        u2_l2[1] = new Flashcard(0, new int[] { 65, 68, 72 }, new int[] { 5, 8, 0 }, 'T', 'R'); // F Minor
        u2_l2[2] = new Flashcard(0, new int[] { 62, 65, 69 }, new int[] { 2, 5, 9 }, 'T', 'R'); // D Minor
        unit2Lessons[1] = new Lesson(4, "Lesson 2", "Minor Chord Identification", u2_l2);
        lessons.add(unit2Lessons[1]);

        // Lesson 3: Mixed Chords
        u2_l3[0] = u2_l1[0]; // C Major
        u2_l3[1] = u2_l2[0]; // C Minor
        u2_l3[2] = u2_l1[1]; // F Major
        u2_l3[3] = u2_l2[1]; // F Minor
        unit2Lessons[2] = new Lesson(5, "Lesson 3", "Mixed Chords", u2_l3);
        lessons.add(unit2Lessons[2]);

        // Drill 1: Mixed Major and Minor Chords
        u2_d1[0] = u2_l1[0];
        u2_d1[1] = u2_l2[0];
        u2_d1[2] = u2_l1[1];
        u2_d1[3] = u2_l2[1];
        unit2Drills[0] = new Drill(1, "Drill 1", "Mixed Chord Drill", u2_d1, 180);
        drills.add(unit2Drills[0]);

        Unit unit2 = new Unit(2, "Unit 2", "Chord Identification", unit2Lessons, unit2Drills);
        units.add(unit2);
    }
}
