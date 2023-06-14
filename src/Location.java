import java.util.Scanner;

public abstract class Location {
    private Player player;
    private String name;
    private int ID;

    Scanner input = new Scanner(System.in);

    public Location(int ID, Player player, String name){
        this.ID = ID;
        this.player = player;
        this.name = name;
    }
    public abstract boolean onLocation();
    public Player getPlayer() {
        return player;
    }
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
