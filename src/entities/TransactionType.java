package entities;

public enum TransactionType {

    DEPOSIT ("Depósito"),
    WITHDRAW("Saque");

    private final String description;

    TransactionType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
