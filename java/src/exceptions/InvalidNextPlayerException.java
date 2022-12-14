package exceptions;

public class InvalidNextPlayerException extends Exception {
    public InvalidNextPlayerException() {
        super("Invalid next player");
    }
}
