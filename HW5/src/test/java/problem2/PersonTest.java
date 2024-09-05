package problem2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

  @Test
  public void testPersonCreation() {
    Person person = new RecordingArtist("John", "Lennon");
    assertEquals("John", person.getFirstName());
    assertEquals("Lennon", person.getLastName());
  }

  @Test
  public void testPersonEqualsAndHashCode() {
    Person person1 = new RecordingArtist("John", "Lennon");
    Person person2 = new RecordingArtist("John", "Lennon");
    Person person3 = new RecordingArtist("Paul", "McCartney");

    assertEquals(person1, person2);
    assertNotEquals(person1, person3);

    assertEquals(person1.hashCode(), person2.hashCode());
    assertNotEquals(person1.hashCode(), person3.hashCode());
  }
}
