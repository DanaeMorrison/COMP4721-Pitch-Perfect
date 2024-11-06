package View;
import java.util.HashMap;
import java.util.Map;

/**
 * The VirtualKeyboard class simulates the backend logic of a virtual keyboard.
 * It keeps track of the last pressed key and allows keys to be "pressed" or "released."
 */
public class VirtualKeyboard implements Keyboard {

    private int lastPressedKey = -1;
    private Map<Integer, Boolean> keyStates; // Stores the state of each key (pressed or not pressed)

    /**
     * Constructs a VirtualKeyboard with the specified number of keys.
     *
     * @param numberOfKeys the number of keys on the virtual keyboard.
     */
    public VirtualKeyboard(int numberOfKeys) {
        keyStates = new HashMap<>();
        initializeKeyStates(numberOfKeys);
    }

    /**
     * Initializes the state of each key on the keyboard.
     *
     * @param numberOfKeys the total number of keys on the keyboard.
     */
    private void initializeKeyStates(int numberOfKeys) {
        for (int i = 0; i < numberOfKeys; i++) {
            keyStates.put(i, false); // All keys start as "not pressed"
        }
    }

    /**
     * Simulates pressing a key on the virtual keyboard.
     *
     * @param key the ID of the key being pressed.
     */
    public void pressKey(int key) {
        if (keyStates.containsKey(key)) {
            keyStates.put(key, true);
            lastPressedKey = key;
            System.out.println("Key " + key + " pressed.");
        } else {
            System.err.println("Invalid key ID: " + key);
        }
    }

    /**
     * Simulates releasing a key on the virtual keyboard.
     *
     * @param key the ID of the key being released.
     */
    public void releaseKey(int key) {
        if (keyStates.containsKey(key)) {
            keyStates.put(key, false);
            if (key == lastPressedKey) {
                lastPressedKey = -1; // Reset last pressed key if it's the one being released
            }
            System.out.println("Key " + key + " released.");
        } else {
            System.err.println("Invalid key ID: " + key);
        }
    }

    /**
     * Returns the last pressed key.
     *
     * @return the ID of the last pressed key, or -1 if no key is currently pressed.
     */
    @Override
    public int getPressedKey() {
        return lastPressedKey;
    }

    /**
     * Checks if a specific key is currently pressed.
     *
     * @param key the ID of the key to check.
     * @return true if the key is pressed, false otherwise.
     */
    public boolean isKeyPressed(int key) {
        return keyStates.getOrDefault(key, false);
    }
}
