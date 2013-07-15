/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Areocraft;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Gustavo
 */
public class AboutDialog extends JDialog {

    JLabel authorLbl = new JLabel();
    JLabel swInfo = new JLabel();
    ImageIcon icon = new ImageIcon(this.getClass().getResource("author1.jpg"));
    JPanel authorInfoPanel;
    JPanel softwareInfoPanel;
    JButton closeButton;

    public AboutDialog() {
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        authorInfoPanel = new JPanel();
        authorInfoPanel.setBorder(BorderFactory.createTitledBorder("About the Author"));
        softwareInfoPanel = new JPanel();
        softwareInfoPanel.setBorder(BorderFactory.createTitledBorder("Software information"));

        authorLbl.setIcon(icon);
        authorInfoPanel.add(add(authorLbl));
        
        String author = "<html>"
                + "Name:        Gustavo Felix <br>"
                + "Ocupation:   Java Developer <br>"
                + "Email:  gustavojofelix@gmail.com "
                + "</html>";
        
        String sw = "<html>"
                + "Name: AeroCraft Game Tutorial <br>"
                + "Version:   1.0 <br>"
                + "Website: <a href=\"gustavojofelix@gmail.com\">site.com</a> "
                + "</html>";
        
        swInfo.setText(sw);
        softwareInfoPanel.add(swInfo);
        add(softwareInfoPanel, BorderLayout.CENTER);
        
//        setLocationRelativeTo(this);
        
        authorLbl.setText(author);
        add(authorInfoPanel, BorderLayout.NORTH);
        
        closeButton = new JButton("Close");
        closeButton.setBounds(getWidth()/2, getHeight(), 50, 80);
        closeButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        
        add(closeButton, BorderLayout.SOUTH);
        

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("About AGT");
        setSize(new Dimension(400, 500));
        setVisible(true);
    }

    public static void main(String[] args) {
        AboutDialog aboutDialog = new AboutDialog();
    }
}
