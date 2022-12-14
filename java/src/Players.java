public enum Players {
    NO_PLAYER_SYMBOL(' ');
    private final char playerSymbol;

    Players(char playerSymbol) {
        this.playerSymbol = playerSymbol;
    }

    private static final char NO_PLAYER = ' ';

    public static char getNoPlayer() {
        return NO_PLAYER;
    }
}
