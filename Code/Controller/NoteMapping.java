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
        trebleClefCoordinates.put(60, new int[]{615, 745, 528, 658}); // C4
        trebleClefImages.put(60, "/Assets/NoteOnLedgerLine.png");

        trebleClefCoordinates.put(61, new int[]{615, 745, 512, 642}); // C#4
        trebleClefImages.put(61, "/Assets/SharpNoteOnLedgerLine.png");

        trebleClefCoordinates.put(62, new int[]{615, 745, 496, 626}); // D4
        trebleClefImages.put(62, "/Assets/NoteBetweenLines.png");

        trebleClefCoordinates.put(63, new int[]{615, 745, 479, 609}); // D#4
        trebleClefImages.put(63, "/Assets/SharpNoteBetweenLines.png");

        trebleClefCoordinates.put(64, new int[]{615, 745, 462, 594}); // E4
        trebleClefImages.put(64, "/Assets/NoteOnLedgerLine.png");

        trebleClefCoordinates.put(65, new int[]{615, 745, 432, 562}); // F4
        trebleClefImages.put(65, "/Assets/NoteBetweenLines.png");

        trebleClefCoordinates.put(66, new int[]{615, 745, 416, 546}); // F#4
        trebleClefImages.put(66, "/Assets/SharpNoteBetweenLines.png");

        trebleClefCoordinates.put(67, new int[]{615, 745, 400, 530}); // G4
        trebleClefImages.put(67, "/Assets/NoteOnLedgerLine.png");

        trebleClefCoordinates.put(68, new int[]{615, 745, 384, 514}); // G#4
        trebleClefImages.put(68, "/Assets/SharpNoteOnLedgerLine.png");

        trebleClefCoordinates.put(69, new int[]{615, 745, 368, 498}); // A4
        trebleClefImages.put(69, "/Assets/NoteBetweenLines.png");

        trebleClefCoordinates.put(70, new int[]{615, 745, 352, 482}); // A#4
        trebleClefImages.put(70, "/Assets/SharpNoteBetweenLines.png");

        trebleClefCoordinates.put(71, new int[]{615, 745, 336, 466}); // B4
        trebleClefImages.put(71, "/Assets/NoteOnLedgerLine.png");

        trebleClefCoordinates.put(72, new int[]{615, 745, 304, 434}); // C5
        trebleClefImages.put(72, "/Assets/NoteOnLedgerLine.png");

        // Add additional notes as needed...

        // Bass Clef MIDI Positions and Image Paths
        bassClefCoordinates.put(40, new int[]{615, 745, 528, 658}); // E2
        bassClefImages.put(40, "/Assets/NoteOnLedgerLine.png");

        bassClefCoordinates.put(41, new int[]{615, 745, 512, 642}); // F2
        bassClefImages.put(41, "/Assets/SharpNoteOnLedgerLine.png");

        bassClefCoordinates.put(43, new int[]{615, 745, 462, 594}); // G2
        bassClefImages.put(43, "/Assets/NoteOnLedgerLine.png");

        bassClefCoordinates.put(44, new int[]{615, 745, 446, 578}); // G#2
        bassClefImages.put(44, "/Assets/SharpNoteOnLedgerLine.png");

        bassClefCoordinates.put(45, new int[]{615, 745, 432, 562}); // A2
        bassClefImages.put(45, "/Assets/NoteBetweenLines.png");

        bassClefCoordinates.put(46, new int[]{615, 745, 416, 546}); // A#2
        bassClefImages.put(46, "/Assets/SharpNoteBetweenLines.png");

        bassClefCoordinates.put(47, new int[]{615, 745, 400, 530}); // B2
        bassClefImages.put(47, "/Assets/NoteOnLedgerLine.png");

        bassClefCoordinates.put(48, new int[]{615, 745, 368, 498}); // C3
        bassClefImages.put(48, "/Assets/NoteBetweenLines.png");

        bassClefCoordinates.put(49, new int[]{615, 745, 352, 482}); // C#3
        bassClefImages.put(49, "/Assets/SharpNoteBetweenLines.png");

        bassClefCoordinates.put(50, new int[]{615, 745, 336, 466}); // D3
        bassClefImages.put(50, "/Assets/NoteOnLedgerLine.png");

        bassClefCoordinates.put(51, new int[]{615, 745, 320, 450}); // D#3
        bassClefImages.put(51, "/Assets/SharpNoteOnLedgerLine.png");

        bassClefCoordinates.put(52, new int[]{615, 745, 304, 434}); // E3
        bassClefImages.put(52, "/Assets/NoteBetweenLines.png");

        // Add additional notes as needed...
    }

    // Method to get note coordinates
    public int[] getCoordinates(int midiValue, char clef) {
        if (clef == 'T') {
            return trebleClefCoordinates.getOrDefault(midiValue, null);
        } else if (clef == 'B') {
            return bassClefCoordinates.getOrDefault(midiValue, null);
        }
        return null; // Invalid clef
    }

    // Method to get note image path
    public String getImagePath(int midiValue, char clef) {
        if (clef == 'T') {
            return trebleClefImages.getOrDefault(midiValue, null);
        } else if (clef == 'B') {
            return bassClefImages.getOrDefault(midiValue, null);
        }
        return null; // Invalid clef
    }
}
