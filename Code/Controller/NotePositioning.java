package Controller;

import java.util.HashMap;

/*
Author: Jacob Richard
Version: 1.0

This class constructs two hashmaps which hold the coordinate values of where each note should be placed on the screen. 
Divided by Treble and Bass clef
*/

public class NotePositioning {
    private HashMap<Integer, int[]> trebleClef = new HashMap<>();
    private HashMap<Integer, int[]> bassClef = new HashMap<>();

    /**
     * Constructs a NotePositioning object and initializes the MIDI positions
     * for notes in both the Treble Clef and Bass Clef.
     * 
     * The positions are stored in two maps: trebleClef and bassClef.
     * Each map associates a MIDI note number with an array of integer positions.
     * 
     */
    public NotePositioning() {
        // Treble Clef MIDI Positions
        trebleClef.put(60, new int[] { 615, 745, 528, 658 }); // C4
        trebleClef.put(62, new int[] { 615, 745, 496, 626 }); // D4
        trebleClef.put(64, new int[] { 615, 745, 462, 594 }); // E4
        trebleClef.put(65, new int[] { 615, 745, 432, 562 }); // F4
        trebleClef.put(67, new int[] { 615, 745, 400, 530 }); // G4
        trebleClef.put(69, new int[] { 615, 745, 368, 498 }); // A4
        trebleClef.put(71, new int[] { 615, 745, 336, 466 }); // B4
        trebleClef.put(72, new int[] { 615, 745, 304, 434 }); // C5
        trebleClef.put(74, new int[] { 615, 745, 272, 402 }); // D5
        trebleClef.put(76, new int[] { 615, 745, 240, 370 }); // E5
        trebleClef.put(77, new int[] { 615, 745, 208, 338 }); // F5
        trebleClef.put(79, new int[] { 615, 745, 176, 306 }); // G5

        // Bass Clef MIDI Positions
        bassClef.put(40, new int[] { 615, 745, 528, 658 }); // E2
        bassClef.put(41, new int[] { 615, 745, 496, 626 }); // F2
        bassClef.put(43, new int[] { 615, 745, 462, 594 }); // G2
        bassClef.put(45, new int[] { 615, 745, 432, 562 }); // A2
        bassClef.put(47, new int[] { 615, 745, 400, 530 }); // B2
        bassClef.put(48, new int[] { 615, 745, 368, 498 }); // C3
        bassClef.put(50, new int[] { 615, 745, 336, 466 }); // D3
        bassClef.put(52, new int[] { 615, 745, 304, 434 }); // E3
        bassClef.put(53, new int[] { 615, 745, 272, 402 }); // F3
        bassClef.put(55, new int[] { 615, 745, 240, 370 }); // G3
        bassClef.put(57, new int[] { 615, 745, 208, 338 }); // A3
        bassClef.put(59, new int[] { 615, 745, 176, 306 }); // B3
        bassClef.put(60, new int[] { 615, 745, 144, 270 }); // C4

        // Add additional notes as needed
    }

    /**
     * Returns the position of the given MIDI note value on the staff.
     * 
     * @param midiValue the MIDI note value to get the position for
     * @param clef      the clef to get the position for ('T' for Treble, 'B' for
     *                  Bass)
     * @return an array of integer positions for the note on the staff
     */
    public int[] getNotePosition(int midiValue, char clef) {
        if (clef == 'T') {
            return trebleClef.get(midiValue);
        } else if (clef == 'B') {
            return bassClef.get(midiValue);
        }
        return new int[] { 0, 0, 0, 0 }; // Default position if note or clef is not found
    }
}
