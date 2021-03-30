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
        ImageView object_Wing = new ImageView(new Image("images/object_Wing.png"));
        object_Wing.setFitWidth(40);
        object_Wing.setFitHeight(42);
        object_Wing.setX(100);
        object_Wing.setY(200);
        Item largeWing = new Item(object_Wing, true);
            largeWing.setDesc("Wow! Look at the size of this wing! You could "
                    + "probably fly around like a bird with this, "
                    + "shame there's only one of ‘em.");
        
        //Create item stoneBox
        ImageView object_Box = new ImageView(new Image("images/object_Box.png"));
        object_Box.setFitWidth(50);
        object_Box.setFitHeight(17);
        object_Box.setX(200);
        object_Box.setY(200);
        Item stoneBox = new Item(object_Box, true);
            stoneBox.setDesc("Who makes a box out of stone? That’s gotta be "
                    + "the dum- huh? There’re some gems in here, ‘bout three of "
                    + "them. But it looks like it could fit about five…");

        //Create item chains
        ImageView object_Chains = new ImageView(new Image("images/object_Chains.png"));
        object_Chains.setFitWidth(40);
        object_Chains.setFitHeight(20);
        object_Chains.setX(300);
        object_Chains.setY(200);
        Item chains = new Item(object_Chains, true); 
            chains.setDesc("I’m not one to judge, but I don’t think there’s "
                    + "any place for chains in a home. Wonder who or what "
                    + "they were for.");
        
            
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
