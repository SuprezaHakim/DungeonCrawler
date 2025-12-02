import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private ArrayList<String> inventory;
    private int health;

    public Player(Room startRoom) {
        this.currentRoom = startRoom;
        this.inventory = new ArrayList<>();
        this.health = 100;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

    public void addItem(String item) {
        inventory.add(item);
        System.out.println("You picked up: " + item);
    }

    public boolean hasItem(String item) {
        return inventory.contains(item);
    }

    public void showStatus() {
        System.out.println("\n--- STATUS ---");
        System.out.println("Health: " + health);
        System.out.println("Inventory: " + inventory);
        System.out.println("--------------\n");
    }
}