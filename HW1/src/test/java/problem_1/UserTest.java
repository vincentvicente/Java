package problem_1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private User user;
    private Credentials credentials;

    @BeforeEach
    void setUp() {
        credentials = new Credentials("initUsername", "initPassword");
        user = new User("Nicolas", "Wang", "2294321456", "Nico@gmail.com", credentials);
    }

    @Test
    void getFirstName() {
        assertEquals("Nicolas", user.getFirstName());
    }

    @Test
    void getLastName() {
        assertEquals("Wang", user.getLastName());
    }

    @Test
    void getPhoneNumber() {
        assertEquals("2294321456", user.getPhoneNumber());
    }

    @Test
    void getEmail() {
        assertEquals("Nico@gmail.com", user.getEmail());
    }

    @Test
    void getCredentials() {
        assertEquals(credentials, user.getCredentials());
    }

    @Test
    void setFirstName() {
        user.setFirstName("Jennie");
        assertEquals("Jennie", user.getFirstName());
    }

    @Test
    void setLastName() {
        user.setLastName("Zhang");
        assertEquals("Zhang", user.getLastName());
    }

    @Test
    void setPhoneNumber() {
        user.setPhoneNumber("2453475679");
        assertEquals("2453475679", user.getPhoneNumber());
    }

    @Test
    void setEmail() {
        user.setEmail("JennieZ@gmail.com");
        assertEquals("JennieZ@gmail.com", user.getEmail());
    }

    @Test
    void setCredentials() {
        Credentials newCredentials = new Credentials("newUserName", "newPasswordHash");
        user.setCredentials(newCredentials);
        assertEquals(newCredentials, user.getCredentials());
    }
}