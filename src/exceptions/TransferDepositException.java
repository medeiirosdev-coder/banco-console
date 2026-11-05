package exceptions;

public class TransferDepositException extends RuntimeException {
    public TransferDepositException(String message) {
        super(message);
    }
}
