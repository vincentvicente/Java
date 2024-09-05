package problem_2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeTest {
    private Time time;
    @BeforeEach
    void setUp() {
        this.time = new Time(1, 20, 30);
    }

    @Test
    void helper() {
        // Time(1, 20, 30) should be 4830 seconds
        assertEquals(4830, time.helper());
    }

    @Test
    void getHour() {
        assertEquals(1, time.getHour());
    }

    @Test
    void setHour() {
        time.setHour(2);
        assertEquals(2, time.getHour());
    }

    @Test
    void getMinute() {
        assertEquals(20 , time.getMinute());
    }

    @Test
    void setMinute() {
        time.setMinute(18);
        assertEquals(18 , time.getMinute());
    }

    @Test
    void getSecond() {
        assertEquals(30 , time.getSecond());
    }

    @Test
    void setSecond() {
        time.setSecond(28);
        assertEquals(28 , time.getSecond());
    }
    @Test
    void testInvalidHour() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Time(-1, 20, 30);
        });
    }

    @Test
    void testInvalidMinute() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Time(1, -1, 30);
        });
    }
    @Test
    void testInvalidSecond() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Time(1, 20, 61);
        });
    }
}