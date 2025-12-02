import java.util.Scanner;

public class Game {
    private Player player;
    private boolean finished;

    public Game() {
        createRooms();
        finished = false;
    }

    private void createRooms() {
        Room outside, lobby, workShop, office, basement;

        outside = new Room("outside the main entrance of the university");
        lobby = new Room("in the grand lobby");
        workShop = new Room("in a computing workshop");
        office = new Room("in the admin office");
        basement = new Room("in the dark basement");

        outside.setExit("east", lobby);
        outside.setExit("south", workShop);
        
        lobby.setExit("west", outside);
        lobby.setExit("east", office);
        
        workShop.setExit("north", outside);
        workShop.setExit("east", basement);
        
        office.setExit("west", lobby);
        
        basement.setExit("west", workShop);

        // Adds  items to rooms
        workShop.setItem("FlashDrive");
        office.setItem("Key");
        basement.setItem("AncientServer");

        // Start game outside
        player = new Player(outside);
    }

    public void play() {
        printWelcome();

        Scanner reader = new Scanner(System.in);
        while (!finished) {
            System.out.print("> ");
            String input = reader.nextLine();
            processCommand(input);
        }
        System.out.println("Thank you for playing. Goodbye.");
        reader.close();
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the University Adventure!");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(player.getCurrentRoom().getLongDescription());
    }

    private void processCommand(String commandLine) {
        String[] words = commandLine.split(" ");
        String command = words[0];

        if (command.equalsIgnoreCase("help")) {
            printHelp();
        } else if (command.equalsIgnoreCase("go")) {
            if (words.length > 1) goRoom(words[1]);
            else System.out.println("Go where?");
        } else if (command.equalsIgnoreCase("take")) {
            takeItem();
        } else if (command.equalsIgnoreCase("status")) {
            player.showStatus();
        } else if (command.equalsIgnoreCase("quit")) {
            finished = true;
        } else {
            System.out.println("I don't know what you mean...");
        }
    }

    private void printHelp() {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around the university.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println("   go [direction]  |  take  |  status  |  quit  |  help");
    }

    private void goRoom(String direction) {
        Room nextRoom = player.getCurrentRoom().getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else {
            player.setCurrentRoom(nextRoom);
            System.out.println(player.getCurrentRoom().getLongDescription());
            
            // Example of interaction: Win condition
            if(player.getCurrentRoom().getShortDescription().contains("basement") && player.hasItem("Key")) {
                System.out.println("You unlocked the secret server room with the Key! YOU WIN!");
                finished = true;
            }
        }
    }

    private void takeItem() {
        Room current = player.getCurrentRoom();
        String item = current.removeItem();
        if (item != null) {
            player.addItem(item);
        } else {
            System.out.println("There is nothing here to take.");
        }
    }
}