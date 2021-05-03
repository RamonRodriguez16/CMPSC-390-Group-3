/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmpsc390softwareproject;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.scene.shape.Rectangle;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
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
        
        // create borders to root scene
        Sprite topWall = new Sprite(new Rectangle(0, 0, rootScene.getWidth(), 5), true);
        Sprite bottomWall = new Sprite(new Rectangle(0, rootScene.getHeight() - 5 - 100, rootScene.getWidth(), 5), true);
        Sprite leftWall = new Sprite(new Rectangle(0, 0, 5, rootScene.getHeight() - 100), true);
        Sprite rightWall = new Sprite(new Rectangle(rootScene.getWidth() - 5, 0, 5, rootScene.getHeight() -100), true);
            root.getChildren().add(topWall.getNode());
            root.getChildren().add(bottomWall.getNode());
            root.getChildren().add(leftWall.getNode());
            root.getChildren().add(rightWall.getNode());
            
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
                
        ImageView rootImage = new ImageView(new Image("images/New_Piskel.png", 50, 50, true, true));
            rootImage.setY((rootScene.getHeight() -100) * 0.75);
            rootImage.setX(rootScene.getWidth() / 2 - 25);
        Player rootPlayer = new Player(rootImage, false);
            Controller playerCon = new Controller(rootPlayer.getNode(), rootPlayer.getVelocity(), rootScene, KeyCode.W, KeyCode.S, KeyCode.A, KeyCode.D);
            rootPlayer.setController(playerCon);
                root.getChildren().add(rootPlayer.getNode());
                
        ImageView rootImage2 = new ImageView(new Image("images/Final_Boss.png", 50, 50, true, true));
            rootImage2.setY((rootScene.getHeight() -100) * 0.25);
            rootImage2.setX(rootScene.getWidth() * 0.5 - 25);
        Enemy rootEnemy = new Enemy(rootImage2, true);
            root.getChildren().add(rootEnemy.getNode());
            
            
            
        // ===== Setup fightScene ===== \\
        Rectangle fightBackground = new Rectangle(rootScene.getWidth(), (rootScene.getHeight() - (rootScene.getHeight() / 4.0)), Color.DARKRED);
            fightBackground.setX(0);
            fightBackground.setY(0);
                // add the background color
                fight.getChildren().add(fightBackground);
                
        // add borders to the fight scene
        Sprite topWall2 = new Sprite(new Rectangle(0, 0, rootScene.getWidth(), 5), true);
        Sprite bottomWall2 = new Sprite(new Rectangle(0, rootScene.getHeight() - 5 - 100, rootScene.getWidth(), 5), true);
        Sprite leftWall2 = new Sprite(new Rectangle(0, 0, 5, rootScene.getHeight() - 100), true);
        Sprite rightWall2 = new Sprite(new Rectangle(rootScene.getWidth() - 5, 0, 5, rootScene.getHeight() -100), true);    
            fight.getChildren().add(topWall2.getNode());
            fight.getChildren().add(bottomWall2.getNode());
            fight.getChildren().add(leftWall2.getNode());
            fight.getChildren().add(rightWall2.getNode());
        
        
        ImageView fightImage = new ImageView(new Image("images/New_Piskel.png", 50, 50, true, true));
            fightImage.setY(100);
            fightImage.setX(120);
        Player fightPlayer = new Player(fightImage, false);
            Controller fightCon = new Controller(fightPlayer.getNode(), fightPlayer.getVelocity(), fightScene, KeyCode.UNDEFINED, KeyCode.UNDEFINED, KeyCode.UNDEFINED, KeyCode.UNDEFINED);
            fightPlayer.setController(playerCon);
                fight.getChildren().add(fightPlayer.getNode());
        HealthBar playerBar = new HealthBar(fightPlayer.getHealth());
                Button playerButton = playerBar.getButton();
                playerButton.setLayoutX(100);
                playerButton.setLayoutY(15);
                fight.getChildren().add(playerButton);
                
                
        ImageView fightImage2 = new ImageView(new Image("images/Final_Boss.png", 50, 50, true, true));
            fightImage2.setY(100);
            fightImage2.setX(400);
        Enemy fightEnemy = new Enemy(fightImage2, true);
            fight.getChildren().add(fightEnemy.getNode());
        EnemyHealthBar enemyBar = new EnemyHealthBar(fightEnemy.getHealth());
                Button enemyButton = enemyBar.getButton();
                enemyButton.setLayoutX(370);
                enemyButton.setLayoutY(15);
                fight.getChildren().add(enemyButton);
        
        // -- BATTLE MENU -- //    
        Narrator fightNarrator = new Narrator();
        StackPane fightMenu = new StackPane();
        fightWindow.add(fightMenu, 0, 1);
        fightMenu.getChildren().add(fightNarrator);
        GridPane battleMenu = new GridPane();
        
        
        Button fleeButton = new Button("FLEE!");
            fleeButton.setOnAction(e -> stage.setScene(rootScene));
        Button fightButton = new Button("FIGHT!");
            fightButton.setOnAction(e -> {
                // --ATTACK MENU-- //
                battleMenu.getChildren().remove(fightButton);
                battleMenu.getChildren().remove(fleeButton);
                Button punchButton = new Button("PUNCH");
                punchButton.setOnAction(ap -> {
                    fight.getChildren().remove(enemyButton);
                    fightEnemy.setHealth(fightEnemy.getHealth() - 5);           // change this for move damage, add chance to hit.
                    EnemyHealthBar enemyUpdated = new EnemyHealthBar(fightEnemy.getHealth());
                    Button enemyButtonUpdated = enemyUpdated.getButton();
                    enemyButtonUpdated.setLayoutX(370);
                    enemyButtonUpdated.setLayoutY(15);
                    fight.getChildren().add(enemyButtonUpdated);
                });
                Button pierceButton = new Button("PIERCE");
                pierceButton.setOnAction(ap -> {
                    fight.getChildren().remove(enemyButton);
                    fightEnemy.setHealth(fightEnemy.getHealth() - 10);           // change this for move damage, add chance to hit.
                    EnemyHealthBar enemyUpdated = new EnemyHealthBar(fightEnemy.getHealth());
                    Button enemyButtonUpdated = enemyUpdated.getButton();
                    enemyButtonUpdated.setLayoutX(370);
                    enemyButtonUpdated.setLayoutY(15);
                    fight.getChildren().add(enemyButtonUpdated);
                });
                Button grabButton = new Button("GRAB");
                grabButton.setOnAction(ap -> {
                    // do the same thing here, but instead of changing damage, 
                    // make it a chance to skip the enemy's turn
                });
                Button fireButton = new Button("FIREBOLT");
                fireButton.setOnAction(ap -> {
                    fight.getChildren().remove(enemyButton);
                    fightEnemy.setHealth(fightEnemy.getHealth() - 24);           // change this for move damage, add chance to hit.
                    EnemyHealthBar enemyUpdated = new EnemyHealthBar(fightEnemy.getHealth());
                    Button enemyButtonUpdated = enemyUpdated.getButton();
                    enemyButtonUpdated.setLayoutX(370);
                    enemyButtonUpdated.setLayoutY(15);
                    fight.getChildren().add(enemyButtonUpdated);
                });
                
                Narrator.attackBattleMenu(battleMenu, punchButton, pierceButton,// Makes the Attack menu
                        grabButton, fireButton); 
            });
        
        fightMenu.getChildren().add(battleMenu);
            Narrator.fofBattleMenu(battleMenu, fightButton, fleeButton);        // Makes the Fight or Flee menu
        // --END BATTLE MENU -- //            
                
                
        AnimationTimer animation = new AnimationTimer()  
        {
            @Override
            public void handle(long now)
            {
                rootPlayer.update(0.016);
                
                rootPlayer.getCollision().checkCollisionY(topWall.getNode());
                rootPlayer.getCollision().checkCollisionY(bottomWall.getNode());
                rootPlayer.getCollision().checkCollisionX(leftWall.getNode());
                rootPlayer.getCollision().checkCollisionX(rightWall.getNode());
                
                rootPlayer.getCollision().checkCollisionX(largeWing.getNode(), largeWing, rootNarrator);
                rootPlayer.getCollision().checkCollisionY(largeWing.getNode(), largeWing, rootNarrator);
                rootPlayer.getCollision().checkCollisionX(stoneBox.getNode(), stoneBox, rootNarrator);
                rootPlayer.getCollision().checkCollisionY(stoneBox.getNode(), stoneBox, rootNarrator);
                rootPlayer.getCollision().checkCollisionX(chains.getNode(), chains, rootNarrator);
                rootPlayer.getCollision().checkCollisionY(chains.getNode(), chains, rootNarrator);
                
                rootEnemy.checkCollision(rootPlayer, fightScene, stage);
            }
        };
        animation.start();
        
        stage.show();  
    }
        
}
