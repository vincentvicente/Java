package problem2;

import java.util.Objects;

/**
 * Abstract class representing a person.
 */
abstract class Person extends Creator {
  protected String firstName;
  protected String lastName;

  /**
   * Constructs a Person with the specified first and last name.
   *
   * @param firstName The first name of the person.
   * @param lastName The last name of the person.
   */
  public Person(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * Gets the first name of the person.
   *
   * @return The first name of the person.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Gets the last name of the person.
   *
   * @return The last name of the person.
   */
  public String getLastName() {
    return lastName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Person person = (Person) o;
    return Objects.equals(firstName, person.firstName) &&
        Objects.equals(lastName, person.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName);
  }
}
