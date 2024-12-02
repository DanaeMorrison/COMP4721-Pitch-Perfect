package View;

import java.util.HashMap;
import java.util.ArrayList;

import javax.sound.midi.MidiUnavailableException;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * The UI class is responsible for managing the user interface components and their interactions.
 */
public class UI {
    private HashMap<Integer, ViewComponent> viewComponents;
    private int numComponents;
    private Pane pane;
    private AudioComponent audioComponent;
    private static final int screenWidth = 1350;
    private static final int screenHeight = 750;

    /**
     * Constructs a new UI instance and initializes the JavaFX stage and scene.
     * 
     * @param primaryStage the primary stage for this application
     * @throws MidiUnavailableException if the synthesizer cannot be opened
     */
    public UI(Stage primaryStage) throws MidiUnavailableException {
        try {
            audioComponent = new AudioComponent();
        } catch (MidiUnavailableException e) {
            System.err.println("Failed to open synthesizer: " + e.getMessage());
            throw e;
        }

        viewComponents = new HashMap<>();
        numComponents = 0;

        // javafx init
        // javafx init
        pane = new Pane();
        pane.setLayoutX(0);
        pane.setLayoutY(0);
        Scene scene = new Scene(pane, screenWidth, screenHeight);
        pane.setPrefSize(screenWidth, screenHeight);

        // Set up the Stage
        primaryStage.setTitle("Pitch Perfect");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * Should create a factory pattern to create view components. View components
     * can be shared across other view components as long as
     * their position is updated once their shown again. Must be careful and set in
     * place rules for this behaviour as it can probably get
     * undefined easily.
     */

    /**
     * Returns the screen width.
     * 
     * @return the screen width
     */
    public int getScreenWidth() {
        return screenWidth;
    }

    /**
     * Returns the screen height.
     * 
     * @return the screen height
     */
    public int getScreenHeight() {
        return screenHeight;
    }

    /**
     * Returns the map of view components.
     * 
     * @return the map of view components
     */
    public HashMap<Integer, ViewComponent> getViewComponents() {
        return viewComponents;
    }

    /**
     * Returns the view component with the specified ID.
     * 
     * @param viewComponentID the ID of the view component
     * @return the view component with the specified ID
     */
    public ViewComponent getViewComponent(int viewComponentID) {
        return viewComponents.get(viewComponentID);
    }

    /**
     * Returns the audio component.
     * 
     * @return the audio component
     */
    public AudioComponent getAudioComponent() {
        return audioComponent;
    }

    /**
     * Two ways of creating a view component, specify its parents viewComponentID
     * for it to be
     * attached as a child of that ViewComponent or dont for it to not have a
     * parent.
     * 
     * Takes a string input into what is essentially switch statements to create the
     * desired ViewComponent class
     * 
     * returns the id of the created viewComponent
     */
    /**
     * Creates a new view component and attaches it as a child to the specified parent component.
     * 
     * @param parentID the ID of the parent view component
     * @param componentType the type of the view component to create
     * @param cords the coordinates for the new component
     * @return the ID of the created view component
     */
    public int createViewComponent(int parentID, String componentType, int[] cords) {
        ViewComponent parent = viewComponents.get(parentID);

        int newComponentID = createViewComponent(componentType);
        ViewComponent newComponent = viewComponents.get(newComponentID);
        parent.addComponent(newComponent, cords);
        return newComponentID;
    }

    /**
     * Creates a new view component of the specified type.
     * 
     * @param componentType the type of the view component to create
     * @return the ID of the created view component
     */
    public int createViewComponent(String componentType) {
        System.out.println("Finding constructor");
        // MUST CHANGE CONSTRUCTORS TO TAKE NO INPUT, INSTEAD MUST BUILD THEM
        ViewComponent newComponent;
        if (componentType.equals("text")) {
            newComponent = new TextComponent();
        } else if (componentType.equals("image")) {
            newComponent = new ImageComponent();
        } else if (componentType.equals("rectangle")) {
            System.out.println("HIT rectangle");
            newComponent = new RectangleComponent();
        } else if (componentType.equals("button")) {
            newComponent = new ButtonComponent();
        } else {
            throw new IllegalArgumentException("requested component type does not exist");
        }

        newComponent.setID(numComponents);
        // pane.getChildren().add(newComponent.getObject());

        Platform.runLater(() -> {
            pane.getChildren().add(newComponent.getObject());
        });
        viewComponents.put(numComponents, newComponent);
        numComponents++;
        return numComponents - 1;
    }

    /*
     * with current datastructure I'm using, i must do more to ensure that the
     * maximum orderRank is never
     * more than numComponents
     */
    /**
     * Sorts the view components based on their order rank and brings them to the front in the correct order.
     */
    public void sortViewOrder() {
        ArrayList<Integer>[] sortedComponents = new ArrayList[numComponents];
        for (int i = 0; i < numComponents; i++) {
            sortedComponents[i] = new ArrayList<Integer>();
        }
        for (ViewComponent component : viewComponents.values()) {
            if (!component.getHidden()) {
                sortedComponents[component.getOrderRank()].add(component.getID());
            }
        }
        for (int i = 0; i < numComponents; i++) {
            for (int id : sortedComponents[i]) {
                getViewComponent(id).toFront();
            }
        }
    }
}
