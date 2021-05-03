/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmpsc390softwareproject;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
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
    private boolean attacking = true;
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
    
    public void setAttacking(Boolean status){
        attacking = status;
    }
    public Boolean getAttacking(){
        return attacking;
    }
    
    public static void fofBattleMenu(GridPane battleMenu, Button fightButton, Button fleeButton){
            battleMenu.setMinSize(500, 100);
            battleMenu.setPadding(new Insets(30, 150, 30, 150));
            battleMenu.setHgap(100);
            battleMenu.add(fightButton, 0, 0);
            battleMenu.add(fleeButton, 1, 0);
    }
    
    public static void attackBattleMenu(GridPane battleMenu, Button punchButton, Button pierceButton,
            Button shockButton, Button fireButton){
                battleMenu.add(punchButton, 0, 0);
                battleMenu.add(pierceButton, 1, 0);
                battleMenu.add(shockButton, 0, 1);
                battleMenu.add(fireButton, 1, 1);
                
                battleMenu.setPadding(new Insets(20, 100, 20, 150));
                battleMenu.setHgap(100);
                battleMenu.setVgap(10);
    }
    
    public static void clearBattleMenu(GridPane battleMenu){
        battleMenu.getChildren().clear();
    }

    public static void enemyAttack(Player p, HealthBar pBar, Narrator fn, GridPane battleMenu, Button fightButton, Button fleeButton){
                    int damage;
                    double odds = Math.random();
                    String attackName = "";
                    
                    battleMenu.getChildren().clear();
                    
                    
                    if (odds <= 0.05){
                        damage = 50;
                        attackName = "EVISCERATING FLAMES";
                    }
                    else if (odds <= 0.4){
                        damage = 14;
                        attackName = "WRETCHED CHOMP";
                    }
                    else if (odds > 0.7){
                        damage = 6;
                        attackName = "DOOM CLAW";
                    }
                    else damage = 0;
        
                    if (damage == 0){
                        fn.setText("Abysmal Detsoob missed!");
                    }
                    else 
                        fn.setText("Abysmal Detsoob used " + attackName + " for " + damage + " damage!");
                    
                    
                    p.setHealth(p.getHealth() - damage);                   // change this for move damage, add chance to hit.
                    pBar.setHP(p.getHealth());
                    if(p.getHealth() <= 0){
                        battleMenu.getChildren().clear();
                        fn.setText("DESTROYED... YOU LOSE.");
                        battleMenu.add(fleeButton, 1, 1);
                    }
                    else {
                        battleMenu.getChildren().clear();
                        fn.setAttacking(true);
                    }
    }
    
                        
    public static void attack(Button attack, Enemy e, Player p, HealthBar pBar, HealthBar eBar, Narrator fn, GridPane battleMenu, Button fightButton, Button fleeButton){
                    String attackName = attack.getText();
                    int damage = 0;
                    
                    if(attackName.equals("PUNCH")){
                        damage = 5;
                    }
                    else if(attackName.equals("PIERCE")){
                        damage = 15;
                    }
                    else if(attackName.equals("FIREBOLT")){
                        damage = 24;
                    }
                    else if(attackName.equals("SHOCK")){
                        damage = 8;
                    }
                    
                    fn.setText("You used " + attackName + " for " + damage + " damage!");
        
                    e.setHealth(e.getHealth() - damage);                   // change this for move damage, add chance to hit.
                    eBar.setHP(e.getHealth());
                    battleMenu.getChildren().clear();
                    if(e.getHealth() <= 0){
                        battleMenu.getChildren().clear();
                        fn.setText("TOTAL SLAUGHTER, YOU WIN");
                        battleMenu.add(fleeButton, 1, 1);
                    }
                    else {
                        battleMenu.getChildren().clear();
                        fn.setAttacking(false);
                    }
    }
    
}
