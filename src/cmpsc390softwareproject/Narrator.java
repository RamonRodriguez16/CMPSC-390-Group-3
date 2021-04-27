/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmpsc390softwareproject;

import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author ramon, david
 */
public class Narrator extends StackPane{
    private boolean isDescribing;
    String textOutput = "";
    Rectangle n = new Rectangle();
    
    Text myText = new Text(textOutput);
    
    
    public Narrator()
    {       
        n.setWidth(500);
        n.setHeight(100);
        Image textbox = new Image("images/textbox.png");
        ImagePattern bg = new ImagePattern(textbox);
        n.setFill(bg);
        
        getChildren().add(n);
        getChildren().add(myText);
        isDescribing = false;
    }
    
    
    
    private void describeObject(Sprite sprite, Player player)
    {
        isDescribing = true;
        // should stop the player from moving (can be done by setting velocities to '0')
        player.getSprite().setVelocity(0, 0);
        
        // should display text to the player about the interactive object
        // sprite.description();
    }
    
    private void playerStats(Player player)
    {
        // present the player's stats to the user
        System.out.println(player.getName());
        // should state player's HP as well
        System.out.println(player.getType());
        System.out.println(player.getPower());
        System.out.println(player.getDefense());
        System.out.println(player.getEnergy());
    }
    
    public void setText(String newText){
        getChildren().remove(myText);
        
        myText = new Text(newText);
        
        myText.setFill(Color.WHITE);
        myText.setFont(Font.font("Calibri", 16));
        myText.setWrappingWidth(485);
        myText.setX(n.getX() + 15);
        myText.setY(n.getY() + 30);
        
        this.getChildren().add(myText);
    }
    
    /*
    private void enemyStats(Enemy enemy)
    {
        // very similar to player but enemies will have a few more stats
    }
    */
}
