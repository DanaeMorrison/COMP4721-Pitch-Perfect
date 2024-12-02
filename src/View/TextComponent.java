package View;

import javafx.scene.text.Text;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextFlow;

/**
 * The TextComponent class represents a text component in the view.
 * It uses TextFlow to enable text formatting.
 */
public class TextComponent extends ViewComponent {
    // Uses TextFlow instead of Text to enable formatting.
    // Unsure about this though because it requires much more
    // object recreation whenever changing text content or font.
    private TextFlow thisObject;
    private Font font;
    private String text;

    /**
     * Constructs a new TextComponent.
     */
    public TextComponent() {
        thisObject = new TextFlow();
    }

    /**
     * Sets the visibility of the text component.
     * 
     * @param isHidden true to hide the component, false to show it
     */
    @Override
    protected void setHiddenHelper(boolean isHidden) {
        thisObject.setVisible(!isHidden);
    }

    /**
     * Updates the position and size of the text component.
     * 
     * @param xyCords an array containing the coordinates and dimensions
     */
    @Override
    protected void updateXYHelper(int[] xyCords) {
        thisObject.setLayoutX(xyCords[0]);
        thisObject.setLayoutY(xyCords[2]);
        thisObject.setPrefWidth(xyCords[1] - xyCords[0]);
        thisObject.setPrefHeight(xyCords[3] - xyCords[2]);
    }

    /**
     * Sets the text content of the text component.
     * 
     * @param text the new text content
     */
    public void setText(String text) {
        this.text = text;
        Text newText = new Text(text);
        TextFlow newObject = new TextFlow(newText);
        thisObject = newObject;
    }

    /**
     * Sets the font of the text component.
     * 
     * @param font the new font
     */
    public void setFont(Font font) {
        this.font = font;
        Text newText = new Text(text);
        newText.setFont(font);
        TextFlow newObject = new TextFlow(newText);
        thisObject = newObject;
    }

    /**
     * Gets the text content of the text component.
     * 
     * @return the text content
     */
    public String getText() {
        return text;
    }

    /**
     * Gets the font of the text component.
     * 
     * @return the font
     */
    public Font getFont() {
        return font;
    }

    /**
     * Gets the TextFlow object representing the text component.
     * 
     * @return the TextFlow object
     */
    @Override
    public TextFlow getObject() {
        return thisObject;
    }
}
