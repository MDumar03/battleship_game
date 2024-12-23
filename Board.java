package battleship;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {
    private final int height;
    private final int width;
    private final Square[][] board;
    private final List<Ship> ships = new ArrayList<>();

    public Board(int height, int width, boolean verticalSplit) {
        this.height = height;
        this.width = width;
        this.board = new Square[height][width];

        generateTerrain(verticalSplit);
    }

    private void generateTerrain(boolean verticalSplit) {
        // Divide board into land and sea
        int splitLine = verticalSplit ? width / 2 : height / 2; // Vertical or horizontal split

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (verticalSplit) {
                    // Vertical split: Sea on the left, Land on the right
                    this.board[i][j] = (j < splitLine) ? new Square(TerrainType.SEA) : new Square(TerrainType.LAND);
                } else {
                    // Horizontal split: Land on the top, Sea on the bottom
                    this.board[i][j] = (i < splitLine) ? new Square(TerrainType.LAND) : new Square(TerrainType.SEA);
                }
            }
        }
    }

    public void setup(Fleet fleet) throws failedtoplaceshipexception {
        for (Ship s : fleet.getShips()) {
            placeShip(s);
        }
    }

    public void placeShip(Ship ship) throws failedtoplaceshipexception {
        Random random = new Random();
        final int BREAK_THRESHOLD = 1000;

        final int rotations = random.nextInt(4);
        for (int i = 0; i < rotations; i++) {
            ship.rotate();
        }

        int breakCount = 0;
        boolean collision = true;
        while (collision) {
            if (breakCount > BREAK_THRESHOLD) {
                // Reset the board and clear placed ships if placement fails
                for (int i = 0; i < this.board.length; i++) {
                    Square[] row = this.board[i];
                    for (int j = 0; j < row.length; j++) {
                        row[j].setShip(null);
                    }
                }
                for (Ship s : this.ships) {
                    s.setLocation(0, 0);
                }
                this.ships.clear();
                throw new failedtoplaceshipexception();
            } else {
                // Rotate the ship
                ship.rotate();
                // Generate random coordinates
                final int x = random.nextInt(this.width - ship.getWidth());
                final int y = random.nextInt(this.height - ship.getHeight());
                ship.setLocation(x, y);
                // Check terrain compatibility
                boolean validPlacement = true;
                for (int dx = 0; dx < ship.getWidth(); dx++) {
                    for (int dy = 0; dy < ship.getHeight(); dy++) {
                        if (!inBound(x + dx, y + dy) ||
                                !ship.getAllowedTerrainType().matches(getSquare(x + dx, y + dy).getTerrainType())) {
                            validPlacement = false;
                            break;
                        }
                    }
                    if (!validPlacement) break;
                }
                if (!validPlacement) {
                    collision = true;
                    breakCount++;
                    continue;
                }
                // Check for overlap with existing ships
                collision = false;
                for (final Ship s : this.ships) {
                    if (s.overlap(ship)) {
                        collision = true;
                        break;
                    }
                }
                breakCount++;
            }
        }
        ship.addToBoard(this);
        ships.add(ship);
    }

    public int getHeight() {return height;}

    public int getWidth() {return width;}

    public Square getSquare(int x, int y) {return this.board[y][x];}

    public boolean inBound(int x, int y) {return x >= 0 && y >= 0 && x < this.width && y < this.height;}

    public Outcome dropBomb(final int x, final int y) {
        Square square = getSquare(x, y);
        if (!square.isTried()) {
            square.setTried(true);
            Ship sunkShip = null;
            boolean gameWon = false;
            if (square.isHit()) {
                if (square.getShip().isSunk()) {
                    sunkShip = square.getShip();
                    gameWon = true;
                    for (Ship ship : this.ships) {
                        if (!ship.isSunk()) {
                            gameWon = false;
                            break;
                        }
                    }
                }
            }
            return new Outcome(x, y, square.isHit(), sunkShip, gameWon);
        } else {
            throw new IllegalStateException("Square already played!");
        }
    }

    public String[] toStringArray(final boolean showShips) {
        final String[] array = new String[this.height];
        for (int y = 0; y < this.height; y++) {
            final StringBuilder builder = new StringBuilder(this.width);
            for (int x = 0; x < this.width; x++) {
                Square square = getSquare(x, y);
                builder.append(square.getCodecharacter(showShips));
            }
            array[y] = builder.toString();
        }return array;
    }

    @Override
    public String toString() {
        final String[] array = toStringArray(true);
        final StringBuilder builder = new StringBuilder();
        for (int y = 0; y < this.height; y++) {
            builder.append(array[y]);
            builder.append("\n");
        }return builder.toString();
    }
}

