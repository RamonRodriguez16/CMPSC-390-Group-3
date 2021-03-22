/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cmpsc390softwareproject;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.shape.Rectangle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
/**
 *
 * 
 */
public class CMPSC390SoftwareProject extends Application {
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
        
        
        //Create item largeWing
        Item largeWing = new Item(new Rectangle (100, 200, 10, 30), true);
            largeWing.setDesc("It looks big enough to fly a person around, but there's only one...");
        
        //Create item stoneBox
        Item stoneBox = new Item(new Rectangle (200, 200, 20, 10), true);
            stoneBox.setDesc("Small box that's made of stone and very heavy. Upon inspection you can tell it holds 3 gems, although it was meant for 5!");

        //Create item chains
        Item chains = new Item(new Rectangle (300, 200, 10, 10), true);    
            chains.setDesc("They are attached to the floor. I wonder who they were meant for?");
        
            
        root.getChildren().add(largeWing.getNode());
        root.getChildren().add(stoneBox.getNode());
        root.getChildren().add(chains.getNode());

        ImageView image = new ImageView(new Image("images/New_Piskel.png"));
            //root.getChildren().add(image);
        //Sprite player = new Sprite(new Rectangle(50, 50, 50, 50), false);
        Sprite player = new Sprite(image, false);
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
