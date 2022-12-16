import java.util.ArrayList;
import java.util.List;

public class Board {
    private static final int SQUARE_BOARD_SIZE = 3;
    private final List<Tile> tiles = new ArrayList<>();

    public Board() {
        buildSquareBoard();
    }

    private void buildSquareBoard() {
        for (int x = 0; x < SQUARE_BOARD_SIZE; x++) {
            for (int y = 0; y < SQUARE_BOARD_SIZE; y++) {
                tiles.add(new Tile(x, y));
            }
        }
    }

    public int getNumberOfRows() {
        return SQUARE_BOARD_SIZE;
    }

    private Tile getTileAt(int x, int y) {
        return tiles.stream().filter(tile -> tile.X == x && tile.Y == y).findFirst().orElseThrow();
    }

    public char getPlayerAt(int x, int y) {
        return getTileAt(x, y).getSymbol();
    }

    public void setPlayerAt(Player player, int x, int y) {
        getTileAt(x, y).setSymbol(player.getSymbol());
    }

    public boolean isRowFullWithSamePlayer(int rowNumber) {
        return this.getPlayerAt(rowNumber, 0) != Player.NO_PLAYER.getSymbol() && this.getPlayerAt(rowNumber, 0) == this.getPlayerAt(rowNumber, 1) && this.getPlayerAt(rowNumber, 2) == this.getPlayerAt(rowNumber, 1);
    }

    public boolean isRowFull(int rowNumber) {
        return this.getPlayerAt(rowNumber, 0) != Player.NO_PLAYER.getSymbol() && this.getPlayerAt(rowNumber, 1) != Player.NO_PLAYER.getSymbol() && this.getPlayerAt(rowNumber, 2) != Player.NO_PLAYER.getSymbol();
    }
}