/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmpsc390softwareproject;

/**
 *
 * @author jamoola
 */
public class Enemy extends Player {
    private int health;
    private int boost;
    
    public void setHealth(int h) {
        health = h;
    }
    public int getHealth() {
        return health;
    }
    public void setBoost(int b) {
        boost = b;
    }
    public int getBoost() {
        return boost;
    }
}
