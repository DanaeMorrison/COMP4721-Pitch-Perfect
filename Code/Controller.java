

/**
 * For now, making this very bare bones to work with UI
 */
public class Controller
{
    public static void main(String[] args)
    {
        System.out.println("Running");
        Controller controller = new Controller();
    }
    
    private UI ui;

    public Controller()
    {
        ui = new UI();
    }

    private createUIObjects()
    {
        int newComponentID = UI.createViewComponent("rectangle");

    }
}