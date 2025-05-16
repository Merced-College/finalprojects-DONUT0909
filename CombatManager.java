import java.util.*;

public class CombatManager {
    public static void fight(Player player, Enemy enemy, Scanner scanner) {
        while (player.isAlive() && enemy.isAlive()) {
            System.out.println("Choose action: [1] Attack  [2] Use Item"); //displays optionsss to the player during battle
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                enemy.takeDamage(15);
            } else if (choice.equals("2")) {
                player.useItem();
            }

            if (enemy.isAlive()) {
                enemy.attack(player);
            }
        }
    }
}