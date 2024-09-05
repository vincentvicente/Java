package problem2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Implementation of the Polynomial interface.
 */
public class PolynomialImpl implements Polynomial {

  private List<Term> terms;

  /**
   * Constructor for PolynomialImpl.
   */
  public PolynomialImpl() {
    this.terms = new ArrayList<>();
  }

  /**
   * Returns the degree of the polynomial.
   *
   * @return the degree of the polynomial.
   */
  @Override
  public int getDegree() {
    int degree = 0;
    for (Term term : terms) {
      if (term.getPower() > degree) {
        degree = term.getPower();
      }
    }
    return degree;
  }

  /**
   * Returns the coefficient of the term with the given power.
   *
   * @param power the power of the term.
   * @return the coefficient of the term.
   */
  @Override
  public int getCoefficient(int power) {
    for (Term term : terms) {
      if (term.getPower() == power) {
        return term.getCoefficient();
      }
    }
    return 0;
  }

  /**
   * Adds a term to the polynomial.
   *
   * @param coefficient the coefficient of the term.
   * @param power       the power of the term.
   */
  @Override
  public void addTerm(int coefficient, int power) {
    if (coefficient == 0) {
      return;
    }
    for (Term term : terms) {
      if (term.getPower() == power) {
        term.setCoefficient(term.getCoefficient() + coefficient);
        if (term.getCoefficient() == 0) {
          terms.remove(term);
        }
        return;
      }
    }
    terms.add(new Term(coefficient, power));
  }

  /**
   * Removes the term with the given power from the polynomial.
   *
   * @param power the power of the term to be removed.
   */
  @Override
  public void removeTerm(int power) {
    terms.removeIf(term -> term.getPower() == power);
  }

  /**
   * Checks if this polynomial is the same as another polynomial.
   *
   * @param other the other polynomial to compare to.
   * @return true if the polynomials are the same, false otherwise.
   */
  @Override
  public boolean isSame(Polynomial other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    PolynomialImpl that = (PolynomialImpl) other;
    return Objects.equals(terms, that.terms);
  }

  /**
   * Adds another polynomial to this polynomial and returns the result.
   *
   * @param other the other polynomial to add.
   * @return the resulting polynomial.
   */
  @Override
  public Polynomial add(Polynomial other) {
    PolynomialImpl result = new PolynomialImpl();
    for (Term term : terms) {
      result.addTerm(term.getCoefficient(), term.getPower());
    }
    for (int i = 0; i <= other.getDegree(); i++) {
      int coefficient = other.getCoefficient(i);
      if (coefficient != 0) {
        result.addTerm(coefficient, i);
      }
    }
    return result;
  }


  /**
   * Returns a string representation of the polynomial.
   *
   * @return the string representation of the polynomial.
   */
  @Override
  public String printPolynomial() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < terms.size(); i++) {
      Term term = terms.get(i);
      if (i > 0 && term.getCoefficient() > 0) {
        sb.append("+");
      }
      sb.append(term.toString());
    }
    return sb.toString();
  }

  @Override
  public String toString() {
    return printPolynomial();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PolynomialImpl that = (PolynomialImpl) o;
    return Objects.equals(terms, that.terms);
  }

  @Override
  public int hashCode() {
    return Objects.hash(terms);
  }
}
