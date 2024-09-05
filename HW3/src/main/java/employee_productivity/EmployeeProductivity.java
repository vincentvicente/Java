package employee_productivity;

/**
 * Interface representing the productivity estimation for employees.
 */
public interface EmployeeProductivity {

  /**
   * Estimates the productivity of the employee.
   *
   * @return the estimated productivity as a double value
   */
  double estimateProductivity();

  /**
   * Applies the employment level bonus if applicable.
   *
   * @param employmentLevel the employment level of the employee
   * @param currentProductivity the current productivity estimate
   * @return the updated productivity estimate with the employment level bonus applied
   */
  double applyEmploymentLevelBonus(EmploymentLevel employmentLevel, double currentProductivity);
}
