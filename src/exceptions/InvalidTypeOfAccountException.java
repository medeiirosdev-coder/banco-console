package exceptions;

public class InvalidTypeOfAccountException extends RuntimeException {
    public InvalidTypeOfAccountException(String message) {
        super(message);
    }
}
