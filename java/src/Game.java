import exceptions.InvalidFirstPlayerException;
import exceptions.InvalidNextPlayerException;
import exceptions.InvalidPosition;

public class Game {
    private final Board board = new Board();
    private char lastPlayedSymbol = Player.getNoPlayer();

    public void Play(char symbol, int x, int y) throws Exception {
        validateMove(symbol, x, y);

        // update game state
        lastPlayedSymbol = symbol;
        board.AddTileAt(symbol, x, y);
    }

    private void validateMove(char symbol, int x, int y) throws Exception {
        validatePlayerXPlaysFirst(symbol);
        validatePlayersMoveIsNotRepeated(symbol);
        validatePlayerNotOverrideAlreadyPlayedTitle(x, y);
    }

    private void validatePlayerNotOverrideAlreadyPlayedTitle(int x, int y) throws InvalidPosition {
        if (board.TileAt(x, y).Symbol != Player.getNoPlayer()) {
            throw new InvalidPosition();
        }
    }

    private void validatePlayersMoveIsNotRepeated(char symbol) throws InvalidNextPlayerException {
        if (symbol == lastPlayedSymbol) {
            throw new InvalidNextPlayerException();
        }
    }

    private void validatePlayerXPlaysFirst(char symbol) throws InvalidFirstPlayerException {
        if (isFirstMove() && symbol != 'X') {
            throw new InvalidFirstPlayerException();
        }
    }

    private boolean isFirstMove() {
        return lastPlayedSymbol == Player.getNoPlayer();
    }

    public char Winner() {
        //if the positions in first row are taken
        if (board.TileAt(0, 0).Symbol != Player.getNoPlayer() && board.TileAt(0, 1).Symbol != Player.getNoPlayer() && board.TileAt(0, 2).Symbol != Player.getNoPlayer()) {
            //if first row is full with same symbol
            if (board.TileAt(0, 0).Symbol == board.TileAt(0, 1).Symbol && board.TileAt(0, 2).Symbol == board.TileAt(0, 1).Symbol) {
                return board.TileAt(0, 0).Symbol;
            }
        }

        //if the positions in first row are taken
        if (board.TileAt(1, 0).Symbol != Player.getNoPlayer() && board.TileAt(1, 1).Symbol != Player.getNoPlayer() && board.TileAt(1, 2).Symbol != Player.getNoPlayer()) {
            //if middle row is full with same symbol
            if (board.TileAt(1, 0).Symbol == board.TileAt(1, 1).Symbol && board.TileAt(1, 2).Symbol == board.TileAt(1, 1).Symbol) {
                return board.TileAt(1, 0).Symbol;
            }
        }

        //if the positions in first row are taken
        if (board.TileAt(2, 0).Symbol != Player.getNoPlayer() && board.TileAt(2, 1).Symbol != Player.getNoPlayer() && board.TileAt(2, 2).Symbol != Player.getNoPlayer()) {
            //if middle row is full with same symbol
            if (board.TileAt(2, 0).Symbol == board.TileAt(2, 1).Symbol && board.TileAt(2, 2).Symbol == board.TileAt(2, 1).Symbol) {
                return board.TileAt(2, 0).Symbol;
            }
        }

        return Player.getNoPlayer();
    }
}

