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
        validateMove(player, x, y);
        updateGameState(player, x, y);
    }

    private void updateGameState(Player player, int x, int y) {
        board.AddTileAt(player.getSymbol(), x, y);
        lastPlayer = player;
    }

    private void validateMove(Player player, int x, int y) throws Exception {
        validatePlayerXPlaysFirst(player);
        validatePlayersMoveIsNotRepeated(player);
        validatePlayerNotOverrideAlreadyPlayedTitle(x, y);
    }

    private void validatePlayerNotOverrideAlreadyPlayedTitle(int x, int y) throws InvalidPosition {
        if (board.TileAt(x, y).Symbol != Player.NO_PLAYER.getSymbol()) {
            throw new InvalidPosition();
        }
    }

    private void validatePlayersMoveIsNotRepeated(Player player) throws InvalidNextPlayerException {
        if (lastPlayer.equals(player)) {
            throw new InvalidNextPlayerException();
        }
    }

    private void validatePlayerXPlaysFirst(Player player) throws InvalidFirstPlayerException {
        if (isFirstMove() && !Player.PLAYER_X.equals(player)) {
            throw new InvalidFirstPlayerException();
        }
    }

    private boolean isFirstMove() {
        return Player.NO_PLAYER.equals(lastPlayer);
    }

    private char Winner() {
        //if the positions in first row are taken
        if (board.TileAt(0, 0).Symbol != Player.NO_PLAYER.getSymbol() && board.TileAt(0, 1).Symbol != Player.NO_PLAYER.getSymbol() && board.TileAt(0, 2).Symbol != Player.NO_PLAYER.getSymbol()) {
            //if first row is full with same symbol
            if (board.TileAt(0, 0).Symbol == board.TileAt(0, 1).Symbol && board.TileAt(0, 2).Symbol == board.TileAt(0, 1).Symbol) {
                return board.TileAt(0, 0).Symbol;
            }
        }

        //if the positions in first row are taken
        if (board.TileAt(1, 0).Symbol != Player.NO_PLAYER.getSymbol() && board.TileAt(1, 1).Symbol != Player.NO_PLAYER.getSymbol() && board.TileAt(1, 2).Symbol != Player.NO_PLAYER.getSymbol()) {
            //if middle row is full with same symbol
            if (board.TileAt(1, 0).Symbol == board.TileAt(1, 1).Symbol && board.TileAt(1, 2).Symbol == board.TileAt(1, 1).Symbol) {
                return board.TileAt(1, 0).Symbol;
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

