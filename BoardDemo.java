package battleship;

public class BoardDemo {
    public static void main (String[] args) throws failedtoplaceshipexception {
        Board b1 = new Board (30,30,true);

        Fleet fleet = new Fleet(1,1,1,1,1,1,1,1);
        b1.setup(fleet);
        System.out.println(b1);

        System.out.println("Bomb 2 whole rows");
        for (int y = 3; y < 5 ; y++) {
            for (int x = 0; x < b1.getWidth(); x++) {
                System.out.println("Bombing square x = " + x + ", y=" + y);
                System.out.println(b1);
                System.out.println();
            }

        }
    }
}
