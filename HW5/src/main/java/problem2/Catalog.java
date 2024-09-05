package problem2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class representing a catalog of items.
 */
public class Catalog {
  private List<Item> items;

  /**
   * Constructs a new Catalog.
   */
  public Catalog() {
    this.items = new ArrayList<>();
  }

  /**
   * Constructs a new Catalog with the specified items.
   *
   * @param items The initial items in the catalog.
   */
  public Catalog(List<Item> items) {
    this.items = new ArrayList<>(items);
  }

  /**
   * Adds an item to the catalog.
   *
   * @param item The item to be added.
   */
  public void addItem(Item item) {
    items.add(item);
  }

  /**
   * Removes an item from the catalog.
   *
   * @param item The item to be removed.
   */
  public void removeItem(Item item) {
    items.remove(item);
  }

  /**
   * Searches the catalog for items with titles containing the specified keyword.
   *
   * @param keyword The keyword to search for.
   * @return A list of items with titles containing the keyword.
   */
  public List<Item> search(String keyword) {
    return items.stream()
        .filter(item -> item.getTitle().toLowerCase().contains(keyword.toLowerCase()))
        .collect(Collectors.toList());
  }

  /**
   * Searches the catalog for items with the specified author.
   *
   * @param author The author to search for.
   * @return A list of items with the specified author.
   */
  public List<Item> search(Author author) {
    return items.stream()
        .filter(item -> item instanceof Book && ((Book) item).getCreator().equals(author))
        .collect(Collectors.toList());
  }

  /**
   * Searches the catalog for items with the specified recording artist.
   *
   * @param artist The recording artist to search for.
   * @return A list of items with the specified recording artist.
   */
  public List<Item> search(RecordingArtist artist) {
    return items.stream()
        .filter(item -> item instanceof Music && (
            ((Music) item).getCreator().equals(artist) ||
                (((Music) item).getCreator() instanceof Band &&
                    ((Band) ((Music) item).getCreator()).getMembers().contains(artist))
        ))
        .collect(Collectors.toList());
  }
}
