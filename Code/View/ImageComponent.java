package View;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
// Removed invalid import statement

public class ImageComponent extends ViewComponent
{
    private ImageView thisObject;

    public ImageComponent()
    {
        //setting image to empty path is temporary and should be changed
        thisObject = new ImageView(new Image(""));
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
        thisObject.setFitWidth(xyCords[1]-xyCords[0]);
        thisObject.setFitHeight(xyCords[3]-xyCords[2]);
    }
    @Override
    public ImageView getObject()
    {
        return thisObject;
    }
    public void changeImage(String url)
    {
        ImageView newObject = new ImageView(new Image(getClass().getResource(url).toExternalForm()));
        this.thisObject = newObject;
    }
}
