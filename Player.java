/**
 * @author: Adam Aguirre Assignment 12 Date: 4/22/21
 */
public class Player {

    private String fName;
    private String lName;
    private double shootPct;
    private int rebounds;
    private int assists;
    private int turnOvers;
    private String conference;
    private int position;
    private boolean starter;

    public Player(String fName, String lName, double shootPct, int rebounds, int assists, int turnOvers){
        this.fName = fName;
        this.lName = lName;
        this.shootPct = shootPct;
        this.rebounds = rebounds;
        this.assists = assists;
        this.turnOvers = turnOvers;
    }
    public Player(String fName, String lName, double shootPct, int rebounds, int assists, int turnOvers, String con, int pos, boolean starter){
        this.fName = fName;
        this.lName = lName;
        this.shootPct = shootPct;
        this.rebounds = rebounds;
        this.assists = assists;
        this.turnOvers = turnOvers;
        this.conference = con;
        this.position = pos;
        this.starter = starter;
    }

    public String getfName() {
        return fName;
    }
    public String getlName() {
        return lName;
    }
    public double getShootPct() {
        return shootPct;
    }
    public int getRebounds() {
        return rebounds;
    }
    public int getAssists() {
        return assists;
    }
    public int getTurnOvers() {
        return turnOvers;
    }
    public String getConference() {
        return conference;
    }
    public int getPosition() {
        return position;
    }
    public boolean isStarter() {
        return starter;
    }
    public void setfName(String fName) {
        this.fName = fName;
    }
    public void setlName(String lName) {
        this.lName = lName;
    }
    public void setShootPct(double shootPct) {
        this.shootPct = shootPct;
    }
    public void setRebounds(int rebounds) {
        this.rebounds = rebounds;
    }
    public void setAssists(int assists) {
        this.assists = assists;
    }
    public void setTurnOvers(int turnOvers) {
        this.turnOvers = turnOvers;
    }
    public void setConference(String conference) {
        this.conference = conference;
    }
    public void setPosition(int position) {
        this.position = position;
    }
    public void setStarter(boolean starter) {
        this.starter = starter;
    }
    
    @Override
    public String toString() {
        return "Player: [fname: " + getfName() + ", lname: " + getlName() + ", shootPct:" + getShootPct() + 
               ", Rebounds:" + getRebounds() + ", Assists:" + getAssists() + ", Turn Overs:" + getTurnOvers() + 
               ", Conference: " + getConference() + ", Position: " + getPosition() + ", Starter" + isStarter() + "]\n";
    }
}
