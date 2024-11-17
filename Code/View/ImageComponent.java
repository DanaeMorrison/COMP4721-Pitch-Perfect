package View;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * The ImageComponent class represents a view component that displays an image.
 */
public class ImageComponent extends ViewComponent {
    private ImageView thisObject;

    /**
     * Constructs an ImageComponent with a default image.
     */
    public ImageComponent() {
        // setting image to empty path is temporary and should be changed
        thisObject = new ImageView(new Image("/Assets/check.png"));
    }

    /**
     * Sets the visibility of the image component.
     * 
     * @param isHidden true to hide the component, false to show it
     */
    @Override
    protected void setHiddenHelper(boolean isHidden) {
        thisObject.setVisible(!isHidden);
    }

    /**
     * Updates the position and size of the image component.
     * 
     * @param xyCords an array containing the coordinates and dimensions [x1, x2,
     *                y1, y2]
     */
    @Override
    protected void updateXYHelper(int[] xyCords) {
        thisObject.setX(xyCords[0]);
        thisObject.setY(xyCords[2]);
        thisObject.setFitWidth(xyCords[1] - xyCords[0]);
        thisObject.setFitHeight(xyCords[3] - xyCords[2]);
    }

    /**
     * Returns the ImageView object of this component.
     * 
     * @return the ImageView object
     */
    @Override
    public ImageView getObject() {
        return thisObject;
    }

    /**
     * Changes the image displayed by this component.
     * 
     * @param url the URL of the new image
     */
    public void changeImage(String url) {
        // Load the new image and set it on the existing ImageView
        thisObject.setImage(new Image(getClass().getResource(url).toExternalForm()));
    }
}
