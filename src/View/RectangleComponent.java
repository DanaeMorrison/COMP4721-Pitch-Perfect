package View;

import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

/**
 * A component that represents a rectangle in the view.
 */
public class RectangleComponent extends ViewComponent {
    private Rectangle thisObject;

    /**
     * Constructs a new RectangleComponent.
     */
    public RectangleComponent() {
        thisObject = new Rectangle();
        System.out.println("Rectangle created");
    }
    
    public void setColor(Color color)
    {
        thisObject.setFill(color);
    }

    /**
     * Sets the visibility of the rectangle.
     * 
     * @param isHidden true to hide the rectangle, false to show it
     */
    @Override
    protected void setHiddenHelper(boolean isHidden) {
        thisObject.setVisible(!isHidden);
    }

    /**
     * Updates the position and size of the rectangle.
     * 
     * @param xyCords an array containing the coordinates and dimensions of the
     *                rectangle
     */
    @Override
    protected void updateXYHelper(int[] xyCords) {
        thisObject.setX(xyCords[0]);
        thisObject.setY(xyCords[2]);
        thisObject.setWidth(xyCords[1] - xyCords[0]);
        thisObject.setHeight(xyCords[3] - xyCords[2]);
    }

    /**
     * Returns the rectangle object.
     * 
     * @return the rectangle object
     */
    @Override
    public Rectangle getObject() {
        return thisObject;
    }
}
