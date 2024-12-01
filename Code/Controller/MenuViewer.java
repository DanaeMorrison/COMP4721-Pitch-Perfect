package Controller;

import Model.*;
import View.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.HashSet;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * The MenuViewer class is responsible for managing and displaying menus in the
 * UI.
 * It initializes menus for units and lessons, handles menu loading and closing,
 * and manages the visibility of menu components.
 */
public class MenuViewer {
    private Controller controller;
    private UI ui;
    private HashMap<Integer, ViewComponent> lessonSelection;
    private RectangleComponent unitSelection;
    private ViewComponent previousMenu;
    private RectangleComponent lessonComplete;
    private RectangleComponent drillComplete;
    private RectangleComponent reviewDrillComplete;
    private int drillCompleteID;
    private final static int PADDING = 50;
    private final static int FILLER = 0;

    /**
     * Constructs a MenuViewer object.
     *
     * @param controller the controller to manage the menu interactions
     * @param ui         the user interface to display the menu
     * @param units      the list of units to be used for initializing menus
     */
    public MenuViewer(Controller controller, UI ui, ArrayList<Unit> units) {
        this.controller = controller;
        this.ui = ui;
        lessonSelection = new HashMap<>();
        initializeMenus(units);
        // loadMenu(previousMenu);
    }

    /**
     * This method sets up the unit selection menu and creates buttons
     * for each unit.
     * It also creates menus for each unit's lessons and drills,
     * setting up buttons for each lesson.
     * The method handles the layout and positioning of these buttons
     * and menus on the screen.
     * 
     * The method performs the following steps:
     * 1. Retrieves the screen width and height from the UI.
     * 2. Sets up the unit selection menu with buttons for each unit.
     * 3. For each unit, creates a menu for its lessons and drills, and
     * sets up buttons for each lesson.
     * 4. Adds the created buttons and menus to the UI and controller.
     * 5. Hides the buttons and menus initially, and sets up their
     * positions on the screen.
     * 6. Displays the unit selection menu.
     * 
     * @param units An ArrayList of Unit objects representing the units to be
     *              displayed.
     */
    public void initializeMenus(ArrayList<Unit> units) {
        System.out.println("Initializing menus");
        int screenWidth = ui.getScreenWidth();
        System.out.println("-1");
        int screenHeight = ui.getScreenHeight();
        System.out.println("0");
        // Setup the menus:
        System.out.println("Testing Menu Setup");

        // Unit selection:
        System.out.println("1");
        // Size of screen
        int[] screenSize = new int[] { 0, screenWidth, 0, screenHeight };
        // The ID of the component that holds all unit buttons
        int unitSelectionID = ui.createViewComponent("rectangle");
        unitSelection = (RectangleComponent) ui.getViewComponent(unitSelectionID);
        unitSelection.updateXY(screenSize);
        System.out.println("2");
        // Okay and we'd want menus for each unit
        int numUnits = units.size();
        // Determine how wide a unit button can be based on width of screen
        // Give it padding to be separate from other units
        // int unitButtonWidth = screenWidth/numUnits;
        int unitButtonWidth = screenWidth / numUnits - (PADDING + PADDING);
        // int[] unitXYCords = new int[]{0,unitButtonWidth,0,screenHeight};
        int[] unitXYCords = new int[] { PADDING, unitButtonWidth, 300, 100 };
        ButtonComponent button;
        int buttonID;
        int menuID;
        RectangleComponent currMenu;
        int lessonButtonWidth;
        int[] lessonXYCords;
        System.out.println("3");
        for (Unit unit : units) {
            if (unit != null) {
                buttonID = ui.createViewComponent(unitSelectionID, "button", unitXYCords);
                button = (ButtonComponent) ui.getViewComponent(buttonID);
                button.setMessage("showLessonSelection " + unit.getUnitID());
                button.setText(unit.getName());
                controller.addParsable(buttonID);
                // unitXYCords[0] += unitButtonWidth;
                unitXYCords[0] += unitButtonWidth + PADDING + PADDING;
                // unitXYCords[1] += unitButtonWidth;
                button.setHidden(true);

                // lets make each units menus as well
                menuID = ui.createViewComponent("rectangle");
                currMenu = (RectangleComponent) ui.getViewComponent(menuID);
                currMenu.updateXY(screenSize);
                // lessonButtonWidth = screenWidth/(unit.getNumLessons() + unit.getNumDrills());
                lessonButtonWidth = screenWidth / (unit.getNumLessons() + unit.getNumDrills()) - (PADDING + PADDING);
                // lessonXYCords = new int[]{0, lessonButtonWidth, 0, screenHeight};
                lessonXYCords = new int[] { PADDING, lessonButtonWidth, 300, 100 };
                Lesson[] lessons = unit.getLessons();
                System.out.println("For " + unit.getName() + ", there are " + Integer.toString(unit.getNumLessons())
                        + " lessons.");
                for (int i = 0; i < unit.getNumLessons(); i++) {
                    System.out.println("Making lesson: " + i);
                    buttonID = ui.createViewComponent(menuID, "button", lessonXYCords);
                    button = (ButtonComponent) ui.getViewComponent(buttonID);
                    // button.setMessage("loadLesson "+lessons[i].getLessonID());
                    button.setMessage("loadLesson " + lessons[i].getLessonID() + " " + menuID);
                    button.setText(lessons[i].getName());
                    controller.addParsable(buttonID);
                    // lessonXYCords[0] += lessonButtonWidth;
                    lessonXYCords[0] += lessonButtonWidth + PADDING + PADDING;
                    // lessonXYCords[1] += lessonButtonWidth;
                    button.getObject().toBack();
                    button.setHidden(true);
                }

                System.out.println("Making drill");
                buttonID = ui.createViewComponent(menuID, "button", lessonXYCords);
                button = (ButtonComponent) ui.getViewComponent(buttonID);
                // button.setMessage("loadLesson "+lessons[i].getLessonID());
                button.setMessage("loadDrill " + unit.getDrills()[0].getLessonID() + " " + menuID);
                button.setText(unit.getDrills()[0].getName());
                controller.addParsable(buttonID);
                // lessonXYCords[0] += lessonButtonWidth;
                lessonXYCords[0] += lessonButtonWidth + PADDING + PADDING;
                // lessonXYCords[1] += lessonButtonWidth;
                button.getObject().toBack();
                button.setHidden(true);

                lessonSelection.put(unit.getUnitID(), currMenu);
                System.out.println("lesson selection size is: " + Integer.toString(lessonSelection.size()));
                System.out.println("Current unit ID is: " + Integer.toString(unit.getUnitID()));
                currMenu.setHidden(false);
                currMenu.getObject().toFront();
                close(currMenu);
            }
        }

        // Screen for Lesson Completion
        int lessonCompleteID = ui.createViewComponent("rectangle");
        lessonComplete = (RectangleComponent) ui.getViewComponent(lessonCompleteID);
        lessonComplete.updateXY(screenSize);
        int returnButtonWidth = screenWidth - (PADDING + PADDING);
        int[] returnXYCords = new int[] { PADDING, returnButtonWidth, 300, 100 };
        // Add text to say that the lesson is complete

        // Create button that brings user back to unit selection
        buttonID = ui.createViewComponent(lessonCompleteID, "button", returnXYCords);
        button = (ButtonComponent) ui.getViewComponent(buttonID);
        button.setMessage("showUnitSelection " + unitSelectionID);
        button.setText("Return to Menu");
        controller.addParsable(buttonID);
        button.setHidden(true);
        lessonComplete.setHidden(false);
        lessonComplete.getObject().toFront();
        close(lessonComplete);

        // Screen for Drill Completion with review
        int reviewDrillCompleteID = ui.createViewComponent("rectangle");
        reviewDrillComplete = (RectangleComponent) ui.getViewComponent(reviewDrillCompleteID);
        reviewDrillComplete.updateXY(screenSize);
        // Add text to say that the lesson is complete

        // Create button that brings user back to unit selection
        buttonID = ui.createViewComponent(reviewDrillCompleteID, "button", returnXYCords);
        button = (ButtonComponent) ui.getViewComponent(buttonID);
        button.setMessage("showUnitSelection " + unitSelectionID);
        button.setText("Return to Menu");
        controller.addParsable(buttonID);
        button.setHidden(true);

        // Create review button
        int reviewButtonWidth = screenWidth - (PADDING + PADDING);
        int[] reviewXYCords = new int[] { PADDING, reviewButtonWidth, 450, 100 };

        buttonID = ui.createViewComponent(reviewDrillCompleteID, "button", reviewXYCords);
        button = (ButtonComponent) ui.getViewComponent(buttonID);
        // button.setMessage("loadLesson "+lessons[i].getLessonID());
        // button.setMessage("loadLesson " + reviewLesson.getLessonID() + " " +
        // reviewDrillCompleteID);
        button.setText("Review Lesson");
        controller.addParsable(buttonID);
        button.getObject().toBack();
        button.setHidden(true);

        reviewDrillComplete.setHidden(false);
        reviewDrillComplete.getObject().toFront();
        close(reviewDrillComplete);

        // drillComplete.setHidden(false);
        // drillComplete.getObject().toFront();
        // close(drillComplete);

        // Make a public method that can be called in controller if the activity is a
        // drill,
        // where if there are incorrect answers from a drill the menuviewer will update
        // the drillcomplete component to add the review button that will link to the
        // review lesson

        System.out.println("Menu creation complete. loading unit selection");
        loadMenu(unitSelection);
        previousMenu = unitSelection;
        System.out.println("Unit selection displayed");

        // Create button that brings user to review lesson if selected
        // If any questions were answered incorrectly
    }

    /*
     * brings a ViewComponents children to the front using breadth first search
     */
    public void loadMenu(String menuID) {
        System.out.println("MenuID: " + menuID);
        if (previousMenu != null) {
            close(previousMenu);
        }
        String[] args = menuID.split(" ");
        if (args.length != 2) {
            throw new IllegalArgumentException("Cant load menu, command doesnt have the correct number of arguments");
        }
        ViewComponent menu;
        if (args[0].equals("showUnitSelection")) {
            menu = unitSelection;
        } else if (args[0].equals("showLessonComplete")) {
            menu = lessonComplete;
        } else if (args[0].equals("showDrillComplete")) {
            menu = drillComplete;
        } else if (args[0].equals("showReviewDrillComplete")) {
            menu = reviewDrillComplete;
        } else if (args[0].equals("showLessonSelection")) {
            menu = lessonSelection.get(Integer.parseInt(args[1]));

            // menu = unitSelection.getComponents()
            System.out.println("UnitID " + args[1] + " selected");

            if (menu == null) {
                System.out.println("FAILED");
                throw new IllegalArgumentException("Not a valid menu");
            }
        } else {
            throw new IllegalArgumentException("Not a valid menu");
        }
        System.out.println("Menu children components: " + Integer.toString(menu.getNumChildren()));
        System.out.println("calling loadMenu");
        loadMenu(menu);
        previousMenu = menu;
    }

    /**
     * Loads the given menu and sets its components to be visible.
     *
     * @param menu the ViewComponent representing the menu to be loaded
     */
    private void loadMenu(ViewComponent menu) {
        System.out.println("Menu children components: " + Integer.toString(menu.getNumChildren()));
        System.out.println("Loading menu");
        /**
         * Queue<ViewComponent> queue = new LinkedList<>();
         * HashSet<ViewComponent> visited = new HashSet<>();
         * queue.add(menu);
         * visited.add(menu);
         * ViewComponent current;
         * boolean first = true;
         * while(queue.peek() != null)
         * {
         * current = queue.remove();
         * //current.setHidden(true);
         * current.setHidden(false);
         * current.toFront();
         * for(ViewComponent child : current.getComponents())
         * {
         * if(!visited.contains(child))
         * {
         * queue.add(child);
         * visited.add(child);
         * }
         * }
         * }
         */

        for (ViewComponent component : menu.getComponents()) {
            if (component != null) {
                component.setHidden(false);
                // component.toFront();
            }
        }

        System.out.println("Menu loaded");
        // maybe for anything being shown, "current" should only ever be 1 thing- the
        // parent.
        // so we go through the parent and display each of its components
        // for the menu with units, that means only the available units will be
        // displayed
        // for the menu of a unit, that means only the available lessons will be
        // displayed
    }

    /**
     * Closes the given ViewComponent and all its child components recursively.
     * If the given component is null, it returns true.
     * If all child components are successfully closed, the given component is
     * marked as hidden.
     *
     * @param obj the ViewComponent to be closed
     * @return true if the given component and all its child components are hidden,
     *         false otherwise
     */
    public boolean close(ViewComponent obj) {
        if (obj == null) {
            return true;
        }
        ViewComponent[] components = obj.getComponents();
        boolean allHidden = true;
        for (ViewComponent component : components) {
            if (!close(component)) {
                allHidden = false;
            }
        }
        if (allHidden) {
            obj.setHidden(true);
        }
        return obj.getHidden();
    }

    public void updateDrillCompleteScreen(Lesson reviewLesson) {
        System.out.println("Adding review lesson to drill complete screen");
        ButtonComponent button;
        int buttonID;
        // RectangleComponent currMenu;
        int screenWidth = ui.getScreenWidth();
        int reviewButtonWidth = screenWidth - (PADDING + PADDING);
        int[] reviewXYCords = new int[] { PADDING, reviewButtonWidth, 450, 100 };

        buttonID = ui.createViewComponent(drillCompleteID, "button", reviewXYCords);
        button = (ButtonComponent) ui.getViewComponent(buttonID);
        // button.setMessage("loadLesson "+lessons[i].getLessonID());
        button.setMessage("loadLesson " + reviewLesson.getLessonID() + " " + drillCompleteID);
        button.setText(reviewLesson.getName());
        controller.addParsable(buttonID);
        drillComplete = (RectangleComponent) ui.getViewComponent(drillCompleteID);
        button.getObject().toBack();
        button.setHidden(true);
    }

    public void createNewDrillCompleteScreen(Lesson reviewLesson) {
        System.out.println("Creating complete screen with review lesson");
        ButtonComponent button;
        int buttonID;
        // RectangleComponent currMenu;
        int screenWidth = ui.getScreenWidth();
        int screenHeight = ui.getScreenHeight();
        int[] screenSize = new int[] { 0, screenWidth, 0, screenHeight };

        int reviewDrillCompleteID = ui.createViewComponent("rectangle");
        reviewDrillComplete = (RectangleComponent) ui.getViewComponent(drillCompleteID);
        reviewDrillComplete.updateXY(screenSize);

        int returnButtonWidth = screenWidth - (PADDING + PADDING);
        int[] returnXYCords = new int[] { PADDING, returnButtonWidth, 300, 100 };
        // Add text to say that the lesson is complete

        // Create button that brings user back to unit selection
        buttonID = ui.createViewComponent(reviewDrillCompleteID, "button", returnXYCords);
        button = (ButtonComponent) ui.getViewComponent(buttonID);
        button.setMessage("showUnitSelection " + FILLER);
        button.setText("Return to Menu");
        controller.addParsable(buttonID);
        button.setHidden(true);

        // Create review button
        int reviewButtonWidth = screenWidth - (PADDING + PADDING);
        int[] reviewXYCords = new int[] { PADDING, reviewButtonWidth, 450, 100 };

        buttonID = ui.createViewComponent(reviewDrillCompleteID, "button", reviewXYCords);
        button = (ButtonComponent) ui.getViewComponent(buttonID);
        // button.setMessage("loadLesson "+lessons[i].getLessonID());
        button.setMessage("loadLesson " + reviewLesson.getLessonID() + " " + reviewDrillCompleteID);
        button.setText(reviewLesson.getName());
        controller.addParsable(buttonID);
        button.getObject().toBack();
        button.setHidden(true);

        reviewDrillComplete.setHidden(false);
        reviewDrillComplete.getObject().toFront();
        close(reviewDrillComplete);
    }
}
