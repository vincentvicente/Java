package problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class mailItemTest {

  private mailItem mailItem;
  private Recipient recipient;

  @BeforeEach
  void setUp() {
    recipient = new Recipient("Tom", "Holland", "Tom.H@outlook.com");
    mailItem = new mailItem(recipient, 2, 2, 3);
  }

  @Test
  void getRecipient() {
    assertEquals(recipient, mailItem.getSomeRecipient());
  }

  @Test
  void getWidth() {
    assertEquals(2, mailItem.getWidth());
  }

  @Test
  void getDepth() {
    assertEquals(2, mailItem.getDepth());
  }

  @Test
  void getHeight() {
    assertEquals(3, mailItem.getHeight());
  }

  @Test
  void testToString() {
    String expectedString = "MailItem{" +
        "someRecipient=" + recipient +
        ", width=" + mailItem.getWidth() +
        ", depth=" + mailItem.getDepth() +
        ", height=" + mailItem.getHeight() +
        '}';
    assertEquals(expectedString, mailItem.toString());
  }

  @Test
  void testEquals_sameObject() {
    assertTrue(mailItem.equals(mailItem));
  }

  @Test
  void testEquals_NullComparison() {
    assertFalse(mailItem.equals(null));
  }

  @Test
  void testEquals_DifferentObject() {
    assertFalse(mailItem.equals("Some String"));
  }

  @Test
  void testEquals_DifferentObjectsSameFields() {
    mailItem anotherMailItem = new mailItem(recipient, 2, 2, 3);
    assertTrue(mailItem.equals(anotherMailItem));
  }

  @Test
  void testEquals_DifferentObjectsDifferentRecipient() {
    Recipient differentRecipient = new Recipient("Tom", "Lee", "Tom.L@outlook.com");
    mailItem anotherMailItem = new mailItem(differentRecipient, 2, 2, 3);
    assertFalse(mailItem.equals(anotherMailItem));
  }

  @Test
  void testEquals_DifferentObjectsDifferentWidth() {
    mailItem anotherMailItem = new mailItem(recipient, 3, 2, 3);
    assertFalse(mailItem.equals(anotherMailItem));
  }

  @Test
  void testEquals_DifferentObjectsDifferentDepth() {
    mailItem anotherMailItem = new mailItem(recipient, 2, 3, 3);
    assertFalse(mailItem.equals(anotherMailItem));
  }

  @Test
  void testEquals_DifferentObjectsDifferentHeight() {
    mailItem anotherMailItem = new mailItem(recipient, 2, 2, 4);
    assertFalse(mailItem.equals(anotherMailItem));
  }

  @Test
  void testHashCode2() {
    mailItem anotherMailItem = new mailItem(recipient, 2, 2, 3);
    assertEquals(mailItem.hashCode(), anotherMailItem.hashCode());
  }

  @Test
  void testInvalidDimensions() {
    assertThrows(IllegalArgumentException.class, () -> {
      new mailItem(recipient, 1, 2, 3);
    });

    assertThrows(IllegalArgumentException.class, () -> {
      new mailItem(recipient, 2, 0, 3);
    });

    assertThrows(IllegalArgumentException.class, () -> {
      new mailItem(recipient, 2, 2, 1);
    });
  }

  @Test
  void testHashCode() {
    mailItem anotherItem = new mailItem(recipient, 2, 2, 3);
    assertEquals(mailItem.hashCode(), anotherItem.hashCode());
  }

}
