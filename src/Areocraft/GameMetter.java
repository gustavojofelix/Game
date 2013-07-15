/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Areocraft;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import static Areocraft.Constants.*;
import java.awt.*;
import javax.swing.ImageIcon;

/**
 *
 * @author Gustavo
 */
public class GameMetter extends JPanel {

//    ImageIcon ii = new ImageIcon("alienA.png");
//    Image image = ii.getImage();
    
//    public GameMetter(){
//        setSize(new Dimension(50, 50));
//    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        setBackground(Color.BLACK);
        g.setColor(Color.GREEN);
//        g.drawRoundRect(2, 60, 30, 30, 1, 1);
//        g.drawRoundRect(20, 60, 30, 30, 1, 1);
//        g.drawRoundRect(40, 60, 30, 30, 1, 1);

        Graphics2D g2d = (Graphics2D) g;

//        g.drawLine(1, 60, BOARD_WIDTH, 60);

        for (int i = 0; i < 10; i++) {
            int ySpace = 1;
            g2d.drawLine(1, ySpace+i*10, BOARD_WIDTH, ySpace+i*10);
            ySpace +=10;
        }
        
        for (int i = 0; i < 10; i++) {
            int ySpace = 1;
            g2d.drawLine(ySpace+i*10,1 , ySpace+i*10,BOARD_HEIGHT);
            ySpace +=10;
        }
        
        
        
    }
}
