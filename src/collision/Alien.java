/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collision;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author Gustavo
 */
public class Alien {

    private String craft = "alienA.png";
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean visible;
    private Image image;

    public Alien(int x, int y) {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(craft));
        image = ii.getImage();
        width = image.getWidth(null);
        height = image.getHeight(null);
        visible = true;
        this.x = x;
        this.y = y;

    }

    public Image getImage() {
        return image;
    }

    

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getX() {
        return x;
    }

    

    public int getY() {
        return y;
    }

    
public Rectangle getBounds(){
    return new Rectangle(x, y, width, height);
}
    
    
    public void move() {
        if (x < 0) {
            x = 500;
        }
        x -= 1;
    }
}
