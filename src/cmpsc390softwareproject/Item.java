/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmpsc390softwareproject;

import javafx.scene.Node;
/**
 *
 * @author David Dziuba
 */
public class Item extends Sprite{
        
    private String description;

    public Item(Node n, boolean solid)
    {
        super(n, solid);
    }

    public void setDesc(String s)
    {
        this.description = s;
    }

    public String getDesc()
    {
        return this.description;
    }
}
