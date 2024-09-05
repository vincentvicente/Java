package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RunnerTest {

  private Runner testRunner;
  private Name testName;

  @BeforeEach
  void setUp() {
    testName = new Name("Jonah", "Mark", "Evans");
    testRunner = new Runner(testName, 190.0, 75.0, 27.35, 145.4, "Boston Marathon");
  }

  @Test
  void getBest5KRunTime() {
    assertEquals(27.35, testRunner.getBest5KRunTime());
  }

  @Test
  void getBestHalfMarathonRunTime() {
    assertEquals(145.4, testRunner.getBestHalfMarathonRunTime());
  }

  @Test
  void getFavoriteRunningEvent() {
    assertEquals("Boston Marathon", testRunner.getFavoriteRunningEvent());
  }

  @Test
  void testEquals_NullComparison() {
    assertFalse(testRunner.equals(null));
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(testRunner.equals(testRunner));
  }

  @Test
  void testEquals_DifferentDataType() {
    assertFalse(testRunner.equals("some string"));
  }

  @Test
  void testEquals_DifferentObjectSameValue() {
    Runner anotherRunner = new Runner(testName, 190.0, 75.0, 27.35, 145.4, "Boston Marathon");
    assertTrue(testRunner.equals(anotherRunner));
  }

  @Test
  void testEquals_DifferentObjectDifferentHeight() {
    Runner anotherRunner = new Runner(testName, 200.0, 75.0, 27.35, 145.4, "Boston Marathon");
    assertFalse(testRunner.equals(anotherRunner));
  }

  @Test
  void testEquals_DifferentObjectDifferentWeight() {
    Runner anotherRunner = new Runner(testName, 190.0, 85.0, 27.35, 145.4, "Boston Marathon");
    assertFalse(testRunner.equals(anotherRunner));
  }

  @Test
  void testEquals_DifferentObjectDifferent5KTime() {
    Runner anotherRunner = new Runner(testName, 190.0, 75.0, 23.35, 145.4, "Boston Marathon");
    assertFalse(testRunner.equals(anotherRunner));
  }

  @Test
  void testEquals_DifferentObjectDifferentHalfMarathonTime() {
    Runner anotherRunner = new Runner(testName, 190.0, 75.0, 27.35, 154.4, "Boston Marathon");
    assertFalse(testRunner.equals(anotherRunner));
  }

  @Test
  void testEquals_DifferentObjectDifferentRunningEvents() {
    Runner anotherRunner = new Runner(testName, 190.0, 75.0, 27.35, 145.4, "New York Marathon");
    assertFalse(testRunner.equals(anotherRunner));
  }

  @Test
  void testEquals_DifferentObjectDifferentConstructors() {
    Runner anotherRunner = new Runner(testName, 190.0, 75.0, "USA", 27.35, 145.4,
        "New York Marathon");
    assertFalse(testRunner.equals(anotherRunner));
  }

  @Test
  void testEquals_DifferentObjectDifferentEvents() {
    Runner anotherRunner = new Runner(testName, 190.0, 75.0, 27.35, 145.4, "New York Marathon");
    assertFalse(testRunner.equals(anotherRunner));
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(
        Objects.hash(testRunner.getAthletesName(), testRunner.getHeight(), testRunner.getWeight(),
            testRunner.getLeague()), testRunner.getBest5KRunTime(),
        testRunner.getBestHalfMarathonRunTime(), testRunner.getFavoriteRunningEvent());
    assertEquals(expectedHashCode, testRunner.hashCode());
  }

  @Test
  void testToString() {
    String expectedString =
        "Runner{" + "best5KRunTime=" + testRunner.getBest5KRunTime() + ", bestHalfMarathonRunTime="
            + testRunner.getBestHalfMarathonRunTime() + ", favoriteRunningEvent='"
            + testRunner.getFavoriteRunningEvent() + '\'' + ", athletesName="
            + testRunner.getAthletesName() + ", height=" + testRunner.getHeight() + ", weight="
            + testRunner.getWeight() + ", league='" + testRunner.getLeague() + '\'' + '}';
    assertEquals(expectedString, testRunner.toString());
  }
}