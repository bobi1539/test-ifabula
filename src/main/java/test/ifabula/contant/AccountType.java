package test.ifabula.contant;

public enum AccountType {

    ADMIN("admin"),
    CUSTOMER("customer");

    public final String value;

    AccountType(String value) {
        this.value = value;
    }
}
