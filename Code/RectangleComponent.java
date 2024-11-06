import javafx.scene.shape.Rectangle;

public class RectangleComponent extends ViewComponent
{
    private Rectangle thisObject;

    public RectangleComponent()
    {
        thisObject = new Rectangle();
        System.out.println("Rectangle created");
    }
    @Override
    protected void setHiddenHelper(boolean isHidden)
    {
        thisObject.setVisible(!isHidden);
    }
    @Override
    protected void updateXYHelper(int[] xyCords)
    {
        thisObject.setX(xyCords[0]);
        thisObject.setY(xyCords[2]);
        thisObject.setWidth(xyCords[1]-xyCords[0]);
        thisObject.setHeight(xyCords[3]-xyCords[2]);
    }
    @Override
    public Rectangle getObject()
    {
        return thisObject;
    }
}
