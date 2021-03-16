/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmpsc390softwareproject;
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
    
    private Controller con;
    private Velocity vel;

    public Sprite(Node node, boolean solid)
    {
        this.solid = solid;
        this.node = node;
        this.vel = new Velocity(node, 0, 0);
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

    public Controller getController()
    {
        return con;
    }
    
    public void setController(Controller con)
    {
        this.con = con;
    }
    
    public void setVelocity(Node n, double x,double y)
    {
        this.vel.setVelocity(n, x, y);
    }
    
    public Velocity getVelocity()
    {
        return this.vel;
    }
    
    public void update(double dt)
    {
        vel.update(dt);
    }
}
