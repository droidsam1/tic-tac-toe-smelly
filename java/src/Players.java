public enum Players {
    NO_PLAYER_SYMBOL(' ');
    private final char playerSymbol;

    Players(char playerSymbol) {
        this.playerSymbol = playerSymbol;
    }

    public static char getNoPlayer() {
        return NO_PLAYER_SYMBOL.playerSymbol;
    }
}
