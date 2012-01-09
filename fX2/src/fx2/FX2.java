/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package fx2;

import java.util.Arrays;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author fazreil.jalil
 */
public class FX2 extends Application {

    public Launcher launcher;
    public Squaretta squaretta[];

    public Launcher getLauncher() {
        return launcher;
    }
    
    public Group root;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World");
        root = new Group();
        Scene scene = new Scene(root, 800, 250);
        Introducticon java = new Introducticon("ipad-java_icon.png");
        Introducticon jenkins = new Introducticon();
        Squaralis sq1 = new Squaralis();

        createSquaretta(root);

        Button button = new Button("Replay");

        button.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent t) {
                System.out.println("fire");
                play();
                createSquaretta(root);
            }

            public void play() {
                for (int x = 0; x < squaretta.length; x++) {
                    System.out.println(x);
                    squaretta[x].play();
                }
            }
        });
        
        root.getChildren().add(button);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public Group createSquaretta(Group root) {
        squaretta = new Squaretta[20];
        int size = 0;
        int distance = 0;
        Color color;
        for (int x = 0; x < squaretta.length; x++) {
            size = (int) (Math.random() * 100);
            distance = (int) (Math.random() * 1000);
            color = new Color((Math.random()), (Math.random()), (Math.random()), (Math.random()));
            squaretta[x] = new Squaretta(size, distance, color);
            System.out.println("new Squaretta(" + size + "," + distance + ", "+color.getRed()+" "+color.getGreen()+" "+color.getBlue()+")");
        }
        for (int x = 0; x < squaretta.length; x++) {
            root.getChildren().add(squaretta[x].create());
        }
        return root;
    }
}
