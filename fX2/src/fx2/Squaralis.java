/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package fx2;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeType;
import javafx.util.Duration;

/**
 *
 * @author fazreil.jalil
 */
public class Squaralis extends Shape{
    private Color color;
    private int size;
    private int rotationInSeconds;
    private int distance;
    private FadeTransition fader;
    private TranslateTransition translate;
    private RotateTransition rotateTransition;
    private ParallelTransition parallel;
    private Rectangle squaralis;
    
    
    public Squaralis()
    {
        color = Color.BLUE;
        size = 100;
        rotationInSeconds = 4;
        distance = 100;
    }
    
    public Squaralis(Color color, int size, int rotationInSeconds, int distance)
    {
        this.color = color;
        this.size = size;
        this.rotationInSeconds = rotationInSeconds;
        this.distance = distance;
    }
    
    public Rectangle create()
    {
        squaralis = new Rectangle(size,size,Color.TRANSPARENT);
        squaralis.setArcHeight(size/10);
        squaralis.setArcWidth(size/10);
        squaralis.setStroke(color);
        squaralis.setStrokeWidth(size/10);
        squaralis.setStrokeType(StrokeType.INSIDE);
        
        rotateTransition = new RotateTransition(Duration.seconds(rotationInSeconds), squaralis);
        rotateTransition.setFromAngle(0);
        rotateTransition.setToAngle(720);
        rotateTransition.setCycleCount(Timeline.INDEFINITE);
        rotateTransition.setAutoReverse(true);
        
        translate = new TranslateTransition(Duration.seconds(rotationInSeconds),squaralis);
        translate.setByX(distance);
        translate.setAutoReverse(false);
        
        fader = new FadeTransition(Duration.seconds(rotationInSeconds), squaralis);
        fader.setAutoReverse(false);
        fader.setFromValue(1.0f);
        fader.setToValue(0.0f);
        
        parallel = new ParallelTransition();
        parallel.getChildren().addAll(rotateTransition, translate, fader);
        parallel.play();
        
//        squaralis.setOnMouseClicked(new EventHandler<MouseEvent>(){
//
//            public void handle(MouseEvent t) {
//                parallel.playFromStart();
//            }
//        });
        
        return squaralis;
    }
    
    public void play()
    {
        parallel.playFromStart();
    }

    @Override
    public com.sun.javafx.geom.Shape impl_configShape() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
