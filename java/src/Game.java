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
        board.setPlayerAt(player, x, y);
        lastPlayer = player;
    }

    private void validateMove(Player player, int x, int y) throws Exception {
        validatePlayerXPlaysFirst(player);
        validatePlayersMoveIsNotRepeated(player);
        validatePlayerNotOverrideAlreadyPlayedTitle(x, y);
    }

    private void validatePlayerNotOverrideAlreadyPlayedTitle(int x, int y) throws InvalidPosition {
        if (board.getPlayerAt(x, y) != Player.NO_PLAYER.getSymbol()) {
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
        for (int row = 0; row < board.getNumberOfRows(); row++) {
            if (isRowFull(row) && isRowFullWithWithSameSymbol(row)) {
                return Player.from(board.getTileAt(row, 0).getSymbol());
            }
        }
        return Player.NO_PLAYER;
    }

    private boolean isRowFullWithWithSameSymbol(int rowNumber) {
        return board.getTileAt(rowNumber, 0).getSymbol() == board.getTileAt(rowNumber, 1).getSymbol() && board.getTileAt(rowNumber, 2).getSymbol() == board.getTileAt(rowNumber, 1).getSymbol();
    }

    private boolean isRowFull(int rowNumber) {
        return board.getTileAt(rowNumber, 0).getSymbol() != Player.NO_PLAYER.getSymbol() && board.getTileAt(rowNumber, 1).getSymbol() != Player.NO_PLAYER.getSymbol() && board.getTileAt(rowNumber, 2).getSymbol() != Player.NO_PLAYER.getSymbol();
    }
}

