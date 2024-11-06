import javax.sound.midi.*;

// THIS IS THE CODE FOR THE MIDI HANDLER, that plays the sound on the keyboard.
/**
 * MidiKeyboardHandler is responsible for handling MIDI keyboard input and
 * playing notes using a synthesizer.
 * It connects to a MIDI input device, receives MIDI messages, and plays
 * corresponding notes.
 */
public class MidiHandler {
    private static final int NOTE_ON = 0x90;
    private static final int NOTE_OFF = 0x80;
    private Synthesizer synthesizer;
    private MidiChannel[] channels;
    private MidiDevice midiDevice;
    private Receiver receiver;

    /**
     * Constructs a MidiKeyboardHandler, initializes the synthesizer, and connects
     * to a MIDI keyboard.
     * 
     * @throws MidiUnavailableException if the synthesizer or MIDI device is
     *                                  unavailable.
     */
    public MidiHandler() throws MidiUnavailableException {
        initializeSynthesizer();
        connectToMidiKeyboard();
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
            System.out.println("Successfully opened synthesizer: " + synthesizer.getDeviceInfo().getName());
        } catch (MidiUnavailableException e) {
            System.err.println("Failed to open synthesizer: " + e.getMessage());
            throw e;
        }
    }

    /**
     * Connects to a suitable MIDI input device.
     * 
     * @throws MidiUnavailableException if no suitable MIDI input device is found.
     */
    private void connectToMidiKeyboard() throws MidiUnavailableException {
        MidiDevice.Info[] infos = MidiSystem.getMidiDeviceInfo();
        for (MidiDevice.Info info : infos) {
            if (info.getName().contains("SE25") || isInputDevice(info)) {
                tryConnectToDevice(info);
                if (midiDevice != null)
                    return;
            }
        }
        throw new MidiUnavailableException("Could not connect to any suitable MIDI input device");
    }

    /**
     * Checks if the given MIDI device info represents an input device.
     * 
     * @param info the MIDI device info to check.
     * @return true if the device is an input device, false otherwise.
     * @throws MidiUnavailableException if the device is unavailable.
     */
    private boolean isInputDevice(MidiDevice.Info info) throws MidiUnavailableException {
        MidiDevice device = MidiSystem.getMidiDevice(info);
        return device.getMaxTransmitters() != 0 && !(device instanceof Sequencer) && !(device instanceof Synthesizer);
    }

    /**
     * Attempts to connect to the MIDI device represented by the given info.
     * 
     * @param info the MIDI device info to connect to.
     */
    private void tryConnectToDevice(MidiDevice.Info info) {
        try {
            MidiDevice device = MidiSystem.getMidiDevice(info);
            if (!device.isOpen()) {
                device.open();
            }
            receiver = new MidiInputReceiver();
            device.getTransmitter().setReceiver(receiver);
            midiDevice = device;
            System.out.println("Successfully connected to MIDI device: " + info.getName());
        } catch (MidiUnavailableException e) {
            System.err.println("Failed to connect to MIDI device " + info.getName() + ": " + e.getMessage());
        }
    }

    /**
     * Handles incoming MIDI messages and plays notes on the synthesizer.
     */
    private class MidiInputReceiver implements Receiver {
        private boolean isOpen = true;

        @Override
        public void send(MidiMessage message, long timeStamp) {
            if (!isOpen)
                return;
            if (message instanceof ShortMessage) {
                ShortMessage sm = (ShortMessage) message;
                int command = sm.getCommand();
                int note = sm.getData1();
                int velocity = sm.getData2();
                if (command == NOTE_ON && velocity > 0) {
                    noteOn(note, velocity);
                } else if (command == NOTE_OFF || (command == NOTE_ON && velocity == 0)) {
                    noteOff(note);
                }
            }
        }

        @Override
        public void close() {
            isOpen = false;
            System.out.println("MIDI receiver closed");
        }
    }

    /**
     * Plays a note on the synthesizer.
     * 
     * @param note     the MIDI note number to play.
     * @param velocity the velocity of the note.
     */
    private void noteOn(int note, int velocity) {
        channels[0].noteOn(note, velocity); // Play the note on channel 0
        System.out.println("Note On: " + note + " Velocity: " + velocity);
    }

    /**
     * Stops playing a note on the synthesizer.
     * 
     * @param note the MIDI note number to stop playing.
     */
    private void noteOff(int note) {
        channels[0].noteOff(note); // Stop playing the note on channel 0
        System.out.println("Note Off: " + note);
    }

    /**
     * Closes the MIDI handler, releasing all resources.
     */
    public void close() {
        if (receiver != null) {
            receiver.close();
        }
        if (midiDevice != null) {
            midiDevice.close();
        }
        if (synthesizer != null) {
            synthesizer.close();
        }
        System.out.println("MIDI Handler closed");
    }

    /**
     * Starts the MIDI keyboard handler, keeping it running until interrupted.
     * 
     * @throws InterruptedException if the thread is interrupted.
     */
    public void start() throws InterruptedException {
        System.out.println("\nMIDI Keyboard Handler is running. Press Ctrl+C to exit.");
        while (true) {
            Thread.sleep(1000); // Keep the handler running
        }
    }

    public static void main(String[] args) {
        MidiHandler handler = null;
        try {
            handler = new MidiHandler(); // Create a new handler

            final MidiHandler finalHandler = handler;
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                if (finalHandler != null) {
                    finalHandler.close(); // Close the handler on shutdown
                }
            }));
            handler.start(); // Start the handler
        } catch (MidiUnavailableException | InterruptedException e) {
            System.err.println("Error: " + e.getMessage());
            if (handler != null) {
                handler.close(); // Close the handler on error
            }
        }
    }
}
