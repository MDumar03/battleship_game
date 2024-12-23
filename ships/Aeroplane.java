package battleship.ships;

import battleship.TerrainType;

public class Aeroplane extends Templateship{
    private static final int[][] pattern = new int [][]{
            new int []{1,1,1},
            new int[]{0,1,0},
    };
    public Aeroplane (){
        super("Aeroplane","P",pattern.clone(), TerrainType.SEA_LAND);
    }
}
