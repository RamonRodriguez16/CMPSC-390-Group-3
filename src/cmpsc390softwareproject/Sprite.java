/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg390project;
/**
 *
 * @author Alexl
 */
import javafx.scene.Node;

public class Sprite
{
    private boolean solid;
    private /* final */ Node node; 
    private double vx, vy;//vx refers to velocity x and  vy velocity y. 

    public Sprite(Node node, boolean solid)
    {
        this.solid = solid;
        this.node = node;
    }
    public boolean getSolid()
    {
        return solid; 
    }

    public Node getNode()
    {
        return node;
    }
    
    public void setSolid(boolean solid) {
        this.solid = solid;
    }

    public void setVelocity(double dx, double dy)//when holding down a key, the velocity is set as a graph. 
    {
        this.vx = dx;
        this.vy = dy;
    }

    public double getVelocityX()
    {
        return vx;
    }

    public void setVelocityX(double dx)
    {
        this.vx = dx;
    }

    public double getVelocityY()
    {
        return vy;
    }

    public void setVelocityY(double dy)
    {
        this.vy = dy;
    }

    public void update()
    {
        //add the velocity to the location
        this.node.setTranslateX(this.node.getTranslateX()+vx);//Translate is the current position of the sprite. The getTranslate is to receive the current position of the sprite.
        this.node.setTranslateY(this.node.getTranslateY()+vy);//Above comment applies as well to this one. 
    }
}
