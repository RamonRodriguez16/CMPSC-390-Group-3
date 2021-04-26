
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
            V.setVelocityY(-V.getVelocityY() * 2.0);
    }
    
    void checkCollisionX(Node target) 
    {
        if (this.node.getBoundsInParent().intersects(target.getBoundsInParent()))
            V.setVelocityX(-V.getVelocityX() * 2.0);
    }
    
    void checkCollision(Node target)
    {
        if (this.node.getBoundsInParent().intersects(target.getBoundsInParent()))
        {
            if(this.node.getTranslateX() < target.getTranslateX()-(target.getScaleX() / 2))
                V.setVelocityX(-V.getVelocityX() * 2.0);
            else if(this.node.getTranslateX() > target.getTranslateX()+(target.getScaleX() / 2))
                V.setVelocityX(-V.getVelocityX() * 2.0);
        }
    }
}
