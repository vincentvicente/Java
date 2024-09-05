package problem2;

import java.util.Objects;

/**
 * Class Recipient stores personal information about the recipient that is using the locker
 */
public class Recipient {

  private final String firstName;
  private final String lastName;
  private final String emailAddress;

  /**
   * Constructor for the class Brunch.
   *
   * @param firstName    - String, representing the first name of the recipient
   * @param lastName     - String, representing the last name of the recipient
   * @param emailAddress - String, representing the email address of the recipient
   */
  public Recipient(String firstName, String lastName, String emailAddress) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.emailAddress = emailAddress;
  }

  /**
   * Getter for the first name of the recipient
   *
   * @return - firstName, giving the first name of the recipient
   **/
  public String getFirstName() {
    return firstName;
  }

  /**
   * Getter for the last name of the recipient
   *
   * @return - lastName, giving the last name of the recipient
   **/
  public String getLastName() {
    return lastName;
  }

  /**
   * Getter for the email address of the recipient
   *
   * @return - emailAddress, giving the email address of the recipient
   **/
  public String getEmailAddress() {
    return emailAddress;
  }

  @Override
  public String toString() {
    return "Recipient{" +
        "first name =" + firstName + '\'' +
        ", last name ='" + lastName + '\'' +
        ", email address =" + emailAddress + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Recipient that = (Recipient) o;
    return Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName)
        && Objects.equals(emailAddress, that.emailAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName, emailAddress);
  }
}
