import javafx.scene.control.Button;

public class ButtonComponent extends ViewComponent
{
    private Button thisObject;
    private int id;
    private boolean isClicked;

    public ButtonComponent()
    {
        //when clicked, controller will request button id and then
        //translate this buttons id to the action required when this
        //button is clicked
        isClicked=false;
        thisObject = new Button();

        // Buttons action on click
        thisObject.setOnAction(event -> {
            //MUST check if button is on topmost rank at its location.
            //will probably make components which arent topmost rank at their location
            //be hidden so keep that in mind.
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
    public int getMessage()
    {
        isClicked = false;
        return id;
    }
    @Override
    public void setID(int id)
    {
        this.id=id;
        Button newButton = new Button(String.valueOf(id));
    }
    @Override
    public Button getObject()
    {
        return thisObject;
    }
}
