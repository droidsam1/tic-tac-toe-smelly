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

    public Tile getTileAt(int x, int y) {
        for (Tile t : tiles) {
            if (t.X == x && t.Y == y) {
                return t;
            }
        }
        return null;
    }

    public void setPlayerAt(Player player, int x, int y) {
        getTileAt(x, y).setSymbol(player.getSymbol());
    }
}