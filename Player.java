import java.util.*;

public class Player {
    private int hp;
    private int x, y;
    private final ArrayList<Item> inventory;

    public Player(String name, int hp) {
        this.hp = hp;
        this.x = 0;
        this.y = 0;
        this.inventory = new ArrayList<>();
    }

    public boolean isAlive() {
        return hp > 0;
    }

    //updates players position based on input
    public void move(int dx, int dy) {
        int newX = x + dx;
        int newY = y + dy;

        if (newX < 0 || newX > 4 || newY < 0 || newY > 4) {
            System.out.println("You can't move in that direction.");
            return;
        }

        x = newX;
        y = newY;
    }

    public void takeDamage(int damage) {
        hp -= damage;
        System.out.println("You took " + damage + " damage. HP: " + hp);
    }

    public void heal(int amount) {
        hp += amount;
        System.out.println("You healed " + amount + " HP. HP: " + hp);
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getHp() { return hp; }

    public void addItem(Item item) {
        inventory.add(item);
        System.out.println("You found a " + item.getName());
    }

    public void useItem() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        Item item = inventory.remove(0);
        item.use(this);
    }
}