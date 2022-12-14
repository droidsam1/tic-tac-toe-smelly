public class Game {
    public static final char NO_PLAYER_SYMBOL = ' ';
    private final Board board = new Board();
    private char lastPlayedSymbol = NO_PLAYER_SYMBOL;

    public void Play(char symbol, int x, int y) throws Exception {
        //if first move
        if (lastPlayedSymbol == NO_PLAYER_SYMBOL) {
            //if player is X
            if (symbol == 'O') {
                throw new Exception("Invalid first player");
            }
        }
        //if not first move but player repeated
        else if (symbol == lastPlayedSymbol) {
            throw new Exception("Invalid next player");
        }
        //if not first move but play on an already played tile
        else if (board.TileAt(x, y).Symbol != NO_PLAYER_SYMBOL) {
            throw new Exception("Invalid position");
        }

        // update game state
        lastPlayedSymbol = symbol;
        board.AddTileAt(symbol, x, y);
    }

    public char Winner() {
        //if the positions in first row are taken
        if (board.TileAt(0, 0).Symbol != NO_PLAYER_SYMBOL && board.TileAt(0, 1).Symbol != NO_PLAYER_SYMBOL && board.TileAt(0, 2).Symbol != NO_PLAYER_SYMBOL) {
            //if first row is full with same symbol
            if (board.TileAt(0, 0).Symbol == board.TileAt(0, 1).Symbol && board.TileAt(0, 2).Symbol == board.TileAt(0, 1).Symbol) {
                return board.TileAt(0, 0).Symbol;
            }
        }

        //if the positions in first row are taken
        if (board.TileAt(1, 0).Symbol != NO_PLAYER_SYMBOL && board.TileAt(1, 1).Symbol != NO_PLAYER_SYMBOL && board.TileAt(1, 2).Symbol != NO_PLAYER_SYMBOL) {
            //if middle row is full with same symbol
            if (board.TileAt(1, 0).Symbol == board.TileAt(1, 1).Symbol && board.TileAt(1, 2).Symbol == board.TileAt(1, 1).Symbol) {
                return board.TileAt(1, 0).Symbol;
            }
        }

        //if the positions in first row are taken
        if (board.TileAt(2, 0).Symbol != NO_PLAYER_SYMBOL && board.TileAt(2, 1).Symbol != NO_PLAYER_SYMBOL && board.TileAt(2, 2).Symbol != NO_PLAYER_SYMBOL) {
            //if middle row is full with same symbol
            if (board.TileAt(2, 0).Symbol == board.TileAt(2, 1).Symbol && board.TileAt(2, 2).Symbol == board.TileAt(2, 1).Symbol) {
                return board.TileAt(2, 0).Symbol;
            }
        }

        return NO_PLAYER_SYMBOL;
    }
}

