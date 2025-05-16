import java.util.*;

public class GameManager {
    private Dungeon dungeon;
    private Player player;
    private Scanner scanner;
    private boolean isRunning;

    public void startGame() { //starts the game loop and game components
        scanner = new Scanner(System.in);
        dungeon = new Dungeon(4, 4);
        player = new Player("Hero", 100);
        isRunning = true;

        System.out.println("Welcome to the Dungeon!");

        //continuous loop if the game is active and player is alive
        while (isRunning && player.isAlive()) {
            Room currentRoom = dungeon.getRoom(player.getX(), player.getY());
            currentRoom.enter(player, scanner);
            if (!player.isAlive()) break;
            handleMovement();
        }

        if (player.isAlive()) {
            System.out.println("You survived the dungeon! Victory!");
        } else {
            System.out.println("You have perished in the dungeon.");
        }
    }

    private void handleMovement() {
        System.out.println("Where do you want to go? (n/s/e/w): ");
        String direction = scanner.nextLine();

        switch (direction) {
            case "n" -> player.move(0, -1);
            case "s" -> player.move(0, 1);
            case "e" -> player.move(1, 0);
            case "w" -> player.move(-1, 0);
            default -> System.out.println("Invalid direction.");
        }
    }
}