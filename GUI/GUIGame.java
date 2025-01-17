package battleship.GUI;
import battleship.AbstractGame;
import battleship.AbstractPlayer;

public class GUIGame extends AbstractGame {
    public static final int DELAY = 0;
    public GUIGame(final AbstractPlayer player1, final AbstractPlayer player2) {
        super(player1, player2);
    }
    @Override
    public void startGame() {
        nextTurn();
    }

    @Override
    public void takeTurn(final int x, final int y) {
        super.takeTurn(x, y);
        if (!this.gameOver) {
            Utils.invokeLater(()->nextTurn(), DELAY); // delay to allow damage to be displayed
        }
    }
}