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
        trebleClefCoordinates.put(0, new int[] { 615, 745, 528, 658 }); // C4
        trebleClefImages.put(0, "/Assets/NoteOnLedgerLine.png");

        trebleClefCoordinates.put(1, new int[] { 615, 745, 528, 658 }); // C#4
        trebleClefImages.put(1, "/Assets/SharpNoteOnLedgerLine.png");

        trebleClefCoordinates.put(2, new int[] { 615, 745, 496, 626 }); // D4
        trebleClefImages.put(2, "/Assets/NoteBetweenLines.png");

        trebleClefCoordinates.put(3, new int[] { 615, 745, 496, 626 }); // D#4
        trebleClefImages.put(3, "/Assets/SharpNoteBetweenLines.png");

        trebleClefCoordinates.put(4, new int[] { 615, 745, 464, 594 }); // E4
        trebleClefImages.put(4, "/Assets/NoteOnLedgerLine.png");

        trebleClefCoordinates.put(5, new int[] { 615, 745, 432, 562 }); // F4
        trebleClefImages.put(5, "/Assets/NoteBetweenLines.png");

        trebleClefCoordinates.put(6, new int[] { 615, 745, 432, 562 }); // F#4
        trebleClefImages.put(6, "/Assets/SharpNoteBetweenLines.png");

        trebleClefCoordinates.put(7, new int[] { 615, 745, 400, 530 }); // G4
        trebleClefImages.put(7, "/Assets/NoteOnLedgerLine.png");

        trebleClefCoordinates.put(8, new int[] { 615, 745, 400, 530 }); // G#4
        trebleClefImages.put(8, "/Assets/SharpNoteOnLedgerLine.png");

        trebleClefCoordinates.put(9, new int[] { 615, 745, 368, 498 }); // A4
        trebleClefImages.put(9, "/Assets/NoteBetweenLines.png");

        trebleClefCoordinates.put(10, new int[] { 615, 745, 368, 498 }); // A#4
        trebleClefImages.put(10, "/Assets/SharpNoteBetweenLines.png");

        trebleClefCoordinates.put(11, new int[] { 615, 745, 336, 466 }); // B4
        trebleClefImages.put(11, "/Assets/NoteOnLedgerLine.png");

        trebleClefCoordinates.put(12, new int[] { 615, 745, 304, 434 }); // C5
        trebleClefImages.put(12, "/Assets/NoteBetweenLines.png");
        
        trebleClefCoordinates.put(13, new int[] { 615, 745, 304, 434 }); // C#5
        trebleClefImages.put(13, "/Assets/SharpNoteBetweenLines.png");
        
        trebleClefCoordinates.put(14, new int[] { 615, 745, 272, 402 }); // D5
        trebleClefImages.put(14, "/Assets/NoteOnLedgerLine.png");
        
        trebleClefCoordinates.put(15, new int[] { 615, 745, 272, 402 }); // D#5
        trebleClefImages.put(15, "/Assets/SharpNoteOnLedgerLine.png");
        
        trebleClefCoordinates.put(16, new int[] { 615, 745, 240, 370 }); // E5
        trebleClefImages.put(16, "/Assets/NoteBetweenLines.png");
        
        trebleClefCoordinates.put(17, new int[] { 615, 745, 208, 338 }); // F5
        trebleClefImages.put(17, "/Assets/NoteOnLedgerLine.png");
        
        trebleClefCoordinates.put(18, new int[] { 615, 745, 208, 338 }); // F#5
        trebleClefImages.put(18, "/Assets/SharpNoteOnLedgerLine.png");
        
        trebleClefCoordinates.put(19, new int[] { 615, 745, 176, 306}); // G5
        trebleClefImages.put(19, "/Assets/NoteBetweenLines.png");
        
        trebleClefCoordinates.put(20, new int[] { 615, 745, 176, 306}); // G#5
        trebleClefImages.put(20, "/Assets/SharpNoteBetweenLines.png");
        
        trebleClefCoordinates.put(21, new int[] { 615, 745, 144, 274 }); // A5
        trebleClefImages.put(21, "/Assets/NoteOnLedgerLine.png");
        
        trebleClefCoordinates.put(22, new int[] { 615, 745, 144, 274 }); // A#5
        trebleClefImages.put(22, "/Assets/SharpNoteOnLedgerLine.png");
        
      
        // Bass Clef MIDI Positions and Image Paths
        bassClefCoordinates.put(4, new int[] { 615, 745, 528, 658 }); // E2
        bassClefImages.put(4, "/Assets/NoteOnLedgerLine.png");

        bassClefCoordinates.put(5, new int[] { 615, 745, 496, 626 }); // F2
        bassClefImages.put(5, "/Assets/NoteBetweenLines.png");

        bassClefCoordinates.put(6, new int[] { 615, 745, 496, 626 }); // F#2
        bassClefImages.put(6, "/Assets/SharpNoteBetweenLines.png");

        bassClefCoordinates.put(7, new int[] { 615, 745, 464, 594 }); // G2
        bassClefImages.put(7, "/Assets/NoteOnLedgerLine.png");

        bassClefCoordinates.put(8, new int[] { 615, 745, 464, 594 }); // G#2
        bassClefImages.put(8, "/Assets/SharpNoteOnLedgerLine.png");

        bassClefCoordinates.put(9, new int[] { 615, 745, 432, 562 }); // A2
        bassClefImages.put(9, "/Assets/NoteBetweenLines.png");

        bassClefCoordinates.put(10, new int[] { 615, 745, 432, 562 }); // A#2
        bassClefImages.put(10, "/Assets/SharpNoteBetweenLines.png");

        bassClefCoordinates.put(11, new int[] { 615, 745, 400, 530 }); // B2
        bassClefImages.put(11, "/Assets/NoteOnLedgerLine.png");

        bassClefCoordinates.put(12, new int[] { 615, 745, 368, 498 }); // C3
        bassClefImages.put(12, "/Assets/NoteBetweenLines.png");

        bassClefCoordinates.put(13, new int[] { 615, 745, 368, 498 }); // C#3
        bassClefImages.put(13, "/Assets/SharpNoteBetweenLines.png");

        bassClefCoordinates.put(14, new int[] { 615, 745, 336, 466 }); // D3
        bassClefImages.put(14, "/Assets/NoteOnLedgerLine.png");

        bassClefCoordinates.put(15, new int[] { 615, 745, 336, 466 }); // D#3
        bassClefImages.put(15, "/Assets/SharpNoteOnLedgerLine.png");

        bassClefCoordinates.put(16, new int[] { 615, 745, 304, 434 }); // E3
        bassClefImages.put(16, "/Assets/NoteBetweenLines.png");

        bassClefCoordinates.put(17, new int[] { 615, 745, 272, 402 }); // F3
        bassClefImages.put(17, "/Assets/NoteOnLedgerLine.png");
        
        bassClefCoordinates.put(18, new int[] { 615, 745, 272, 402 }); // F#3
        bassClefImages.put(18, "/Assets/SharpNoteOnLedgerLine.png");
        
        bassClefCoordinates.put(19, new int[] { 615, 745, 240, 370 }); // G3
        bassClefImages.put(19, "/Assets/NoteBetweenLines.png");
        
        bassClefCoordinates.put(20, new int[] { 615, 745, 240, 370 }); // G#3
        bassClefImages.put(20, "/Assets/SharpNoteBetweenLines.png");
        
        bassClefCoordinates.put(21, new int[] { 615, 745, 208, 338 }); // A3
        bassClefImages.put(21, "/Assets/NoteOnLedgerLine.png");
        
        bassClefCoordinates.put(22, new int[] { 615, 745, 208, 338 }); // A#3
        bassClefImages.put(22, "/Assets/SharpNoteOnLedgerLine.png");
        
        bassClefCoordinates.put(23, new int[] { 615, 745, 176, 306}); // B3
        bassClefImages.put(23, "/Assets/NoteBetweenLines.png");
        
        bassClefCoordinates.put(0, new int[] { 615, 745, 144, 274 }); // C4
        bassClefImages.put(0, "/Assets/NoteOnLedgerLine.png");
        
        bassClefCoordinates.put(1, new int[] { 615, 745, 144, 274 }); // C#4
        bassClefImages.put(1, "/Assets/SharpNoteOnLedgerLine.png");
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
        midiValue = ((midiValue+12) % 24);
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
        midiValue = ((midiValue+12) % 24);
        if (clef == 'T') {
            return trebleClefImages.getOrDefault(midiValue, null);
        } else if (clef == 'B') {
            return bassClefImages.getOrDefault(midiValue, null);
        }
        return null; // Invalid clef
    }
}
