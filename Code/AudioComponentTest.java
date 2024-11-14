import View.AudioComponent;
import javax.sound.midi.*;

public class AudioComponentTest {
    public static void main(String[] args) throws MidiUnavailableException {
        int[] notes1 = {0};
        int[] notes_1 = {2};
        int[] notes_2 = {1};
        int[] notes2 = {0, 4};
        int[] notes3 = {0, 4, 7};

        try {
            AudioComponent audio = new AudioComponent();
            audio.playSound(notes1);
            audio.playSound(notes_1);
            audio.playSound(notes_2);
            audio.playSound(notes2);
            audio.playSound(notes3);
        } catch (MidiUnavailableException e) {
            System.err.println("Failed to open synthesizer: " + e.getMessage());
            throw e;
        }
    }
}