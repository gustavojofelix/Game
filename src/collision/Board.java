/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collision;

import java.awt.*;
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
public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private Craft craft;
    private ArrayList aliens;
    private boolean ingame;
    private int B_WIDTH;
    private int B_HEIGHT;
    //Initial position of Alliens ships
    private int[][] pos = {
        {2380, 29}, {2500, 59}, {1380, 89},
        {780, 109}, {580, 139}, {680, 239},
        {790, 259}, {760, 50}, {790, 150},
        {980, 209}, {560, 45}, {510, 70},
        {930, 159}, {590, 80}, {530, 60},
        {940, 59}, {990, 30}, {920, 200},
        {900, 259}, {660, 50}, {540, 90},
        {810, 220}, {860, 20}, {740, 180},
        {820, 128}, {490, 170}, {700, 30}
    };

    public Board() {

        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        ingame = true;

        setSize(500, 500);

        craft = new Craft();

        initAliens();

        timer = new Timer(5, this);
        timer.start();
    }

    @Override
    public void addNotify() {
        super.addNotify();
        B_HEIGHT = getHeight();
        B_WIDTH = getWidth();

    }

    public void initAliens() {
        aliens = new ArrayList();

        for (int i = 0; i < pos.length; i++) {
            aliens.add(new Alien(pos[i][0], pos[i][1]));
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if (ingame) {
            Graphics2D g2d = (Graphics2D) g;
            if(craft.isVisible()){
                g2d.drawImage(craft.getImage(), craft.getX(), craft.getY(), this);
            }
            
            ArrayList ms = craft.getMissiles();
            
            for(int i = 0; i < ms.size(); i++){
                Missile m = (Missile) ms.get(i);
                g2d.drawImage(m.getImage(), m.getX(), m.getY(), this);
            }
            
            for(int i = 0; i < aliens.size(); i++){
                Alien a = (Alien) aliens.get(i);
                if(a.isVisible()){
                    g2d.drawImage(a.getImage(), a.getX(), a.getY(), this);
                }
            }
            
            g2d.setColor(Color.WHITE);
            g2d.drawString("Made by Gustavo Felix (gustavojofelix@gmail.com)", 5, 15);
            g2d.drawString("Aliens Left : " + aliens.size(), 15, 30);
            
            if(aliens.isEmpty()){
                String msg = "You Won!";
            Font small = new Font("Helvetica", Font.BOLD, 14);
            FontMetrics metr = this.getFontMetrics(small);
            g.setColor(Color.WHITE);
            g.setFont(small);
            g.drawString(msg, (B_WIDTH - metr.stringWidth(msg))/2, B_HEIGHT/2);
            ingame = false;
            }
            
        } else {
            String msg = "Game Over";
            Font small = new Font("Helvetica", Font.BOLD, 14);
            FontMetrics metr = this.getFontMetrics(small);
            g.setColor(Color.WHITE);
            g.setFont(small);
            g.drawString(msg, (B_WIDTH - metr.stringWidth(msg))/2, B_HEIGHT/2);
        }
        
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(aliens.isEmpty()){
            ingame = true;
        }
        
        ArrayList ms = craft.getMissiles();
        
        for(int i = 0; i < ms.size(); i++){
            Missile m = (Missile) ms.get(i);
            if(m.isVisible()){
                m.move();
            }
            else{
                ms.remove(i);
            }
        }
        
        for(int i =0; i < aliens.size(); i++){
            Alien a = (Alien) aliens.get(i);
            if(a.isVisible()){
                a.move();
            } else {
                aliens.remove(i);
            }
        }
        
        craft.move();
        checkCollisions();
        repaint();
    }
    
    public void checkCollisions(){
        Rectangle r3 = craft.getBounds();
        
        for(int i = 0; i < aliens.size(); i++){
            Alien a = (Alien) aliens.get(i);
            Rectangle r2 = a.getBounds();
            
            if(r3.intersects(r2)){
                a.setVisible(false);
                craft.setVisible(false);
                ingame = false;
            }
        }
        
        ArrayList ms = craft.getMissiles();
        
        for(int i = 0; i < ms.size(); i++){
            Missile m = (Missile) ms.get(i);
            
            Rectangle r1 = m.getBounds();
            
            for(int j = 0; j <aliens.size(); j++){
                Alien a = (Alien) aliens.get(j);
                Rectangle r5 = a.getBounds();
                
                if(r1.intersects(r5)){
                    a.setVisible(false);
                    m.setVisible(false);
                }
            }
        }
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            craft.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            craft.keyReleased(e);
        }
    }
}
