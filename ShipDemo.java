package battleship;

import battleship.ships.Aeroplane;
import battleship.ships.AircraftCarrier;
import battleship.ships.SimpleShip;

public class ShipDemo {

    public static void main(String[] args){
        Ship s = new AircraftCarrier();
        System.out.println(s);
        s.rotate();
        System.out.println(s);
        s.rotate();
        System.out.println(s);
        s.rotate();
        System.out.println(s);
        s.rotate();
        System.out.println(s);
    }
}
