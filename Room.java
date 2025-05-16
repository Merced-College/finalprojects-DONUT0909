import java.util.*;

public class Room {
    private boolean visited = false;
    private final Random rand = new Random(); //Generates random events in the room

    //handles what happens when player enters a room
    public void enter(Player player, Scanner scanner) {
        if (player.getX() == 4 && player.getY() == 4) {
            System.out.println("You found the exit and escaped the dungeon!");
            System.out.println("Would you like to play again? (yes/no)");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("yes")) {
                GameManager newGame = new GameManager();
                newGame.startGame();
            } else {
                System.out.println("Thanks for playing!");
                System.exit(0);
            }
         }
        if (visited) {
            System.out.println("You have already been here.");
            return;
        }
        visited = true;

        int event = rand.nextInt(4);
        switch (event) {
            case 0 -> {
                System.out.println("An enemy appears!");
                Enemy enemy = new Enemy("Goblin", 30);
                CombatManager.fight(player, enemy, scanner);
            }
            case 1 -> {
                System.out.println("You found a healing fountain!");
                player.heal(20);
            }
            case 2 -> {
                System.out.println("You found a potion.");
                player.addItem(new Item("Healing Potion", 25));
            }
            case 3 -> System.out.println("The room is empty.");
        }
    }
}