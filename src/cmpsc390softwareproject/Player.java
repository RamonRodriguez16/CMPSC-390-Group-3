/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmpsc390softwareproject;

import javafx.scene.Node;

public class Player extends Sprite {
    String name;
    int power;
    int defense;
    int energy;
    int health;
    String type;
    Sprite sprite;
    
    public Player(Node node, boolean solid)
    {
        super(node, solid);
        name = "Dummy";
        power = 0;
        defense = 0;
        energy = 0;
        type = "dummy";
    }
    public void setName(String n) {
        name = n;
    }
    public String getName() {
        return name;
    }
    public void setPower(int p) {
        power = p;
    }
    public int getPower() {
        return power;
    }
    public void setDefense(int d) {
        defense = d;
    }
    public int getDefense() {
        return defense;
    }
    public void setEnergy(int e) {
        energy = e;
    }
    public int getEnergy() {
        return energy;
    }
    public void setHealth(int h) {
        health = h;
    }
    public int getHealth() {
        return health;
    }
    public void setType(String t) {
        type = t;
    }
    public String getType() {
        return type;
    }
    public void setSprite(Sprite s) {
        sprite = s;
    }
    public Sprite getSprite()
    {
        return sprite;
    }
}
