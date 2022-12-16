public class Tile {
    public int X;
    public int Y;
    private char Symbol;

    public Tile(int x, int y) {
        X = x;
        Y = y;
        setSymbol(Player.NO_PLAYER.getSymbol());
    }

    public char getSymbol() {
        return Symbol;
    }

    public void setSymbol(char symbol) {
        Symbol = symbol;
    }
}