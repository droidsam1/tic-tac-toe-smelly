import exceptions.InvalidFirstPlayerException;
import exceptions.InvalidNextPlayerException;
import exceptions.InvalidPosition;

public class Game {
    private final Board board;
    private Player lastPlayer;

    public Game() {
        board = new Board();
        lastPlayer = Player.NO_PLAYER;
    }

    public void Play(Player player, int x, int y) throws Exception {
        this.Play(player.getSymbol(), x, y);
        lastPlayer = player;
    }

    public void Play(char symbol, int x, int y) throws Exception {
        validateMove(symbol, x, y);

        // update game state
        board.AddTileAt(symbol, x, y);
    }

    private void validateMove(char symbol, int x, int y) throws Exception {
        validatePlayerXPlaysFirst(symbol);
        validatePlayersMoveIsNotRepeated(symbol);
        validatePlayerNotOverrideAlreadyPlayedTitle(x, y);
    }

    private void validatePlayerNotOverrideAlreadyPlayedTitle(int x, int y) throws InvalidPosition {
        if (board.TileAt(x, y).Symbol != Player.NO_PLAYER.getSymbol()) {
            throw new InvalidPosition();
        }
    }

    private void validatePlayersMoveIsNotRepeated(char symbol) throws InvalidNextPlayerException {
        if (symbol == lastPlayer.getSymbol()) {
            throw new InvalidNextPlayerException();
        }
    }

    private void validatePlayerXPlaysFirst(char symbol) throws InvalidFirstPlayerException {
        if (isFirstMove() && symbol != 'X') {
            throw new InvalidFirstPlayerException();
        }
    }

    private boolean isFirstMove() {
        return lastPlayer.getSymbol() == Player.NO_PLAYER.getSymbol();
    }

    private char Winner() {
        //if the positions in first row are taken
        if (board.TileAt(0, 0).Symbol != Player.NO_PLAYER.getSymbol() && board.TileAt(0, 1).Symbol != Player.NO_PLAYER.getSymbol()) {
            if (board.TileAt(0, 2).Symbol != Player.NO_PLAYER.getSymbol()) {
                //if first row is full with same symbol
                if (board.TileAt(0, 0).Symbol == board.TileAt(0, 1).Symbol && board.TileAt(0, 2).Symbol == board.TileAt(0, 1).Symbol) {
                    return board.TileAt(0, 0).Symbol;
                }
            }
        }

        //if the positions in first row are taken
        if (board.TileAt(1, 0).Symbol != Player.NO_PLAYER.getSymbol() && board.TileAt(1, 1).Symbol != Player.NO_PLAYER.getSymbol()) {
            if (board.TileAt(1, 2).Symbol != Player.NO_PLAYER.getSymbol()) {
                //if middle row is full with same symbol
                if (board.TileAt(1, 0).Symbol == board.TileAt(1, 1).Symbol && board.TileAt(1, 2).Symbol == board.TileAt(1, 1).Symbol) {
                    return board.TileAt(1, 0).Symbol;
                }
            }
        }

        //if the positions in first row are taken
        if (board.TileAt(2, 0).Symbol != Player.NO_PLAYER.getSymbol() && board.TileAt(2, 1).Symbol != Player.NO_PLAYER.getSymbol()) {
            if (board.TileAt(2, 2).Symbol != Player.NO_PLAYER.getSymbol()) {
                //if middle row is full with same symbol
                if (board.TileAt(2, 0).Symbol == board.TileAt(2, 1).Symbol && board.TileAt(2, 2).Symbol == board.TileAt(2, 1).Symbol) {
                    return board.TileAt(2, 0).Symbol;
                }
            }
        }

        return Player.NO_PLAYER.getSymbol();
    }

    public Player getWinner() {
        return Player.from(this.Winner());
    }
}

