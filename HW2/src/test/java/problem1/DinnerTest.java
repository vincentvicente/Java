package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DinnerTest {

  private Dinner testDinner;

  @BeforeEach
  void setUp() {
    testDinner = new Dinner(LocalDate.of(2024, 9, 19), "Catrina Lopez", 50);
  }

  @Test
  void getNonVegetarian() {
    assertEquals(40, testDinner.getNonVegetarian()); // 50 * 0.8 = 40
  }

  @Test
  void getVegetarian() {
    assertEquals(10, testDinner.getVegetarian()); // 50 * 0.2 = 10
  }

  @Test
  void getVegan() {
    assertEquals(3, testDinner.getVegan()); // 50 * 0.05 = 2.5, round to 3
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(testDinner.equals(testDinner));
  }

  @Test
  void testEquals_NullComparison() {
    assertFalse(testDinner.equals(null));
  }

  @Test
  void testEquals_DifferentObject() {
    assertFalse(testDinner.equals("Some String"));
  }

  @Test
  void testEquals_DifferentObjectsSameFields() {
    Dinner anotherDinner = new Dinner(LocalDate.of(2024, 9, 19), "Catrina Lopez", 50);
    assertTrue(testDinner.equals(anotherDinner));
  }

  @Test
  void testEquals_DifferentObjectsDifferentDate() {
    Dinner anotherDinner = new Dinner(LocalDate.of(2024, 9, 18), "Catrina Lopez", 50);
    assertFalse(testDinner.equals(anotherDinner));
  }

  @Test
  void testEquals_DifferentObjectsDifferentScheduler() {
    Dinner anotherDinner = new Dinner(LocalDate.of(2024, 9, 19), "Lilian Lopez", 50);
    assertFalse(testDinner.equals(anotherDinner));
  }

  @Test
  void testEquals_DifferentObjectsDifferentAttendees() {
    Dinner anotherDinner = new Dinner(LocalDate.of(2024, 9, 19), "Catrina Lopez", 60);
    assertFalse(testDinner.equals(anotherDinner));
  }

  @Test
  void testHashCode() {
    Dinner anotherDinner = new Dinner(LocalDate.of(2024, 9, 19), "Catrina Lopez", 50);
    assertEquals(testDinner.hashCode(), anotherDinner.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "DinnerEvent{" +
        "scheduleDate=" + testDinner.getScheduleDate() +
        ", schedulePerson='" + testDinner.getSchedulePerson() + '\'' +
        ", numAttendees=" + testDinner.getNumAttendees() +
        ", non-vegetarian entrees=" + testDinner.getNonVegetarian() +
        ", vegetarian entrees=" + testDinner.getVegetarian() +
        ", vegan entrees=" + testDinner.getVegan() +
        '}';
    assertEquals(expectedString, testDinner.toString());
  }
}
