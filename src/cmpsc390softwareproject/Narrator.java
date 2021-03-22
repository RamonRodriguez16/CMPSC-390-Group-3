/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmpsc390softwareproject;

/**
 *
 * @author ramon, technically
 */
public class Narrator {
    private boolean isDescribing;
    
    public Narrator()
    {
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
    
    /*
    private void enemyStats(Enemy enemy)
    {
        // very similar to player but enemies will have a few more stats
    }
    */
}
