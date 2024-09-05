package employee_productivity;

import java.time.LocalDate;

/**
 * Abstract class representing a full-time employee in the productivity tracking system.
 */
public abstract class FullTimeEmployee extends Employee implements EmployeeProductivity {

  /**
   * The base pay of the full-time employee.
   */
  protected double basePay;

  /**
   * The bonuses earned by the full-time employee.
   */
  protected double bonuses;

  /**
   * The overtime pay earned by the full-time employee.
   */
  protected double overTime;

  /**
   * The date of the last promotion for the full-time employee.
   */
  protected LocalDate lastPromotionDate;

  /**
   * The number of projects the full-time employee is involved in.
   */
  protected Integer numProjects;


  /**
   * Constructor for the FullTimeEmployee class.
   *
   * @param ID                the unique identifier for the employee
   * @param employmentDate    the date the employee started working at the current company
   * @param contactInfo       the contact information for the employee
   * @param educationLevel    the education level of the employee
   * @param employmentLevel   the employment level of the employee
   * @param lastYearEarning   the employee's earnings from last year
   * @param basePay           the base pay of the full-time employee
   * @param bonuses           the bonuses earned by the full-time employee
   * @param overTime          the overtime pay earned by the full-time employee
   * @param lastPromotionDate the date of the last promotion for the full-time employee
   * @param numProjects       the number of projects the full-time employee is involved in
   */
  public FullTimeEmployee(String ID, LocalDate employmentDate, ContactInfo contactInfo,
      EducationLevel educationLevel, EmploymentLevel employmentLevel,
      double lastYearEarning, double basePay, double bonuses, double overTime,
      LocalDate lastPromotionDate, Integer numProjects) {
    super(ID, employmentDate, contactInfo, educationLevel, employmentLevel, lastYearEarning);
    this.basePay = basePay;
    this.bonuses = bonuses;
    this.overTime = overTime;
    this.lastPromotionDate = lastPromotionDate;
    this.numProjects = numProjects;
  }

  /**
   * Gets the base pay of the full-time employee.
   *
   * @return the base pay
   */
  public double getBasePay() {
    return basePay;
  }

  /**
   * Sets the base pay of the full-time employee.
   *
   * @param basePay the base pay
   */
  public void setBasePay(double basePay) {
    this.basePay = basePay;
  }

  /**
   * Gets the bonuses earned by the full-time employee.
   *
   * @return the bonuses
   */
  public double getBonuses() {
    return bonuses;
  }

  /**
   * Sets the bonuses earned by the full-time employee.
   *
   * @param bonuses the bonuses
   */
  public void setBonuses(double bonuses) {
    this.bonuses = bonuses;
  }

  /**
   * Gets the overtime pay earned by the full-time employee.
   *
   * @return the overtime pay
   */
  public double getOverTime() {
    return overTime;
  }

  /**
   * Sets the overtime pay earned by the full-time employee.
   *
   * @param overTime the overtime pay
   */
  public void setOverTime(double overTime) {
    this.overTime = overTime;
  }

  /**
   * Gets the date of the last promotion for the full-time employee.
   *
   * @return the date of the last promotion
   */
  public LocalDate getLastPromotionDate() {
    return lastPromotionDate;
  }

  /**
   * Sets the date of the last promotion for the full-time employee.
   *
   * @param lastPromotionDate the date of the last promotion
   */
  public void setLastPromotionDate(LocalDate lastPromotionDate) {
    this.lastPromotionDate = lastPromotionDate;
  }

  /**
   * Gets the number of projects the full-time employee is involved in.
   *
   * @return the number of projects
   */
  public Integer getNumProjects() {
    return numProjects;
  }

  /**
   * Sets the number of projects the full-time employee is involved in.
   *
   * @param numProjects the number of projects
   */
  public void setNumProjects(Integer numProjects) {
    this.numProjects = numProjects;
  }

  /**
   * Estimates the productivity of the full-time employee. Base productivity of full-time employees
   * is calculated as a ratio between an employee's last year's earnings and their base pay.
   *
   * @return the estimated productivity as a double value
   */
  @Override
  public double estimateProductivity() {
    return lastYearEarning / basePay;
  }
}
