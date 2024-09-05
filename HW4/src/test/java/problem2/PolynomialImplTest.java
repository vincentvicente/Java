package problem2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PolynomialImplTest {

  @Test
  void testGetDegree() {
    Polynomial polynomial = new PolynomialImpl();
    polynomial.addTerm(3, 4);
    polynomial.addTerm(-5, 3);
    polynomial.addTerm(2, 1);
    polynomial.addTerm(-4, 0);
    assertEquals(4, polynomial.getDegree());
  }

  @Test
  void testGetCoefficient() {
    Polynomial polynomial = new PolynomialImpl();
    polynomial.addTerm(3, 4);
    polynomial.addTerm(-5, 3);
    polynomial.addTerm(2, 1);
    polynomial.addTerm(-4, 0);
    assertEquals(3, polynomial.getCoefficient(4));
    assertEquals(-5, polynomial.getCoefficient(3));
    assertEquals(2, polynomial.getCoefficient(1));
    assertEquals(-4, polynomial.getCoefficient(0));
    assertEquals(0, polynomial.getCoefficient(2));
  }

  @Test
  void testAddTerm() {
    Polynomial polynomial = new PolynomialImpl();
    polynomial.addTerm(3, 4);
    polynomial.addTerm(-5, 3);
    polynomial.addTerm(2, 1);
    polynomial.addTerm(-4, 0);
    polynomial.addTerm(2, 4);
    assertEquals(5, polynomial.getCoefficient(4));
    polynomial.addTerm(-5, 3);
    assertEquals(-10, polynomial.getCoefficient(3));
  }

  @Test
  void testRemoveTerm() {
    Polynomial polynomial = new PolynomialImpl();
    polynomial.addTerm(3, 4);
    polynomial.addTerm(-5, 3);
    polynomial.addTerm(2, 1);
    polynomial.addTerm(-4, 0);
    polynomial.removeTerm(3);
    assertEquals(0, polynomial.getCoefficient(3));
  }

  @Test
  void testIsSame() {
    Polynomial polynomial1 = new PolynomialImpl();
    polynomial1.addTerm(3, 4);
    polynomial1.addTerm(-5, 3);
    polynomial1.addTerm(2, 1);
    polynomial1.addTerm(-4, 0);

    Polynomial polynomial2 = new PolynomialImpl();
    polynomial2.addTerm(3, 4);
    polynomial2.addTerm(-5, 3);
    polynomial2.addTerm(2, 1);
    polynomial2.addTerm(-4, 0);

    Polynomial polynomial3 = new PolynomialImpl();
    polynomial3.addTerm(3, 4);
    polynomial3.addTerm(-5, 3);
    polynomial3.addTerm(2, 1);

    assertTrue(polynomial1.isSame(polynomial2));
    assertFalse(polynomial1.isSame(polynomial3));
  }

  @Test
  void testAdd() {
    Polynomial polynomial1 = new PolynomialImpl();
    polynomial1.addTerm(3, 4);
    polynomial1.addTerm(-5, 3);
    polynomial1.addTerm(2, 1);
    polynomial1.addTerm(-4, 0);

    Polynomial polynomial2 = new PolynomialImpl();
    polynomial2.addTerm(2, 3);
    polynomial2.addTerm(2, 5);
    polynomial2.addTerm(4, 0);

    Polynomial result = polynomial1.add(polynomial2);

    assertEquals(3, result.getCoefficient(4));
    assertEquals(-3, result.getCoefficient(3));
    assertEquals(2, result.getCoefficient(5));
    assertEquals(2, result.getCoefficient(0));
    assertEquals(2, result.getCoefficient(1));
  }


  @Test
  void testPrintPolynomial() {
    Polynomial polynomial = new PolynomialImpl();
    polynomial.addTerm(3, 4);
    polynomial.addTerm(-5, 3);
    polynomial.addTerm(2, 1);
    polynomial.addTerm(-4, 0);
    assertEquals("3x^4-5x^3+2x^1-4x^0", polynomial.printPolynomial());
  }
}
