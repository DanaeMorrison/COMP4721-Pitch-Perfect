package Controller;

import Model.*;
import View.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.HashSet;
import java.util.HashMap;
import java.util.ArrayList;

import javafx.application.Platform;
import javafx.scene.text.Font;

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
    private RectangleComponent homePage;
    private ImageComponent homePageImage;
    private RectangleComponent lessonComplete;
    private RectangleComponent drillComplete;
    private RectangleComponent reviewDrillComplete;
    private int drillCompleteID;
    ButtonComponent button;
    TextComponent text;
    private final static int PADDING = 50;
    private final static int FILLER = 0;
    private final static Font FONT = new Font(32);

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
        int screenWidth = ui.getScreenWidth();
        int screenHeight = ui.getScreenHeight();
        // Setup the menus:

        // Unit selection:
        int[] screenSize = new int[] { 0, screenWidth, 0, screenHeight };
        int unitSelectionID = ui.createViewComponent("rectangle");
        unitSelection = (RectangleComponent) ui.getViewComponent(unitSelectionID);
        unitSelection.updateXY(screenSize);
        int numUnits = units.size();
        int unitButtonWidth = screenWidth / numUnits - (PADDING + PADDING);
        int[] unitXYCords = new int[] { PADDING, unitButtonWidth, 300, 100 };
        int buttonID;
        int menuID;
        RectangleComponent currMenu;
        int lessonButtonWidth;
        int[] lessonXYCords;

        for (Unit unit : units) {
            if (unit != null) {
                buttonID = ui.createViewComponent(unitSelectionID, "button", unitXYCords);
                button = (ButtonComponent) ui.getViewComponent(buttonID);
                button.setMessage("showLessonSelection " + unit.getUnitID());
                button.setText(unit.getName());
                controller.addParsable(buttonID);
                unitXYCords[0] += unitButtonWidth + PADDING + PADDING;
                button.setHidden(true);

                menuID = ui.createViewComponent("rectangle");
                currMenu = (RectangleComponent) ui.getViewComponent(menuID);
                currMenu.updateXY(screenSize);
                lessonButtonWidth = screenWidth / (unit.getNumLessons() + unit.getNumDrills()) - (PADDING + PADDING);
                lessonXYCords = new int[] { PADDING, lessonButtonWidth, 300, 100 };
                Lesson[] lessons = unit.getLessons();

                for (int i = 0; i < unit.getNumLessons(); i++) {
                    buttonID = ui.createViewComponent(menuID, "button", lessonXYCords);
                    button = (ButtonComponent) ui.getViewComponent(buttonID);
                    button.setMessage("loadLesson " + lessons[i].getLessonID() + " " + menuID);
                    button.setText(lessons[i].getName());
                    controller.addParsable(buttonID);
                    lessonXYCords[0] += lessonButtonWidth + PADDING + PADDING;
                    button.getObject().toBack();
                    button.setHidden(true);
                }

                buttonID = ui.createViewComponent(menuID, "button", lessonXYCords);
                button = (ButtonComponent) ui.getViewComponent(buttonID);
                button.setMessage("loadDrill " + unit.getDrills()[0].getLessonID() + " " + menuID);
                button.setText(unit.getDrills()[0].getName());
                controller.addParsable(buttonID);
                lessonXYCords[0] += lessonButtonWidth + PADDING + PADDING;
                button.getObject().toBack();
                button.setHidden(true);

                lessonSelection.put(unit.getUnitID(), currMenu);
                currMenu.setHidden(false);
                currMenu.getObject().toFront();
                close(currMenu);
            }
        }

        // Home page
        int homePageID = ui.createViewComponent("rectangle");
        homePage = (RectangleComponent) ui.getViewComponent(homePageID);
        homePage.updateXY(screenSize);
        
        int homePageImageID = ui.createViewComponent(homePageID, "image", screenSize);
        homePageImage = (ImageComponent) ui.getViewComponent(homePageImageID);
        homePageImage.changeImage("/Assets/homePage.png");
        homePageImage.updateXY(screenSize);
        
        int[] startButtonXYCords = new int[] { 600, 150, 450, 50 };
        
        buttonID = ui.createViewComponent(homePageID, "button", startButtonXYCords);
        button = (ButtonComponent) ui.getViewComponent(buttonID);
        button.setMessage("showUnitSelection " + unitSelectionID);
        button.setText("Start");
        controller.addParsable(buttonID);
        button.setHidden(true);
        homePage.setHidden(true);
        homePage.getObject().toFront();
        close(homePage);

        // Screen for Lesson Completion
        int lessonCompleteID = ui.createViewComponent("rectangle");
        lessonComplete = (RectangleComponent) ui.getViewComponent(lessonCompleteID);
        lessonComplete.updateXY(screenSize);
        int returnButtonWidth = screenWidth - (PADDING + PADDING);
        int[] returnXYCords = new int[] { PADDING, returnButtonWidth, 300, 100 };
        int[] lessonCompleteTestXYCords = new int[] {550, 900, 50, 75};
        int lessonCompleteTextID = ui.createViewComponent(lessonCompleteID, "text", lessonCompleteTestXYCords);
        TextComponent lessonCompleteText = (TextComponent) ui.getViewComponent(lessonCompleteTextID);
        lessonCompleteText.setText("Lesson Complete");
        lessonCompleteText.setFont(FONT);
        lessonCompleteText.setXY(lessonCompleteTestXYCords);
        lessonCompleteText.setHidden(true);
        buttonID = ui.createViewComponent(lessonCompleteID, "button", returnXYCords);
        button = (ButtonComponent) ui.getViewComponent(buttonID);
        button.setMessage("back");
        button.setText("Return to Menu");
        controller.addParsable(buttonID);
        button.setHidden(true);
        lessonComplete.setHidden(false);
        lessonComplete.getObject().toFront();
        close(lessonComplete);

        // Screen for Drill Completion without review
        int drillCompleteID = ui.createViewComponent("rectangle");
        drillComplete = (RectangleComponent) ui.getViewComponent(drillCompleteID);
        drillComplete.updateXY(screenSize);
        int[] drillCompleteTextXYCords = new int[] {600, 900, 50, 75};
        int drillCompleteTextID = ui.createViewComponent(drillCompleteID, "text", drillCompleteTextXYCords);
        text = (TextComponent) ui.getViewComponent(drillCompleteTextID);
        text.setText("Drill Complete");
        text.setFont(FONT);
        text.setXY(drillCompleteTextXYCords);
        text.setHidden(true);

        int[] drillCompleteScoreXYCords = new int[] {450, 950, 100, 125};
        int drillCompleteScoreID = ui.createViewComponent(drillCompleteID, "text", drillCompleteScoreXYCords);
        text = (TextComponent) ui.getViewComponent(drillCompleteScoreID);
        text.setText("You answered everything correctly!");
        text.setFont(FONT);
        text.setXY(drillCompleteScoreXYCords);
        text.setHidden(true);

        buttonID = ui.createViewComponent(drillCompleteID, "button", returnXYCords);
        button = (ButtonComponent) ui.getViewComponent(buttonID);
        button.setMessage("back");
        button.setText("Return to Menu");
        controller.addParsable(buttonID);
        button.setHidden(true);

        drillComplete.setHidden(false);
        drillComplete.getObject().toFront();
        close(drillComplete);

        System.out.println("Menu creation complete. loading unit selection");
        loadMainMenu();
        System.out.println("Unit selection displayed");
    }

    /**
     * Brings a ViewComponent's children to the front using breadth-first search.
     *
     * @param menuID the ID of the menu to be loaded
     */
    public void loadMenu(String menuID) {
        if (previousMenu != null) {
            close(previousMenu);
        }
        String[] args = menuID.split(" ");
        if (args.length != 2) {
            throw new IllegalArgumentException("Cant load menu, command doesnt have the correct number of arguments");
        }
        ViewComponent menu;
        if (args[0].equals("showHomePage")) {
            menu = homePage;
        } else if (args[0].equals("showUnitSelection")) {
            menu = unitSelection;
        } else if (args[0].equals("showLessonComplete")) {
            menu = lessonComplete;
        } else if (args[0].equals("showDrillComplete")) {
            menu = drillComplete;
        } else if (args[0].equals("showReviewDrillComplete")) {
            menu = reviewDrillComplete;
        } else if (args[0].equals("showLessonSelection")) {
            menu = lessonSelection.get(Integer.parseInt(args[1]));
            if (menu == null) {
                throw new IllegalArgumentException("Not a valid menu");
            }
        } else {
            throw new IllegalArgumentException("Not a valid menu");
        }
        loadMenu(menu);
        previousMenu = menu;
    }

    /**
     * Loads the given menu and sets its components to be visible.
     *
     * @param menu the ViewComponent representing the menu to be loaded
     */
    private void loadMenu(ViewComponent menu) {
        for (ViewComponent component : menu.getComponents()) {
            if (component != null) {
                component.setHidden(false);
            }
        }
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

    /**
     * Updates the drill complete screen with a review lesson button.
     *
     * @param reviewLesson the lesson to be reviewed
     */
    public void updateDrillCompleteScreen(Lesson reviewLesson) {
        int buttonID;
        int screenWidth = ui.getScreenWidth();
        int reviewButtonWidth = screenWidth - (PADDING + PADDING);
        int[] reviewXYCords = new int[] { PADDING, reviewButtonWidth, 450, 100 };

        buttonID = ui.createViewComponent(drillCompleteID, "button", reviewXYCords);
        button = (ButtonComponent) ui.getViewComponent(buttonID);
        button.setMessage("loadLesson " + reviewLesson.getLessonID() + " " + drillCompleteID);
        button.setText(reviewLesson.getName());
        controller.addParsable(buttonID);
        drillComplete = (RectangleComponent) ui.getViewComponent(drillCompleteID);
        button.getObject().toBack();
        button.setHidden(true);
    }

    /**
     * Creates a new drill complete screen with a review lesson button and score.
     *
     * @param reviewLesson         the lesson to be reviewed
     * @param totalDrillFlashcards the total number of drill flashcards
     * @param numberCorrectAnswers the number of correct answers
     */
    public void createNewDrillCompleteScreen(Lesson reviewLesson, int totalDrillFlashcards, int numberCorrectAnswers) {
        int buttonID;
        int screenWidth = ui.getScreenWidth();
        int screenHeight = ui.getScreenHeight();
        int[] screenSize = new int[] { 0, screenWidth, 0, screenHeight };

        int reviewDrillCompleteID = ui.createViewComponent("rectangle");
        reviewDrillComplete = (RectangleComponent) ui.getViewComponent(reviewDrillCompleteID);
        reviewDrillComplete.updateXY(screenSize);

        int returnButtonWidth = screenWidth - (PADDING + PADDING);
        int[] returnXYCords = new int[] { PADDING, returnButtonWidth, 300, 100 };

        buttonID = ui.createViewComponent(reviewDrillCompleteID, "button", returnXYCords);
        button = (ButtonComponent) ui.getViewComponent(buttonID);
        button.setMessage("back");
        button.setText("Return to Menu");
        controller.addParsable(buttonID);
        button.setHidden(true);

        int reviewButtonWidth = screenWidth - (PADDING + PADDING);
        int[] reviewXYCords = new int[] { PADDING, reviewButtonWidth, 450, 100 };

        buttonID = ui.createViewComponent(reviewDrillCompleteID, "button", reviewXYCords);
        button = (ButtonComponent) ui.getViewComponent(buttonID);
        button.setMessage("loadLesson " + reviewLesson.getLessonID() + " " + reviewDrillCompleteID);
        button.setText(reviewLesson.getName());
        controller.addParsable(buttonID);
        Platform.runLater(() -> {
            button.getObject().toBack();
        });
        button.setHidden(true);

        reviewDrillComplete.setHidden(false);
        Platform.runLater(() -> {
            reviewDrillComplete.getObject().toFront();
        });
        close(reviewDrillComplete);
    }

    /**
     * Prints the score of the drill.
     *
     * @param numberCorrectAnswers the number of correct answers
     * @param totalDrillFlashcards the total number of drill flashcards
     */
    public void printScore(int numberCorrectAnswers, int totalDrillFlashcards) {
        System.out.println("Score: " + Integer.toString(numberCorrectAnswers) + "/" + Integer.toString(totalDrillFlashcards));
    }
    
    /**
     * Loads the main menu.
     */
    public void loadMainMenu() {
        close(previousMenu);
        loadMenu(homePage);
        previousMenu = homePage;
    }
}
