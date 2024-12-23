package battleship.ships;

import battleship.Board;
import battleship.Ship;
import battleship.Square;
import battleship.TerrainType;

public class Templateship extends Ship {
    private int[][] template;

    public Templateship(String name, String code, int[][] template, TerrainType allowedTerrainType) {
        super(name, code, countSquares(template), allowedTerrainType);
        this.template = new int[template.length][];
        for (int i = 0; i < template.length; i++) {
            this.template[i] = template[i].clone();
        }
    }

    private static int countSquares(final int[][] template) {
        int count = 0;
        for (int y = 0; y < template.length; y++) {
            for (int x = 0; x < template[y].length; x++) {
                if (template[y][x] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public void rotate() {
        transpose();
        mirror();
    }

    private void transpose() {
        final int[][] nextTemplate = new int[this.getWidth()][this.getHeight()];
        for (int y = 0; y < this.getHeight(); y++) {
            for (int x = 0; x < this.getWidth(); x++) {
                nextTemplate[x][y] = this.template[y][x];
            }
        }
        this.template = nextTemplate;
    }

    private void mirror() {
        for (int y = 0; y < this.getHeight(); y++) {
            final int[] row = this.template[y].clone();
            for (int x = 0; x < this.getWidth(); x++) {
                row[x] = this.template[y][(this.getWidth() - 1) - x];
            }
            this.template[y] = row;
        }
    }

    @Override
    public int getWidth() {
        return this.template[0].length;
    }

    @Override
    public int getHeight() {
        return this.template.length;
    }

    @Override
    public void addToBoard(final Board board) {
        // Ensure the ship fits on the board
        if (this.x < 0 || this.y < 0 || this.x + this.getWidth() > board.getWidth() || this.y + this.getHeight() > board.getHeight()) {
            throw new IllegalArgumentException("Ship does not fit on the board!");
        }

        for (int y = 0; y < this.getHeight(); y++) {
            for (int x = 0; x < this.getWidth(); x++) {
                if (this.template[y][x] == 1) { // Only place ship parts (1s)
                    Square square = board.getSquare(x + this.x, y + this.y);
                    square.setShip(this);
                }
            }
        }
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        for (int y = 0; y < this.getHeight(); y++) {
            for (int x = 0; x < this.getWidth(); x++) {
                if (this.template[y][x] == 0) {
                    builder.append("~");
                } else {
                    builder.append("0");
                }
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
