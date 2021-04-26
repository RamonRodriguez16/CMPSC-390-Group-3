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
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
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
        Group fightLayout = new Group();
        Scene scene = new Scene(root, 500, 400);
        Scene fightScene = new Scene(fightLayout, 500, 400);
        stage.setScene(scene); 
        stage.show();
        
        
        
        // Start the Fight
        Button fightButton = new Button("FIGHT!");
        fightButton.setOnAction(e -> stage.setScene(fightScene));
        root.getChildren().add(fightButton);
        
        // Exit the Fight
        Button exitButton = new Button("FLEE!");
        exitButton.setOnAction(e -> stage.setScene(scene));
        fightLayout.getChildren().add(exitButton);
        
        
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
        
        
        // Testing a narrator thing
        /*
        Rectangle r = new Rectangle();
        r.setX(0);
        r.setY(300);
        r.setWidth(500);
        r.setHeight(100);
        r.setArcWidth(20);
        r.setArcHeight(20);
        r.setStroke(Color.BLACK);
        r.setFill(Color.WHITE);
        root.getChildren().add(r); */
        
        //Text text = new Text("If this works I am one step closer to making a solid game");
        
        Narrator narrator = new Narrator();
        
        Text text = new Text("If this works I am one step closer to making a solid game");
        text.setX(narrator.getX() + 20);
        text.setY(narrator.getY() + 50);
        root.getChildren().addAll(narrator, text);
        stage.show();
    }
}
