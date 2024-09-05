package employee_productivity;

import java.time.LocalDate;

/**
 * Class representing a manager in the productivity tracking system.
 */
public class Manager extends FullTimeEmployee implements EmployeeProductivity {

  private static final double PROJECTS_BONUS_THRESHOLD = 2;
  private static final double PROJECTS_BONUS_AMOUNT = 1.5;
  private static final int EMPLOYEES_MANAGED_THRESHOLD = 8;
  private static final double EMPLOYEES_MANAGED_BONUS_AMOUNT = 1.8;
  private static final int PROMOTION_YEARS_THRESHOLD = 3;
  private static final double PROMOTION_PENALTY_AMOUNT = -0.8;

  private int numberOfEmployeesManaged;

  /**
   * Constructor for the Manager class.
   *
   * @param ID                       the unique identifier for the employee
   * @param employmentDate           the date the employee started working at the current company
   * @param contactInfo              the contact information for the employee
   * @param educationLevel           the education level of the employee
   * @param employmentLevel          the employment level of the employee
   * @param lastYearEarning          the employee's earnings from last year
   * @param basePay                  the employee's base pay
   * @param bonuses                  the employee's last year earned bonuses
   * @param overTime                 the employee's last year's earnings due to overtime payments
   * @param lastPromotionDate        the date of the employee's last promotion
   * @param numProjects              the number of projects the employee is working on
   * @param numberOfEmployeesManaged the number of employees managed by the manager
   */
  public Manager(String ID, LocalDate employmentDate, ContactInfo contactInfo,
      EducationLevel educationLevel, EmploymentLevel employmentLevel,
      double lastYearEarning, double basePay, double bonuses, double overTime,
      LocalDate lastPromotionDate, Integer numProjects, int numberOfEmployeesManaged) {
    super(ID, employmentDate, contactInfo, educationLevel, employmentLevel, lastYearEarning,
        basePay, bonuses, overTime, lastPromotionDate, numProjects);
    this.numberOfEmployeesManaged = numberOfEmployeesManaged;
  }

  /**
   * Gets the number of employees managed by the manager.
   *
   * @return the number of employees managed
   */
  public int getNumberOfEmployeesManaged() {
    return numberOfEmployeesManaged;
  }

  /**
   * Sets the number of employees managed by the manager.
   *
   * @param numberOfEmployeesManaged the number of employees managed
   */
  public void setNumberOfEmployeesManaged(int numberOfEmployeesManaged) {
    this.numberOfEmployeesManaged = numberOfEmployeesManaged;
  }

  /**
   * Estimates the productivity of the manager.
   *
   * @return the estimated productivity as a double value
   */
  @Override
  public double estimateProductivity() {
    double baseProductivity = calculateBaseProductivity();
    baseProductivity = applyProjectsBonus(baseProductivity);
    baseProductivity = applyEmployeesManagedBonus(baseProductivity);
    baseProductivity = applyPromotionPenalty(baseProductivity);
    return applyEmploymentLevelBonus(employmentLevel, baseProductivity);
  }

  private double calculateBaseProductivity() {
    return lastYearEarning / basePay;
  }

  private double applyProjectsBonus(double productivity) {
    if (numProjects > PROJECTS_BONUS_THRESHOLD) {
      return productivity + PROJECTS_BONUS_AMOUNT;
    }
    return productivity;
  }

  private double applyEmployeesManagedBonus(double productivity) {
    if (numberOfEmployeesManaged > EMPLOYEES_MANAGED_THRESHOLD) {
      return productivity + EMPLOYEES_MANAGED_BONUS_AMOUNT;
    }
    return productivity;
  }

  private double applyPromotionPenalty(double productivity) {
    if (lastPromotionDate.isBefore(LocalDate.now().minusYears(PROMOTION_YEARS_THRESHOLD))) {
      return productivity + PROMOTION_PENALTY_AMOUNT;
    }
    return productivity;
  }

  @Override
  public double applyEmploymentLevelBonus(EmploymentLevel employmentLevel,
      double currentProductivity) {
    if (employmentLevel == EmploymentLevel.INTERMEDIATE_LEVEL) {
      return currentProductivity + INTERMEDIATE_LEVEL_BONUS;
    }
    return currentProductivity;
  }

  @Override
  public String toString() {
    return "Manager{" +
        "ID='" + ID + '\'' +
        ", contactInfo=" + contactInfo +
        ", employmentDate=" + employmentDate +
        ", educationLevel=" + educationLevel +
        ", employmentLevel=" + employmentLevel +
        ", lastYearEarning=" + lastYearEarning +
        ", basePay=" + basePay +
        ", bonuses=" + bonuses +
        ", overTime=" + overTime +
        ", lastPromotionDate=" + lastPromotionDate +
        ", numProjects=" + numProjects +
        ", numberOfEmployeesManaged=" + numberOfEmployeesManaged +
        '}';
  }
}
