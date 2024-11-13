package View;

import javafx.scene.control.Button;

public class ButtonComponent extends ViewComponent
{
    private Button thisObject;
    private int id;
    private boolean isClicked;
    private String message;

    public ButtonComponent()
    {
        //when clicked, controller will request button id and then
        //translate this buttons id to the action required when this
        //button is clicked
        isClicked=false;
        thisObject = new Button();

        message = "";
        // Buttons action on click
        thisObject.setOnAction(event -> {
            isClicked = true;
        });
    }
    @Override
    protected void setHiddenHelper(boolean isHidden)
    {
        thisObject.setVisible(!isHidden);
    }
    @Override
    protected void updateXYHelper(int[] xyCords)
    {
        thisObject.setLayoutX(xyCords[0]);
        thisObject.setLayoutY(xyCords[2]);
        thisObject.setPrefWidth(xyCords[1]-xyCords[0]);
        thisObject.setPrefHeight(xyCords[3]-xyCords[2]);
    }
    //If clicked, then it has a message and once controller checks
    //if this button has a message to send, it will request this buttons
    //id to translate this message
    public boolean hasMessage()
    {
        return isClicked;
    }
    public String getMessage()
    {
        isClicked = false;
        return message;
    }
    public void setMessage(String message)
    {
        this.message = message;
    }
    @Override
    public Button getObject()
    {
        return thisObject;
    }
}
