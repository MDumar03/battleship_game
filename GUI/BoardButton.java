package battleship.GUI;
import battleship.Square;
import battleship.TerrainType;
import javax.swing.*;
import java.awt.*;

public class BoardButton extends JButton {
    private Square square;
    private boolean showShips;

    public BoardButton(final Square square) {
        this.square = square;
        setPreferredSize(new Dimension(16, 16));
    }

    public void setShowShips(boolean showShips) {
        this.showShips = showShips;
    }

    @Override
    public void paintComponent(Graphics g) {
        g = g.create();
        final Color darkRed = new Color(195, 0, 0);

        if (this.square.getTerrainType() == TerrainType.LAND) {
            g.setColor(Color.ORANGE);
        } else {
            g.setColor(Color.BLUE);
        }
        g.fillRect(0, 0, getWidth(), getHeight());

        // Draw tried squares (hit or miss)
        if (this.square.isTried()) {
            if (this.square.isHit()) {
                g.setColor(Color.darkGray);
                g.fillRect(0, 0, getWidth(), getHeight());
                if (this.square.getShip().isSunk()) {
                    g.setColor(darkRed); // Sunk ship
                } else {
                    g.setColor(Color.orange); // Active hit ship
                }
                g.fillOval(4, 4, getWidth() - 8, getHeight() - 8);
            } else if (this.square.isMiss()) {
                g.setColor(Color.WHITE); // Miss indicator
                g.drawOval(4, 4, getWidth() - 8, getHeight() - 8);
            }
        } else {
            // Draw ship if showShips is true and square has a ship
            if (this.showShips && this.square.getShip() != null) {
                g.setColor(Color.DARK_GRAY); // Ship background
                g.fillRect(0, 0, getWidth(), getHeight());

            }
        }
    }
}
