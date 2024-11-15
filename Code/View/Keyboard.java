package View;
public interface Keyboard {
    public boolean hasMessage();
    //messages for keyboards should be of the form: toggleKeys followed by a series of keyID's
    //where each key is seperated by spaces
    //ex: "toggleKeys 0 1"
    public String getMessage();
}
