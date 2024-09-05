package problem_3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdentifierTest {
    private Identifier identifier;
    @BeforeEach
    void setUp() {
        this.identifier = new Identifier("initUsername", 2000,"USA");
    }

    @Test
    void getYear() {
        assertEquals(2000, identifier.getYear());
    }

    @Test
    void getCountry() {
        assertEquals("USA", identifier.getCountry());
    }

    @Test
    void getUsername() {
        assertEquals("initUsername", identifier.getUsername());
    }
}