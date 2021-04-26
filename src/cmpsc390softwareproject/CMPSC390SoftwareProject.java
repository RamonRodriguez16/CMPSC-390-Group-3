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
        boolean moving = false;
        
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
            // add items
                root.getChildren().add(largeWing.getNode());
                root.getChildren().add(stoneBox.getNode());
                root.getChildren().add(chains.getNode());

        // add the player
        // Sprite player = new Sprite(new Rectangle(50, 50, 50, 50), false);
        ImageView image = new ImageView(new Image("images/New_Piskel.png", 50, 50, true, true));
            image.setY(scene.getWidth() / 2);
            image.setX(scene.getHeight() / 2);
//                 Testing ->
//                    root.getChildren().add(image);
        Player player = new Player(image, false);
            Controller playerCon = new Controller(player.getNode(), player.getVelocity(), scene, KeyCode.W, KeyCode.S, KeyCode.A, KeyCode.D);
            player.setController(playerCon);
                root.getChildren().add(player.getNode());
                
        ImageView image2 = new ImageView(new Image("images/Final_Boss.png", 50, 50, true, true));
            image2.setY(scene.getWidth() / 5);
            image2.setX(scene.getHeight() / 1.5);
        Enemy enemy = new Enemy(image2, true);
            root.getChildren().add(enemy.getNode());
            
        // add the scene boarders
        Sprite topWall = new Sprite(new Rectangle(0, 0, scene.getWidth(), 5), true);
        Sprite bottomWall = new Sprite(new Rectangle(0, scene.getHeight() - 5, scene.getWidth(), 5), true);
        Sprite leftWall = new Sprite(new Rectangle(0, 0, 5, scene.getHeight()), true);
        Sprite rightWall = new Sprite(new Rectangle(scene.getWidth() - 5, 0, 5, scene.getHeight()), true);
            root.getChildren().add(topWall.getNode());
            root.getChildren().add(bottomWall.getNode());
            root.getChildren().add(leftWall.getNode());
            root.getChildren().add(rightWall.getNode());
            
        AnimationTimer animation = new AnimationTimer()  
        {
            @Override
            public void handle(long now)
            {
                player.update(0.016);
                
                player.getCollision().checkCollisionY(topWall.getNode());
                player.getCollision().checkCollisionY(bottomWall.getNode());
                player.getCollision().checkCollisionX(leftWall.getNode());
                player.getCollision().checkCollisionX(rightWall.getNode());
                
                player.getCollision().checkCollisionX(largeWing.getNode());
                player.getCollision().checkCollisionY(largeWing.getNode());
                player.getCollision().checkCollisionX(stoneBox.getNode());
                player.getCollision().checkCollisionY(stoneBox.getNode());
                player.getCollision().checkCollisionX(chains.getNode());
                player.getCollision().checkCollisionY(chains.getNode());
                
                enemy.checkCollision(player, scene);
//                if(moving == false)
//                {
//                    switch(player.getVelocity().velDif())
//                    {
//                        case -2:
//                            System.out.println("going left");
//                            break;
//                        case -1:
//                            System.out.println("going up");
//                            break;
//                        case 1:
//                            System.out.println("going down");
//                            break;
//                        case 2:
//                            System.out.println("going right");
//                            break;
//                        default:
//                            break;
//                    }
//                }
                
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
