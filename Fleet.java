package battleship;

import battleship.ships.*;

import java.util.ArrayList;
import java.util.List;

public class Fleet {

    private List<Ship> ships = new ArrayList<>();

    public Fleet(int battleships, int destroyer, int submarine, int aeroplane, int aircrafterCarrier, int tanks, int bases, int ammoDumps){

        for (int i = 0; i < tanks; i++) {
            this.ships.add(new Tank());
        }
        for (int i = 0; i < bases; i++) {
            this.ships.add(new Base());
        }
        for (int i = 0; i < ammoDumps; i++) {
            this.ships.add(new AmmoDump());
        }
        for (int i =0;i < battleships;i++ ){
            this.ships.add(new Battleship());
        }
        for (int i =0;i < destroyer;i++ ){
            this.ships.add(new Destroyer());
        }
        for (int i =0;i < submarine;i++ ){
            this.ships.add(new Submarine());
        }
        for (int i =0;i < aeroplane;i++ ){
            this.ships.add(new Aeroplane());
        }
        for (int i =0;i < aircrafterCarrier;i++ ){
            this.ships.add(new AircraftCarrier());
        }

    }
    public List<Ship> getShips() {
        return this.ships;
    }
}

