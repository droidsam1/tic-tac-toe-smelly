public class Tile {
    public int X;
    public int Y;
    public char Symbol;

    public Tile(int x, int y) {
        X = x;
        Y = y;
        Symbol = Player.NO_PLAYER.getSymbol();
    }
}