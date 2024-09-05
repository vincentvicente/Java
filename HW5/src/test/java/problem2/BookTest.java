package problem2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

  @Test
  public void testBookCreation() {
    Author author = new Author("George", "Orwell");
    Book book = new Book("1984", 1949, author);

    assertEquals("1984", book.getTitle());
    assertEquals(1949, book.getYear());
    assertEquals(author, book.getCreator());
  }

  @Test
  public void testBookEqualsAndHashCode() {
    Author author = new Author("George", "Orwell");
    Book book1 = new Book("1984", 1949, author);
    Book book2 = new Book("1984", 1949, author);
    Book book3 = new Book("Animal Farm", 1945, author);

    assertEquals(book1, book2);
    assertNotEquals(book1, book3);

    assertEquals(book1.hashCode(), book2.hashCode());
    assertNotEquals(book1.hashCode(), book3.hashCode());
  }
}
