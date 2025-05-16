public class Dungeon {
    private final Room[][] rooms;
    private final int width;
    private final int height;

    public Dungeon(int width, int height) {
        this.width = width;
        this.height = height;
        rooms = new Room[width][height]; //initializes the 2D array

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                rooms[x][y] = new Room(); //populates each cell in the in the dungeon with a random object
            }
        }
    }

    public Room getRoom(int x, int y) {
        if (x < 0 || x >= width || y < 0 || y >= height) return new Room();
        return rooms[x][y];
    }
}
