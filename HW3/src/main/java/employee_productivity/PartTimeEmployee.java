package employee_productivity;

import java.time.LocalDate;

/**
 * Abstract class representing a part-time employee in the productivity tracking system.
 */
public abstract class PartTimeEmployee extends Employee {

  /**
   * The contractual number of hours the part-time employee is expected to work.
   */
  protected double contractualNumHours;

  /**
   * The actual number of hours the part-time employee worked.
   */
  protected double actualHours;

  /**
   * The extra earnings from bonuses and overtime.
   */
  protected double extra;

  /**
   * Constructor for the PartTimeEmployee class.
   *
   * @param ID                  the unique identifier for the employee
   * @param employmentDate      the date the employee started working at the current company
   * @param contactInfo         the contact information for the employee
   * @param educationLevel      the education level of the employee
   * @param employmentLevel     the employment level of the employee
   * @param lastYearEarning     the employee's earnings from last year
   * @param contractualNumHours the contractual number of hours the part-time employee is expected
   *                            to work
   * @param actualHours         the actual number of hours the part-time employee worked
   * @param extra               the extra earnings from bonuses and overtime
   */
  public PartTimeEmployee(String ID, LocalDate employmentDate, ContactInfo contactInfo,
      EducationLevel educationLevel, EmploymentLevel employmentLevel,
      double lastYearEarning, double contractualNumHours, double actualHours, double extra) {
    super(ID, employmentDate, contactInfo, educationLevel, employmentLevel, lastYearEarning);
    this.contractualNumHours = contractualNumHours;
    this.actualHours = actualHours;
    this.extra = extra;
  }

  /**
   * Gets the contractual number of hours the part-time employee is expected to work.
   *
   * @return the contractual number of hours
   */
  public double getContractualNumHours() {
    return contractualNumHours;
  }

  /**
   * Sets the contractual number of hours the part-time employee is expected to work.
   *
   * @param contractualNumHours the contractual number of hours
   */
  public void setContractualNumHours(double contractualNumHours) {
    this.contractualNumHours = contractualNumHours;
  }

  /**
   * Gets the actual number of hours the part-time employee worked.
   *
   * @return the actual number of hours
   */
  public double getActualHours() {
    return actualHours;
  }

  /**
   * Sets the actual number of hours the part-time employee worked.
   *
   * @param actualHours the actual number of hours
   */
  public void setActualHours(double actualHours) {
    this.actualHours = actualHours;
  }

  /**
   * Gets the extra earnings from bonuses and overtime.
   *
   * @return the extra earnings
   */
  public double getExtra() {
    return extra;
  }

  /**
   * Sets the extra earnings from bonuses and overtime.
   *
   * @param extra the extra earnings
   */
  public void setExtra(double extra) {
    this.extra = extra;
  }
}
