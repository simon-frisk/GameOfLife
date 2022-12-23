package game;

import java.util.HashSet;

public class Game {
    private HashSet<Tile> activeTiles;
    private int step = 1;

    public Game(HashSet<Tile> activeTiles) {
        this.activeTiles = activeTiles;
    }

    public void step() {
        HashSet<Tile> neighborTiles = new HashSet<>();
        for(Tile tile : activeTiles) {
            Tile neighborLeft = new Tile(tile.X - 1, tile.Y);
            if(! activeTiles.contains(neighborLeft))
                neighborTiles.add(neighborLeft);
            Tile neighborRight = new Tile(tile.X + 1, tile.Y);
            if(! activeTiles.contains(neighborRight))
                neighborTiles.add(neighborRight);
            Tile neighborUp = new Tile(tile.X, tile.Y - 1);
            if(! activeTiles.contains(neighborUp))
                neighborTiles.add(neighborUp);
            Tile neighborDown = new Tile(tile.X, tile.Y + 1);
            if(! activeTiles.contains(neighborDown))
                neighborTiles.add(neighborDown);
            Tile neighborDownLeft = new Tile(tile.X - 1, tile.Y + 1);
            if(! activeTiles.contains(neighborDownLeft))
                neighborTiles.add(neighborDownLeft);
            Tile neighborDownRight = new Tile(tile.X + 1, tile.Y + 1);
            if(! activeTiles.contains(neighborDownRight))
                neighborTiles.add(neighborDownRight);
            Tile neighborUpLeft = new Tile(tile.X - 1, tile.Y - 1);
            if(! activeTiles.contains(neighborUpLeft))
                neighborTiles.add(neighborUpLeft);
            Tile neighborUpRight = new Tile(tile.X + 1, tile.Y - 1);
            if(! activeTiles.contains(neighborUpRight))
                neighborTiles.add(neighborUpRight);
        }

        HashSet<Tile> newActiveTiles = new HashSet<>();

        for(Tile tile : neighborTiles)
            if(activeNeighborCount(tile) == 3)
                newActiveTiles.add(tile);

        for(Tile tile : activeTiles) {
            int numActiveNeighbors = activeNeighborCount(tile);
            if (numActiveNeighbors == 2 || numActiveNeighbors == 3)
                newActiveTiles.add(tile);
        }

        activeTiles = newActiveTiles;
        step++;
    }

    public int activeNeighborCount(Tile tile) {
        int neighborCount = 0;

        if(activeTiles.contains(new Tile(tile.X - 1, tile.Y))) neighborCount++;
        if(activeTiles.contains(new Tile(tile.X - 1, tile.Y - 1))) neighborCount++;
        if(activeTiles.contains(new Tile(tile.X, tile.Y - 1))) neighborCount++;
        if(activeTiles.contains(new Tile(tile.X + 1, tile.Y - 1))) neighborCount++;
        if(activeTiles.contains(new Tile(tile.X + 1, tile.Y))) neighborCount++;
        if(activeTiles.contains(new Tile(tile.X + 1, tile.Y + 1))) neighborCount++;
        if(activeTiles.contains(new Tile(tile.X, tile.Y + 1))) neighborCount++;
        if(activeTiles.contains(new Tile(tile.X - 1, tile.Y + 1))) neighborCount++;

        return neighborCount;
    }

    public HashSet<Tile> getActiveTiles() {
        return activeTiles;
    }

    public int getStep() {
        return step;
    }
}
