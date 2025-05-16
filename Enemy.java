public class Enemy {
    private final String name;
    private int hp;

    public Enemy(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public void takeDamage(int damage) {
        hp -= damage;
        System.out.println(name + " takes " + damage + " damage. HP: " + hp);
    }

    public void attack(Player player) {
        int damage = 10;
        System.out.println(name + " attacks!");
        player.takeDamage(damage);
    }

    public int getHp() { return hp; }
}
