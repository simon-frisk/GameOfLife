package gui;

import game.Game;
import game.Tile;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;

public class GameCanvas extends JPanel {
    private int numCellsX;
    private int numCellsY;
    private int cellWidth;
    private Game game;

    public GameCanvas(int numCellsX, int numCellsY, int cellWidth, Game game) {
        this.numCellsX = numCellsX;
        this.numCellsY = numCellsY;
        this.cellWidth = cellWidth;
        this.game = game;
    }

    public void paintComponent(Graphics g) {
        setBackground(Color.WHITE);
        g.setColor(Color.ORANGE);
        g.drawString(String.format("Step: %d", game.getStep()), 10, 15);
        g.setColor(Color.LIGHT_GRAY);

        for(int x = 0; x < numCellsX; x++) {
            for(int y = 0; y < numCellsY; y++) {
                g.drawRect(x*cellWidth, y*cellWidth, cellWidth, cellWidth);
            }
        }

        g.setColor(Color.ORANGE);

        for(Tile tile : game.getActiveTiles()) {
            g.fillRect(tile.X*cellWidth, tile.Y*cellWidth, cellWidth, cellWidth);
        }
    }
}
