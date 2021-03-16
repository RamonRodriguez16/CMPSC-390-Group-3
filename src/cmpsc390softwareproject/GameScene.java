package cmpsc390softwareproject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.*;

/**
 *
 * @author Tegop
 */
public class GameScene extends Application
{
    public static void main(String[] args) 
    {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception
    {
        stage.setTitle("Test Scene");
        
        Group root = new Group();
        Scene scene = new Scene(root, 300, 300);
        stage.setScene(scene);

        Sprite player = new Sprite(new Rectangle(50, 50, 50, 50), false);
            Controller playerCon = new Controller(player.getNode(), player.getVelocity(), scene, KeyCode.W, KeyCode.S, KeyCode.A, KeyCode.D);
            player.setController(playerCon);
        
            root.getChildren().add(player.getNode());
        
        AnimationTimer animation = new AnimationTimer()  
        {
            @Override
            public void handle(long now)
            {
                player.update(0.016);
            }
        };
        animation.start();
        
        stage.show();
    }
}