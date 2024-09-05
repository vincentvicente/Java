package problem2;

import java.util.Objects;

/**
 * Abstract class representing an item in the catalog.
 */
public abstract class Item {
  protected String title;
  protected int year;
  protected Creator creator;

  /**
   * Constructs a new Item.
   *
   * @param title The title of the item.
   * @param year The year the item was released or published.
   * @param creator The creator of the item.
   */
  public Item(String title, int year, Creator creator) {
    this.title = title;
    this.year = year;
    this.creator = creator;
  }

  /**
   * Gets the title of the item.
   *
   * @return The title of the item.
   */
  public String getTitle() {
    return title;
  }

  /**
   * Gets the year the item was released or published.
   *
   * @return The year the item was released or published.
   */
  public int getYear() {
    return year;
  }

  /**
   * Gets the creator of the item.
   *
   * @return The creator of the item.
   */
  public Creator getCreator() {
    return creator;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Item item = (Item) o;
    return year == item.year &&
        Objects.equals(title, item.title) &&
        Objects.equals(creator, item.creator);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, year, creator);
  }
}
