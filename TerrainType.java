package battleship;

public enum TerrainType {
    SEA,
    LAND,
    SEA_LAND; // Combination type for plane to travel on both terrain
    public boolean matches(TerrainType terrain) {
        return this == terrain || this == SEA_LAND || terrain == SEA_LAND;
    }
}
