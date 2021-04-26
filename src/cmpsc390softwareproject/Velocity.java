package cmpsc390softwareproject;

import javafx.scene.Node; 

public class Velocity
{    
    private double dx, dy;
    private Node node;    
    
    public Velocity(Node node)    
    {        
        dx = 0;        
        dy = 0;        
        this.node = node;    
    }    
    
    public Velocity(Node node, double dx, double dy)    
    {        
        this.dx = dx;
        this.dy = dy;        
        this.node = node;    
    }    
    
    public void setVelocity(Node node, double dx, double dy)    
    {        
        this.dx = dx;
        this.dy = dy;        
        this.node = node;    
    }    
    
    public double getVelocityX()    
    {        
        return dx;
    }        
    
    public void setVelocityX(double dx)    
    {        
        this.dx = dx;
    }    
    
    public double getVelocityY()    
    {        
        return dy;    
    }    
    
    public void setVelocityY(double dy)    
    {        
        this.dy = dy;
    }    
    
    public int velDif()
    {
        int tempVelX = (int)this.dx * 2;
        return ((int)this.dy + tempVelX);
    }
    
    public void update(double dt)    
    {        
        double ticks = 60*dt;        
        //add the velocity to the location        
        this.node.setTranslateX(this.node.getTranslateX()+dx*ticks);        
        this.node.setTranslateY(this.node.getTranslateY()+dy*ticks);    
    }
}

