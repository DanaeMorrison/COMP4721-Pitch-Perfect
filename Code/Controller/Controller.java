package Controller;
import View.UI;
import View.ViewComponent;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * For now, making this very bare bones to work with UI
 */
public class Controller
{
    private UI ui;

    public Controller(Stage primaryStage)
    {
        System.out.println("Controller created. Creating UI...");
        ui = new UI(primaryStage);
        createKeyboard();;
    }

    private void createUIObjects()
    {
        int[] cords = new int[4];
        cords[0] = 0;
        cords[2] = 0;
        cords[1] = 400;
        cords[3] = 400;


        System.out.println("Creating rectangle");
        int newComponentID = ui.createViewComponent("rectangle");
        System.out.println("changing view of rectangle");
        ViewComponent rectangle = ui.getViewComponent(newComponentID);
        rectangle.updateXY(cords);


        System.out.println("Done");
    }

    private void createKeyboard()
    {
        int startX=0;
        int startY=0;
        int totalWidth=600;
        int totalHeight=300;
        int keyWidth = totalWidth/12;

        int[] backgroundCords = new int[4];
        backgroundCords[0]=startX;
        backgroundCords[1]=totalWidth;
        backgroundCords[2]=startY;
        backgroundCords[3]=totalHeight;
        int backGroundID = ui.createViewComponent("rectangle");
        ui.getViewComponent(backGroundID).updateXY(backgroundCords);

        int[] keyCords = new int[4];
        keyCords[0]=startX;
        keyCords[1]=keyWidth;
        keyCords[2]=startY;
        keyCords[3]=totalHeight;
        int[] keyIDs = new int[12];
        for(int i=0; i<12; i++)
        {
            keyIDs[i] = ui.createViewComponent("button");
            ui.getViewComponent(keyIDs[i]).updateXY(keyCords);
            keyCords[0]+=keyWidth;
            keyCords[1]+=keyWidth;
        }
    }
}