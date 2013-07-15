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
public class Missile {

    private String craft = "missilIcon.png";
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean visible;
    private Image image;
    
    private final int MISSIL_SPEED = 2;
    private final int BOARD_WIDTH = 490;

    public Missile(int x, int y) {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(craft));
        image = ii.getImage();
        visible = true;
        width = image.getWidth(null);
        height = image.getHeight(null);
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
    
    public void move(){
        x += MISSIL_SPEED;
        if (x > BOARD_WIDTH){
            visible = false;
            //TODO: use setVisible instead
        }
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x, y, width, height);
    }
}
