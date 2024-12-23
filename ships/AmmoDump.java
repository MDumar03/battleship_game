package battleship.ships;

import battleship.TerrainType;

public class AmmoDump extends Templateship {
    private static final int[][] pattern = {
            new int []{1,0,1},
            new int[]{1,1,1},
            new int[]{1, 0, 1}
    };
    public AmmoDump() {
        super("Ammodump", "A", pattern.clone(), TerrainType.LAND);
    }
}


