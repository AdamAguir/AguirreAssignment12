import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @author: Adam Aguirre Assignment 12 Date: 4/22/21
 */
public class BBallPanel extends JPanel {

    private ArrayList<Player> players = new ArrayList<Player>();
    private int index = 0;
    private JLabel fNameLBL = new JLabel("First Name");
    private JLabel lNameLBL = new JLabel("Last Name");
    private JLabel shootPctLBL = new JLabel("Shooting %");
    private JLabel reboundsLBL = new JLabel("Rebounds");
    private JLabel assistsLBL = new JLabel("Assists");
    private JLabel turnoversLBL = new JLabel("Turnovers");
    private JLabel currentLBL = new JLabel("0 of 0");
    private JTextField fNameTXT = new JTextField(10);
    private JTextField lNameTXT = new JTextField(10);
    private JTextField shootPctTXT = new JTextField(10);
    private JTextField reboundsTXT = new JTextField(10);
    private JTextField assistsTXT = new JTextField(10);
    private JTextField turnoverseTXT = new JTextField(10);
    private JButton newBTN = new JButton("New");
    private JButton saveBTN = new JButton("Save");
    private JButton exitBTN = new JButton("Exit");
    private JButton toFirstBTN = new JButton("<<<");
    private JButton previousBTN = new JButton("<");
    private JButton nextBTN = new JButton(">");
    private JButton toLastBTN = new JButton(">>>");
    private JPanel panelNorth = new JPanel();
    private JPanel panelCenter = new JPanel();
    private JPanel panelSouth = new JPanel();
    private JPanel panelWest = new JPanel();
    private String fname;
    private String lname;
    private double shootPct;
    private int rebounds;
    private int assists;
    private int turnOvers;
    private JMenuBar menu;
    private String con;
    private int pos;
    private boolean start;
    private JMenu fileMnu = new JMenu("File");
    private JMenu dataMnu = new JMenu("Data");
    private JMenuItem saveMI = new JMenuItem("Save");
    private JMenuItem exitMI = new JMenuItem("Exit");
    private JMenuItem newMI = new JMenuItem("New");
    private JMenuItem loadMI = new JMenuItem("Load");
    private JMenuItem firstMI = new JMenuItem("First");
    private JMenuItem lastMI = new JMenuItem("Last");
    private JButton loadBTN = new JButton("Load");
    private JRadioButton eastRB = new JRadioButton("East");
    private JRadioButton westRB = new JRadioButton("West");
    private ButtonGroup buttonGroup = new ButtonGroup();
    private JCheckBox starterCB = new JCheckBox();
    private JLabel positionLBL = new JLabel("Position");
    private String[] posValues = { "Point Guard", "Shooting Guard", "Small Forward", "Power Forward", "Center" };
    private JComboBox positionCMB = new JComboBox(posValues);
    private Border etched = BorderFactory.createEtchedBorder();
    private Border titled = BorderFactory.createTitledBorder(etched, "Conference");
    private Border lowerEtched = BorderFactory.createEtchedBorder();
    private Border raised = BorderFactory.createRaisedBevelBorder();

    public BBallPanel(JMenuBar menu) throws FileNotFoundException {
        // setBackground(Color.CYAN);
        setLayout(new BorderLayout());
        this.menu = menu;
        makeMenu();
        //setSize(new Dimension(150,150));
        fNameLBL.setPreferredSize(new Dimension(120, 25));
        lNameLBL.setPreferredSize(new Dimension(120, 25));
        shootPctLBL.setPreferredSize(new Dimension(120, 25));
        assistsLBL.setPreferredSize(new Dimension(120, 25));
        reboundsLBL.setPreferredSize(new Dimension(120, 25));
        turnoversLBL.setPreferredSize(new Dimension(120, 25));
        fNameLBL.setHorizontalAlignment(SwingConstants.RIGHT);
        lNameLBL.setHorizontalAlignment(SwingConstants.RIGHT);
        shootPctLBL.setHorizontalAlignment(SwingConstants.RIGHT);
        assistsLBL.setHorizontalAlignment(SwingConstants.RIGHT);
        reboundsLBL.setHorizontalAlignment(SwingConstants.RIGHT);
        turnoversLBL.setHorizontalAlignment(SwingConstants.RIGHT);

        panelWest.setLayout(new BoxLayout(panelWest, BoxLayout.PAGE_AXIS));

        add(panelNorth, BorderLayout.NORTH);
        add(panelCenter, BorderLayout.CENTER);
        add(panelSouth, BorderLayout.SOUTH);
        add(panelWest, BorderLayout.WEST);
        add(new EastPanel(players), BorderLayout.EAST);

        buttonGroup.add(eastRB);
        buttonGroup.add(westRB);
        Box row = Box.createHorizontalBox();
        row.add(eastRB);
        row.add(westRB);
        loadBTN.setAlignmentX(CENTER_ALIGNMENT);
        starterCB.setAlignmentX(CENTER_ALIGNMENT);
        positionLBL.setAlignmentX(CENTER_ALIGNMENT);
        positionCMB.setAlignmentX(CENTER_ALIGNMENT);
        positionCMB.setMaximumSize(positionCMB.getPreferredSize());

        panelNorth.add(newBTN);
        panelNorth.add(saveBTN);
        panelNorth.add(exitBTN);
        panelNorth.add(currentLBL);
        panelCenter.add(fNameLBL);
        panelCenter.add(fNameTXT);
        panelCenter.add(lNameLBL);
        panelCenter.add(lNameTXT);
        panelCenter.add(shootPctLBL);
        panelCenter.add(shootPctTXT);
        panelCenter.add(reboundsLBL);
        panelCenter.add(reboundsTXT);
        panelCenter.add(assistsLBL);
        panelCenter.add(assistsTXT);
        panelCenter.add(turnoversLBL);
        panelCenter.add(turnoverseTXT);
        panelSouth.add(toFirstBTN);
        panelSouth.add(previousBTN);
        panelSouth.add(nextBTN);
        panelSouth.add(toLastBTN);
        panelWest.add(loadBTN);
        panelWest.add(Box.createRigidArea(new Dimension(0, 10)));
        panelWest.add(row);
        panelWest.add(Box.createRigidArea(new Dimension(0, 10)));
        panelWest.add(starterCB);
        panelWest.add(Box.createRigidArea(new Dimension(0, 10)));
        panelWest.add(positionLBL);
        panelWest.add(Box.createRigidArea(new Dimension(0, 10)));
        panelWest.add(positionCMB);

        newBTN.addActionListener(e -> newRecord());
        saveBTN.addActionListener(e -> saveRecord());
        exitBTN.addActionListener(e -> System.exit(0));
        loadBTN.addActionListener(new FileChooser());
        toFirstBTN.addActionListener(e -> firstRecord());
        previousBTN.addActionListener(e -> previousRecord());
        nextBTN.addActionListener(e -> nextRecord());
        toLastBTN.addActionListener(e -> lastRecord());

        newBTN.setMnemonic('N');
        saveBTN.setMnemonic('S');
        loadBTN.setMnemonic('O');
        exitBTN.setMnemonic('E');

        row.setBorder(titled);
        panelNorth.setBorder(lowerEtched);
        panelSouth.setBorder(lowerEtched);
        panelCenter.setBorder(raised);
    }

    private void newRecord() {
        index = players.size();
        currentLBL.setText(players.size() + " of " + (players.size() + 1));
        fNameTXT.setText("");
        lNameTXT.setText("");
        shootPctTXT.setText("");
        reboundsTXT.setText("");
        assistsTXT.setText("");
        turnoverseTXT.setText("");
        buttonGroup.clearSelection();
    }

    private void saveRecord() {
        fname = fNameTXT.getText();
        lname = lNameTXT.getText();
        shootPct = Double.parseDouble(shootPctTXT.getText());
        rebounds = Integer.parseInt(reboundsTXT.getText());
        assists = Integer.parseInt(assistsTXT.getText());
        turnOvers = Integer.parseInt(turnoverseTXT.getText());
        pos = positionCMB.getSelectedIndex();
        start = starterCB.isSelected();
        if (fNameTXT.getText().equals("") || lNameTXT.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "must enter a first and last name");
        } else {
            if (westRB.isSelected() || eastRB.isSelected()) {
                if (westRB.isSelected()) {
                    con = "West";
                }
                if (eastRB.isSelected()) {
                    con = "East";
                }
                players.add(new Player(fname, lname, shootPct, rebounds, assists, turnOvers, con, pos, start));
                newRecord();

            } else {
                JOptionPane.showMessageDialog(null, "must enter a conference");
            }
        }
    }

    private void firstRecord() {
        index = 0;
        displayRecord();
    }

    private void lastRecord() {
        index = players.size() - 1;
        displayRecord();
    }

    private void nextRecord() {
        if ((index + 1) > players.size() - 1) {
            JOptionPane.showMessageDialog(null, "There are no saved records to show");
        } else {
            index++;
            displayRecord();
        }
    }

    private void previousRecord() {
        if ((index - 1) < 0) {
            JOptionPane.showMessageDialog(null, "There are no saved records to show");
        } else {
            index--;
            displayRecord();
        }
    }

    private void displayRecord() {
        currentLBL.setText((index + 1) + " of " + players.size());
        fNameTXT.setText(players.get(index).getfName());
        lNameTXT.setText(players.get(index).getlName());
        shootPctTXT.setText(String.valueOf(players.get(index).getShootPct()));
        reboundsTXT.setText(String.valueOf(players.get(index).getRebounds()));
        assistsTXT.setText(String.valueOf(players.get(index).getAssists()));
        turnoverseTXT.setText(String.valueOf(players.get(index).getTurnOvers()));
        // use .contains for comparint the strings
        if (players.get(index).getConference().contains("East")) {
            eastRB.setSelected(true);
        } else {
            westRB.setSelected(true);
        }
        if (players.get(index).isStarter()) {
            starterCB.setSelected(true);
        } else {
            starterCB.setSelected(false);
        }
        positionCMB.setSelectedIndex(players.get(index).getPosition());
    }

    private void makeMenu() {
        // menu.setBackground(Color.ORANGE);
        menu.add(fileMnu);
        menu.add(dataMnu);
        fileMnu.add(newMI);
        fileMnu.add(loadMI);
        fileMnu.add(saveMI);
        fileMnu.add(exitMI);
        dataMnu.add(firstMI);
        dataMnu.add(lastMI);

        saveMI.addActionListener(e -> saveRecord());
        exitMI.addActionListener(e -> System.exit(0));
        newMI.addActionListener(e -> newRecord());
        loadMI.addActionListener(new FileChooser());
        firstMI.addActionListener(e -> firstRecord());
        lastMI.addActionListener(e -> lastRecord());

        saveMI.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
        exitMI.setAccelerator(KeyStroke.getKeyStroke("ctrl E"));
        newMI.setAccelerator(KeyStroke.getKeyStroke("ctrl N"));
        loadMI.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
        firstMI.setAccelerator(KeyStroke.getKeyStroke("ctrl F"));
        lastMI.setAccelerator(KeyStroke.getKeyStroke("ctrl L"));

    }

    public void loadData(File data) throws FileNotFoundException {
        Scanner scan = new Scanner(data);
        while (scan.hasNextLine()) {
            fname = scan.next();
            lname = scan.next();
            shootPct = scan.nextDouble();
            rebounds = scan.nextInt();
            assists = scan.nextInt();
            turnOvers = scan.nextInt();
            con = scan.next();
            pos = scan.nextInt();
            start = scan.nextBoolean();
            // System.out.println("fname: " + fname + " lname: " + lname + " shootPct: " + shootPct
            // + " rebounds: " + rebounds + " assists: " + assists + " TurnOvers: " + turnOvers + 
            // " Conferance: " + con + " Pos: " + pos + " Start: " + start);
            players.add(new Player(fname, lname, shootPct, rebounds, assists, turnOvers, con, pos, start));
            newRecord();
        }
        scan.close();
    }

    private class FileChooser implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("."));
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Documents", "txt");
            // fileChooser.addChoosableFileFilter(filter);
            fileChooser.setFileFilter(filter);
            int result = fileChooser.showOpenDialog(BBallPanel.this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                try {
                    loadData(selectedFile);
                } catch (FileNotFoundException s) {
                    s.printStackTrace();
                }
            }
        }
    }
}
