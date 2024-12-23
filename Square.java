package battleship;
public class Square {
    private boolean isTried;
    private Ship ship;
    private TerrainType terrainType;

    public Square(TerrainType terrainType) {
        this.terrainType = terrainType;
    }

    public TerrainType getTerrainType() {
        return terrainType;
    }

    public Ship getShip() {
        return this.ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }


    public boolean isTried() {
        return isTried;
    }

    public void setTried(boolean tried) {
        isTried = tried;

        if (this.ship != null && this.ship.getAllowedTerrainType().matches(this.terrainType)) {
            this.ship.incrementHitCount();
        }
    }

    public boolean isHit() {
        return this.isTried && this.ship != null && this.ship.getAllowedTerrainType().matches(this.terrainType);
    }


    public boolean isMiss() {
        return this.isTried && this.ship == null;
    }

    public String getCodecharacter(Boolean showShips) {
        if (this.isTried) {
            if (this.isHit()) {
                return "x"; // Hit
            } else if (this.isMiss()) {
                return "'"; // Miss
            }
        } else if (showShips && this.ship != null) {
            return this.ship.getCode(); // Show ship if allowed
        }
        return "□"; // Default (untried square)
    }

}