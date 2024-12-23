package battleship;

import java.awt.geom.Rectangle2D;

public abstract class Ship {
    private final String name;
    private final String code;
    protected int squareCount;
    private int hits;
    protected int x;
    protected int y;

    private final TerrainType allowedTerrainType;
    public Ship(String name, String code, int squareCount, TerrainType allowedTerrainType) {
        this.name = name;
        this.code = code;
        this.squareCount = squareCount;
        this.allowedTerrainType = allowedTerrainType;
    }

    public String getName() {
        return this.name;
    }

    public String getCode() {
        return this.code;
    }

    public TerrainType getAllowedTerrainType() { // NEW METHOD
        return this.allowedTerrainType;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract void rotate();

    public abstract int getWidth();

    public abstract int getHeight();

    public boolean incrementHitCount() {

        if (this.hits < this.squareCount) {
            this.hits++;
        }
        return (this.hits == this.squareCount);

    }

    public boolean isSunk() {
        return (this.hits == this.squareCount);
    }

    public boolean overlap(final Ship other) {
        final Rectangle2D rectThis = new Rectangle2D.Double(this.x, this.y, this.getWidth(), this.getHeight());
        final Rectangle2D rectOther = new Rectangle2D.Double(other.x, other.y, other.getWidth(), other.getHeight());
        final Rectangle2D intersection = rectThis.createIntersection(rectOther);
        return (intersection.getWidth() >= 0) && (intersection.getHeight() >= 0);
    }


    public abstract void addToBoard(final Board board);

}