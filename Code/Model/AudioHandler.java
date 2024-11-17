package Model;

import javax.sound.midi.*;

/**
 * AudioHandler manages the synthesizer and handles playing and stopping notes.
 */
public class AudioHandler {
    private static final int DEFAULT_CHANNEL = 0; // Typically, channel 0 is used for piano sounds
    private Synthesizer synthesizer;
    private MidiChannel[] channels;

    /**
     * Constructs an AudioHandler and initializes the synthesizer.
     *
     * @throws MidiUnavailableException if the synthesizer is unavailable.
     */
    public AudioHandler() throws MidiUnavailableException {
        initializeSynthesizer();
    }

    /**
     * Initializes the synthesizer and retrieves available MIDI channels.
     *
     * @throws MidiUnavailableException if the synthesizer cannot be opened.
     */
    private void initializeSynthesizer() throws MidiUnavailableException {
        synthesizer = MidiSystem.getSynthesizer();
        synthesizer.open();
        channels = synthesizer.getChannels();
        System.out.println("Synthesizer opened: " + synthesizer.getDeviceInfo().getName());
    }

    /**
     * Plays a note on the synthesizer.
     *
     * @param note     the MIDI note number to play.
     * @param velocity the velocity of the note (0-127).
     */
    public void noteOn(int note, int velocity) {
        if (isValidNoteNumber(note) && isValidVelocity(velocity)) {
            channels[DEFAULT_CHANNEL].noteOn(note, velocity);
            System.out.println("Note On: " + note + " Velocity: " + velocity);
        } else {
            System.err.println("Invalid note or velocity: " + note + ", " + velocity);
        }
    }

    /**
     * Stops playing a note on the synthesizer.
     *
     * @param note the MIDI note number to stop.
     */
    public void noteOff(int note) {
        if (isValidNoteNumber(note)) {
            channels[DEFAULT_CHANNEL].noteOff(note);
            System.out.println("Note Off: " + note);
        } else {
            System.err.println("Invalid note number: " + note);
        }
    }

    /**
     * Closes the synthesizer and releases all audio resources.
     */
    public void close() {
        if (synthesizer != null && synthesizer.isOpen()) {
            synthesizer.close();
            System.out.println("Synthesizer closed.");
        }
    }

    /**
     * Validates if the note number is within the MIDI range.
     *
     * @param note the MIDI note number.
     * @return true if valid, false otherwise.
     */
    private boolean isValidNoteNumber(int note) {
        return note >= 0 && note <= 127;
    }

    /**
     * Validates if the velocity is within the MIDI range.
     *
     * @param velocity the velocity value.
     * @return true if valid, false otherwise.
     */
    private boolean isValidVelocity(int velocity) {
        return velocity >= 0 && velocity <= 127;
    }
}
