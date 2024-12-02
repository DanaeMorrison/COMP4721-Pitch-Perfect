import Controller.Controller;
import Controller.CommandParser;
import javafx.application.Application;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;

/**
 * Main class that extends the JavaFX Application class.
 * It serves as the entry point for the application.
 */
public class Main extends Application
{
    /**
     * The main method that launches the JavaFX application.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * The start method is called after the application is launched.
     * It initializes the primary stage and starts the command parser thread.
     *
     * @param primaryStage the primary stage for this application
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void start(Stage primaryStage) throws IOException
    {
        System.out.println("Running");
        File stateFile = new File("../input.txt");
        try{
            Controller controller = new Controller(primaryStage);
            CommandParser commandParser = controller.getParser();
            Thread commandParserThread = new Thread(commandParser);
            commandParserThread.setDaemon(true);
            System.out.println("Starting thread:");
            commandParserThread.start();
            System.out.println("should be started");
            Runtime.getRuntime().addShutdownHook(new Thread(() -> commandParser.stop()));
        }
        catch(Exception exception){
            System.out.println(exception);            
        }
    }   
}
