/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmpsc390softwareproject;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.shape.Rectangle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Group;
import javafx.scene.Scene;
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
            largeWing.setDesc("Wow! Look at the size of this wing! You could "
                    + "probably fly around like a bird with this, "
                    + "shame there's only one of ‘em.");
        
        //Create item stoneBox
        Item stoneBox = new Item(new Rectangle (200, 200, 20, 10), true);
            stoneBox.setDesc("Who makes a box out of stone? That’s gotta be "
                    + "the dum- huh? There’re some gems in here, ‘bout three of "
                    + "them. But it looks like it could fit about five…");

        //Create item chains
        Item chains = new Item(new Rectangle (300, 200, 10, 10), true);    
            chains.setDesc("I’m not one to judge, but I don’t think there’s "
                    + "any place for chains in a home. Wonder who or what "
                    + "they were for.");
        
            
        root.getChildren().add(largeWing.getNode());
        root.getChildren().add(stoneBox.getNode());
        root.getChildren().add(chains.getNode());
    }
}
