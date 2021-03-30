package cmpsc390softwareproject;

import java.util.HashMap;
import java.util.Map;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Controller {
    private Node node;
    private Command moveUp;
    private Command moveDown;
    private Command moveLeft;
    private Command moveRight;
    private Command stopMoving;
    private Velocity vel;
    
    public Controller()
    {
        node = null;
        vel = null;
    }
    
    public Controller(Node node, Velocity vel, Scene scene, KeyCode up, KeyCode down, KeyCode left, KeyCode right)
    {
        this.node = node;
        this.vel = vel;
        
        moveUp = new Command()
        {
            @Override
            public void execute()
            {
                vel.setVelocity(node, 0, -1);
                // velDif = -2
            }
        };
        moveDown = new Command()
        {
            @Override
            public void execute()
            {
                vel.setVelocity(node, 0, 1);
                // velDif = 2
            }
        };
        moveLeft = new Command()
        {
            @Override
            public void execute()
            {
                vel.setVelocity(node, -1, 0);
                // velDif = -1
            }
        };
        moveRight = new Command()
        {
            @Override
            public void execute()
            {
                vel.setVelocity(node, 1, 0);
                // velDif = 1
            }
        };
        
        stopMoving = new Command()
        {
            @Override
            public void execute()
            {
                vel.setVelocity(node, 0, 0);
                // velDif = 0
            }
        };
        
        //        Build the table of keyboard commands
        Map<KeyCode,Command> inputControl = new HashMap<>();
        inputControl.put(up, moveUp);
        inputControl.put(down, moveDown);
        inputControl.put(left, moveLeft);
        inputControl.put(right, moveRight);
        
        //Tell the scene to watch for key presses and check the table
        scene.setOnKeyPressed(new EventHandler<KeyEvent>()
        {
            @Override
            public void handle(KeyEvent evt)
            {
                Command command = inputControl.get(evt.getCode());
                if (command != null)
                    command.execute();
                //command will be null in the case that the pressed
                // key is not in the table. In that case, do nothing.
            }
        });
        scene.setOnKeyReleased(new EventHandler<KeyEvent>()
        {
            @Override
            public void handle(KeyEvent evt)
            {
                Command command = stopMoving;
                if (command != null)
                    command.execute();
            }
        });
    }
}