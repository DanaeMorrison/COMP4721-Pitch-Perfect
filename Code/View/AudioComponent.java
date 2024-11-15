package View;

import java.io.File;
import java.util.HashMap;
import javax.sound.midi.*;

public class AudioComponent {
    private File soundFile;

    private static final int VELOCITY = 100;

    private Synthesizer synthesizer;
    private MidiChannel[] channels;

    private HashMap<Integer, Integer> allnotes;
    private boolean noteStates[];
    
    public AudioComponent() throws MidiUnavailableException { 
        noteStates = new boolean[25];
        allnotes = new HashMap<>();
        allnotes.put(0, 60);  // C4
        allnotes.put(1, 61);  // C#4
        allnotes.put(2, 62);  // D4
        allnotes.put(3, 63);  // D#4
        allnotes.put(4, 64);  // E4
        allnotes.put(5, 65);  // F4
        allnotes.put(6, 66);  // F#4
        allnotes.put(7, 67);  // G4
        allnotes.put(8, 68);  // G#4
        allnotes.put(9, 69);  // A4
        allnotes.put(10, 70); // A#4
        allnotes.put(11, 71); // B4
        allnotes.put(12, 72); // C5
        allnotes.put(13, 73); // C#5
        allnotes.put(14, 74); // D5
        allnotes.put(15, 75); // D#5
        allnotes.put(16, 76); // E5
        allnotes.put(17, 77); // F5
        allnotes.put(18, 78); // F#5
        allnotes.put(19, 79); // G5
        allnotes.put(20, 80); // G#5
        allnotes.put(21, 81); // A5
        allnotes.put(22, 82); // A#5
        allnotes.put(23, 83); // B5
        allnotes.put(24, 84); // C6
        

        initializeSynthesizer();
    }

    /**
     * Initializes the synthesizer and opens it for use.
     * 
     * @throws MidiUnavailableException if the synthesizer is unavailable.
     */
    private void initializeSynthesizer() throws MidiUnavailableException {
        try {
            synthesizer = MidiSystem.getSynthesizer();
            synthesizer.open();
            channels = synthesizer.getChannels();
            Instrument[] instruments = synthesizer.getDefaultSoundbank().getInstruments();
            synthesizer.loadInstrument(instruments[19]); // Index 19 is often an organ
            channels[0].programChange(19); // Change to an organ sound
            System.out.println("Successfully opened synthesizer");
        } catch (MidiUnavailableException e) {
            System.err.println("Failed to open synthesizer: " + e.getMessage());
            throw e;
        }
    }

    // maybe the different channels aren't necessary. Probably not- that might mean
    // expecting various outputs, like different speakers. I'll test it out
    public void toggleNotes(int[] notes) {
        int lengthNotes = notes.length;
        int currentNote;
        
        for (int i = 0; i < lengthNotes; i++) {
            currentNote = allnotes.get(notes[i]);
            if(noteStates[notes[i]])
            {
                noteStates[notes[i]] = false;
                channels[0].noteOff(currentNote, VELOCITY);
            } else
            {
                noteStates[notes[i]] = true;
                channels[0].noteOn(currentNote, VELOCITY);    
            }
        }
    }
}
