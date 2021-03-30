/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmpsc390softwareproject;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

/**
 *
 * @author jamoola
 */
public class Enemy extends Player {
    private int boost;
    
    public Enemy (Node node, boolean solid)
    {
        super(node, solid);
        boost = 0;
    }
//    public void setHealth(int h) {
//        health = h;
//    }
//    public int getHealth() {
//        return health;
//    }
    public void setBoost(int b) {
        boost = b;
    }
    public int getBoost() {
        return boost;
    }
    
    // when player collides with enemy, should take the node of the player
        // place the player in one spot
        // make the player's velocity 0,0
    
    void checkCollision(Player player, Scene scene)
    {
        if(this.getNode().getBoundsInParent().intersects(player.getNode().getBoundsInParent()))
        {
            player.getNode().setTranslateX(this.getNode().getLayoutX() - 25);
            
                Velocity noVel = new Velocity(player.getNode(), 0, 0);
                Controller noCon = new Controller(player.getNode(), player.getVelocity(), scene, KeyCode.UNDEFINED, KeyCode.UNDEFINED, KeyCode.UNDEFINED, KeyCode.UNDEFINED);
                
                player.setController(noCon);
        }
    }
}
