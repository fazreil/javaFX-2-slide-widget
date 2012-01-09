/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package fx2;

import javafx.animation.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.util.Duration;

/**
 *
 * @author fazreil.jalil
 */
public class Squaretta extends Rectangle{
    
    private Color color;
    private int size;
    private int rotationInSeconds;
    private int distance;
    private FadeTransition fader;
    private TranslateTransition translate;
    private RotateTransition rotateTransition;
    private ParallelTransition parallel;

    public Squaretta()
    {
        super(100, 100, Color.TRANSPARENT);       
        color = Color.BLUE;
        size = 100;
        rotationInSeconds = 4;
        distance = 50;
    }
    
        public Squaretta(int size, int distance, Color color)
    {
        super(size, size, Color.TRANSPARENT);       
        this.color = color;
        this.size = size;
        this.rotationInSeconds = 4;
        this.distance = distance;
    }
    
    public Squaretta create()
    {
        //this.setFill(color);
        this.setArcHeight(size/10);
        this.setArcWidth(size/10);
        this.setStroke(color);
        this.setStrokeWidth(size/10);
        this.setStrokeType(StrokeType.INSIDE);
        
        rotateTransition = new RotateTransition(Duration.seconds(rotationInSeconds), this);
        rotateTransition.setFromAngle(0);
        rotateTransition.setToAngle(720);
        rotateTransition.setCycleCount(Timeline.INDEFINITE);
        rotateTransition.setAutoReverse(true);
        
        translate = new TranslateTransition(Duration.seconds(rotationInSeconds),this);
        translate.setByX(distance);
        translate.setAutoReverse(false);
        
        fader = new FadeTransition(Duration.seconds(rotationInSeconds), this);
        fader.setAutoReverse(false);
        fader.setFromValue(1.0f);
        fader.setToValue(0.0f);
        
        parallel = new ParallelTransition();
        parallel.getChildren().addAll(rotateTransition, translate, fader);
        parallel.play();
        
        return this;
    }
    
    public void play()
    {
        reset();
        this.parallel.playFromStart();
    }
    
    public void reset()
    {
        this.setTranslateX(size);
        this.setY(0);
    }
    
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public FadeTransition getFader() {
        return fader;
    }

    public void setFader(FadeTransition fader) {
        this.fader = fader;
    }

    public ParallelTransition getParallel() {
        return parallel;
    }

    public void setParallel(ParallelTransition parallel) {
        this.parallel = parallel;
    }

    public RotateTransition getRotateTransition() {
        return rotateTransition;
    }

    public void setRotateTransition(RotateTransition rotateTransition) {
        this.rotateTransition = rotateTransition;
    }

    public int getRotationInSeconds() {
        return rotationInSeconds;
    }

    public void setRotationInSeconds(int rotationInSeconds) {
        this.rotationInSeconds = rotationInSeconds;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public TranslateTransition getTranslate() {
        return translate;
    }

    public void setTranslate(TranslateTransition translate) {
        this.translate = translate;
    }
    
    
    
}
