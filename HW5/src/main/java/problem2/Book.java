package problem2;

/**
 * Class representing a book.
 */
public class Book extends Item {
  /**
   * Constructs a Book with the specified title, year, and author.
   *
   * @param title The title of the book.
   * @param year The year the book was published.
   * @param author The author of the book.
   */
  public Book(String title, int year, Author author) {
    super(title, year, author);
  }
}
