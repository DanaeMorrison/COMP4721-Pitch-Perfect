

public abstract class ViewComponent
{
    private int id;
    private int[] xyCords;
    private int orderRank;
    private ViewComponent[] components;
    private int numChildren;
    private int componentCapacity;

    ViewComponent()
    {
        //initialize
        componentCapacity = 8;
        components = new ViewComponent[componentCapacity];
        numChildren = 0;
        xyCords = new int[4]
        xyCords = {0,0,0,0};
        orderRank=0; 
        //xyCords and orderRank intialized when added as a child to some other ViewComponent
        //therefore in almost all cases, a ViewComponent should have a parent ViewComponent
    }

    /*
     * Returns this components x,y start and end values in
     * the form of an int[] where [0]=xStart, [1]=xEnd, [2]=yStart
     * [3]=yEnd
     */
    public int[] getXY()
    {
        return xyCords;
    }

    /*
     * the input is not relative to its parent by default, contrary to the typical convention
     * the ViewComponents are supposed to use. This is in part because ViewComponent doesnt contain
     * who its parents are. Instead, when putting the xyCordsNew into this method, they require preprocessing
     * (making them relative to parent) to be correct.
     */
    public void updateXY(int[] xyCordsNew)
    {
        int xStartDiff = xyCordsNew[0] - xyCords[0];
        int xEndDiff = xyCordsNew[1] - xyCords[1];
        int yStartDiff = xyCordsNew[2] - xyCords[2];
        int yEndDiff = xyCordsNew[3] - xyCords[3];
        
        int[] xyCordsComponent;
        for(ViewComponent component : components)
        {
            xyCordsComponent = component.getXY();
            xyCordsComponent[0] += xStartDiff;
            xyCordsComponent[1] += xEndDiff;
            xyCordsComponent[2] += yStartDiff;
            xyCordsComponent[3] += yEndDiff;
            component.updateXY(xyCordsComponent);
        }
        xyCords = xyCordsNew;
        
        //Still need to actually update the xStart, etc..., of the javaFX object.
        //I think I want this to call a private method which is contained in extensions
        //of this abstract class which handles this.
        updateXYHelper(xyCords);
    }
    public int getOrderRank()
    {
        return orderRank;
    }
    public void setOrderRank(int newRank)
    {
        int rankDifference = newRank-orderRank;
        for(ViewComponent component : components)
        {
            component.setOrderRank(component.getOrderRank()+rankDifference);
        }
        orderRank = newRank;
    }
    //Instead of isHidden boolean, I should just literally hide or
    //unhide
    public void setHidden(boolean isHidden)
    {
        //Calls helper method implemented within this abstract classes extensions
        setHiddenHelper(isHidden);
    }
    public ViewComponent[] getComponents()
    {
        return components;
    }

    /*
     * Adds child ViewComponent to this ViewComponent. input xyCordsNew[] are relative to this ViewComponent's.
     */
    public void addComponent(ViewComponent component, int[] xyCordsNew)
    {
        //Expand capacity if needed
        //NEED TO ENSURE this works and whether it should be componentCapacity-1 or smt else
        if(numChildren == componentCapacity-1)
        {
            int newCapacity = 2*componentCapacity;
            ViewComponent[] newComponents = new ViewComponent[newCapacity];
            for(int i=0; i<componentCapacity; i++)
            {
                newComponents[i] = components[i];
            }
            components = newComponents;
            componentCapacity = newCapacity;
        }
        
        //set child components xy and orderRank
        //calculate its xy cords
        xyCordsNew[0] += xyCords[0];
        xyCordsNew[1] += xyCords[1];
        xyCordsNew[2] += xyCords[2];
        xyCordsNew[3] += xyCords[3];

        component.updateXY(xyCordsNew);
        component.setOrderRank(orderRank+1);

        //Finish
        components[numChildren] = component;
        numChildren++;
    }
    protected abstract void updateXYHelper(int[] xyCords);
    protected abstract void setHiddenHelper(boolean isHidden);
}
