/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package fx2;

import javafx.animation.ParallelTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author fazreil.jalil
 */
public class Launcher {

    private Squaralis[] sqArr;

    public Launcher() {
        sqArr = new Squaralis[20];
        int size = 0;
        int rotation = 0;
        int distance = 0;

        for (int i = 0; i < sqArr.length; i++) {
            size = (int) (Math.random() * 100);
            rotation = (int) (Math.random() * 10);
            distance = (int) (Math.random() * 5000);
            sqArr[i] = new Squaralis(Color.GREEN, size, rotation, distance);
            System.out.println("new Squaralis(Color.GREEN, " + size + ", " + rotation + ", " + distance + ")");
        }
    }
    
    public Rectangle[] convert(Squaralis[] square)
    {
        Rectangle[] rectangulier = new Rectangle[square.length];
        for(int k=0;k<square.length;k++)
        {
            rectangulier[k] = square[k].create();
        }
        return rectangulier;
    }
    
    
    public void play()
    {
        for(int i=0;i<sqArr.length;i++)
        {
            sqArr[i].play();
        }
    }
    
    public Rectangle[] create() {
        return convert(sqArr);
    }
    
    
}
