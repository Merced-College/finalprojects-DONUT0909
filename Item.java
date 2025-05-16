public class Item {
    private final String name;
    private final int healAmount;

    public Item(String name, int healAmount) {
        this.name = name;
        this.healAmount = healAmount;
    }

    public void use(Player player) {
        System.out.println("Using " + name);
        player.heal(healAmount);
    }

    public String getName() {
        return name;
    }
}
