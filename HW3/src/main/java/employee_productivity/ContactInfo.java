package employee_productivity;

import java.util.Objects;

/**
 * Class representing contact information for an employee.
 */
public class ContactInfo {

  private Name name;
  private String address;
  private String phoneNumber;
  private String emailAddress;
  private Name emergencyContactName;

  /**
   * Constructor for the ContactInfo class.
   *
   * @param name                 the name of the employee
   * @param address              the address of the employee
   * @param phoneNumber          the phone number of the employee
   * @param emailAddress         the email address of the employee
   * @param emergencyContactName the name of the emergency contact
   */
  public ContactInfo(Name name, String address, String phoneNumber, String emailAddress,
      Name emergencyContactName) {
    this.name = name;
    this.address = address;
    this.phoneNumber = phoneNumber;
    this.emailAddress = emailAddress;
    this.emergencyContactName = emergencyContactName;
  }

  /**
   * Gets the name of the employee.
   *
   * @return the name
   */
  public Name getName() {
    return name;
  }

  /**
   * Sets the name of the employee.
   *
   * @param name the name
   */
  public void setName(Name name) {
    this.name = name;
  }

  /**
   * Gets the address of the employee.
   *
   * @return the address
   */
  public String getAddress() {
    return address;
  }

  /**
   * Sets the address of the employee.
   *
   * @param address the address
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * Gets the phone number of the employee.
   *
   * @return the phone number
   */
  public String getPhoneNumber() {
    return phoneNumber;
  }

  /**
   * Sets the phone number of the employee.
   *
   * @param phoneNumber the phone number
   */
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  /**
   * Gets the email address of the employee.
   *
   * @return the email address
   */
  public String getEmailAddress() {
    return emailAddress;
  }

  /**
   * Sets the email address of the employee.
   *
   * @param emailAddress the email address
   */
  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  /**
   * Gets the name of the emergency contact.
   *
   * @return the emergency contact name
   */
  public Name getEmergencyContactName() {
    return emergencyContactName;
  }

  /**
   * Sets the name of the emergency contact.
   *
   * @param emergencyContactName the emergency contact name
   */
  public void setEmergencyContactName(Name emergencyContactName) {
    this.emergencyContactName = emergencyContactName;
  }

  @Override
  public String toString() {
    return "ContactInfo{" +
        "name=" + name +
        ", address='" + address + '\'' +
        ", phoneNumber='" + phoneNumber + '\'' +
        ", emailAddress='" + emailAddress + '\'' +
        ", emergencyContactName=" + emergencyContactName +
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
    ContactInfo that = (ContactInfo) o;
    return Objects.equals(name, that.name) &&
        Objects.equals(address, that.address) &&
        Objects.equals(phoneNumber, that.phoneNumber) &&
        Objects.equals(emailAddress, that.emailAddress) &&
        Objects.equals(emergencyContactName, that.emergencyContactName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, address, phoneNumber, emailAddress, emergencyContactName);
  }
}
