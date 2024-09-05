package problem_3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    private Account account;
    private Identifier identifier;
    private Amount initialBalance;

    @BeforeEach
    void setUp() {
        identifier = new Identifier("Vincent", 2024, "China");
        initialBalance = new Amount(60, 50);
        account = new Account(identifier, initialBalance);
    }

    @Test
    void getIdentifier() {
        assertEquals(identifier, account.getIdentifier());
    }

    @Test
    void getBalance() {
        assertEquals(initialBalance, account.getBalance());
    }

    @Test
    void deposit() {
        Amount depositAmount = new Amount(40, 40);
        Account newAccount = account.deposit(depositAmount);
        Amount depositedBalance = new Amount(100, 90);
        assertEquals(depositedBalance.getDollars(), newAccount.getBalance().getDollars());
        assertEquals(depositedBalance.getCents(), newAccount.getBalance().getCents());
    }

    @Test
    void withdraw() {
        Amount withdrawAmount = new Amount(45, 20);
        Account newAccount = account.withdraw(withdrawAmount);
        Amount expectedBalance = new Amount(15, 30);
        assertEquals(expectedBalance.getDollars(), newAccount.getBalance().getDollars());
        assertEquals(expectedBalance.getCents(), newAccount.getBalance().getCents());
    }

    @Test
    void convert() {
        double expectedBTC = (60 + 50 / 100.0) * 0.000025;
        assertEquals(expectedBTC, account.convert());
    }

}