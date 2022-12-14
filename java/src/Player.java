public enum Player {
    NO_PLAYER(' ');

    private final char symbol;

    Player(char symbol) {
        this.symbol = symbol;
    }

    public static char getNoPlayer() {
        return NO_PLAYER.symbol;
    }

    public char getSymbol() {
        return symbol;
    }
}
