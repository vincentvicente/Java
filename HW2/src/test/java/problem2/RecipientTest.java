package problem2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RecipientTest {

  private Recipient recipient;

  @BeforeEach
  void setUp() {
    recipient = new Recipient("Alex", "Morphy", "AlexM@outlook.com");
  }

  @Test
  void getFirstName() {
    assertEquals("Alex", recipient.getFirstName());
  }

  @Test
  void getLastName() {
    assertEquals("Morphy", recipient.getLastName());
  }

  @Test
  void getEmailAddress() {
    assertEquals("AlexM@outlook.com", recipient.getEmailAddress());
  }


  @Test
  void testToString() {
    String expectedString = "Recipient{" +
        "first name =" + recipient.getFirstName() +
        ", last name ='" + recipient.getLastName() + '\'' +
        ", email address =" + recipient.getEmailAddress() +
        '}';
    assertEquals(expectedString, recipient.toString());
  }

  @Test
  void testEquals_sameObject() {
    assertTrue(recipient.equals(recipient));
  }

  @Test
  void testEquals_NullComparison() {

    assertFalse(recipient == null);
  }

  @Test
  void testEquals_DifferentObject() {
    assertFalse(recipient.equals("Some String"));
  }

  @Test
  void testEquals_DifferentObjectsSameFields() {
    Recipient anotherRecipient = new Recipient("Alex", "Morphy", "AlexM@outlook.com");
    assertTrue(recipient.equals(anotherRecipient));
  }

  @Test
  void testEquals_DifferentObjectsDifferentFirstName() {
    Recipient anotherRecipient = new Recipient("Michael", "Morphy", "AlexM@outlook.com");
    assertFalse(recipient.equals(anotherRecipient));
  }

  @Test
  void testEquals_DifferentObjectsDifferentLastName() {
    Recipient anotherRecipient = new Recipient("Alex", "Smith", "AlexM@outlook.com");
    assertFalse(recipient.equals(anotherRecipient));
  }

  @Test
  void testEquals_DifferentObjectsDifferentEmailAddress() {
    Recipient anotherRecipient = new Recipient("Alex", "Morphy", "AlexM@gmail.com");
    assertFalse(recipient.equals(anotherRecipient));
  }

  @Test
  void testHashCode() {
    Recipient anotherRecipient = new Recipient("Alex", "Morphy", "AlexM@outlook.com");
    assertEquals(recipient.hashCode(), anotherRecipient.hashCode());
  }

}




