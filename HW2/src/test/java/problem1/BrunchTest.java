package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BrunchTest {

  private Brunch testBrunch;

  @BeforeEach
  void setUp() {
    testBrunch = new Brunch(LocalDate.of(2024, 9, 28), "Vincent Zhu", 50);
  }

  @Test
  void getOmelets() {
    assertEquals(33, testBrunch.getOmelets()); // 50 * 0.65 = 32.5, round to 33
  }

  @Test
  void getPancakes() {
    assertEquals(75, testBrunch.getPancakes()); // 50 * 1.5 = 75
  }

  @Test
  void getFruitBowls() {
    assertEquals(60, testBrunch.getFruitBowls()); // 50 * 1.2 = 60
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(testBrunch.equals(testBrunch));
  }

  @Test
  void testEquals_NullComparison() {
    assertFalse(testBrunch.equals(null));
  }

  @Test
  void testEquals_DifferentObject() {
    assertFalse(testBrunch.equals("Some String"));
  }

  @Test
  void testEquals_DifferentObjectsSameFields() {
    Brunch anotherBrunch = new Brunch(LocalDate.of(2024, 9, 28), "Vincent Zhu", 50);
    assertTrue(testBrunch.equals(anotherBrunch));
  }

  @Test
  void testEquals_DifferentObjectsDifferentDate() {
    Brunch anotherBrunch = new Brunch(LocalDate.of(2024, 9, 29), "Vincent Zhu", 50);
    assertFalse(testBrunch.equals(anotherBrunch));
  }

  @Test
  void testEquals_DifferentObjectsDifferentScheduler() {
    Brunch anotherBrunch = new Brunch(LocalDate.of(2024, 9, 28), "Cloud Doe", 50);
    assertFalse(testBrunch.equals(anotherBrunch));
  }

  @Test
  void testEquals_DifferentObjectsDifferentAttendees() {
    Brunch anotherBrunch = new Brunch(LocalDate.of(2024, 9, 28), "Vincent Zhu", 60);
    assertFalse(testBrunch.equals(anotherBrunch));
  }

  @Test
  void testHashCode() {
    Brunch anotherBrunch = new Brunch(LocalDate.of(2024, 9, 28), "Vincent Zhu", 50);
    assertEquals(testBrunch.hashCode(), anotherBrunch.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "BrunchEvent{" +
        "scheduleDate=" + testBrunch.getScheduleDate() +
        ", schedulePerson='" + testBrunch.getSchedulePerson() + '\'' +
        ", numAttendees=" + testBrunch.getNumAttendees() +
        ", omelets=" + testBrunch.getOmelets() +
        ", pancakes=" + testBrunch.getPancakes() +
        ", fruitBowls=" + testBrunch.getFruitBowls() +
        '}';
    assertEquals(expectedString, testBrunch.toString());
  }
}
