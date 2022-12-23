package game;

public class Tile {
    public int X;
    public int Y;

    public Tile(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }

    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        else if(!(o instanceof Tile)) return false;
        else {
            Tile t = (Tile) o;
            return (this.X == t.X && this.Y == t.Y);
        }
    }

    @Override
    public int hashCode() {
        return this.X+(10^5)*this.Y;
    }

    @Override
    public String toString() {
        return String.format("(%d,%d)",X,Y);
    }
}
