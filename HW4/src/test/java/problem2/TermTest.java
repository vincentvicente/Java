package problem2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TermTest {

  @Test
  void testGetCoefficient() {
    Term term = new Term(3, 4);
    assertEquals(3, term.getCoefficient());
  }

  @Test
  void testSetCoefficient() {
    Term term = new Term(3, 4);
    term.setCoefficient(5);
    assertEquals(5, term.getCoefficient());
  }

  @Test
  void testGetPower() {
    Term term = new Term(3, 4);
    assertEquals(4, term.getPower());
  }

  @Test
  void testSetPower() {
    Term term = new Term(3, 4);
    term.setPower(2);
    assertEquals(2, term.getPower());
  }

  @Test
  void testEquals() {
    Term term1 = new Term(3, 4);
    Term term2 = new Term(3, 4);
    Term term3 = new Term(5, 4);
    assertEquals(term1, term2);
    assertNotEquals(term1, term3);
  }

  @Test
  void testHashCode() {
    Term term1 = new Term(3, 4);
    Term term2 = new Term(3, 4);
    Term term3 = new Term(5, 4);
    assertEquals(term1.hashCode(), term2.hashCode());
    assertNotEquals(term1.hashCode(), term3.hashCode());
  }

  @Test
  void testToString() {
    Term term = new Term(3, 4);
    assertEquals("3x^4", term.toString());
  }
}
