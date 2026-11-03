package entities;

public enum AccountType {
    SAVINGS("Poupança"),
    CHECKING("Corrente");

    private final String description;

    AccountType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

