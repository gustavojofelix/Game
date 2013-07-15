/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Areocraft;

import static Areocraft.Constants.BOARD_HEIGHT;
import static Areocraft.Constants.BOARD_WIDTH;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Gustavo
 */
public class GameBoard extends JPanel {

    private boolean paused;
    //Craft object to be placed on the board
//    private Craft craft;
    private Craft craft1;
    private AlienCraft craft;
    private ArrayList<AlienCraft> aliens;
    //Initial Position of the Aliens
    private int[][] aliensPositions = {
        {400, 200}, {300, 100}, {500, 600},
        {400, 50}, {300, 60}, {400, 600},
        {800, 200}, {750, 100}, {500, 500},
        {700, 50}, {650, 60}, {400, 400},
        {600, 200}, {350, 100}, {500, 500},
        {500, 50}, {150, 60}, {400, Areocraft.Constants.BOARD_HEIGHT-50},
        {500, 300}, {400, 200}, {600, 200},
        {500, 150}, {400, 160}, {500, 200},
        {900, 300}, {850, 200}, {600, 300},
        {800, 150}, {750, 160}, {500, 400},
        {700, 300}, {450, 200}, {600, 700},
        {600, 150}, {250, 160}, {500, 250}
    };
    //Timer object used to trigger an event in specified interval
    //of Time
    Timer timer;

    /**
     * Constructor to initialize basic object
     */
    public GameBoard() {

        //Adding KeyListener to the Board. The CraftController class
        //Is created below
        addKeyListener(new GameBoard.CraftController());

        //seting Focus to true, so that this object can accept KeyEvent
        setFocusable(true);

        //New instance of the Craft
//        craft = new Craft();
//        craft = new AlienCraft(200,100);
        initaliens();

        paused = false;
        //new instance of the timer object indicating the interval(5) in
        //miliseconds and the action it will perform in this interval
        timer = new Timer(5, moveCraft);

        //Trigger the Event
        if (!paused) {

            timer.start();
        } else {
            timer.stop();
        }
    }

    public boolean isPaused() {
        return paused;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    //Initialize the Aliens
    public void initaliens() {
        aliens = new ArrayList<>();
        for (int i = 0; i < aliensPositions.length; i++) {
            aliens.add(new AlienCraft(aliensPositions[i][0], aliensPositions[i][1]));
        }
    }
    /**
     * This is the ActionListener Object, we override on it actionPerformed
     * method that will move the craft (call the method <b>move()</b>)
     */
    ActionListener moveCraft = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < aliens.size(); i++) {
                AlienCraft a = aliens.get(i);
                a.move(getWidth());
            }

//            craft.move();
            repaint();
        }
    };

    /**
     * We override this method to do custom painting
     *
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        setBackground(Color.black);

        Craft c = new Craft();
        
        g.drawImage(c.getCraft(), c.getxPosition(), c.getyPosition(), this);

        
        
        // here we are drawing an image (craft) on the panel.
        //Refer to ... for more information on Java 2D
        for (int i = 0; i < aliens.size(); i++) {
            AlienCraft a = aliens.get(i);
            g.drawImage(a.getCraft(), a.getxPosition(), a.getyPosition(), this);

        }
       
         
        
        g.setColor(Color.WHITE);
        g.drawString("SCORES: ", 15, 15);
         g.drawString("ALIENS LEFT: " + aliens.size(), 450, 15);
         
    }

    /**
     * This is an adapter to KeyEvent
     */
    public class CraftController extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_P) {
                if (timer.isRunning()) {
                    timer.stop();
                }else{
                    timer.start();
                }
            }
        }
        /*
         * @Override public void keyReleased(KeyEvent e){ craft.keyReleased(e);
         * }
    }
         */
    }
}
