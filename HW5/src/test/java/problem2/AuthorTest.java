package problem2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AuthorTest {

  @Test
  public void testAuthorCreation() {
    Author author = new Author("George", "Orwell");
    assertEquals("George", author.getFirstName());
    assertEquals("Orwell", author.getLastName());
  }

  @Test
  public void testAuthorEqualsAndHashCode() {
    Author author1 = new Author("George", "Orwell");
    Author author2 = new Author("George", "Orwell");
    Author author3 = new Author("Aldous", "Huxley");

    assertEquals(author1, author2);
    assertNotEquals(author1, author3);

    assertEquals(author1.hashCode(), author2.hashCode());
    assertNotEquals(author1.hashCode(), author3.hashCode());
  }
}
