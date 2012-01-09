/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package fx2;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author fazreil.jalil
 */
public class Introducticon{

    private Group group;
    private Rectangle rectangle;
    private ImageView imageView;
    private String iconString;
    private Image icon;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public String getIconString() {
        return iconString;
    }

    public void setIconString(String iconString) {
        this.iconString = iconString;
    }
    
    public Introducticon() {
        //setting jenkins icon by default
        iconString = "jenkins_icon.png";
    }
    
    public Introducticon(String iconString)
    {
        this.iconString = iconString;    
    }
    
    public ImageView create() {
        icon = new Image(Introducticon.class.getResourceAsStream(iconString));
        imageView = new ImageView(icon);
        System.out.println("fin");
        return imageView;
    }
}
