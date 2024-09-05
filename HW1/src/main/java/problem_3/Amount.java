package problem_3;

public class Amount {
    private final int dollars;
    private final int cents;

    public Amount(int dollars, int cents) {
        if (dollars < 0) {
            throw new IllegalArgumentException("Dollars must be greater than or equal to 0");
        }
        if (cents < 0 || cents > 100) {
            throw new IllegalArgumentException("Cents must be between 0 and 99 inclusive");
        }
        this.dollars = dollars;
        this.cents = cents;
    }

    public int getDollars() {
        return dollars;
    }

    public int getCents() {
        return cents;
    }


    public Amount plus(Amount other) {
        int totalCents = cents + other.cents;
        int totalDollars = dollars + other.dollars + totalCents / 100;
        totalCents %= 100;
        return new Amount(totalDollars, totalCents);
    }

    // assume the withdrawal amount will not be less than the account balance.
    public Amount minus(Amount other) {
        int totalCents = cents - other.cents;
        int totalDollars = dollars - other.dollars;
        if (totalDollars < 0) {
            totalCents += 100;
            totalDollars -= 1;
        }
        return new Amount(totalDollars, totalCents);
    }
}
