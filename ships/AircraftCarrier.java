package battleship.ships;
import battleship.TerrainType;

public class AircraftCarrier extends Templateship{
    private static final int[][] pattern = new int [][]{
            new int []{1,1,1,1,0},
            new int[]{0,1,1,1,1},
    };
    public AircraftCarrier (){
        super("Aircraft carrier","C",pattern.clone(), TerrainType.SEA);
    }
}
