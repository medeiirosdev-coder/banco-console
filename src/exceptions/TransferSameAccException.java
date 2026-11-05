package exceptions;

public class TransferSameAccException extends RuntimeException {
    public TransferSameAccException(String message) {
        super(message);
    }
}
