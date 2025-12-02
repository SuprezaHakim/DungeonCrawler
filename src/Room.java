import java.util.HashMap;
import java.util.Set;

public class Room {
    private String description;
    private HashMap<String, Room> exits; // Stores exits like "north" -> Room Object
    private String item; 

    public Room(String description) {
        this.description = description;
        exits = new HashMap<>();
        this.item = null;
    }

    public void setExit(String direction, Room neighbor) {
        exits.put(direction, neighbor);
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }

    public String getShortDescription() {
        return description;
    }

    public String getLongDescription() {
        return "You are " + description + ".\n" + getExitString();
    }

    private String getExitString() {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for (String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }

    public String removeItem() {
        String temp = item;
        item = null;
        return temp;
    }
}