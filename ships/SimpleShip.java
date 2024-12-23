package battleship.ships;
import battleship.Board;
import battleship.Ship;
import battleship.TerrainType;

public class SimpleShip extends Ship {
    private boolean horizontal;

    public SimpleShip(String name, String code, int squareCount, TerrainType allowedTerrainType) {
        super(name, code, squareCount, allowedTerrainType);
    }
    @Override
    public void rotate() {
        this.horizontal = !this.horizontal;
    }

    @Override
    public int getWidth() {
        return this.horizontal ? this.squareCount : 1;
    }

    @Override
    public int getHeight() {
        return this.horizontal ? 1 : this.squareCount;
    }

    @Override
    public void addToBoard(final Board board) {
        if (this.horizontal) {
            for (int x = 0; x < this.squareCount; x++) {
                board.getSquare(this.x + x, this.y).setShip(this);
            }
        } else {
            for (int y = 0; y < this.squareCount; y++) {
                board.getSquare(this.x, this.y + y).setShip(this);
            }
        }
    }
}


