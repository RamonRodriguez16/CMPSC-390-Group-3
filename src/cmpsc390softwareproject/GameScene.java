package GameScene;

/**
 *
 * @author David Dziuba
 */

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameScene extends Application
{
    public static void main(String[] args) 
    {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception
    {
        stage.setTitle("Group 3 - Game");
        
        Group root = new Group();
        Scene scene = new Scene(root, 500, 400);
        stage.setScene(scene); 
        stage.show();
    }
}