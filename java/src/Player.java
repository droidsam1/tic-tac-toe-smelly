import java.util.Arrays;

public enum Player {
    NO_PLAYER(' '), PLAYER_X('X'), PLAYER_O('O');

    private final char symbol;

    Player(char symbol) {
        this.symbol = symbol;
    }

    public static Player from(char symbol) {
        return Arrays.stream(Player.values()).filter(player -> player.symbol == symbol).findFirst().orElse(NO_PLAYER);
    }

    public char getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
}
