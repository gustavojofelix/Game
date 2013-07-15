/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Areocraft;

import static Areocraft.Constants.BOARD_HEIGHT;
import static Areocraft.Constants.BOARD_WIDTH;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 *
 * @author Gustavo
 */
public class Test extends JFrame{

    public Test(JPanel panel){
        add(panel);
        setTitle("Moving the Plane");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setSize(BOARD_WIDTH,BOARD_HEIGHT);
    }
    
    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) {
//        // TODO code application logic here
//        Test test = new Test(new GameMetter());
////        Test test1 = new Test(new Board());
//    }
}
