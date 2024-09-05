package problem_3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AmountTest {
    private Amount amount;

    @BeforeEach
    void setUp() {
        this.amount = new Amount(100, 50);
    }

    @Test
    void getDollars() {
        assertEquals(100, amount.getDollars());
    }

    @Test
    void getCents() {
        assertEquals(50, amount.getCents());
    }

    @Test
    void plus() {
        Amount other = new Amount(50, 50);
        Amount res = amount.plus(other);
        assertEquals(151, res.getDollars());
        assertEquals(0, res.getCents());
    }

    @Test
    void minus() {
        Amount other = new Amount(50, 25);
        Amount res = amount.minus(other);
        assertEquals(50, res.getDollars());
        assertEquals(25, res.getCents());
    }

    @Test
    void invalidDollars() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Amount(-1, 50);
        });
    }

    @Test
    void invalidCents() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Amount(100, -50);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Amount(100, 101);
        });
    }
}