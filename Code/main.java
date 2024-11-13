import Controller.Controller;
import Controller.CommandParser;
import javafx.application.Application;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;

public class main extends Application
{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException
    {
        System.out.println("Running");
        File stateFile = new File("./input.txt");
        Controller controller = new Controller(primaryStage, stateFile);
        CommandParser commandParser = controller.getParser();
        Thread commandParserThread = new Thread(commandParser);
        commandParserThread.setDaemon(true);
        commandParserThread.start();


        Runtime.getRuntime().addShutdownHook(new Thread(() -> commandParser.stop()));
    }   
}