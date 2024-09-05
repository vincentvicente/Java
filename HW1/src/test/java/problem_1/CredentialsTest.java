package problem_1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CredentialsTest {
    private Credentials credentials;

    @BeforeEach
    void setUp() {
        credentials = new Credentials("InitialUsername", "InitialPassword");
    }

    @Test
    void getUsername() {
        assertEquals("InitialUsername", credentials.getUsername());
    }

    @Test
    void setUsername() {
        credentials.setUsername("NewUsername");
        assertEquals("NewUsername", credentials.getUsername());
    }

    @Test
    void getPasswordHash() {
        assertEquals("InitialPassword", credentials.getPasswordHash());
    }

    @Test
    void setPasswordHash() {
        credentials.setPasswordHash("NewPasswordHash");
        assertEquals("NewPasswordHash", credentials.getPasswordHash());
    }
}