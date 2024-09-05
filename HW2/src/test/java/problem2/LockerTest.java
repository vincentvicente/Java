package problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LockerTest {

  private Locker locker;
  private mailItem mailItem;
  private Recipient recipient;

  @BeforeEach
  void setUp() {
    locker = new Locker(15, 25, 10);
    recipient = new Recipient("Tom", "Holland", "Tom.H@outlook.com");
    mailItem = new mailItem(recipient, 2, 2, 3);
  }

  @Test
  void testAddMail() {
    locker.addMail(mailItem);
    assertEquals(mailItem, locker.getSomeItem());
  }

  @Test
  void testAddMail_LockerOccupied() {
    locker.addMail(mailItem);
    mailItem anotherMailItem = new mailItem(recipient, 2, 2, 3);
    assertThrows(IllegalArgumentException.class, () -> {
      locker.addMail(anotherMailItem);
    });
  }

  @Test
  void testAddMail_MailExceedsDimensions() {
    mailItem largeMailItem = new mailItem(recipient, 16, 2, 3);
    assertThrows(IllegalArgumentException.class, () -> {
      locker.addMail(largeMailItem);
    });
  }

  @Test
  void testPickupMail_CorrectRecipient() {
    locker.addMail(mailItem);
    mailItem pickedUpMail = locker.pickupMail(recipient);
    assertEquals(mailItem, pickedUpMail);
    assertNull(locker.getSomeItem());
  }

  @Test
  void testPickupMail_WrongRecipient() {
    locker.addMail(mailItem);
    Recipient wrongRecipient = new Recipient("Jane", "Doe", "jane.doe@example.com");
    mailItem pickedUpMail = locker.pickupMail(wrongRecipient);
    assertNull(pickedUpMail);
    assertEquals(mailItem, locker.getSomeItem());
  }

  @Test
  void testPickupMail_EmptyLocker() {
    mailItem pickedUpMail = locker.pickupMail(recipient);
    assertNull(pickedUpMail);
  }

  @Test
  void testToString() {
    String expectedString = "Locker{" +
        "maxWidth=" + locker.getMaxWidth() +
        ", maxHeight=" + locker.getMaxHeight() +
        ", maxDepth=" + locker.getMaxDepth() +
        ", mailItem=" + locker.getSomeItem() +
        '}';
    assertEquals(expectedString, locker.toString());
  }

  @Test
  void testEquals_sameObject() {
    assertTrue(locker.equals(locker));
  }

  @Test
  void testEquals_NullComparison() {
    assertFalse(locker.equals(null));
  }

  @Test
  void testEquals_DifferentObject() {
    assertFalse(locker.equals("Some String"));
  }

  @Test
  void testEquals_DifferentObjectsSameFields() {
    Locker anotherLocker = new Locker(15, 25, 10);
    assertTrue(locker.equals(anotherLocker));
  }

  @Test
  void testEquals_DifferentObjectsDifferentWidth() {
    Locker anotherLocker = new Locker(14, 25, 10);
    assertFalse(locker.equals(anotherLocker));
  }

  @Test
  void testEquals_DifferentObjectsDifferentHeight() {
    Locker anotherLocker = new Locker(15, 24, 10);
    assertFalse(locker.equals(anotherLocker));
  }

  @Test
  void testEquals_DifferentObjectsDifferentDepth() {
    Locker anotherLocker = new Locker(15, 25, 9);
    assertFalse(locker.equals(anotherLocker));
  }

  @Test
  void testHashCode() {
    Locker anotherLocker = new Locker(15, 25, 10);
    assertEquals(locker.hashCode(), anotherLocker.hashCode());
  }
}
