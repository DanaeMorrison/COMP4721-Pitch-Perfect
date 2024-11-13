import Controller.Controller;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application
{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        System.out.println("Running");
        Controller controller = new Controller(primaryStage);
        CommandParser commandParser = controller.getParser();
        Thread commandParserThread = new Thread(commandParser);
        commandParserThread.setDaemon(true);
        commandParserThread.start();


        Runtime.getRuntime().addShutdownHook(new Thread(() -> commandParser.stop()));
    }   
}