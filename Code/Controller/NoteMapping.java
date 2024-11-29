package Controller;

import java.util.HashMap;

public class NoteMapping {
    // HashMaps to store coordinates and image paths for treble and bass clefs
    private final HashMap<Integer, int[]> trebleClefCoordinates = new HashMap<>();
    private final HashMap<Integer, String> trebleClefImages = new HashMap<>();
    private final HashMap<Integer, int[]> bassClefCoordinates = new HashMap<>();
    private final HashMap<Integer, String> bassClefImages = new HashMap<>();

    public NoteMapping() {
        // Treble Clef MIDI Positions and Image Paths
        trebleClefCoordinates.put(60, new int[] { 615, 745, 528, 658 }); // C4
        trebleClefImages.put(60, "/Assets/NoteOnLedgerLine.png");

        trebleClefCoordinates.put(61, new int[] { 560, 800, 473, 713 }); // C#4
        trebleClefImages.put(61, "/Assets/SharpNoteOnLedgerLine.png");

        trebleClefCoordinates.put(62, new int[] { 615, 745, 496, 626 }); // D4
        trebleClefImages.put(62, "/Assets/NoteBetweenLines.png");

        trebleClefCoordinates.put(63, new int[] { 560, 800, 441, 681 }); // D#4
        trebleClefImages.put(63, "/Assets/SharpNoteBetweenLines.png");

        trebleClefCoordinates.put(64, new int[] { 615, 745, 464, 594 }); // E4
        trebleClefImages.put(64, "/Assets/NoteOnLedgerLine.png");

        trebleClefCoordinates.put(65, new int[] { 615, 745, 432, 562 }); // F4
        trebleClefImages.put(65, "/Assets/NoteBetweenLines.png");

        trebleClefCoordinates.put(66, new int[] { 560, 800, 377, 617 }); // F#4
        trebleClefImages.put(66, "/Assets/SharpNoteBetweenLines.png");

        trebleClefCoordinates.put(67, new int[] { 615, 745, 400, 530 }); // G4
        trebleClefImages.put(67, "/Assets/NoteOnLedgerLine.png");

        trebleClefCoordinates.put(68, new int[] { 560, 800, 345, 585 }); // G#4
        trebleClefImages.put(68, "/Assets/SharpNoteOnLedgerLine.png");

        trebleClefCoordinates.put(69, new int[] { 615, 745, 368, 498 }); // A4
        trebleClefImages.put(69, "/Assets/NoteBetweenLines.png");

        trebleClefCoordinates.put(70, new int[] { 560, 800, 313, 553 }); // A#4
        trebleClefImages.put(70, "/Assets/SharpNoteBetweenLines.png");

        trebleClefCoordinates.put(71, new int[] { 615, 745, 336, 466 }); // B4
        trebleClefImages.put(71, "/Assets/NoteOnLedgerLine.png");

        trebleClefCoordinates.put(72, new int[] { 615, 745, 304, 434 }); // C5
        trebleClefImages.put(72, "/Assets/NoteBetweenLines.png");

        trebleClefCoordinates.put(73, new int[] { 560, 800, 249, 489 }); // C#5
        trebleClefImages.put(73, "/Assets/SharpNoteBetweenLines.png");

        trebleClefCoordinates.put(74, new int[] { 615, 745, 272, 402 }); // D5
        trebleClefImages.put(74, "/Assets/NoteOnLedgerLine.png");

        trebleClefCoordinates.put(75, new int[] { 560, 800, 217, 457 }); // D#5
        trebleClefImages.put(75, "/Assets/SharpNoteOnLedgerLine.png");

        trebleClefCoordinates.put(76, new int[] { 615, 745, 240, 370 }); // E5
        trebleClefImages.put(76, "/Assets/NoteBetweenLines.png");

        trebleClefCoordinates.put(77, new int[] { 615, 745, 208, 338 }); // F5
        trebleClefImages.put(77, "/Assets/NoteOnLedgerLine.png");

        trebleClefCoordinates.put(78, new int[] { 560, 800, 153, 393 }); // F#5
        trebleClefImages.put(78, "/Assets/SharpNoteOnLedgerLine.png");

        trebleClefCoordinates.put(79, new int[] { 615, 745, 176, 306 }); // G5
        trebleClefImages.put(79, "/Assets/NoteBetweenLines.png");

        trebleClefCoordinates.put(80, new int[] { 560, 800, 121, 361 }); // G#5
        trebleClefImages.put(80, "/Assets/SharpNoteBetweenLines.png");

        trebleClefCoordinates.put(81, new int[] { 615, 745, 144, 274 }); // A5
        trebleClefImages.put(81, "/Assets/NoteOnLedgerLine.png");

        trebleClefCoordinates.put(82, new int[] { 560, 800, 89, 329 }); // A#5
        trebleClefImages.put(82, "/Assets/SharpNoteOnLedgerLine.png");

        // Bass Clef MIDI Positions and Image Paths
        bassClefCoordinates.put(40, new int[] { 615, 745, 528, 658 }); // E2
        bassClefImages.put(40, "/Assets/NoteOnLedgerLine.png");

        bassClefCoordinates.put(41, new int[] { 615, 745, 496, 626 }); // F2
        bassClefImages.put(41, "/Assets/NoteBetweenLines.png");

        bassClefCoordinates.put(42, new int[] { 560, 800, 441, 681 }); // F#2
        bassClefImages.put(42, "/Assets/SharpNoteBetweenLines.png");

        bassClefCoordinates.put(43, new int[] { 615, 745, 464, 594 }); // G2
        bassClefImages.put(43, "/Assets/NoteOnLedgerLine.png");

        bassClefCoordinates.put(44, new int[] { 560, 800, 409, 649 }); // G#2
        bassClefImages.put(44, "/Assets/SharpNoteOnLedgerLine.png");

        bassClefCoordinates.put(45, new int[] { 615, 745, 432, 562 }); // A2
        bassClefImages.put(45, "/Assets/NoteBetweenLines.png");

        bassClefCoordinates.put(46, new int[] { 560, 800, 377, 617 }); // A#2
        bassClefImages.put(46, "/Assets/SharpNoteBetweenLines.png");

        bassClefCoordinates.put(47, new int[] { 615, 745, 400, 530 }); // B2
        bassClefImages.put(47, "/Assets/NoteOnLedgerLine.png");

        bassClefCoordinates.put(48, new int[] { 615, 745, 368, 498 }); // C3
        bassClefImages.put(48, "/Assets/NoteBetweenLines.png");

        bassClefCoordinates.put(49, new int[] { 560, 800, 313, 553 }); // C#3
        bassClefImages.put(49, "/Assets/SharpNoteBetweenLines.png");

        bassClefCoordinates.put(50, new int[] { 615, 745, 336, 466 }); // D3
        bassClefImages.put(50, "/Assets/NoteOnLedgerLine.png");

        bassClefCoordinates.put(51, new int[] { 560, 800, 281, 521 }); // D#3
        bassClefImages.put(51, "/Assets/SharpNoteOnLedgerLine.png");

        bassClefCoordinates.put(52, new int[] { 615, 745, 304, 434 }); // E3
        bassClefImages.put(52, "/Assets/NoteBetweenLines.png");

        bassClefCoordinates.put(53, new int[] { 615, 745, 272, 402 }); // F3
        bassClefImages.put(53, "/Assets/NoteOnLedgerLine.png");

        bassClefCoordinates.put(54, new int[] { 560, 800, 217, 457 }); // F#3
        bassClefImages.put(54, "/Assets/SharpNoteOnLedgerLine.png");

        bassClefCoordinates.put(55, new int[] { 615, 745, 240, 370 }); // G3
        bassClefImages.put(55, "/Assets/NoteBetweenLines.png");

        bassClefCoordinates.put(56, new int[] { 560, 800, 185, 425 }); // G#3
        bassClefImages.put(56, "/Assets/SharpNoteBetweenLines.png");

        bassClefCoordinates.put(57, new int[] { 615, 745, 208, 338 }); // A3
        bassClefImages.put(57, "/Assets/NoteOnLedgerLine.png");

        bassClefCoordinates.put(58, new int[] { 560, 800, 153, 393 }); // A#3
        bassClefImages.put(58, "/Assets/SharpNoteOnLedgerLine.png");

        bassClefCoordinates.put(59, new int[] { 615, 745, 176, 306 }); // B3
        bassClefImages.put(59, "/Assets/NoteBetweenLines.png");

        bassClefCoordinates.put(60, new int[] { 615, 745, 144, 274 }); // C4
        bassClefImages.put(60, "/Assets/NoteOnLedgerLine.png");

        bassClefCoordinates.put(61, new int[] { 560, 800, 89, 329 }); // C#4
        bassClefImages.put(61, "/Assets/SharpNoteOnLedgerLine.png");
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
