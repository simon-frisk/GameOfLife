import game.Game;
import game.Tile;
import gui.GUI;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<Tile> startTiles = new HashSet<>();
        startTiles.add(new Tile(30, 20));
        startTiles.add(new Tile(30, 21));
        startTiles.add(new Tile(30, 22));
        startTiles.add(new Tile(29, 21));
        startTiles.add(new Tile(31, 20));


        Game game = new Game(startTiles);

        GUI gui = new GUI(game);


    }
}
