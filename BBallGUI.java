import java.awt.Container;
import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

/**
 * @author: Adam Aguirre Assignment 12 Date: 4/22/21
 */
public class BBallGUI extends JFrame {

    public BBallGUI() throws FileNotFoundException {
        setSize(1150, 450);
        setResizable(false);
        setTitle("My BBall Stats Program");

        Container pane = getContentPane();
        JMenuBar menu = new JMenuBar();
        setJMenuBar(menu);
        pane.add(new BBallPanel(menu));

    }

    public static void main(String[] args) throws FileNotFoundException {
        BBallGUI frame = new BBallGUI();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}