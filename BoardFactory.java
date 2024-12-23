package battleship;

public class BoardFactory {

    public static Board getBigBoard() {
        Fleet fleet = new Fleet(1, 1, 2, 4, 1, 5, 2, 1);
        Board board = new Board(16, 21, false);
        while (true) {
            try {
                board.setup(fleet);
                return board;
            } catch (failedtoplaceshipexception x) {
                System.err.println("FailedToPlaceShipException");
            }
        }
    }

    public static Board[] getBigBoards() {
        return new Board[] { getBigBoard(),getBigBoard() };
    }

    public static Board getSmallBoard() {
        Fleet fleet = new Fleet(1, 1, 0, 1, 1, 1, 1, 1);
        boolean verticalSplit = false; // Set to false for horizontal land/sea split
        Board board = new Board(10, 10, verticalSplit); // Pass verticalSplit to Board constructor
        while (true) {
            try {
                board.setup(fleet);
                return board;
            } catch (failedtoplaceshipexception x) {
                System.err.println("FailedToPlaceShipException:");
            }
        }
    }
    public static Board[] getSmallBoards() {
        return new Board[] { getSmallBoard(), getSmallBoard() };
    }
    public static Board getTinyBoard() {
        Fleet fleet = new Fleet(0, 0, 0, 1, 1, 1, 1, 1);
        boolean verticalSplit = true; // Example: vertical split for tiny board
        Board board = new Board(5, 5, verticalSplit); // Pass verticalSplit to Board constructor
        while (true) {
            try {
                board.setup(fleet);
                return board;
            } catch (failedtoplaceshipexception x) {
                System.err.println("FailedToPlaceShipException:");
            }
        }
    }
    public static Board[] getTinyBoards() {
        return new Board[] { getTinyBoard(), getTinyBoard() };
    }
}
