import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageComponent extends ViewComponent
{
    private ImageView thisObject;
    /*
     * Tryna decide whether I can keep it simple and just set image
     * in constructor or if we'd want to get/set the image and store the url
     */
    public ImageComponent(String url)
    {
        thisObject = new ImageView(new Image(url));
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
}
