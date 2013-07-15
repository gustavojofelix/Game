/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Areocraft;

import static Areocraft.Constants.BOARD_WIDTH;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Gustavo
 */
public class MissilCraft {
    
    private ArrayList<MissilCraft> missil;
    private boolean visible;
    
    //This is the String name of Image representation of the craft
    private String imageUrl = "missil.png";
    
    //These are the coordinates (x,y) of the craft location
    private int xPosition;
    private int yPosition;
    
    //These values represent the actual speed in which the craft is 
    //moving
    private int xSpeed = 2;
//    private int ySpeed;
    
    //This variable will be used to store the image object of the craft
    private Image craft;
    
    /**
     * This is the constructor used to setup the initial values
     * of craft, like image and its initial position
     */
    public MissilCraft(){
        //Initial position of the craft
        xPosition = 1;
        yPosition = 60;
        
        //Creating the Image
        ImageIcon imageIcon = new ImageIcon(this.getClass().getResource(imageUrl));
        craft = imageIcon.getImage();
        
        missil = new ArrayList<>();
        visible = true;
    }

    //Accessor methods. Used to access the craft properties
    public Image getCraft() {
        return craft;
    }

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public ArrayList<MissilCraft> getMissil() {
        return missil;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
    
    /**
     * This method is to move the craft, actually it means change
     * the coordinates(x,y) values by increasing or decreasing 
     * depending in which position we want to move the craft.
     * xSpeed and ySpeed values will determine how fast it 
     * will be moving
     */
    public void move(){
        xPosition += xSpeed;
//        yPosition += ySpeed;
        
        if(xPosition > BOARD_WIDTH){
            visible = false;
        }
        
//        if(yPosition <0){
//            yPosition = 0;
//        }
    }
    
    public void fire(){
        missil.add(new MissilCraft());
    }
    
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        
        if(key == KeyEvent.VK_SPACE){
            fire();
        }
    }
}
