package View;

public interface Keyboard {
    /**
     * Checks if there is a message available.
     * 
     * @return true if there is a message, false otherwise.
     */
    public boolean hasMessage();

    /**
     * Retrieves the message from the keyboard.
     * Messages for keyboards should be of the form: toggleKeys followed by a series
     * of keyID's
     * where each key is separated by spaces.
     * Example: "toggleKeys 0 1"
     * 
     * @return the message as a String.
     */
    public String getMessage();
}
