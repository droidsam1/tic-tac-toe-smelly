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
            if (board.isRowFullWithSamePlayer(row)) {
                return Player.from(board.getPlayerAt(row, 0));
            }
        }
        return Player.NO_PLAYER;
    }

}

