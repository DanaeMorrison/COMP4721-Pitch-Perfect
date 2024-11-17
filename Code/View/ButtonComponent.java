package View;

import javafx.scene.control.Button;

/**
 * Represents a button component in the view.
 */
public class ButtonComponent extends ViewComponent
{
    private Button thisObject;
    private int id;
    private boolean hasMessage;
    private String message;

    /**
     * Constructs a ButtonComponent.
     */
    public ButtonComponent()
    {
        //when clicked, controller will request button id and then
        //translate this buttons id to the action required when this
        //button is clicked
        hasMessage=false;
        thisObject = new Button();

        message = "";
        // Buttons action on click
        thisObject.setOnAction(event -> {
            hasMessage = true;
        });
    }

    /**
     * Sets the visibility of the button.
     * 
     * @param isHidden true to hide the button, false to show it
     */
    @Override
    protected void setHiddenHelper(boolean isHidden)
    {
        thisObject.setVisible(!isHidden);
    }

    /**
     * Updates the position and size of the button.
     * 
     * @param xyCords an array containing the x, y coordinates and width, height of the button
     */
    @Override
    protected void updateXYHelper(int[] xyCords)
    {
        thisObject.setPrefWidth(xyCords[1]);
        thisObject.setPrefHeight(xyCords[3]);
        thisObject.setLayoutX(xyCords[0]);
        thisObject.setLayoutY(xyCords[2]);
    }

    /**
     * Checks if the button has a message.
     * 
     * @return true if the button has a message, false otherwise
     */
    public boolean hasMessage()
    {
        return hasMessage;
    }

    /**
     * Gets the message of the button.
     * 
     * @return the message of the button
     */
    public String getMessage()
    {
        hasMessage = false;
        return message;
    }

    /**
     * Sets the message of the button.
     * 
     * @param message the message to set
     */
    public void setMessage(String message)
    {
        this.message = message;
    }

    /**
     * Sets the style of the button.
     * 
     * @param style the style to set
     */
    public void setStyle(String style)
    {
        thisObject.setStyle(style);
    }

    /**
     * Sets the text of the button.
     * 
     * @param text the text to set
     */
    public void setText(String text)
    {
        thisObject.setText(text);
    }

    /**
     * Gets the button object.
     * 
     * @return the button object
     */
    @Override
    public Button getObject()
    {
        return thisObject;
    }
}
