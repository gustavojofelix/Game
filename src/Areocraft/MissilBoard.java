/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Areocraft;

import java.awt.Color;
import java.awt.Graphics;
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
public class MissilBoard extends JPanel {

    ArrayList<MissilCraft> missiles;
    //Craft object to be placed on the board
//    private Craft craft;
    private MissilCraft craft;
    //Timer object used to trigger an event in specified interval
    //of Time
    Timer timer;

    /**
     * Constructor to initialize basic object
     */
    public MissilBoard() {

        //Adding KeyListener to the Board. The CraftController class
        //Is created below
        addKeyListener(new MissilBoard.CraftController());

        //seting Focus to true, so that this object can accept KeyEvent
        setFocusable(true);

        //New instance of the Craft
//        craft = new Craft();
        craft = new MissilCraft();

        //new instance of the timer object indicating the interval(5) in
        //miliseconds and the action it will perform in this interval
        timer = new Timer(5, moveCraft);

        //Trigger the Event
        timer.start();
    }
    /**
     * This is the ActionListener Object, we override on it actionPerformed
     * method that will move the craft (call the method <b>move()</b>)
     */
    ActionListener moveCraft = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            missiles = craft.getMissil();
            for (int i = 0; i < missiles.size(); i++) {
                MissilCraft mc = missiles.get(i);
                if (mc.isVisible()) {
                    mc.move();
                }else{
                    missiles.remove(i);
                }
            }

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

        // here we are drawing an image (craft) on the panel.
        //Refer to ... for more information on Java 2D

        missiles = craft.getMissil();

        for (int i = 0; i < missiles.size(); i++) {
            MissilCraft mc = missiles.get(i);
            g.drawImage(mc.getCraft(), mc.getxPosition(), mc.getyPosition(), this);

        }

    }

    /**
     * This is an adapter to KeyEvent
     */
    public class CraftController extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            craft.keyPressed(e);
        }
        /*
         * @Override public void keyReleased(KeyEvent e){ craft.keyReleased(e);
         * }
    }
         */
    }
}
