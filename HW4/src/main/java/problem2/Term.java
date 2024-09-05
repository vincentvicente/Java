package problem2;

import java.util.Objects;

/**
 * Class representing a term in a polynomial.
 */
public class Term {

  private int coefficient;
  private int power;

  /**
   * Constructor for a term.
   *
   * @param coefficient the coefficient of the term
   * @param power       the power of the term
   */
  public Term(int coefficient, int power) {
    this.coefficient = coefficient;
    this.power = power;
  }

  /**
   * Gets the coefficient of the term.
   *
   * @return the coefficient of the term
   */
  public int getCoefficient() {
    return coefficient;
  }

  /**
   * Sets the coefficient of the term.
   *
   * @param coefficient the new coefficient of the term
   */
  public void setCoefficient(int coefficient) {
    this.coefficient = coefficient;
  }

  /**
   * Gets the power of the term.
   *
   * @return the power of the term
   */
  public int getPower() {
    return power;
  }

  /**
   * Sets the power of the term.
   *
   * @param power the new power of the term
   */
  public void setPower(int power) {
    this.power = power;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Term term = (Term) o;
    return coefficient == term.coefficient && power == term.power;
  }

  @Override
  public int hashCode() {
    return Objects.hash(coefficient, power);
  }

  @Override
  public String toString() {
    return coefficient + "x^" + power;
  }
}
