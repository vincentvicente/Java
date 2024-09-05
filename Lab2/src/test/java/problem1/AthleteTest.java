package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;

class AthleteTest {

  private Athlete testAthlete;
  private Name testName;

  @BeforeEach
  public void setUp() throws Exception {
    testName = new Name("Ken", "Adam", "Johnson");
    testAthlete = new Athlete(testName, 198.0, 85.0);
  }

  @org.junit.jupiter.api.Test
  void getAthletesName() {
    Name expectedName = new Name("Ken", "Adam", "Johnson");
    assertEquals(expectedName, testAthlete.getAthletesName());
  }

  @org.junit.jupiter.api.Test
  void getHeight() {
    assertEquals(198.0, testAthlete.getHeight());
  }

  @org.junit.jupiter.api.Test
  void getWeight() {
    assertEquals(85.0, testAthlete.getWeight());
  }

  @org.junit.jupiter.api.Test
  void getLeague() {
    assertNull(testAthlete.getLeague());
  }

  @org.junit.jupiter.api.Test
  void testEquals_SameObject() {
    assertTrue(testAthlete.equals(testAthlete));
    assertEquals(Boolean.TRUE, testAthlete.equals(testAthlete));
  }

  @org.junit.jupiter.api.Test
  void testEquals_NullComparison() {
    assertFalse(testAthlete.equals(null));
    //assertEquals(Boolean.FALSE, testAthlete.equals(testAthlete));
    //assertNotEquals(Boolean.TRUE, testAthlete.equals(testName));
  }

  @org.junit.jupiter.api.Test
  void testEquals_DifferentObject() {
    assertFalse(testAthlete.equals(testName));
  }

  @org.junit.jupiter.api.Test
  void testEquals_DifferentObjectsSameFields() {
    Athlete anotherAthlete = new Athlete(testName, 198.0, 85.0);
    assertTrue(testAthlete.equals(anotherAthlete));
  }

  @org.junit.jupiter.api.Test
  void testEquals_DifferentObjectsDifferentName() {
    Name anotherName = new Name("Ken", "Adam", "Adams");
    Athlete anotherAthlete = new Athlete(anotherName, 198.0, 85.0);
    assertFalse(testAthlete.equals(anotherAthlete));
  }

  @org.junit.jupiter.api.Test
  void testEquals_DifferentObjectsDifferentHeight() {
    Athlete anotherAthlete = new Athlete(testName, 200.0, 85.0);
    assertFalse(testAthlete.equals(anotherAthlete));
  }

  @org.junit.jupiter.api.Test
  void testEquals_DifferentObjectsDifferentWeight() {
    Athlete anotherAthlete = new Athlete(testName, 198.0, 95.0);
    assertFalse(testAthlete.equals(anotherAthlete));
  }

  @org.junit.jupiter.api.Test
  void testEquals_DifferentObjectsDifferentLeagueName() {
    Athlete anotherAthlete = new Athlete(testName, 198.0, 85.0, "MLB");
    assertFalse(testAthlete.equals(anotherAthlete));
  }

  @org.junit.jupiter.api.Test
  void testHashCode() {
    int expectedHash = Objects.hash(testAthlete.getAthletesName(), testAthlete.getHeight(),
        testAthlete.getWeight(), testAthlete.getLeague());
    assertEquals(expectedHash, testAthlete.hashCode());
    // assertEquals(testAthlete.hashCode(), testAthlete.hashCode());  **Warning: bad test, created by
    //    //the AI tool
  }

  @org.junit.jupiter.api.Test
  void testToString() {
    //assertEquals(testAthlete.toString(), testAthlete.toString()); **Warning: bad test, created by
    //the AI tool

    String expectedString =
        "Athlete{" + "athletesName=" + testAthlete.getAthletesName() + ", height="
            + testAthlete.getHeight() + ", weight=" + testAthlete.getWeight() + ", league='"
            + testAthlete.getLeague() + '\'' + '}';
    assertEquals(expectedString, testAthlete.toString());
  }
}