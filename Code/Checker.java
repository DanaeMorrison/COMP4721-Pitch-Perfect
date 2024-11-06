import java.util.HashMap;

// This class is for checking the user inputed note and lessons correct note.
public class Checker {
    private HashMap<Integer,String> allnotes;
    Checker() { 
        allnotes = new HashMap<>();
        allnotes.put(0,"C");
        allnotes.put(1,"C#");
        allnotes.put(2, "D");
        allnotes.put(3, "D#");
        allnotes.put(4, "E");
        allnotes.put(5, "F");
        allnotes.put(6, "F#");
        allnotes.put(7, "G");
        allnotes.put(8, "G#");
        allnotes.put(9, "A");
        allnotes.put(10, "A#");
        allnotes.put(11, "B");
    }
    // Checks if the number from the userInput on midi keyboard is equal to the correct node from the lesson class. 
    public boolean check(int userInput,int correctNote){
        return (userInput % 12) == (correctNote % 12);
    }
    // if we want to return the name of the note that is played, for some reason, this method is here as well. 
    public String returnNoteName(int note){
        int moddedNote = note % 12;
        return allnotes.get(moddedNote);
    }
   
}