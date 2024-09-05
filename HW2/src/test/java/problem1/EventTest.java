package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EventTest {

  private Event testEvent;

  @BeforeEach
  public void setUp() throws Exception {
    testEvent = new Event(LocalDate.of(2024, 5, 27), "Amy Wang", 50);
  }

  @Test
  void getScheduleDate() {
    assertEquals(LocalDate.of(2024, 5, 27), testEvent.getScheduleDate());
  }

  @Test
  void getSchedulePerson() {
    assertEquals("Amy Wang", testEvent.getSchedulePerson());
  }

  @Test
  void getNumAttendees() {
    assertEquals(50, testEvent.getNumAttendees());
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(testEvent.equals(testEvent));
  }

  @Test
  void testEquals_NullComparison() {
    assertFalse(testEvent.equals(null));
  }

  @Test
  void testEquals_DifferentObject() {
    assertFalse(testEvent.equals("Some String"));
  }

  @Test
  void testEquals_DifferentObjectsSameFields() {
    Event anotherEvent = new Event(LocalDate.of(2024, 5, 27), "Amy Wang", 50);
    assertTrue(testEvent.equals(anotherEvent));
  }

  @Test
  void testEquals_DifferentObjectsDifferentDate() {
    Event anotherEvent = new Event(LocalDate.of(2024, 5, 28), "Amy Wang", 50);
    assertFalse(testEvent.equals(anotherEvent));
  }

  @Test
  void testEquals_DifferentObjectsDifferentScheduler() {
    Event anotherEvent = new Event(LocalDate.of(2024, 5, 27), "Marie Wang", 50);
    assertFalse(testEvent.equals(anotherEvent));
  }

  @Test
  void testEquals_DifferentObjectsDifferentAttendees() {
    Event anotherEvent = new Event(LocalDate.of(2024, 5, 27), "Amy Wang", 60);
    assertFalse(testEvent.equals(anotherEvent));
  }

  @Test
  void testHashCode() {
    int expectedHash = Objects.hash(testEvent.getScheduleDate(), testEvent.getSchedulePerson(), testEvent.getNumAttendees());
    assertEquals(expectedHash, testEvent.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "Event{" +
        "scheduleDate=" + testEvent.getScheduleDate() +
        ", schedulePerson='" + testEvent.getSchedulePerson() + '\'' +
        ", numAttendees=" + testEvent.getNumAttendees() +
        '}';
    assertEquals(expectedString, testEvent.toString());
  }
}
