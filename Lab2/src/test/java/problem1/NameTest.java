package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NameTest {

  private Name testName;

  @BeforeEach
  public void setup() {
    testName = new Name("Jane", "Mary", "Cooper");
  }

  @Test
  void getFirstName() {
    assertEquals("Jane", testName.getFirstName());
  }

  @Test
  void getMiddleName() {
    assertEquals("Mary", testName.getMiddleName());
  }

  @Test
  void getLastName() {
    assertEquals("Cooper", testName.getLastName());
  }

  @Test
  void testEquals_NullComparison() {
    assertFalse(testName.equals(null));
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(testName.equals(testName));
  }

  @Test
  void testEquals_DifferentDataTypes() {
    assertFalse(testName.equals("testName"));
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(testName.getFirstName(), testName.getMiddleName(),
        testName.getLastName());
    assertEquals(expectedHashCode, testName.hashCode());
  }

  @Test
  void testToString() {
    String expectedString =
        "Name{" + "firstName='" + testName.getFirstName() + '\'' + ", middleName='"
            + testName.getMiddleName() + '\'' + ", lastName='" + testName.getLastName() + '\''
            + '}';
    assertEquals(expectedString, testName.toString());
  }
}