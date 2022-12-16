import java.util.ArrayList;
import java.util.List;

public class Board {
    private static final int SQUARE_BOARD_SIZE = 3;
    private final List<Tile> tiles = new ArrayList<>();

    public Board() {
        buildSquareBoard();
    }

    private void buildSquareBoard() {
        for (int i = 0; i < SQUARE_BOARD_SIZE; i++) {
            for (int j = 0; j < SQUARE_BOARD_SIZE; j++) {
                Tile tile = new Tile();
                tile.X = i;
                tile.Y = j;
                tile.Symbol = Player.NO_PLAYER.getSymbol();
                tiles.add(tile);
            }
        }
    }

    public Tile TileAt(int x, int y) {
        for (Tile t : tiles) {
            if (t.X == x && t.Y == y) {
                return t;
            }
        }
        return null;
    }

    public void AddTileAt(char symbol, int x, int y) {
        TileAt(x, y).Symbol = symbol;
    }
}