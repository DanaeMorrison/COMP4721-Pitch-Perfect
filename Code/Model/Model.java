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
        initializeUnit3();
        initializeUnit4();
    }

    /**
     * Initializes Unit 1 with its lessons and drills.
     */
    private void initializeUnit1() {
        // UNIT 1: Note Identification
        Flashcard[] u1_l1 = new Flashcard[15];
        Flashcard[] u1_l2 = new Flashcard[15];
        Flashcard[] u1_l3 = new Flashcard[20];
        Flashcard[] u1_d1 = new Flashcard[20];

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
        u1_l3[1] = new Flashcard(1, new int[] { 69 }, new int[] { 0 }, 'T', 'R'); // A (Treble)
        u1_l3[2] = new Flashcard(2, new int[] { 52 }, new int[] { 4 }, 'B', 'L'); // E (Bass)
        u1_l3[3] = new Flashcard(3, new int[] { 47 }, new int[] { 3 }, 'B', 'L'); // B (Bass)
        u1_l3[4] = new Flashcard(4, new int[] { 65 }, new int[] { 7 }, 'T', 'R'); // F (Treble)
        u1_l3[5] = new Flashcard(5, new int[] { 74 }, new int[] { 5 }, 'T', 'R'); // D (Treble)
        u1_l3[6] = new Flashcard(6, new int[] { 60 }, new int[] { 0 }, 'B', 'L'); // Middle C (Bass) //
        u1_l3[7] = new Flashcard(7, new int[] { 45 }, new int[] { 0 }, 'B', 'L'); // A (Bass)
        u1_l3[8] = new Flashcard(8, new int[] { 76 }, new int[] { 4 }, 'T', 'R'); // E (Treble)
        u1_l3[9] = new Flashcard(9, new int[] { 79 }, new int[] { 3 }, 'T', 'R'); // G (Treble)
        u1_l3[10] = new Flashcard(10, new int[] { 59 }, new int[] { 7 }, 'B', 'L'); // B (Bass)
        u1_l3[11] = new Flashcard(11, new int[] { 40 }, new int[] { 5 }, 'B', 'L'); // E (Bass)
        u1_l3[12] = new Flashcard(12, new int[] { 60 }, new int[] { 0 }, 'T', 'R'); // Middle C (Treble)
        u1_l3[13] = new Flashcard(13, new int[] { 43 }, new int[] { 0 }, 'B', 'L'); // F (Bass)
        u1_l3[14] = new Flashcard(14, new int[] { 64 }, new int[] { 4 }, 'T', 'R'); // E (Treble)
        u1_l3[15] = new Flashcard(15, new int[] { 47 }, new int[] { 3 }, 'B', 'L'); // A (Bass)
        u1_l3[16] = new Flashcard(16, new int[] { 67 }, new int[] { 7 }, 'T', 'R'); // G (Treble)
        u1_l3[17] = new Flashcard(17, new int[] { 48 }, new int[] { 5 }, 'B', 'L'); // C (Bass)
        u1_l3[18] = new Flashcard(18, new int[] { 60 }, new int[] { 0 }, 'T', 'R'); // Middle C (Treble)
        u1_l3[19] = new Flashcard(19, new int[] { 43 }, new int[] { 0 }, 'B', 'L'); // F (Bass)

        unit1Lessons[2] = new Lesson(2, "Lesson 3", "Mixed Treble and Bass Clef Notes", u1_l3);
        lessons.add(unit1Lessons[2]);

        // Drill 1: Mixed Clefs - Manually assigning flashcards
        u1_d1[0] = u1_l1[0]; // Middle C (Treble)
        u1_d1[1] = u1_l1[2]; // E (Treble)
        u1_d1[2] = u1_l1[4]; // G (Treble)
        u1_d1[3] = u1_l1[5]; // High C (Treble)
        u1_d1[4] = u1_l1[8]; // A (Treble)
        u1_d1[5] = u1_l2[0]; // F (Bass)
        u1_d1[6] = u1_l2[1]; // G (Bass)
        u1_d1[7] = u1_l2[3]; // B (Bass)
        u1_d1[8] = u1_l2[6]; // E (Bass)
        u1_d1[9] = u1_l2[8]; // D (Bass)
        u1_d1[10] = u1_l3[1]; // A (Mixed - Treble)
        u1_d1[11] = u1_l3[3]; // B (Mixed - Bass)
        u1_d1[12] = u1_l3[4]; // F (Mixed - Treble)
        u1_d1[13] = u1_l3[6]; // Middle C (Mixed - Bass)
        u1_d1[14] = u1_l3[8]; // E (Mixed - Treble)
        u1_d1[15] = u1_l3[10]; // B (Mixed - Treble)
        u1_d1[16] = u1_l3[12]; // Middle C (Mixed - Treble)
        u1_d1[17] = u1_l3[14]; // E (Mixed - Treble)
        u1_d1[18] = u1_l3[16]; // G (Mixed - Treble)
        u1_d1[19] = u1_l3[19]; // F (Mixed - Bass)

        unit1Drills[0] = new Drill(0, "Drill 1", "Mixed Clef Drill", u1_d1, 180);
        drills.add(unit1Drills[0]);

        Unit unit1 = new Unit(1, "Unit 1", "Note Identification", unit1Lessons, unit1Drills);
        units.add(unit1);
    }

    private void initializeUnit2() {
        // UNIT 2: Note Identification with Sharps
        Flashcard[] u2_l1 = new Flashcard[15]; // Lesson 1: Treble Clef (1 & 2 notes with sharps)
        Flashcard[] u2_l2 = new Flashcard[15]; // Lesson 2: Bass Clef (1 & 2 notes with sharps)
        Flashcard[] u2_l3 = new Flashcard[20]; // Lesson 3: Mixed Clef (1 & 2 notes with sharps)
        Flashcard[] u2_d1 = new Flashcard[20]; // Drill: Mixed Clef Drill

        Lesson[] unit2Lessons = new Lesson[3];
        Drill[] unit2Drills = new Drill[1];

        // Lesson 1: Treble Clef (Sharps only, single and double notes)
        u2_l1[0] = new Flashcard(0, new int[] { 61 }, new int[] { 1 }, 'T', 'R'); // C#
        u2_l1[1] = new Flashcard(1, new int[] { 63 }, new int[] { 3 }, 'T', 'R'); // D#
        u2_l1[2] = new Flashcard(2, new int[] { 66 }, new int[] { 6 }, 'T', 'R'); // F#
        u2_l1[3] = new Flashcard(3, new int[] { 68 }, new int[] { 8 }, 'T', 'R'); // G#
        u2_l1[4] = new Flashcard(4, new int[] { 70 }, new int[] { 10 }, 'T', 'R'); // A#
        u2_l1[5] = new Flashcard(5, new int[] { 73 }, new int[] { 1 }, 'T', 'R'); // C#
        u2_l1[6] = new Flashcard(6, new int[] { 75 }, new int[] { 3 }, 'T', 'R'); // D#
        u2_l1[7] = new Flashcard(7, new int[] { 78 }, new int[] { 6 }, 'T', 'R'); // F#
        u2_l1[8] = new Flashcard(8, new int[] { 80 }, new int[] { 8 }, 'T', 'R'); // G#
        u2_l1[9] = new Flashcard(9, new int[] { 82 }, new int[] { 10 }, 'T', 'R'); // A#
        u2_l1[10] = new Flashcard(10, new int[] { 61, 66 }, new int[] { 1, 6 }, 'T', 'R'); // C#, F#
        u2_l1[11] = new Flashcard(11, new int[] { 68, 70 }, new int[] { 8, 10 }, 'T', 'R'); // G#, A#
        u2_l1[12] = new Flashcard(12, new int[] { 63, 66 }, new int[] { 3, 6 }, 'T', 'R'); // D#, F#
        u2_l1[13] = new Flashcard(13, new int[] { 73, 78 }, new int[] { 1, 6 }, 'T', 'R'); // C#, F#
        u2_l1[14] = new Flashcard(14, new int[] { 75, 80 }, new int[] { 3, 8 }, 'T', 'R'); // D#, G#

        unit2Lessons[0] = new Lesson(3, "Lesson 1", "Treble Clef Note Identification with Sharps", u2_l1);
        lessons.add(unit2Lessons[0]);

        // Lesson 2: Bass Clef (Sharps only, single and double notes)
        u2_l2[0] = new Flashcard(0, new int[] { 49 }, new int[] { 1 }, 'B', 'L'); // C#
        u2_l2[1] = new Flashcard(1, new int[] { 51 }, new int[] { 3 }, 'B', 'L'); // D#
        u2_l2[2] = new Flashcard(2, new int[] { 54 }, new int[] { 6 }, 'B', 'L'); // F#
        u2_l2[3] = new Flashcard(3, new int[] { 56 }, new int[] { 8 }, 'B', 'L'); // G#
        u2_l2[4] = new Flashcard(4, new int[] { 58 }, new int[] { 10 }, 'B', 'L'); // A#
        u2_l2[5] = new Flashcard(5, new int[] { 61 }, new int[] { 1 }, 'B', 'L'); // C#
        u2_l2[6] = new Flashcard(6, new int[] { 63 }, new int[] { 3 }, 'B', 'L'); // D#
        u2_l2[7] = new Flashcard(7, new int[] { 66 }, new int[] { 6 }, 'B', 'L'); // F#
        u2_l2[8] = new Flashcard(8, new int[] { 68 }, new int[] { 8 }, 'B', 'L'); // G#
        u2_l2[9] = new Flashcard(9, new int[] { 70 }, new int[] { 10 }, 'B', 'L'); // A#
        u2_l2[10] = new Flashcard(10, new int[] { 49, 54 }, new int[] { 1, 6 }, 'B', 'L'); // C#, F#
        u2_l2[11] = new Flashcard(11, new int[] { 56, 58 }, new int[] { 8, 10 }, 'B', 'L'); // G#, A#
        u2_l2[12] = new Flashcard(12, new int[] { 51, 54 }, new int[] { 3, 6 }, 'B', 'L'); // D#, F#
        u2_l2[13] = new Flashcard(13, new int[] { 61, 66 }, new int[] { 1, 6 }, 'B', 'L'); // C#, F#
        u2_l2[14] = new Flashcard(14, new int[] { 63, 68 }, new int[] { 3, 8 }, 'B', 'L'); // D#, G#

        unit2Lessons[1] = new Lesson(4, "Lesson 2", "Bass Clef Note Identification with Sharps", u2_l2);
        lessons.add(unit2Lessons[1]);

        // Lesson 3: Mixed Clef (Sharps only, single and double notes)
        for (int i = 0; i < 10; i++) {
            u2_l3[i] = u2_l1[i];
            u2_l3[i + 10] = u2_l2[i];
        }
        unit2Lessons[2] = new Lesson(5, "Lesson 3", "Mixed Clef Note Identification with Sharps", u2_l3);
        lessons.add(unit2Lessons[2]);

        // Drill 1: Mixed Clef Drill (Sharps only, 20 questions)
        u2_d1[0] = u2_l1[0];
        u2_d1[1] = u2_l1[2];
        u2_d1[2] = u2_l1[4];
        u2_d1[3] = u2_l1[6];
        u2_d1[4] = u2_l1[8];
        u2_d1[5] = u2_l2[1];
        u2_d1[6] = u2_l2[3];
        u2_d1[7] = u2_l2[5];
        u2_d1[8] = u2_l2[7];
        u2_d1[9] = u2_l2[9];
        u2_d1[10] = u2_l3[0];
        u2_d1[11] = u2_l3[2];
        u2_d1[12] = u2_l3[4];
        u2_d1[13] = u2_l3[6];
        u2_d1[14] = u2_l3[8];
        u2_d1[15] = u2_l3[10];
        u2_d1[16] = u2_l3[12];
        u2_d1[17] = u2_l3[14];
        u2_d1[18] = u2_l3[16];
        u2_d1[19] = u2_l3[18];

        unit2Drills[0] = new Drill(1, "Drill 1", "Mixed Clef Drill with Sharps", u2_d1, 180);
        drills.add(unit2Drills[0]);

        Unit unit2 = new Unit(2, "Unit 2", "Note Identification with Sharps", unit2Lessons, unit2Drills);
        units.add(unit2);
    }

    private void initializeUnit3() {
        // UNIT 3: Chord Identification
        Flashcard[] u3_l1 = new Flashcard[15]; // Lesson 1: Major Chords
        Flashcard[] u3_l2 = new Flashcard[15]; // Lesson 2: Minor Chords
        Flashcard[] u3_l3 = new Flashcard[20]; // Lesson 3: Mixed Major and Minor Chords
        Flashcard[] u3_d1 = new Flashcard[20]; // Drill: Combination of Major, Minor, and Mixed Triads

        Lesson[] unit3Lessons = new Lesson[3];
        Drill[] unit3Drills = new Drill[1];

        // Lesson 1: Major Chords
        u3_l1[0] = new Flashcard(0, new int[] { 60, 64, 67 }, new int[] { 1, 5, 8 }, 'T', 'R'); // C Major
        u3_l1[1] = new Flashcard(1, new int[] { 62, 66, 69 }, new int[] { 2, 6, 9 }, 'T', 'R'); // D Major
        u3_l1[2] = new Flashcard(2, new int[] { 64, 68, 71 }, new int[] { 4, 8, 11 }, 'T', 'R'); // E Major
        u3_l1[3] = new Flashcard(3, new int[] { 65, 69, 72 }, new int[] { 5, 9, 1 }, 'T', 'R'); // F Major
        u3_l1[4] = new Flashcard(4, new int[] { 67, 71, 74 }, new int[] { 8, 11, 2 }, 'T', 'R'); // G Major
        u3_l1[5] = new Flashcard(5, new int[] { 69, 73, 76 }, new int[] { 9, 1, 4 }, 'T', 'R'); // A Major
        u3_l1[6] = new Flashcard(6, new int[] { 71, 75, 78 }, new int[] { 11, 3, 6 }, 'T', 'R'); // B Major
        u3_l1[7] = new Flashcard(7, new int[] { 48, 52, 55 }, new int[] { 1, 5, 8 }, 'B', 'L'); // C Major
        u3_l1[8] = new Flashcard(8, new int[] { 50, 54, 57 }, new int[] { 2, 6, 9 }, 'B', 'L'); // D Major
        u3_l1[9] = new Flashcard(9, new int[] { 52, 56, 59 }, new int[] { 4, 8, 11 }, 'B', 'L'); // E Major
        u3_l1[10] = new Flashcard(10, new int[] { 53, 57, 60 }, new int[] { 5, 9, 1 }, 'B', 'L'); // F Major
        u3_l1[11] = new Flashcard(11, new int[] { 43, 47, 50 }, new int[] { 8, 11, 2 }, 'B', 'L'); // G Major
        u3_l1[12] = new Flashcard(12, new int[] { 45, 49, 52 }, new int[] { 9, 1, 4 }, 'B', 'L'); // A Major
        u3_l1[13] = new Flashcard(13, new int[] { 47, 51, 54 }, new int[] { 11, 3, 6 }, 'B', 'L'); // B Major
        u3_l1[14] = new Flashcard(14, new int[] { 60, 64, 67 }, new int[] { 1, 5, 8 }, 'T', 'R'); // C Major

        unit3Lessons[0] = new Lesson(6, "Lesson 1", "Major Chords Identification", u3_l1);
        lessons.add(unit3Lessons[0]);

        // Lesson 2: Minor Chords
        u3_l2[0] = new Flashcard(0, new int[] { 60, 63, 67 }, new int[] { 1, 4, 8 }, 'T', 'R'); // C Minor
        u3_l2[1] = new Flashcard(1, new int[] { 62, 65, 69 }, new int[] { 2, 5, 9 }, 'T', 'R'); // D Minor
        u3_l2[2] = new Flashcard(2, new int[] { 64, 67, 71 }, new int[] { 4, 7, 11 }, 'T', 'R'); // E Minor
        u3_l2[3] = new Flashcard(3, new int[] { 65, 68, 72 }, new int[] { 5, 8, 1 }, 'T', 'R'); // F Minor
        u3_l2[4] = new Flashcard(4, new int[] { 67, 70, 74 }, new int[] { 8, 10, 2 }, 'T', 'R'); // G Minor
        u3_l2[5] = new Flashcard(5, new int[] { 69, 72, 76 }, new int[] { 9, 12, 4 }, 'T', 'R'); // A Minor
        u3_l2[6] = new Flashcard(6, new int[] { 71, 74, 78 }, new int[] { 11, 2, 6 }, 'T', 'R'); // B Minor
        u3_l2[7] = new Flashcard(7, new int[] { 48, 51, 55 }, new int[] { 1, 4, 8 }, 'B', 'L'); // C Minor
        u3_l2[8] = new Flashcard(8, new int[] { 50, 53, 57 }, new int[] { 2, 5, 9 }, 'B', 'L'); // D Minor
        u3_l2[9] = new Flashcard(9, new int[] { 52, 55, 59 }, new int[] { 4, 7, 11 }, 'B', 'L'); // E Minor
        u3_l2[10] = new Flashcard(10, new int[] { 53, 56, 60 }, new int[] { 5, 8, 1 }, 'B', 'L'); // F Minor
        u3_l2[11] = new Flashcard(11, new int[] { 43, 46, 50 }, new int[] { 8, 10, 2 }, 'B', 'L'); // G Minor
        u3_l2[12] = new Flashcard(13, new int[] { 47, 50, 54 }, new int[] { 11, 2, 6 }, 'B', 'L'); // B Minor
        u3_l2[13] = new Flashcard(12, new int[] { 45, 48, 52 }, new int[] { 9, 12, 4 }, 'B', 'L'); // A Minor
        u3_l2[14] = new Flashcard(14, new int[] { 60, 63, 67 }, new int[] { 1, 4, 8 }, 'T', 'R'); // C Minor

        unit3Lessons[1] = new Lesson(7, "Lesson 2", "Minor Chords Identification", u3_l2);
        lessons.add(unit3Lessons[1]);

        // Lesson 3: Mixed Major and Minor Chords
        for (int i = 0; i < 10; i++) {
            u3_l3[i] = u3_l1[i];
            u3_l3[i + 10] = u3_l2[i];
        }

        unit3Lessons[2] = new Lesson(8, "Lesson 3", "Mixed Chords Identification", u3_l3);
        lessons.add(unit3Lessons[2]);

        // Drill: Combination of Major, Minor, and Mixed Triads
        u3_d1[0] = u3_l1[0]; // C Major
        u3_d1[1] = u3_l1[3]; // G Major
        u3_d1[2] = u3_l2[1]; // A Minor
        u3_d1[3] = u3_l2[4]; // E Minor
        u3_d1[4] = u3_l3[0]; // F Major
        u3_d1[5] = u3_l3[3]; // D Minor
        u3_d1[6] = u3_l1[5]; // D Major
        u3_d1[7] = u3_l1[7]; // E Major
        u3_d1[8] = u3_l2[7]; // G Minor
        u3_d1[9] = u3_l2[9]; // B Minor
        u3_d1[10] = u3_l3[1]; // A Major
        u3_d1[11] = u3_l3[4]; // C Minor
        u3_d1[12] = u3_l1[2]; // F Major
        u3_d1[13] = u3_l1[8]; // A Major
        u3_d1[14] = u3_l2[3]; // F Minor
        u3_d1[15] = u3_l2[5]; // D Minor
        u3_d1[16] = u3_l3[2]; // G Major
        u3_d1[17] = u3_l3[5]; // B Minor
        u3_d1[18] = u3_l2[6]; // E Minor
        u3_d1[19] = u3_l1[6]; // B Major

        unit3Drills[0] = new Drill(2, "Drill 1", "Major and Minor Triads Drill", u3_d1, 240);
        drills.add(unit3Drills[0]);

        Unit unit3 = new Unit(3, "Unit 3", "Chord Identification", unit3Lessons, unit3Drills);
        units.add(unit3);
    }

    private void initializeUnit4() {
        // UNIT 4: Triad Inversions and Root Position 7th Chords
        Flashcard[] u4_l1 = new Flashcard[15]; // Lesson 1: Triad Inversions
        Flashcard[] u4_l2 = new Flashcard[15]; // Lesson 2: Root Position 7th Chords
        Flashcard[] u4_l3 = new Flashcard[20]; // Lesson 3: Mixed Inversions and 7th Chords
        Flashcard[] u4_d1 = new Flashcard[20]; // Drill: Combination of all

        Lesson[] unit4Lessons = new Lesson[3];
        Drill[] unit4Drills = new Drill[1];

        // Lesson 1: Triad Inversions
        u4_l1[0] = new Flashcard(0, new int[] { 60, 64, 67 }, new int[] { 0, 4, 7 }, 'T', 'R'); // C Major Root
        u4_l1[1] = new Flashcard(1, new int[] { 64, 67, 72 }, new int[] { 4, 7, 12 }, 'T', 'R'); // C Major 1st Inv
        u4_l1[2] = new Flashcard(2, new int[] { 67, 72, 76 }, new int[] { 7, 12, 16 }, 'T', 'R'); // C Major 2nd Inv
        u4_l1[3] = new Flashcard(3, new int[] { 65, 69, 72 }, new int[] { 5, 9, 0 }, 'T', 'R'); // F Major Root
        u4_l1[4] = new Flashcard(4, new int[] { 69, 72, 77 }, new int[] { 9, 0, 4 }, 'T', 'R'); // F Major 1st Inv
        u4_l1[5] = new Flashcard(5, new int[] { 72, 77, 81 }, new int[] { 0, 4, 7 }, 'T', 'R'); // F Major 2nd Inv
        u4_l1[6] = new Flashcard(6, new int[] { 62, 65, 69 }, new int[] { 2, 5, 9 }, 'T', 'R'); // D Minor Root
        u4_l1[7] = new Flashcard(7, new int[] { 65, 69, 74 }, new int[] { 5, 9, 14 }, 'T', 'R'); // D Minor 1st Inv
        u4_l1[8] = new Flashcard(8, new int[] { 69, 74, 78 }, new int[] { 9, 14, 17 }, 'T', 'R'); // D Minor 2nd Inv
        u4_l1[9] = new Flashcard(9, new int[] { 67, 70, 74 }, new int[] { 7, 10, 14 }, 'T', 'R'); // G Minor Root
        u4_l1[10] = new Flashcard(10, new int[] { 70, 74, 79 }, new int[] { 10, 14, 19 }, 'T', 'R'); // G Minor 1st Inv
        u4_l1[11] = new Flashcard(11, new int[] { 74, 79, 71 }, new int[] { 14, 19, 22 }, 'T', 'R'); // G Minor 2nd Inv
        u4_l1[12] = new Flashcard(12, new int[] { 61, 65, 68 }, new int[] { 1, 5, 8 }, 'T', 'R'); // Bb Major Root
        u4_l1[13] = new Flashcard(13, new int[] { 65, 68, 73 }, new int[] { 5, 8, 13 }, 'T', 'R'); // Bb Major 1st Inv
        u4_l1[14] = new Flashcard(14, new int[] { 68, 73, 77 }, new int[] { 8, 13, 17 }, 'T', 'R'); // Bb Major 2nd Inv

        unit4Lessons[0] = new Lesson(9, "Lesson 1", "Triad Inversions", u4_l1);
        lessons.add(unit4Lessons[0]);

        // Lesson 2: Root Position 7th Chords
        u4_l2[0] = new Flashcard(0, new int[] { 60, 64, 67, 71 }, new int[] { 0, 4, 7, 11 }, 'T', 'R'); // C Major 7th
        u4_l2[1] = new Flashcard(1, new int[] { 62, 65, 69, 72 }, new int[] { 2, 5, 9, 12 }, 'T', 'R'); // D Minor 7th
        u4_l2[2] = new Flashcard(2, new int[] { 65, 69, 72, 76 }, new int[] { 5, 9, 0, 4 }, 'T', 'R'); // F Major 7th
        u4_l2[3] = new Flashcard(3, new int[] { 67, 71, 74, 77 }, new int[] { 7, 11, 14, 17 }, 'T', 'R'); // G Dominant
                                                                                                          // 7th
        u4_l2[4] = new Flashcard(4, new int[] { 59 + 12, 62, 65, 69 }, new int[] { 11, 2, 5, 9 }, 'T', 'R'); // B
                                                                                                             // Diminished
                                                                                                             // 7th
        u4_l2[5] = new Flashcard(5, new int[] { 61, 65, 68, 72 }, new int[] { 1, 5, 8, 12 }, 'T', 'R'); // Bb Major 7th
        u4_l2[6] = new Flashcard(6, new int[] { 64, 67, 71, 74 }, new int[] { 4, 7, 11, 14 }, 'T', 'R'); // E Dominant
                                                                                                         // 7th
        u4_l2[7] = new Flashcard(7, new int[] { 60, 63, 67, 71 }, new int[] { 0, 3, 7, 11 }, 'T', 'R'); // C Minor 7th
        u4_l2[8] = new Flashcard(8, new int[] { 62, 66, 69, 72 }, new int[] { 2, 6, 9, 12 }, 'T', 'R'); // D
                                                                                                        // Half-Diminished
                                                                                                        // 7th
        u4_l2[9] = new Flashcard(9, new int[] { 65, 68, 72, 76 }, new int[] { 5, 8, 12, 16 }, 'T', 'R'); // F Minor 7th
        u4_l2[10] = new Flashcard(10, new int[] { 67, 71, 74, 77 }, new int[] { 7, 11, 14, 17 }, 'T', 'R'); // G
                                                                                                            // Dominant
                                                                                                            // 7th
        u4_l2[11] = new Flashcard(11, new int[] { 71, 63, 66, 69 }, new int[] { 11, 3, 6, 9 }, 'T', 'R'); // B
                                                                                                               // Half-Diminished
                                                                                                               // 7th
        u4_l2[12] = new Flashcard(12, new int[] { 61, 65, 68, 72 }, new int[] { 1, 5, 8, 12 }, 'T', 'R'); // Bb Major
                                                                                                          // 7th
        u4_l2[13] = new Flashcard(13, new int[] { 64, 68, 71, 74 }, new int[] { 4, 8, 11, 14 }, 'T', 'R'); // E
                                                                                                           // Half-Diminished
                                                                                                           // 7th
        u4_l2[14] = new Flashcard(14, new int[] { 60, 64, 67, 71 }, new int[] { 0, 4, 7, 11 }, 'T', 'R'); // C Major 7th

        unit4Lessons[1] = new Lesson(10, "Lesson 2", "Root Position 7th Chords", u4_l2);
        lessons.add(unit4Lessons[1]);

        // Lesson 3: Mixed Inversions and Root Position 7th Chords
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0)
                u4_l3[i] = u4_l1[i % 15];
            else
                u4_l3[i] = u4_l2[i % 15];
        }

        unit4Lessons[2] = new Lesson(11, "Lesson 3", "Mixed Inversions and 7th Chords", u4_l3);
        lessons.add(unit4Lessons[2]);

        // Drill: Combination of all
        u4_d1[0] = u4_l1[0]; // C Major Root
        u4_d1[1] = u4_l2[1]; // D Minor 7th
        u4_d1[2] = u4_l1[3]; // F Major Root
        u4_d1[3] = u4_l2[3]; // G Dominant 7th
        u4_d1[4] = u4_l1[6]; // D Minor Root
        u4_d1[5] = u4_l2[5]; // Bb Major 7th
        u4_d1[6] = u4_l1[9]; // G Minor Root
        u4_d1[7] = u4_l2[7]; // C Minor 7th
        u4_d1[8] = u4_l1[12]; // Bb Major Root
        u4_d1[9] = u4_l2[9]; // F Minor 7th
        u4_d1[10] = u4_l1[1]; // C Major 1st Inv
        u4_d1[11] = u4_l2[11]; // B Half-Diminished 7th
        u4_d1[12] = u4_l1[4]; // F Major 1st Inv
        u4_d1[13] = u4_l2[13]; // E Half-Diminished 7th
        u4_d1[14] = u4_l1[7]; // D Minor 1st Inv
        u4_d1[15] = u4_l2[0]; // C Major 7th
        u4_d1[16] = u4_l1[10]; // G Minor 1st Inv
        u4_d1[17] = u4_l2[2]; // F Major 7th
        u4_d1[18] = u4_l1[13]; // Bb Major 1st Inv
        u4_d1[19] = u4_l2[4]; // B Diminished 7th

        unit4Drills[0] = new Drill(3, "Drill 1", "Inversions and 7th Chords Drill", u4_d1, 240);
        drills.add(unit4Drills[0]);

        Unit unit4 = new Unit(4, "Unit 4", "Inversions and Root Position 7th Chords", unit4Lessons, unit4Drills);
        units.add(unit4);
    }

}
