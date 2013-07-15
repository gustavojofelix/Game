/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Areocraft;

import static Areocraft.Constants.BOARD_HEIGHT;
import static Areocraft.Constants.BOARD_WIDTH;
import collision.Collision;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.URL;
import javax.swing.*;

/**
 *
 * @author Gustavo
 */
public class Main {
    
    private static JLabel statusBar;
    
    public Main() {
        
        
        
    }
    
    public JMenuBar createMenuBar() {
        //MenuBar, Menus and MenuItems
        JMenuBar menuBar;
        JMenu fileMenu;
        JMenu helpMenu;
        JMenuItem exitMenu;
        JMenuItem aboutMenu;
        
        menuBar = new JMenuBar();
        
        fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        
        menuBar.add(fileMenu);
        
        ImageIcon icon = new ImageIcon(this.getClass().getResource("close.png"));
        exitMenu = new JMenuItem("Exit", icon);
        exitMenu.setMnemonic(KeyEvent.VK_X);
        exitMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.CTRL_DOWN_MASK));
        
        exitMenu.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        
        fileMenu.add(exitMenu);
        
        helpMenu = new JMenu("Help");
        helpMenu.setMnemonic(KeyEvent.VK_H);
        
        menuBar.add(helpMenu);
        
        aboutMenu = new JMenuItem("About AGT");
        aboutMenu.setMnemonic(KeyEvent.VK_A);
        aboutMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK));
        aboutMenu.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                AboutDialog aboutDialog = new AboutDialog();
            }
        });
        
        helpMenu.add(aboutMenu);
        
        
        return menuBar;
        
    }
    
    protected ImageIcon createImageIcon(String path) {
        URL imageURL = Main.class.getResource(path);
        
        if (imageURL != null) {
            return new ImageIcon(imageURL);
        } else {
            System.err.println("Couldn't find image in specified location "
                    + " " + imageURL);
            return null;
        }
    }
    
    public Container createContentPane() {
        //Buttons
        ImageIcon createImageIcon;
        createImageIcon = createImageIcon("alienicon.png");
        JButton playBtn = new JButton("Play Game", createImageIcon);
        createImageIcon = createImageIcon("crafticon.png");
        JButton craftDemoBtn = new JButton("Craft Demo", createImageIcon);
        createImageIcon = createImageIcon("missilicon.png");
        JButton missilDemoBtn = new JButton("Missil Demo", createImageIcon);
        
        missilDemoBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Test t = new Test(new MissilBoard());
            }
        });
        
        craftDemoBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Test t = new Test(new CraftBoard());
            }
        });
        
        playBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //Test t = new Test(new GameBoard());
                collision.Collision cl = new Collision();
            }
        });
        
        
        JPanel pane = new JPanel();
        
        pane.add(Box.createRigidArea(new Dimension(5, 5)));
        pane.add(playBtn);
//        pane.add(Box.createRigidArea(new Dimension(5, 5)));
//        pane.add(craftDemoBtn);
//        pane.add(Box.createRigidArea(new Dimension(5, 5)));
//        pane.add(missilDemoBtn);
//        
        
        pane.setLayout(
                new BoxLayout(pane, BoxLayout.Y_AXIS));
        
        pane.setBackground(Color.WHITE);
        
        return pane;
    }
    
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("AeroCraft Game Tutorial - AGT (Demo)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(BOARD_WIDTH - 100, BOARD_HEIGHT - 100));
        frame.setVisible(true);
        
        frame.setLocationRelativeTo(null);
        
        statusBar = new JLabel("AGT V1.0 @ Designed by Gustavo Felix(gustavojofelix@gmail.com)");
        statusBar.setBorder(BorderFactory.createEtchedBorder());
        
        frame.add(statusBar, BorderLayout.SOUTH);
        Main main = new Main();
        frame.add(main.createContentPane(), BorderLayout.WEST);
        AlienBoard ab = new AlienBoard();
        GameMetter gm = new GameMetter();
        frame.add(ab, BorderLayout.CENTER);
        frame.setJMenuBar(main.createMenuBar());
//        frame.setContentPane(main.createContentPane());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        SwingUtilities.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
