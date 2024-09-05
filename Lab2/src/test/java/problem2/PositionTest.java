package problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PositionTest {

  private Position position1;
  private Position position2;
  private Position position3;

  @BeforeEach
  void setUp() {
    position1 = new Position(5, 10);
    position2 = new Position(5, 10);
    position3 = new Position(10, 20);
  }

  @Test
  void getXCoordinate() {
    assertEquals(5, position1.getXCoordinate());
    assertEquals(10, position3.getXCoordinate());
  }

  @Test
  void getYCoordinate() {
    assertEquals(10, position1.getYCoordinate());
    assertEquals(20, position3.getYCoordinate());
  }

  @Test
  void testEquals() {
    assertEquals(position1, position2);
    assertNotEquals(position1, position3);
    assertNotEquals(position2, position3);
    assertNotEquals(position1, null);
    assertNotEquals(position1, new Object());
  }

  @Test
  void testHashCode() {
    assertEquals(position1.hashCode(), position2.hashCode());
    assertNotEquals(position1.hashCode(), position3.hashCode());
  }
}
