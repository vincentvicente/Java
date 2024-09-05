package problem_3;

public class Account {
    private final Identifier identifier;
    private final Amount balance;

    public Account(Identifier identifier, Amount balance) {
        this.identifier = identifier;
        this.balance = balance;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public Amount getBalance() {
        return balance;
    }

    public Account deposit(Amount amount) {
        Amount newBalance = balance.plus(amount);
        return new Account(this.identifier, newBalance);
    }
    // assume the withdrawal amount will not be less than the account balance
    public Account withdraw(Amount amount) {
        Amount newBalance = balance.minus(amount);
        return new Account(this.identifier, newBalance);
    }

    public Double convert() {
        double totalAmountInUSD = this.balance.getDollars() + this.balance.getCents() / 100.0;
        return totalAmountInUSD * 0.000025;
    }
}
