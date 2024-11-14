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

    public AudioComponent() throws MidiUnavailableException { 
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
            System.out.println("Successfully opened synthesizer");
        } catch (MidiUnavailableException e) {
            System.err.println("Failed to open synthesizer: " + e.getMessage());
            throw e;
        }
    }

    // maybe the different channels aren't necessary. Probably not- that might mean
    // expecting various outputs, like different speakers. I'll test it out
    public void playSound(int[] notes) {
        int lengthNotes = notes.length;

        for (int i = 0; i < lengthNotes; i++) {
            int currentNote = allnotes.get(notes[i]);
            channels[i].noteOn(currentNote, VELOCITY);
        }
        try {
            Thread.sleep(1800); //this might not be what I want. I want a delay of
            //1.5 seconds that allows the note to play for that long
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        for (int i = 0; i < lengthNotes; i++) {
            channels[i].noteOff(notes[i]);
        }
    }
}
