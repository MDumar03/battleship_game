
package battleship.ships;

import battleship.TerrainType;

public class Tank extends SimpleShip {
    public Tank() {
        super("Tank", "T", 1, TerrainType.LAND);
    }
}