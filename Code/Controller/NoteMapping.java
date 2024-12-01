/**
 * The NoteMapping class provides a mapping between MIDI values and their corresponding
 * coordinates and image paths for both treble and bass clefs. It uses HashMaps to store
 * these mappings and provides methods to retrieve the coordinates and image paths based
 * on the MIDI value and clef type.
 */
package Controller;

import java.util.HashMap;

public class NoteMapping {
    // HashMaps to store coordinates and image paths for treble and bass clefs
    private final HashMap<Integer, int[]> trebleClefCoordinates = new HashMap<>();
    private final HashMap<Integer, String> trebleClefImages = new HashMap<>();
    private final HashMap<Integer, int[]> bassClefCoordinates = new HashMap<>();
    private final HashMap<Integer, String> bassClefImages = new HashMap<>();

    /**
     * Constructor to initialize the NoteMapping object.
     * Initializes the mappings for treble and bass clefs.
     */
    public NoteMapping() {
        // Treble Clef MIDI Positions and Image Paths
        initializeTrebleClef();
        // Bass Clef MIDI Positions and Image Paths
        initializeBassClef();
    }

    /**
     * Initializes the mappings for the treble clef.
     */
    private void initializeTrebleClef() {
        addTrebleClefMapping(60, new int[] { 615, 745, 528, 658 }, "/Assets/NoteOnLedgerLine.png");
        addTrebleClefMapping(61, new int[] { 560, 800, 473, 713 }, "/Assets/SharpNoteOnLedgerLine.png");
        addTrebleClefMapping(62, new int[] { 615, 745, 496, 626 }, "/Assets/NoteBetweenLines.png");
        addTrebleClefMapping(63, new int[] { 560, 800, 441, 681 }, "/Assets/SharpNoteBetweenLines.png");
        addTrebleClefMapping(64, new int[] { 615, 745, 464, 594 }, "/Assets/NoteOnLedgerLine.png");
        addTrebleClefMapping(65, new int[] { 615, 745, 432, 562 }, "/Assets/NoteBetweenLines.png");
        addTrebleClefMapping(66, new int[] { 560, 800, 377, 617 }, "/Assets/SharpNoteBetweenLines.png");
        addTrebleClefMapping(67, new int[] { 615, 745, 400, 530 }, "/Assets/NoteOnLedgerLine.png");
        addTrebleClefMapping(68, new int[] { 560, 800, 345, 585 }, "/Assets/SharpNoteOnLedgerLine.png");
        addTrebleClefMapping(69, new int[] { 615, 745, 368, 498 }, "/Assets/NoteBetweenLines.png");
        addTrebleClefMapping(70, new int[] { 560, 800, 313, 553 }, "/Assets/SharpNoteBetweenLines.png");
        addTrebleClefMapping(71, new int[] { 615, 745, 336, 466 }, "/Assets/NoteOnLedgerLine.png");
        addTrebleClefMapping(72, new int[] { 615, 745, 304, 434 }, "/Assets/NoteBetweenLines.png");
        addTrebleClefMapping(73, new int[] { 560, 800, 249, 489 }, "/Assets/SharpNoteBetweenLines.png");
        addTrebleClefMapping(74, new int[] { 615, 745, 272, 402 }, "/Assets/NoteOnLedgerLine.png");
        addTrebleClefMapping(75, new int[] { 560, 800, 217, 457 }, "/Assets/SharpNoteOnLedgerLine.png");
        addTrebleClefMapping(76, new int[] { 615, 745, 240, 370 }, "/Assets/NoteBetweenLines.png");
        addTrebleClefMapping(77, new int[] { 615, 745, 208, 338 }, "/Assets/NoteOnLedgerLine.png");
        addTrebleClefMapping(78, new int[] { 560, 800, 153, 393 }, "/Assets/SharpNoteOnLedgerLine.png");
        addTrebleClefMapping(79, new int[] { 615, 745, 176, 306 }, "/Assets/NoteBetweenLines.png");
        addTrebleClefMapping(80, new int[] { 560, 800, 121, 361 }, "/Assets/SharpNoteBetweenLines.png");
        addTrebleClefMapping(81, new int[] { 615, 745, 144, 274 }, "/Assets/NoteOnLedgerLine.png");
        addTrebleClefMapping(82, new int[] { 560, 800, 89, 329 }, "/Assets/SharpNoteOnLedgerLine.png");
    }

    /**
     * Initializes the mappings for the bass clef.
     */
    private void initializeBassClef() {
        addBassClefMapping(40, new int[] { 615, 745, 528, 658 }, "/Assets/NoteOnLedgerLine.png");
        addBassClefMapping(41, new int[] { 615, 745, 496, 626 }, "/Assets/NoteBetweenLines.png");
        addBassClefMapping(42, new int[] { 560, 800, 441, 681 }, "/Assets/SharpNoteBetweenLines.png");
        addBassClefMapping(43, new int[] { 615, 745, 464, 594 }, "/Assets/NoteOnLedgerLine.png");
        addBassClefMapping(44, new int[] { 560, 800, 409, 649 }, "/Assets/SharpNoteOnLedgerLine.png");
        addBassClefMapping(45, new int[] { 615, 745, 432, 562 }, "/Assets/NoteBetweenLines.png");
        addBassClefMapping(46, new int[] { 560, 800, 377, 617 }, "/Assets/SharpNoteBetweenLines.png");
        addBassClefMapping(47, new int[] { 615, 745, 400, 530 }, "/Assets/NoteOnLedgerLine.png");
        addBassClefMapping(48, new int[] { 615, 745, 368, 498 }, "/Assets/NoteBetweenLines.png");
        addBassClefMapping(49, new int[] { 560, 800, 313, 553 }, "/Assets/SharpNoteBetweenLines.png");
        addBassClefMapping(50, new int[] { 615, 745, 336, 466 }, "/Assets/NoteOnLedgerLine.png");
        addBassClefMapping(51, new int[] { 560, 800, 281, 521 }, "/Assets/SharpNoteOnLedgerLine.png");
        addBassClefMapping(52, new int[] { 615, 745, 304, 434 }, "/Assets/NoteBetweenLines.png");
        addBassClefMapping(53, new int[] { 615, 745, 272, 402 }, "/Assets/NoteOnLedgerLine.png");
        addBassClefMapping(54, new int[] { 560, 800, 217, 457 }, "/Assets/SharpNoteOnLedgerLine.png");
        addBassClefMapping(55, new int[] { 615, 745, 240, 370 }, "/Assets/NoteBetweenLines.png");
        addBassClefMapping(56, new int[] { 560, 800, 185, 425 }, "/Assets/SharpNoteBetweenLines.png");
        addBassClefMapping(57, new int[] { 615, 745, 208, 338 }, "/Assets/NoteOnLedgerLine.png");
        addBassClefMapping(58, new int[] { 560, 800, 153, 393 }, "/Assets/SharpNoteOnLedgerLine.png");
        addBassClefMapping(59, new int[] { 615, 745, 176, 306 }, "/Assets/NoteBetweenLines.png");
        addBassClefMapping(60, new int[] { 615, 745, 144, 274 }, "/Assets/NoteOnLedgerLine.png");
        addBassClefMapping(61, new int[] { 560, 800, 89, 329 }, "/Assets/SharpNoteOnLedgerLine.png");
    }

    /**
     * Adds a mapping for a treble clef note.
     *
     * @param midiValue   the MIDI value of the note
     * @param coordinates the coordinates of the note
     * @param imagePath   the image path of the note
     */
    private void addTrebleClefMapping(int midiValue, int[] coordinates, String imagePath) {
        trebleClefCoordinates.put(midiValue, coordinates);
        trebleClefImages.put(midiValue, imagePath);
    }

    /**
     * Adds a mapping for a bass clef note.
     *
     * @param midiValue   the MIDI value of the note
     * @param coordinates the coordinates of the note
     * @param imagePath   the image path of the note
     */
    private void addBassClefMapping(int midiValue, int[] coordinates, String imagePath) {
        bassClefCoordinates.put(midiValue, coordinates);
        bassClefImages.put(midiValue, imagePath);
    }

    /**
     * Retrieves the coordinates for a given MIDI value and clef.
     *
     * @param midiValue the MIDI value of the note
     * @param clef      the clef character ('T' for treble clef, 'B' for bass clef)
     * @return an array of integers representing the coordinates of the note,
     *         or null if the MIDI value is not found or the clef is invalid
     */
    public int[] getCoordinates(int midiValue, char clef) {
        if (clef == 'T') {
            return trebleClefCoordinates.getOrDefault(midiValue, null);
        } else if (clef == 'B') {
            return bassClefCoordinates.getOrDefault(midiValue, null);
        }
        return null; // Invalid clef
    }

    /**
     * Retrieves the image path corresponding to a given MIDI value and clef.
     *
     * @param midiValue the MIDI value of the note
     * @param clef      the clef character ('T' for treble clef, 'B' for bass clef)
     * @return the image path as a String if found, or null if the MIDI value is not
     *         found or the clef is invalid
     */
    public String getImagePath(int midiValue, char clef) {
        if (clef == 'T') {
            return trebleClefImages.getOrDefault(midiValue, null);
        } else if (clef == 'B') {
            return bassClefImages.getOrDefault(midiValue, null);
        }
        return null; // Invalid clef
    }
}
