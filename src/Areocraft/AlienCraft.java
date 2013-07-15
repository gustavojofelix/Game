/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Areocraft;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Gustavo
 */
public class AlienCraft {
    
    //This is the String name of Image representation of the craft
    private String imageUrl = "alienA.png";
    
    //These are the coordinates (x,y) of the craft location
    private int xPosition;
    private int yPosition;
    
    //These values represent the actual speed in which the craft is 
    //moving
    private int xSpeed = 1;
//    private int ySpeed;
    
    //This variable will be used to store the image object of the craft
    private Image craft;
    
    /**
     * This is the constructor used to setup the initial values
     * of craft, like image and its initial position
     */
    public AlienCraft(int x, int y){
        //Initial position of the craft
        xPosition = x;
        yPosition = y;
        
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
    public void move(int width){
        xPosition -= xSpeed;
//        yPosition += ySpeed;
        
        if(xPosition <0){
            xPosition = width; //Constants.BOARD_WIDTH;
        }
        
//        if(yPosition <0){
//            yPosition = 0;
//        }
    }
    
}
