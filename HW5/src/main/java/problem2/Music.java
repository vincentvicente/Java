package problem2;

/**
 * Class representing music.
 */
public class Music extends Item {
  /**
   * Constructs a Music item with the specified title, year, and creator.
   *
   * @param title The title of the music item.
   * @param year The year the music item was released.
   * @param creator The creator of the music item.
   */
  public Music(String title, int year, Creator creator) {
    super(title, year, creator);
  }
}
