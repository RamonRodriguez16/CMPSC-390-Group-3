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
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
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
    public void start(Stage stage) throws Exception {
        // ===== Initialize the Scenes ===== \\
        stage.setTitle("Group 3 - Game");  

        // creating the group, window, and scene for the root
        Group root = new Group();
            GridPane rootWindow = new GridPane();
                rootWindow.setMinSize(500, 400);
                rootWindow.add(root, 0, 0);

            Scene rootScene = new Scene(rootWindow, 500, 400);

        // creating the group, window, and scene for the fight
        Group fight = new Group();
            GridPane fightWindow = new GridPane();
                fightWindow.setMinSize(500, 400);
                fightWindow.add(fight, 0, 0);

            Scene fightScene = new Scene(fightWindow, 500, 400);

        // default start scene will be the root
        stage.setScene(rootScene); 
        stage.show();


        
        
        // ===== Setup rootScene ===== \\
        Rectangle rootBackground = new Rectangle(rootScene.getWidth(), (rootScene.getHeight() - (rootScene.getHeight() / 4.0)), Color.ANTIQUEWHITE);
            rootBackground.setX(0);
            rootBackground.setY(0);
                // add the background color
                root.getChildren().add(rootBackground);
        
        // create actual boarders
        Sprite topWall = new Sprite(new Rectangle(0, 0, rootScene.getWidth(), 5), true);
        Sprite bottomWall = new Sprite(new Rectangle(0, rootScene.getHeight() - 5 - 100, rootScene.getWidth(), 5), true);
        Sprite leftWall = new Sprite(new Rectangle(0, 0, 5, rootScene.getHeight() - 100), true);
        Sprite rightWall = new Sprite(new Rectangle(rootScene.getWidth() - 5, 0, 5, rootScene.getHeight() -100), true);
            root.getChildren().add(topWall.getNode());
            root.getChildren().add(bottomWall.getNode());
            root.getChildren().add(leftWall.getNode());
            root.getChildren().add(rightWall.getNode());
        
        // create visual boarders
        ImageView top_wall = new ImageView(new Image("images/Brick_wall.png"));
            top_wall.setFitWidth(rootScene.getWidth() / 10.0);
            top_wall.setFitHeight(25);
            top_wall.setX(0);
            top_wall.setY(0);
            Sprite top_wallSprite = new Sprite(top_wall, true);
                root.getChildren().add(top_wallSprite.getNode());
        ImageView top_wall2 = new ImageView(new Image("images/Brick_wall.png"));
            top_wall2.setFitWidth(rootScene.getWidth() / 10.0);
            top_wall2.setFitHeight(25);
            top_wall2.setX(100);
            top_wall2.setY(0);
            Sprite top_wallSprite2 = new Sprite(top_wall2, true);
                root.getChildren().add(top_wallSprite2.getNode());
        ImageView top_wall3 = new ImageView(new Image("images/Brick_wall.png"));
            top_wall3.setFitWidth(rootScene.getWidth() / 10.0);
            top_wall3.setFitHeight(25);
            top_wall3.setX(200);
            top_wall3.setY(0);
            Sprite top_wallSprite3 = new Sprite(top_wall3, true);
                root.getChildren().add(top_wallSprite3.getNode());
        ImageView top_wall4 = new ImageView(new Image("images/Brick_wall.png"));
            top_wall4.setFitWidth(rootScene.getWidth() / 10.0);
            top_wall4.setFitHeight(25);
            top_wall4.setX(300);
            top_wall4.setY(0);
            Sprite top_wallSprite4 = new Sprite(top_wall4, true);
                root.getChildren().add(top_wallSprite4.getNode());
        ImageView top_wall5 = new ImageView(new Image("images/Brick_wall.png"));
            top_wall5.setFitWidth(rootScene.getWidth() / 10.0);
            top_wall5.setFitHeight(25);
            top_wall5.setX(400);
            top_wall5.setY(0);
            Sprite top_wallSprite5 = new Sprite(top_wall5, true);
                root.getChildren().add(top_wallSprite5.getNode());
//        ImageView bot_wall = new ImageView(new Image("images/Brick_wall.png"));
//            bot_wall.setFitWidth(50);
//            bot_wall.setFitHeight(50);
//            bot_wall.setX(rootScene.getWidth());
//            bot_wall.setY(rootScene.getHeight() - (rootScene.getHeight() / 4.0));
//            Sprite bot_wallSprite = new Sprite(bot_wall, true);
//                root.getChildren().add(bot_wallSprite.getNode());
                
        Narrator rootNarrator = new Narrator();
            rootWindow.add(rootNarrator, 0, 1);
        
            
            
        ImageView object_Wing = new ImageView(new Image("images/object_Wing.png"));
            object_Wing.setFitWidth(30);
            object_Wing.setFitHeight(30);
            object_Wing.setX(130);
            object_Wing.setY((rootScene.getHeight() -100) / 2);
            Item largeWing = new Item(object_Wing, true);
                largeWing.setDesc("Wow! Look at the size of this wing! You could "
                                + "probably fly around like a bird with this, "
                                + "shame there's only one of ‘em.");
        ImageView object_Box = new ImageView(new Image("images/object_Box.png"));
            object_Box.setFitWidth(30);
            object_Box.setFitHeight(30);
            object_Box.setX(225);
            object_Box.setY((rootScene.getHeight() -100) / 2);
            Item stoneBox = new Item(object_Box, true);
                stoneBox.setDesc("Who makes a box out of stone? That’s gotta be "
                                + "the dum- huh? There’re some gems in here, ‘bout three of "
                                + "them. But it looks like it could fit about five…");
        ImageView object_Chains = new ImageView(new Image("images/object_Chains.png"));
            object_Chains.setFitWidth(30);
            object_Chains.setFitHeight(30);
            object_Chains.setX(330);
            object_Chains.setY((rootScene.getHeight() -100) / 2);
            Item chains = new Item(object_Chains, true); 
                chains.setDesc("I’m not one to judge, but I don’t think there’s "
                                + "any place for chains in a home. Wonder who or what "
                                + "they were for.");
                // add items
                root.getChildren().add(largeWing.getNode());
                root.getChildren().add(stoneBox.getNode());
                root.getChildren().add(chains.getNode());
            
            
            
        // ===== Setup fightScene ===== \\
        Rectangle fightBackground = new Rectangle(rootScene.getWidth(), (rootScene.getHeight() - (rootScene.getHeight() / 4.0)), Color.DARKRED);
            fightBackground.setX(0);
            fightBackground.setY(0);
                // add the background color
                fight.getChildren().add(fightBackground);
        
        Narrator fightNarrator = new Narrator();
            fightWindow.add(fightNarrator, 0, 1);
        
        
        
        // ===== Testing Scene Swapping ===== \\
        // Start the Fight
        Button fightButton = new Button("FIGHT!");
            fightButton.setOnAction(e -> stage.setScene(fightScene));
            root.getChildren().add(fightButton);
        
        // Exit the Fight
        Button exitButton = new Button("FLEE!");
            exitButton.setOnAction(e -> stage.setScene(rootScene));
            fight.getChildren().add(exitButton);
        
        
        
        // ===== Fight Menu ===== \\
//        GridPane grid = new GridPane();
//        grid.setPrefHeight(100);
//        grid.setPrefWidth(500);
//        grid.BackgroundImage("images/textbox.png");
//        fightLayout.getChildren().add();
        
        

        // add the player
        // Sprite player = new Sprite(new Rectangle(50, 50, 50, 50), false);
        ImageView image = new ImageView(new Image("images/New_Piskel.png", 50, 50, true, true));
            image.setY((rootScene.getHeight() -100) * 0.75);
            image.setX(rootScene.getWidth() / 2 - 25);
//                 Testing ->
//                    root.getChildren().add(image);
        Player player = new Player(image, false);
            Controller playerCon = new Controller(player.getNode(), player.getVelocity(), rootScene, KeyCode.W, KeyCode.S, KeyCode.A, KeyCode.D);
            player.setController(playerCon);
                root.getChildren().add(player.getNode());
                
        ImageView image2 = new ImageView(new Image("images/Final_Boss.png", 50, 50, true, true));
            image2.setY((rootScene.getHeight() -100) * 0.25);
            image2.setX(rootScene.getWidth() * 0.5 - 25);
        Enemy enemy = new Enemy(image2, true);
            root.getChildren().add(enemy.getNode());
            
        // add boarders to the main scene
//        Sprite topWall = new Sprite(new Rectangle(0, 0, rootScene.getWidth(), 5), true);
//        Sprite bottomWall = new Sprite(new Rectangle(0, rootScene.getHeight() - 5 - 100, rootScene.getWidth(), 5), true);
//        Sprite leftWall = new Sprite(new Rectangle(0, 0, 5, rootScene.getHeight() - 100), true);
//        Sprite rightWall = new Sprite(new Rectangle(rootScene.getWidth() - 5, 0, 5, rootScene.getHeight() -100), true);
//            root.getChildren().add(topWall.getNode());
//            root.getChildren().add(bottomWall.getNode());
//            root.getChildren().add(leftWall.getNode());
//            root.getChildren().add(rightWall.getNode());
//            
        // add boarders to the fight scene
        Sprite topWall2 = new Sprite(new Rectangle(0, 0, rootScene.getWidth(), 5), true);
        Sprite bottomWall2 = new Sprite(new Rectangle(0, rootScene.getHeight() - 5 - 100, rootScene.getWidth(), 5), true);
        Sprite leftWall2 = new Sprite(new Rectangle(0, 0, 5, rootScene.getHeight() - 100), true);
        Sprite rightWall2 = new Sprite(new Rectangle(rootScene.getWidth() - 5, 0, 5, rootScene.getHeight() -100), true);    
            fight.getChildren().add(topWall2.getNode());
            fight.getChildren().add(bottomWall2.getNode());
            fight.getChildren().add(leftWall2.getNode());
            fight.getChildren().add(rightWall2.getNode());
        
        
        
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
                
                player.getCollision().checkCollisionX(largeWing.getNode(), largeWing, rootNarrator);
                player.getCollision().checkCollisionY(largeWing.getNode(), largeWing, rootNarrator);
                player.getCollision().checkCollisionX(stoneBox.getNode(), stoneBox, rootNarrator);
                player.getCollision().checkCollisionY(stoneBox.getNode(), stoneBox, rootNarrator);
                player.getCollision().checkCollisionX(chains.getNode(), chains, rootNarrator);
                player.getCollision().checkCollisionY(chains.getNode(), chains, rootNarrator);
                
                //enemy.checkCollision(player, rootScene);
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
        
        stage.show();
    }
}