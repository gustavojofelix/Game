/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Areocraft;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author Gustavo
 */
public class Aliens {
    
    //This is the String name of Image representation of the craft
    private String imageUrl = "alien.png";
    
    //These are the coordinates (x,y) of the craft location
    private int xPosition;
    private int yPosition;
    
    //These values represent the actual speed in which the craft is 
    //moving
    private int xSpeed;
    private int ySpeed;
    
    //This variable will be used to store the image object of the craft
    private Image craft;
    
    /**
     * This is the constructor used to setup the initial values
     * of craft, like image and its initial position
     */
    public Aliens(){
        //Initial position of the craft
        xPosition = 40;
        yPosition = 60;
        
        //Creating the Image
        ImageIcon imageIcon = new ImageIcon(this.getClass().getResource(imageUrl));
        craft = imageIcon.getImage();
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
    
    /**
     * This method is to move the craft, actually it means change
     * the coordinates(x,y) values by increasing or decreasing 
     * depending in which position we want to move the craft.
     * xSpeed and ySpeed values will determine how fast it 
     * will be moving
     */
    public void move(){
        xPosition += xSpeed;
        yPosition += ySpeed;
        
        if(xPosition <0){
            xPosition = 0;
        }
        
        if(yPosition <0){
            yPosition = 0;
        }
    }
    
    //These method is to be used by KeyAdapter
    //To Learn more about Adapters and Events refers to...
    
    /**
     * we press the direction key to set the xSpeed and ySpeed.
     * The speed will remain the same until we release the key, which
     * means that the craft will keep moving until we release the key
     * @param e 
     */
    public void keyPressed(KeyEvent e){
        
        int key = e.getKeyCode();
        
        if(key == KeyEvent.VK_LEFT){
            xSpeed = -1;
        }
        
        if(key == KeyEvent.VK_RIGHT){
            xSpeed = 1;
        }
        if(key == KeyEvent.VK_UP){
            ySpeed = -1;
        }
        if(key == KeyEvent.VK_DOWN){
            ySpeed = 1;
        }
    }
    
    /**
     * When we release the keys, the speed to all direction 
     * are setup to 0(Zero), which means that the craft stop moving
     * @param e 
     */
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        
        if(key == KeyEvent.VK_LEFT){
            xSpeed = 0;
        }
        
        if(key == KeyEvent.VK_RIGHT){
            xSpeed = 0;
        }
        if(key == KeyEvent.VK_UP){
            ySpeed = 0;
        }
        if(key == KeyEvent.VK_DOWN){
            ySpeed = 0;
        }
    }
}
