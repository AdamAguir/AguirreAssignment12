import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
/**
 * @author: Adam Aguirre Assignment 12 Date: 4/22/21
 */
public class EastPanel extends JPanel {

    private JButton allDataBTN = new JButton("All Data");
    private JButton filterBTN = new JButton("Filter");
    private JButton clearBTN = new JButton("Clear Data");
    private JButton assistsBTN = new JButton("Total Assists");
    private JButton reboundsBTN = new JButton("Total Rebounds");
    private JButton turnoversBTN = new JButton("Total Turnovers");
    private JLabel filterLBL = new JLabel("FILTER DATA");
    private JLabel firstLBL = new JLabel("First Start With");
    private JLabel lastLBL = new JLabel("Last Starts With");
    private JLabel assistLBL = new JLabel("Assist >");
    private JTextField firstTXT = new JTextField(10);
    private JTextField lastTXT = new JTextField(10);
    private JTextField assistTXT = new JTextField(10);
    private JTextArea textArea = new JTextArea(25,25);
    private String data = "";
    private int count;
    
    public EastPanel(ArrayList<Player> players){
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        Box row1 = Box.createHorizontalBox();
        row1.add(Box.createRigidArea(new Dimension(20,0)));
        row1.add(allDataBTN);
        row1.add(Box.createRigidArea(new Dimension(5,0)));
        row1.add(filterBTN);
        row1.add(Box.createRigidArea(new Dimension(5,0)));
        row1.add(clearBTN);
        row1.add(Box.createRigidArea(new Dimension(20,0)));
        row1.add(assistsBTN);
        row1.add(Box.createRigidArea(new Dimension(5,0)));
        row1.add(reboundsBTN);
        row1.add(Box.createRigidArea(new Dimension(5,0)));
        row1.add(turnoversBTN);
        row1.add(Box.createRigidArea(new Dimension(20,0)));

        Box row2 = Box.createHorizontalBox();
        row2.add(Box.createRigidArea(new Dimension(35,0)));
        row2.add(firstLBL);
        row2.add(Box.createRigidArea(new Dimension(5,0)));
        row2.add(firstTXT);
        row2.add(Box.createRigidArea(new Dimension(5,0)));
        row2.add(lastLBL);
        row2.add(Box.createRigidArea(new Dimension(5,0)));
        row2.add(lastTXT);
        row2.add(Box.createRigidArea(new Dimension(5,0)));
        row2.add(assistLBL);
        row2.add(Box.createRigidArea(new Dimension(5,0)));
        assistTXT.setText("0");
        row2.add(assistTXT);
        row2.add(Box.createRigidArea(new Dimension(35,0)));

        Box row3 = Box.createHorizontalBox();
        row3.add(Box.createRigidArea(new Dimension(10,0)));
        row3.add(scroll);
        row3.add(Box.createRigidArea(new Dimension(10,0)));

        Box rowlabel = Box.createHorizontalBox();
        rowlabel.add(Box.createRigidArea(new Dimension(25,0)));
        rowlabel.add(filterLBL);
        rowlabel.add(Box.createRigidArea(new Dimension(50,0)));


        add(Box.createRigidArea(new Dimension(0,15)));
        add(row1);
        add(Box.createRigidArea(new Dimension(0,15)));
        add(rowlabel);
        add(Box.createRigidArea(new Dimension(0,15)));
        add(row2);
        add(Box.createRigidArea(new Dimension(0,15)));
        add(row3);
        add(Box.createRigidArea(new Dimension(0,15)));
        
        allDataBTN.addActionListener(e -> allData(players));
        filterBTN.addActionListener(e -> filter(players));
        clearBTN.addActionListener(e -> clear());
        assistsBTN.addActionListener(e -> totalAssists(players));
        reboundsBTN.addActionListener(e -> totalRebounds(players));
        turnoversBTN.addActionListener(e -> totalTurnovers(players));
    }
    private void allData(ArrayList<Player> players){
        System.out.println("Selecting all Data");
        players.stream()
            .forEach(player -> data += player.toString());
        textArea.setText(data);
        data = "";
    }
    private void filter(ArrayList<Player> players){
        System.out.println("Filtering Data");
        players.stream()
            .filter(player -> player.getfName().contains(firstTXT.getText()))
            .filter(player -> player.getlName().contains(lastTXT.getText()))
            .filter(player -> player.getAssists() > Integer.parseInt(assistTXT.getText()))
            .forEach(player -> data += player.toString());
        textArea.setText(data);
        data = "";
    }
    private void clear(){
        System.out.println("Clearing Data");
        firstTXT.setText("");
        lastTXT.setText("");
        assistTXT.setText("0");
        textArea.setText("");
    }
    private void totalAssists(ArrayList<Player> players){
        System.out.println("Getting total assists");
        players.stream()
            .forEach(player -> count += player.getAssists());
        textArea.setText("Total Assists: " + count);
        count = 0;
    }
    private void totalRebounds(ArrayList<Player> players){
        System.out.println("Getting Total Rebounds");
        players.stream()
            .forEach(player -> count += player.getRebounds());
        textArea.setText("Total Rebounds: " + count);
        count = 0;
    }
    private void totalTurnovers(ArrayList<Player> players){
        System.out.println("Getting Total Turnovers");
        players.stream()
            .forEach(player -> count += player.getTurnOvers());
        textArea.setText("Total Turnovers: " + count);
        count = 0;
    }
}
