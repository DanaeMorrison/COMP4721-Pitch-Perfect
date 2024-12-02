package Controller;

import javax.sound.midi.*;

/**
 * MidiInputHandler listens to MIDI keyboard input and controls audio playback
 * via the Controller.
 */
public class MidiInputHandler {
    private static final int NOTE_ON = 0x90;
    private static final int NOTE_OFF = 0x80;

    private Controller controller;
    private Synthesizer synthesizer;
    private MidiDevice midiDevice;
    private Receiver receiver;

    /**
     * Constructs a MidiInputHandler and connects to a MIDI keyboard.
     *
     * @param controller the Controller to control audio playback.
     * @throws MidiUnavailableException if no suitable MIDI device is available.
     */
    public MidiInputHandler(Controller controller) throws MidiUnavailableException {
        this.controller = controller;
        connectToMidiKeyboard();
    }

    /**
     * Connects to a suitable MIDI input device.
     *
     * @throws MidiUnavailableException if no suitable MIDI input device is found.
     */
    private void connectToMidiKeyboard() throws MidiUnavailableException {
        MidiDevice.Info[] infos = MidiSystem.getMidiDeviceInfo();
        for (MidiDevice.Info info : infos) {
            MidiDevice device = MidiSystem.getMidiDevice(info);
            if (isInputDevice(device)) {
                tryConnectToDevice(device, info);
                if (midiDevice != null) {
                    return;
                }
            }
        }
        throw new MidiUnavailableException("No suitable MIDI input device found.");
    }

    /**
     * Checks if the MIDI device is an input device.
     *
     * @param device the MIDI device to check.
     * @return true if it's an input device, false otherwise.
     */
    private boolean isInputDevice(MidiDevice device) {
        try {
            return device.getMaxTransmitters() != 0 && !(device instanceof Sequencer)
                    && !(device instanceof Synthesizer);
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Attempts to connect to the specified MIDI device.
     *
     * @param device the MIDI device to connect to.
     * @param info   the MIDI device info.
     */
    private void tryConnectToDevice(MidiDevice device, MidiDevice.Info info) {
        try {
            if (!device.isOpen()) {
                device.open();
            }
            Receiver midiReceiver = new MidiInputReceiver();
            device.getTransmitter().setReceiver(midiReceiver);
            midiDevice = device;
            System.out.println("Connected to MIDI device: " + info.getName());
        } catch (MidiUnavailableException e) {
            System.err.println("Failed to connect to MIDI device " + info.getName() + ": " + e.getMessage());
        }
    }

    /**
     * Changes the MIDI input device to a new device.
     *
     * @param newDevice the new MIDI device to connect to.
     * @throws MidiUnavailableException if the new MIDI device is unavailable.
     */
    public void changeMidiDevice(MidiDevice newDevice) throws MidiUnavailableException {
        if (midiDevice != null && midiDevice.isOpen()) {
            midiDevice.close();
        }
        tryConnectToDevice(newDevice, newDevice.getDeviceInfo());
    }

    /**
     * Closes the MIDI input handler and releases resources.
     */
    public void close() {
        if (receiver != null) {
            receiver.close();
        }
        if (midiDevice != null && midiDevice.isOpen()) {
            midiDevice.close();
            System.out.println("MIDI device closed.");
        }
    }

    /**
     * Inner class to handle incoming MIDI messages.
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
                    controller.onNoteOn(note, velocity);
                } else if (command == NOTE_OFF || (command == NOTE_ON && velocity == 0)) {
                    controller.onNoteOff(note);
                }
            }
        }

        @Override
        public void close() {
            isOpen = false;
            System.out.println("MIDI receiver closed.");
        }
    }
}
