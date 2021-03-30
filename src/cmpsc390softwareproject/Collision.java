
package cmpsc390softwareproject;

/**
 *
 * @author Tegop
 */
import javafx.scene.Node;

public class Collision
{   
    private Node node;
    private Velocity V;
    
    public Collision(Node n, Velocity v){
        V = v;
        node = n;
    }
    
    void checkCollisionY(Node target)
    {
        if (this.node.getBoundsInParent().intersects(target.getBoundsInParent()))
            V.setVelocityY(-V.getVelocityY());
    }
    
    void checkCollisionX(Node target) 
    {
        if (this.node.getBoundsInParent().intersects(target.getBoundsInParent()))
            V.setVelocityX(-V.getVelocityX());
    }
    
    void checkCollision(Node target)
    {
        if (this.node.getBoundsInParent().intersects(target.getBoundsInParent()))
        {
            if(this.node.getTranslateX() < target.getTranslateX()-(target.getScaleX() / 2))
                V.setVelocityX(-V.getVelocityX());
            else if(this.node.getTranslateX() > target.getTranslateX()+(target.getScaleX() / 2))
                V.setVelocityX(-V.getVelocityX());
        }
    }
}
