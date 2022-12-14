public enum Players {
    NO_PLAYER(' ');
    private final char symbol;

    Players(char symbol) {
        this.symbol = symbol;
    }

    public static char getNoPlayer() {
        return NO_PLAYER.symbol;
    }
}
