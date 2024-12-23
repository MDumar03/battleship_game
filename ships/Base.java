package battleship.ships;

import battleship.TerrainType;

public class Base extends Templateship {
    private static final int[][] PATTERN = {
            new int []{1,1},
            new int[]{1, 1}
    };
    public Base() {
        super("Base", "B", PATTERN.clone(), TerrainType.LAND);
    }
}