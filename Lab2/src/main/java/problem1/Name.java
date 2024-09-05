package problem1;

import java.util.Objects;

/**
 * Class Name stores information about name. Name consists of three Strings: first name, middle
 * name, and last name.
 */
public class Name {

  private String firstName;
  private String middleName;
  private String lastName;

  /**
   * Constructor for class Name.
   *
   * @param firstName  String, storing first name
   * @param middleName String, storing middle name
   * @param lastName   String, storing last name
   */
  public Name(String firstName, String middleName, String lastName) {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
  }

  /**
   * Getter for first name.
   *
   * @return String, first name.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Getter for middle name.
   *
   * @return String, middle name.
   */
  public String getMiddleName() {
    return middleName;
  }

  /**
   * Getter for last name.
   *
   * @return String, last name.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Name name = (Name) o;
    return Objects.equals(firstName, name.firstName) && Objects.equals(middleName,
        name.middleName) && Objects.equals(lastName, name.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, middleName, lastName);
  }

  @Override
  public String toString() {
    return "Name{" +
        "firstName='" + firstName + '\'' +
        ", middleName='" + middleName + '\'' +
        ", lastName='" + lastName + '\'' +
        '}';
  }
}
