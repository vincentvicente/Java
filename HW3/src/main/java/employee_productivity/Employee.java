package employee_productivity;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Abstract class representing a general employee in the productivity tracking system.
 */
public abstract class Employee {

  static final double INTERMEDIATE_LEVEL_BONUS = 1.4;

  /**
   * Unique identifier for the employee.
   */
  protected String ID;

  /**
   * Contact information for the employee.
   */
  protected ContactInfo contactInfo;

  /**
   * Date the employee started working at the current company.
   */
  protected LocalDate employmentDate;

  /**
   * Education level of the employee.
   */
  protected EducationLevel educationLevel;

  /**
   * Employment level of the employee.
   */
  protected EmploymentLevel employmentLevel;

  /**
   * The employee's earnings from last year.
   */
  protected double lastYearEarning;

  /**
   * Constructor for the Employee class.
   *
   * @param ID              the unique identifier for the employee
   * @param employmentDate  the date the employee started working at the current company
   * @param contactInfo     the contact information for the employee
   * @param educationLevel  the education level of the employee
   * @param employmentLevel the employment level of the employee
   * @param lastYearEarning the employee's earnings from last year
   */
  public Employee(String ID, LocalDate employmentDate, ContactInfo contactInfo,
      EducationLevel educationLevel, EmploymentLevel employmentLevel, double lastYearEarning) {
    this.ID = ID;
    this.employmentDate = employmentDate;
    this.contactInfo = contactInfo;
    this.educationLevel = educationLevel;
    this.employmentLevel = employmentLevel;
    this.lastYearEarning = lastYearEarning;
  }

  /**
   * Gets the unique identifier for the employee.
   *
   * @return the unique identifier
   */
  public String getID() {
    return ID;
  }

  /**
   * Sets the unique identifier for the employee.
   *
   * @param ID the unique identifier
   */
  public void setID(String ID) {
    this.ID = ID;
  }

  /**
   * Gets the contact information for the employee.
   *
   * @return the contact information
   */
  public ContactInfo getContactInfo() {
    return contactInfo;
  }

  /**
   * Sets the contact information for the employee.
   *
   * @param contactInfo the contact information
   */
  public void setContactInfo(ContactInfo contactInfo) {
    this.contactInfo = contactInfo;
  }

  /**
   * Gets the education level of the employee.
   *
   * @return the education level
   */
  public EducationLevel getEducationLevel() {
    return educationLevel;
  }

  /**
   * Sets the education level of the employee.
   *
   * @param educationLevel the education level
   */
  public void setEducationLevel(EducationLevel educationLevel) {
    this.educationLevel = educationLevel;
  }

  /**
   * Gets the date the employee started working at the current company.
   *
   * @return the employment date
   */
  public LocalDate getEmploymentDate() {
    return employmentDate;
  }

  /**
   * Sets the date the employee started working at the current company.
   *
   * @param employmentDate the employment date
   */
  public void setEmploymentDate(LocalDate employmentDate) {
    this.employmentDate = employmentDate;
  }

  /**
   * Gets the employment level of the employee.
   *
   * @return the employment level
   */
  public EmploymentLevel getEmploymentLevel() {
    return employmentLevel;
  }

  /**
   * Sets the employment level of the employee.
   *
   * @param employmentLevel the employment level
   */
  public void setEmploymentLevel(EmploymentLevel employmentLevel) {
    this.employmentLevel = employmentLevel;
  }

  /**
   * Gets the employee's earnings from last year.
   *
   * @return the last year's earnings
   */
  public double getLastYearEarning() {
    return lastYearEarning;
  }

  /**
   * Sets the employee's earnings from last year.
   *
   * @param lastYearEarning the last year's earnings
   */
  public void setLastYearEarning(double lastYearEarning) {
    this.lastYearEarning = lastYearEarning;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Employee employee = (Employee) o;
    return Double.compare(employee.lastYearEarning, lastYearEarning) == 0
        && Objects.equals(ID, employee.ID)
        && Objects.equals(contactInfo, employee.contactInfo)
        && Objects.equals(employmentDate, employee.employmentDate)
        && educationLevel == employee.educationLevel
        && employmentLevel == employee.employmentLevel;
  }


  @Override
  public int hashCode() {
    return Objects.hash(ID, contactInfo, employmentDate, educationLevel, employmentLevel,
        lastYearEarning);
  }

  @Override
  public String toString() {
    return "Employee{" +
        "ID='" + ID + '\'' +
        ", contactInfo=" + contactInfo +
        ", employmentDate=" + employmentDate +
        ", educationLevel=" + educationLevel +
        ", employmentLevel=" + employmentLevel +
        ", lastYearEarning=" + lastYearEarning +
        '}';
  }

  /**
   * Applies the employment level bonus if applicable.
   *
   * @param employmentLevel     the employment level of the employee
   * @param currentProductivity the current productivity estimate
   * @return the updated productivity estimate with the employment level bonus applied
   */
  public double applyEmploymentLevelBonus(EmploymentLevel employmentLevel,
      double currentProductivity) {
    if (employmentLevel == EmploymentLevel.INTERMEDIATE_LEVEL) {
      return currentProductivity + INTERMEDIATE_LEVEL_BONUS;
    }
    return currentProductivity;
  }
}
