package View;
import javax.sound.midi.*;

/**
 * The MIDI class is responsible for connecting to a MIDI keyboard and handling
 * MIDI input messages.
 * It listens for NOTE_ON and NOTE_OFF messages and keeps track of the last
 * pressed key.
 */
//public class MIDI implements Keyboard {
public class MIDI {


    private static final int NOTE_ON = 0x90;
    private static final int NOTE_OFF = 0x80;
    private MidiDevice midiDevice;
    private Receiver receiver;
    private int lastPressedKey = -1;

    /**
     * Constructs a new MIDI object and attempts to connect to a MIDI keyboard.
     *
     * @throws MidiUnavailableException if no suitable MIDI input device could be
     *                                  found or connected to.
     */
    public MIDI() throws MidiUnavailableException {
        connectToMidiKeyboard();
    }

    /**
     * Attempts to connect to a suitable MIDI input device.
     *
     * @throws MidiUnavailableException if no suitable MIDI input device could be
     *                                  found or connected to.
     */
    private void connectToMidiKeyboard() throws MidiUnavailableException {
        MidiDevice.Info[] infos = MidiSystem.getMidiDeviceInfo();
        for (MidiDevice.Info info : infos) {
            if (isInputDevice(info)) {
                tryConnectToDevice(info);
                if (midiDevice != null)
                    return;
            }
        }
        throw new MidiUnavailableException("Could not connect to any suitable MIDI input device");
    }

    /**
     * Checks if the given MIDI device info corresponds to an input device.
     *
     * @param info the MIDI device info to check.
     * @return true if the device is an input device, false otherwise.
     * @throws MidiUnavailableException if the device could not be retrieved.
     */
    private boolean isInputDevice(MidiDevice.Info info) throws MidiUnavailableException {
        MidiDevice device = MidiSystem.getMidiDevice(info);
        return device.getMaxTransmitters() != 0 && !(device instanceof Sequencer) && !(device instanceof Synthesizer);
    }

    /**
     * Attempts to connect to the MIDI device specified by the given info.
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
        } catch (MidiUnavailableException e) {
            System.err.println("Failed to connect to MIDI device " + info.getName() + ": " + e.getMessage());
        }
    }

    /**
     * A custom Receiver implementation to handle incoming MIDI messages.
     */
    private class MidiInputReceiver implements Receiver {
        private boolean isOpen = true;

        /**
         * Handles incoming MIDI messages.
         *
         * @param message   the MIDI message to handle.
         * @param timeStamp the timestamp of the message.
         */
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
                    lastPressedKey = note;
                } else if (command == NOTE_OFF || (command == NOTE_ON && velocity == 0)) {
                    lastPressedKey = -1;
                }
            }
        }

        /**
         * Closes the receiver.
         */
        @Override
        public void close() {
            isOpen = false;
        }
    }

    /**
     * Returns the last pressed key.
     *
     * @return the last pressed key, or -1 if no key is currently pressed.
     */
    public int getPressedKey() {
        return lastPressedKey;
    }

    /**
     * Closes the MIDI connection and releases resources.
     */
    public void close() {
        if (receiver != null) {
            receiver.close();
        }
        if (midiDevice != null) {
            midiDevice.close();
        }
    }
}
