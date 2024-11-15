package View;

import java.io.File;
import java.util.HashMap;
import javax.sound.midi.*;

public class AudioComponent {
    private File soundFile;

    private static final int VELOCITY = 100;

    private Synthesizer synthesizer;
    private MidiChannel[] channels;

    private HashMap<Integer, Integer /** String*/> allnotes;
    private boolean noteStates[];
    
    public AudioComponent() throws MidiUnavailableException { 
        noteStates = new boolean[12];
        allnotes = new HashMap<>();
        allnotes.put(0, 60/**"C"*/);
        allnotes.put(1, 61/**"C#"*/);
        allnotes.put(2, 62/**"D"*/);
        allnotes.put(3, 63/**"D#"*/);
        allnotes.put(4, 64/**"E"*/);
        allnotes.put(5, 65/**"F"*/);
        allnotes.put(6, 66/**"F#"*/);
        allnotes.put(7, 67/**"G"*/);
        allnotes.put(8, 68/**"G#"*/);
        allnotes.put(9, 69/**"A"*/);
        allnotes.put(10, 70/**"A#"*/);
        allnotes.put(11, 71/**"B"*/);

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
    public void toggleKeys(int[] notes) {
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
