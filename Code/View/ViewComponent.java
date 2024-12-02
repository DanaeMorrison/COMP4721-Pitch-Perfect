package View;

import javafx.application.Platform;
import javafx.scene.Node;

/**
 * Abstract class representing a view component in a graphical user interface.
 */
public abstract class ViewComponent {
    private int id;
    private int[] xyCords;
    private int orderRank;
    private ViewComponent[] components;
    private int numChildren;
    private int componentCapacity;
    private boolean isHidden;

    /**
     * Constructor to initialize a ViewComponent with default values.
     */
    public ViewComponent() {
        // initialize
        componentCapacity = 8;
        components = new ViewComponent[componentCapacity];
        numChildren = 0;
        xyCords = new int[4];
        for (int i = 0; i < 4; i++) {
            xyCords[i] = 0;
        }
        orderRank = 0;
        isHidden = true;
        // xyCords and orderRank intialized when added as a child to some other
        // ViewComponent
        // therefore in almost all cases, a ViewComponent should have a parent
        // ViewComponent
    }

    /**
     * Returns this component's x, y start and end values.
     * 
     * @return an int[] where [0]=xStart, [1]=xEnd, [2]=yStart, [3]=yEnd
     */
    public int[] getXY() {
        return xyCords;
    }

    /**
     * Updates the x, y coordinates of this component and its children.
     * 
     * @param xyCordsNew the new coordinates to set
     */
    public void updateXY(int[] xyCordsNew) {
        int xStartDiff = xyCordsNew[0] - xyCords[0];
        int xEndDiff = xyCordsNew[1] - xyCords[1];
        int yStartDiff = xyCordsNew[2] - xyCords[2];
        int yEndDiff = xyCordsNew[3] - xyCords[3];

        int[] xyCordsComponent;
        for (ViewComponent component : components) {
            if (component != null) {
                xyCordsComponent = component.getXY();
                xyCordsComponent[0] += xStartDiff;
                // xyCordsComponent[1] += xEndDiff;
                xyCordsComponent[2] += yStartDiff;
                // xyCordsComponent[3] += yEndDiff;
                component.updateXY(xyCordsComponent);
            }
        }
        xyCords = xyCordsNew;

        // private abstract method to be implemented by extensions
        updateXYHelper(xyCords);
    }

    /**
     * Sets the coordinates of a view component to the specified values.
     * 
     * @param xyCordsNew the coordinates that the component will be set to
     */
    public void setXY(int[] xyCordsNew) {
        updateXYHelper(xyCordsNew);
    }

    /**
     * Returns the order rank of this component.
     * 
     * @return the order rank
     */
    public int getOrderRank() {
        return orderRank;
    }

    /**
     * Sets the order rank of this component and adjusts the ranks of its children.
     * 
     * @param newRank the new order rank to set
     */
    public void setOrderRank(int newRank) {
        int rankDifference = newRank - orderRank;
        for (ViewComponent component : components) {
            if (component != null) {
                component.setOrderRank(component.getOrderRank() + rankDifference);
            }
        }
        orderRank = newRank;
    }

    /**
     * Brings this component to the front of the view.
     */
    public void toFront() {
        Platform.runLater(() -> {
            getObject().toFront();
        });
        
    }

    /**
     * Sets the visibility of this component.
     * 
     * @param isHidden true to hide the component, false to show it
     */
    public void setHidden(boolean isHidden) {
        // Calls helper method implemented within this abstract classes extensions
        this.isHidden = isHidden;
        setHiddenHelper(isHidden);
    }

    /**
     * Returns whether this component is hidden.
     * 
     * @return true if the component is hidden, false otherwise
     */
    public boolean getHidden() {
        return isHidden;
    }

    /**
     * Returns the child components of this component.
     * 
     * @return an array of child components
     */
    public ViewComponent[] getComponents() {
        return components;
    }

    /**
     * Adds a child ViewComponent to this component.
     * 
     * @param component  the child component to add
     * @param xyCordsNew the coordinates of the child component relative to this
     *                   component
     */
    public void addComponent(ViewComponent component, int[] xyCordsNew) {
        // Expand capacity if needed
        // NEED TO ENSURE this works and whether it should be componentCapacity-1 or smt
        // else
        if (numChildren == componentCapacity - 1) {
            int newCapacity = 2 * componentCapacity;
            ViewComponent[] newComponents = new ViewComponent[newCapacity];
            for (int i = 0; i < componentCapacity; i++) {
                newComponents[i] = components[i];
            }
            components = newComponents;
            componentCapacity = newCapacity;
        }

        // set child components xy and orderRank
        // calculate its xy cords
        xyCordsNew[0] += xyCords[0];
        // xyCordsNew[1] += xyCords[1];
        xyCordsNew[2] += xyCords[2];
        // xyCordsNew[3] += xyCords[3];

        component.updateXY(xyCordsNew);
        component.setOrderRank(orderRank + 1);

        // Finish
        components[numChildren] = component;
        numChildren++;
    }

    /**
     * Returns the ID of this component.
     * 
     * @return the ID
     */
    public int getID() {
        return id;
    }

    /**
     * Sets the ID of this component.
     * 
     * @param id the ID to set
     */
    public void setID(int id) {
        this.id = id;
    }

    /**
     * Returns the number of child components.
     * 
     * @return the number of children
     */
    public int getNumChildren() {
        return numChildren;
    }

    /**
     * Abstract method to update the coordinates of this component.
     * 
     * @param xyCords the new coordinates to set
     */
    protected abstract void updateXYHelper(int[] xyCords);

    /**
     * Abstract method to set the visibility of this component.
     * 
     * @param isHidden true to hide the component, false to show it
     */
    protected abstract void setHiddenHelper(boolean isHidden);

    /**
     * Abstract method to get the underlying Node object of this component.
     * 
     * @return the Node object
     */
    protected abstract Node getObject();
}
