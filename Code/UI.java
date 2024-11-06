import java.util.HashMap;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class UI
{
    private HashMap<Integer,ViewComponent> viewComponents;
    private int numComponents;
    private Pane pane;
    //NOT YET IMPLEMENTED private AudioComponent audioComponent = new audioComponent;

    public UI(Stage primaryStage)
    {
        viewComponents = new HashMap<>();
        numComponents = 0;

        //javafx init
        pane = new Pane();
        Scene scene = new Scene(pane, 400, 300);

        // Set up the Stage
        primaryStage.setTitle("JavaFX Rectangle Display");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Should create a factory pattern to create view components. View components can be shared across other view components as long as 
     * their position is updated once their shown again. Must be careful and set in place rules for this behaviour as it can probably get 
     * undefined easily.
     */

    public HashMap<Integer,ViewComponent> getViewComponents()
    {
        return viewComponents;
    }
    public ViewComponent getViewComponent(int viewComponentID)
    {
        return viewComponents.get(viewComponentID);
    }

    /**
     * Two ways of creating a view component, specify its parents viewComponentID for it to be 
     * attached as a child of that ViewComponent or dont for it to not have a parent.
     * 
     * Takes a string input into what is essentially switch statements to create the desired ViewComponent class
     * 
     * returns the id of the created viewComponent
     */
    public int createViewComponent(int parentID, String componentType, int[] cords)
    {
        ViewComponent parent = viewComponents.get(parentID);
        
        int newComponentID = createViewComponent(componentType);
        ViewComponent newComponent = viewComponents.get(newComponentID);
        parent.addComponent(newComponent, cords);
        return newComponentID;
    }
    public int createViewComponent(String componentType)
    {
        System.out.println("Finding constructor");
        // MUST CHANGE CONSTRUCTORS TO TAKE NO INPUT, INSTEAD MUST BUILD THEM
        ViewComponent newComponent;
        if(componentType.equals("text"))
        {
            newComponent = new TextComponent();
        } else if(componentType.equals("image"))
        {
            newComponent = new ImageComponent();
        } else if(componentType.equals("rectangle"))
        {
            System.out.println("HIT rectangle");
            newComponent = new RectangleComponent();
        } else if(componentType.equals("button"))
        {
            newComponent = new ButtonComponent();
        } else 
        {
            throw new IllegalArgumentException("requested component type does not exist");
        }

        newComponent.setID(numComponents);
        pane.getChildren().add(newComponent.getObject());
        viewComponents.put(numComponents, newComponent);
        numComponents++;
        return numComponents-1;
    }
}