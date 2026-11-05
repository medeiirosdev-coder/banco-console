package entities;

public enum TransactionType {

    DEPOSIT ("Depósito"),
    WITHDRAW("Saque"),
    TRANSFER_IN("Transferência enviada"),
    TRANSFER_OUT("Transferência recebida"),
    REFUND("Estorno");

    private final String description;

    TransactionType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
