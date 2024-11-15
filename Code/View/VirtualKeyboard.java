package View;
import java.util.ArrayList;
import java.util.HashSet;

public class VirtualKeyboard implements Keyboard {
    private UI ui;
    private ArrayList<ButtonComponent> keys;
    //Integer since it just needs unique numbers of keys which are pressed
    private HashSet<Integer> pressedKeys;
    private boolean hasMessage;
    private String message;
    //will also keep track of keyStates (done in audio component as well) to track visual state
    private boolean[] keyStates;
    private boolean[] isSharp;
    private static final int numKeys = 25;
    private static final String styleMain = "-fx-background-color: white; -fx-text-fill: black;";
    private static final String styleSharp = "-fx-background-color: black; -fx-text-fill: white;";
    private static final String styleOn = "-fx-background-color: purple; -fx-text-fill: black;";

    
    public VirtualKeyboard(UI ui)
    {
        this.ui = ui;
        keys = new ArrayList<>();
        pressedKeys = new HashSet<>();
        keyStates = new boolean[numKeys];
        isSharp = new boolean[numKeys];
        createKeyboard();
    }
            
    private void createKeyboard() {
        int numMainKeys = 15;
        int startX = 0;
        int startY = 0;
        int totalWidth = 600;
        int totalHeight = 300;
        int keyWidth = totalWidth / numMainKeys;
    
        int[] backgroundCords = {startX, totalWidth, startY, totalHeight};
        int backGroundID = ui.createViewComponent("rectangle");
        ui.getViewComponent(backGroundID).updateXY(backgroundCords);
        
        int[] keyCords = new int[4];
        keyCords[0] = startX;
        keyCords[1] = keyWidth;
        keyCords[2] = startY;
        keyCords[3] = totalHeight;
    
        int xMain = keyWidth;
        int xSharp;
        int sharpWidth = keyWidth / 2;
        int sharpHeight = totalHeight / 2;
        int[] skipIndices = {5,12,17, 24};
        int skipListIndex = 0;
        //alternates between main and sharp
        boolean isMainKey = true;
        for (int i = 0; i < numKeys; i++) {
            //check if skip indices
            if(i == skipIndices[skipListIndex])
            {
                skipListIndex++;
                isMainKey=true;
            }
            ButtonComponent button = (ButtonComponent) ui.getViewComponent(ui.createViewComponent(backGroundID, "button", keyCords));
            if (!isMainKey) {
                keyCords[0] = xMain;
                keyCords[1] = keyWidth;
                keyCords[2] = startY;
                keyCords[3] = totalHeight;
                xMain += keyWidth;
                button.setStyle(styleMain);
            } else {
                xSharp = xMain - (sharpWidth / 2);//put sharp between last main key
                keyCords[0] = xSharp;
                keyCords[1] = sharpWidth;
                keyCords[2] = startY+sharpHeight;
                keyCords[3] = totalHeight;
                button.setStyle(styleSharp);
                isSharp[i] = true;
            }
    
            button.setMessage(String.valueOf(i));
            keys.add(button);
        }
    
        System.out.println("Virtual keyboard created");
    }



    
    public boolean hasMessage()
    {
        //System.out.println("checking keys for messages");
        message = "toggleKeys";
        int keyID;
        for(ButtonComponent key : keys)
        {
            //System.out.println("checking key: "+String.valueOf(key.getID()));
            //System.out.println(key.hasMessage());
            String style;
            if(key.hasMessage())
            {
                hasMessage = true;
                message += " " + key.getMessage();
                keyID = Integer.valueOf(key.getMessage());
                //set visuals of that key
                if(keyStates[keyID])
                {
                    keyStates[keyID] = false;
                    if(isSharp[keyID])
                    {
                        style = styleSharp;
                    } else
                    {
                        style = styleMain;
                    }
                } else
                {
                    keyStates[keyID] = true;
                    style = styleOn;
                }
                key.setStyle(style);
            }
        }
        
        if(hasMessage)
        {
            System.out.println("Message found, being: "+message);
        }
        return hasMessage;
    }
    public String getMessage()
    {
        hasMessage = false;
        return message;
    }
}
