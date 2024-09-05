package problem2;

import java.security.PublicKey;
import java.util.Objects;
import javax.sound.midi.Receiver;

/**
 * Class Locker stores information of the locker
 */
public class Locker {

  private final int maxWidth;
  private final int maxHeight;
  private final int maxDepth;
  private mailItem someItem;

  /**
   * Constructor for the class Locker.
   *
   * @param maxWidth  -  Int, representing the maximum width less than or equal to 15 in inches
   * @param maxHeight - Int, representing the maximum height less than or equal to 25 in inches
   * @param maxDepth  - Int, representing the maximum depth less than or equal to 10 in inches
   * @param someItem  - mailItem, representing the item that stores in this locker
   */

  public Locker(int maxWidth, int maxHeight, int maxDepth) {
    if (maxWidth > 15 || maxHeight > 25 || maxDepth > 10) {
      throw new IllegalArgumentException("Invalid locker dimensions.");
    }
    this.maxWidth = maxWidth;
    this.maxHeight = maxHeight;
    this.maxDepth = maxDepth;
    this.someItem = null;
  }

  public void addMail(mailItem someItem) throws IllegalArgumentException {
    if (this.someItem != null) {
      throw new IllegalArgumentException("This locker has already been occupied.");
    }
    if (someItem == null) {
      throw new IllegalArgumentException("Item cannot be empty.");
    }

    if (someItem.getWidth() > maxWidth || someItem.getHeight() > maxHeight
        || someItem.getDepth() > maxDepth) {
      throw new IllegalArgumentException("Mail item exceeds locker's dimensions.");
    }
    this.someItem = someItem;
  }

  public mailItem pickupMail(Recipient recipient) throws IllegalArgumentException {
    if (this.someItem != null && this.someItem.getSomeRecipient().equals(recipient)) {
      mailItem tmp = this.someItem;
      this.someItem = null;
      return tmp;
    }
    return null;
  }

  /**
   * Getter for the maximum width of the locker
   *
   * @return - maxWidth, giving the maximum width of the locker
   **/
  public int getMaxWidth() {
    return maxWidth;
  }

  /**
   * Getter for the maximum height of the locker
   *
   * @return - maxHeight, giving the maximum height of the locker
   **/
  public int getMaxHeight() {
    return maxHeight;
  }

  /**
   * Getter for the maximum depth of the locker
   *
   * @return - maxDepth, giving the maximum depth of the locker
   **/
  public int getMaxDepth() {
    return maxDepth;
  }

  /**
   * Getter for item stored in this locker
   *
   * @return - someItem, giving the item stored in this locker
   **/
  public mailItem getSomeItem() {
    return someItem;
  }

  @Override
  public String toString() {
    return "Locker{" + "maxWidth=" + maxWidth + ", maxHeight=" + maxHeight + ", maxDepth="
        + maxDepth + ", mailItem=" + someItem + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Locker locker = (Locker) o;
    return maxWidth == locker.maxWidth &&
        maxHeight == locker.maxHeight &&
        maxDepth == locker.maxDepth &&
        Objects.equals(someItem, locker.someItem);
  }

  @Override
  public int hashCode() {
    return Objects.hash(maxWidth, maxHeight, maxDepth, someItem);
  }

}

