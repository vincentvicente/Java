package problem2;

/**
 * Interface representing a Polynomial.
 */
public interface Polynomial {

  /**
   * Returns the degree of the polynomial.
   *
   * @return the degree of the polynomial.
   */
  int getDegree();

  /**
   * Returns the coefficient for the term with the given power.
   *
   * @param power the power of the term.
   * @return the coefficient of the term with the given power.
   */
  int getCoefficient(int power);

  /**
   * Adds a term to the polynomial.
   *
   * @param coefficient the coefficient of the term.
   * @param power       the power of the term.
   */
  void addTerm(int coefficient, int power);

  /**
   * Removes a term with the given power from the polynomial.
   *
   * @param power the power of the term to be removed.
   */
  void removeTerm(int power);

  /**
   * Checks if this polynomial is the same as another polynomial.
   *
   * @param other the other polynomial.
   * @return true if the polynomials are the same, false otherwise.
   */
  boolean isSame(Polynomial other);

  /**
   * Adds another polynomial to this polynomial and returns the result.
   *
   * @param other the other polynomial.
   * @return the resulting polynomial after addition.
   */
  Polynomial add(Polynomial other);

  /**
   * Returns a string representation of the polynomial.
   *
   * @return the string representation of the polynomial.
   */
  String printPolynomial();
}
