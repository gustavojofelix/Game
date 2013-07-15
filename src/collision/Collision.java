/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collision;

import javax.swing.JFrame;

/**
 *
 * @author Gustavo
 */
public class Collision extends JFrame {
    
    public Collision(){
        add(new Board());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setTitle("Shooting Aliens - By Gustavo Felix");
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
    }
    
    public static void main(String[] args) {
        Collision collision = new Collision();
    }
}
