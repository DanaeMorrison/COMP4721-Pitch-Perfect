package View;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * The VirtualKeyboard class represents a virtual keyboard with a UI interface.
 * It implements the Keyboard interface and provides methods to create and
 * manage
 * the virtual keyboard.
 */
public class VirtualKeyboard implements Keyboard {
    private UI ui;
    private ArrayList<ButtonComponent> keys;
    // Integer since it just needs unique numbers of keys which are pressed
    private HashSet<Integer> pressedKeys;
    private boolean hasMessage;
    private String message;
    // will also keep track of keyStates (done in audio component as well) to track
    // visual state
    private boolean[] keyStates;
    private boolean[] isSharp;
    private static final int numKeys = 25;
    private static final String styleMain = "-fx-background-color: white; -fx-text-fill: black;";
    private static final String styleSharp = "-fx-background-color: black; -fx-text-fill: white;";
    private static final String styleOn = "-fx-background-color: purple; -fx-text-fill: black;";

    /**
     * Constructs a VirtualKeyboard with the specified UI.
     * 
     * @param ui the UI interface to be used for the virtual keyboard
     */
    public VirtualKeyboard(UI ui) {
        this.ui = ui;
        keys = new ArrayList<>();
        pressedKeys = new HashSet<>();
        keyStates = new boolean[numKeys];
        isSharp = new boolean[numKeys];
        createKeyboard();
    }

    /**
     * Creates the virtual keyboard with the specified number of keys and styles.
     */
    private void createKeyboard() {
        int numMainKeys = 25;
        int startX = 0;
        int startY = 0;
        int totalWidth = 300;
        int totalHeight = 200;
        int keyWidth = 2 * totalWidth / numMainKeys;

        int[] backgroundCords = { startX, totalWidth, startY, totalHeight };
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
        int[] skipIndices = { 5, 12, 17, 24 };
        int skipListIndex = 0;
        // alternates between main and sharp
        boolean isMainKey = true;
        // for (int i = 0; i < numKeys; i++) {
        // //check if skip indices
        // if(i == skipIndices[skipListIndex])
        // {
        // skipListIndex++;
        // isMainKey=true;
        // }
        // ButtonComponent button = (ButtonComponent)
        // ui.getViewComponent(ui.createViewComponent(backGroundID, "button",
        // keyCords));
        // if (!isMainKey) {
        // keyCords[0] = xMain;
        // keyCords[1] = keyWidth;
        // keyCords[2] = startY;
        // keyCords[3] = totalHeight;
        // xMain += keyWidth;
        // button.setStyle(styleMain);
        // } else {
        // xSharp = xMain - (sharpWidth / 2);//put sharp between last main key
        // keyCords[0] = xSharp;
        // keyCords[1] = sharpWidth;
        // keyCords[2] = startY+sharpHeight;
        // keyCords[3] = totalHeight;
        // button.setStyle(styleSharp);
        // isSharp[i] = true;
        // }

        // button.setMessage(String.valueOf(i));
        // keys.add(button);
        // }

        for (int i = 0; i < 25; i++) {
            ButtonComponent button = (ButtonComponent) ui
                    .getViewComponent(ui.createViewComponent(backGroundID, "button", keyCords));
            keyCords[0] += keyWidth / 2;
            // keyCords[1] += keyWidth;
            if (i % 2 == 0) {
                keyCords[1] = -keyWidth;
                keyCords[2] = 0;
                keyCords[3] = 100;
                button.setStyle(styleMain);
            } else {
                keyCords[1] = keyWidth;
                keyCords[2] = startY;
                keyCords[3] = totalHeight;
                button.setStyle(styleSharp);
                isSharp[i] = true;
            }
            button.setMessage(String.valueOf(i));
            keys.add(button);
        }

        for (ButtonComponent key : keys) {
            if (isSharp[Integer.valueOf(key.getMessage())]) {
                key.toFront();
            }
        }

        System.out.println("Virtual keyboard created");
    }

    /**
     * Checks if the virtual keyboard has any messages from the keys.
     * 
     * @return true if there is a message, false otherwise
     */
    public boolean hasMessage() {
        // System.out.println("checking keys for messages");
        message = "toggleKeys";
        int keyID;
        for (ButtonComponent key : keys) {
            // System.out.println("checking key: "+String.valueOf(key.getID()));
            // System.out.println(key.hasMessage());
            String style;
            if (key.hasMessage()) {
                hasMessage = true;
                message += " " + key.getMessage();
                keyID = Integer.valueOf(key.getMessage());
                // set visuals of that key
                if (keyStates[keyID]) {
                    keyStates[keyID] = false;
                    if (isSharp[keyID]) {
                        style = styleSharp;
                    } else {
                        style = styleMain;
                    }
                } else {
                    keyStates[keyID] = true;
                    style = styleOn;
                }
                key.setStyle(style);
            }
        }

        if (hasMessage) {
            System.out.println("Message found, being: " + message);
        }
        return hasMessage;
    }

    /**
     * Returns the message from the virtual keyboard.
     * 
     * @return the message from the virtual keyboard
     */
    public String getMessage() {
        hasMessage = false;
        return message;
    }
}
