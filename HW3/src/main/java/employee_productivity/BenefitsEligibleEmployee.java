package employee_productivity;

import java.time.LocalDate;

/**
 * Class representing a benefits-eligible part-time employee in the productivity tracking system.
 */
public class BenefitsEligibleEmployee extends PartTimeEmployee implements EmployeeProductivity {

  /**
   * Constructor for the BenefitsEligibleEmployee class.
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
  public BenefitsEligibleEmployee(String ID, LocalDate employmentDate, ContactInfo contactInfo,
      EducationLevel educationLevel, EmploymentLevel employmentLevel,
      double lastYearEarning, double contractualNumHours, double actualHours, double extra) {
    super(ID, employmentDate, contactInfo, educationLevel, employmentLevel, lastYearEarning,
        contractualNumHours, actualHours, extra);
  }

  /**
   * Estimates the productivity of the benefits-eligible part-time employee.
   *
   * @return the estimated productivity as a double value
   */
  @Override
  public double estimateProductivity() {
    double baseProductivity = (actualHours / contractualNumHours) * 3.7;
    return applyEmploymentLevelBonus(employmentLevel, baseProductivity);
  }

  @Override
  public double applyEmploymentLevelBonus(EmploymentLevel employmentLevel,
      double currentProductivity) {
    return 0;
  }

  @Override
  public String toString() {
    return "BenefitsEligibleEmployee{" +
        "ID='" + ID + '\'' +
        ", contactInfo=" + contactInfo +
        ", employmentDate=" + employmentDate +
        ", educationLevel=" + educationLevel +
        ", employmentLevel=" + employmentLevel +
        ", lastYearEarning=" + lastYearEarning +
        ", contractualNumHours=" + contractualNumHours +
        ", actualHours=" + actualHours +
        ", extra=" + extra +
        '}';
  }

}
