package problem2;

import java.util.Objects;

/**
 * Class mailItem stores information of a mail item
 */
public class mailItem {

  /**
   * Constructor for the class Brunch.
   *
   * @param someRecipient - Recipient, representing the recipient of the mail item
   * @param width     - Int, representing the width of the mail item, greater or equal to 1.5
   * @param depth - Int, representing the depth of the mail item, greater or equal to 1
   * @param height - Int, representing the height of the mail item, greater or equal to 2
   */
  private final Recipient someRecipient;
  private final int width;
  private final int depth;
  private final int height;

  public mailItem(Recipient someRecipient, int width, int depth, int height) {
    if (width < 1.5 || depth < 1 || height < 2) {
      throw new IllegalArgumentException("Invalid mail item dimensions.");
    }
    this.someRecipient = someRecipient;
    this.width = width;
    this.depth = depth;
    this.height = height;
  }

  /**
   * Getter for the recipient of the mail item
   *
   * @return - someRecipient, giving the recipient that will receive this mail item
   **/
  public Recipient getSomeRecipient() {
    return someRecipient;
  }

  /**
   * Getter for the width of the mail item
   *
   * @return - width, giving the width of the mail item
   **/
  public int getWidth() {
    return width;
  }

  /**
   * Getter for the depth of the mail item
   *
   * @return - depth, giving the depth of the mail item
   **/
  public int getDepth() {
    return depth;
  }

  /**
   * Getter for the height of the mail item
   *
   * @return - height, giving the height of the mail item
   **/
  public int getHeight() {
    return height;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    mailItem that = (mailItem) o;
    return width == that.width && depth == that.depth && height == that.height
        && someRecipient == that.someRecipient;
  }

  @Override
  public String toString() {
    return "MailItem{" +
        "someRecipient=" + someRecipient +
        ", width=" + width +
        ", depth=" + depth +
        ", height=" + height +
        '}';
  }

  @Override
  public int hashCode() {
    return Objects.hash(someRecipient, width, depth, height);
  }


}
