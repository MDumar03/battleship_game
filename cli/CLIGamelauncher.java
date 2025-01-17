package battleship.cli;

import battleship.*;

public class CLIGamelauncher {

    public static void main(String[] args) {
//    Board[] boards = BoardFactory.getBigBoards();
//    Board[] boards = BoardFactory.getSmallBoards();
        Board[] boards = BoardFactory.getTinyBoards();

        AbstractPlayer player1 = null;
        AbstractPlayer player2 = null;
        ComputerPlayerStrategy strategy1 = new RandomStrategy();
        ComputerPlayerStrategy strategy2 = new RandomStrategy();

        GameType gameType = GameType.COMPUTER_V_COMPUTER;

        switch(gameType) {
            case COMPUTER_V_COMPUTER:
                player1 = new CLIComputer("Computer1", boards[0], strategy1);
                player2 = new CLIComputer("Computer2", boards[1], strategy2);
                break;
            case HUMAN_V_COMPUTER:
                player1 = new CLIHuman("Human", boards[0]);
                player2 = new CLIComputer("Computer", boards[1], strategy2);
                break;
            case HUMAN_V_HUMAN:
                player1 = new CLIHuman("Human1", boards[0]);
                player2 = new CLIHuman("Human2", boards[1]);
                break;
            default:
                break;
        }

        AbstractGame game = new CLIGame(player1, player2);
        game.startGame();
    }

}