package problem2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class CatalogTest {

  @Test
  public void testAddAndRemoveItem() {
    Catalog catalog = new Catalog();
    Author author = new Author("George", "Orwell");
    Book book = new Book("1984", 1949, author);

    catalog.addItem(book);
    assertEquals(1, catalog.search("1984").size());

    catalog.removeItem(book);
    assertEquals(0, catalog.search("1984").size());
  }

  @Test
  public void testSearchByKeyword() {
    Author author = new Author("George", "Orwell");
    RecordingArtist artist = new RecordingArtist("John", "Lennon");
    Band band = new Band("The Beatles", Arrays.asList(artist));

    Book book = new Book("1984", 1949, author);
    Music music1 = new Music("Imagine", 1971, artist);
    Music music2 = new Music("Let It Be", 1970, band);

    Catalog catalog = new Catalog(Arrays.asList(book, music1, music2));

    List<Item> results = catalog.search("imagine");
    assertEquals(1, results.size());
    assertTrue(results.contains(music1));
  }

  @Test
  public void testSearchByAuthor() {
    Author author1 = new Author("George", "Orwell");
    Author author2 = new Author("Aldous", "Huxley");
    Book book1 = new Book("1984", 1949, author1);
    Book book2 = new Book("Brave New World", 1932, author2);

    Catalog catalog = new Catalog(Arrays.asList(book1, book2));

    List<Item> results = catalog.search(author1);
    assertEquals(1, results.size());
    assertTrue(results.contains(book1));
  }

  @Test
  public void testSearchByRecordingArtist() {
    RecordingArtist artist1 = new RecordingArtist("John", "Lennon");
    RecordingArtist artist2 = new RecordingArtist("Paul", "McCartney");
    Band band = new Band("The Beatles", Arrays.asList(artist1, artist2));

    Music music1 = new Music("Imagine", 1971, artist1);
    Music music2 = new Music("Hey Jude", 1968, artist2);
    Music music3 = new Music("Let It Be", 1970, band);

    Catalog catalog = new Catalog(Arrays.asList(music1, music2, music3));

    List<Item> results = catalog.search(artist1);
    assertEquals(2, results.size());
    assertTrue(results.contains(music1));
    assertTrue(results.contains(music3));
  }
}
