package entities;

public enum TransactionType {

    DEPOSIT ("Depósito"),
    WITHDRAW("Saque"),
    TRANSFER_IN("Transferência recebida"),
    TRANSFER_OUT("Transferência enviada"),
    REFUND("Estorno");

    private final String description;

    TransactionType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
