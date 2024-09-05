package employee_productivity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NameTest {

  private Name name;

  @BeforeEach
  void setUp() {
    name = new Name("Alice", "Brown");
  }

  @Test
  void getFirstName() {
    assertEquals("Alice", name.getFirstName());
  }

  @Test
  void setFirstName() {
    name.setFirstName("Eve");
    assertEquals("Eve", name.getFirstName());
  }

  @Test
  void getLastName() {
    assertEquals("Brown", name.getLastName());
  }

  @Test
  void setLastName() {
    name.setLastName("Johnson");
    assertEquals("Johnson", name.getLastName());
  }

  @Test
  void testEquals() {
    Name sameName = new Name("Alice", "Brown");
    Name differentName = new Name("Eve", "Johnson");
    assertEquals(name, sameName);
    assertNotEquals(name, differentName);
  }

  @Test
  void testHashCode() {
    Name sameName = new Name("Alice", "Brown");
    assertEquals(name.hashCode(), sameName.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "Name{firstName='Alice', lastName='Brown'}";
    assertEquals(expectedString, name.toString());
  }
}
