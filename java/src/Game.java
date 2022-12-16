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

    public Player getWinner() {
        int numberOfRows = 3;
        for (int row = 0; row < numberOfRows; row++) {
            if (isRowFull(row) && isRowFullWithWithSameSymbol(row)) {
                return Player.from(board.TileAt(row, 0).Symbol);
            }
        }
        return Player.NO_PLAYER;
    }

    private boolean isRowFullWithWithSameSymbol(int rowNumber) {
        return board.TileAt(rowNumber, 0).Symbol == board.TileAt(rowNumber, 1).Symbol && board.TileAt(rowNumber, 2).Symbol == board.TileAt(rowNumber, 1).Symbol;
    }

    private boolean isRowFull(int rowNumber) {
        return board.TileAt(rowNumber, 0).Symbol != Player.NO_PLAYER.getSymbol() && board.TileAt(rowNumber, 1).Symbol != Player.NO_PLAYER.getSymbol() && board.TileAt(rowNumber, 2).Symbol != Player.NO_PLAYER.getSymbol();
    }
}

