import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthorTest {
    private Author author;

    @BeforeEach
    void setUp() {
        author = new Author("Jose", "Jose@gmail.com", "205 102ND AVE");
    }

    @Test
    void getName() {
        assertEquals("Jose", author.getName());
    }

    @Test
    void getEmail() {
        assertEquals("Jose@gmail.com", author.getEmail());
    }

    @Test
    void getAddress() {
        assertEquals("205 102ND AVE", author.getAddress());
    }


    @Test
    void setName() {
        author.setName("Johnny");
        assertEquals("Johnny", author.getName());
    }

    @Test
    void setEmail() {
        author.setEmail("johnny@gmail.com");
        assertEquals("johnny@gmail.com", author.getEmail());
    }

    @Test
    void setAddress() {
        author.setAddress("105 1ST AVE");
        assertEquals("105 1ST AVE", author.getAddress());
    }
}