package problem2;

import java.util.List;

/**
 * Represents the payroll system interface.
 */
public interface PayrollSystem {

  /**
   * Checks if the PayrollSystem is empty.
   *
   * @return true if the PayrollSystem contains no employees, false otherwise
   */
  boolean isEmpty();

  /**
   * Counts the number of employees in the PayrollSystem.
   *
   * @return the number of employees
   */
  int countEmployees();

  /**
   * Adds an employee to the PayrollSystem. If the employee already exists, updates the employee's role.
   *
   * @param employee the employee to add
   */
  PayrollSystem addEmployee(Employee employee);

  /**
   * Removes the specified employee from the PayrollSystem.
   *
   * @param employee the employee to remove
   * @throws EmployeeNotFoundException if the employee does not exist
   */
  PayrollSystem removeEmployee(Employee employee) throws EmployeeNotFoundException;

  /**
   * Checks if a specified employee exists in the PayrollSystem.
   *
   * @param employee the employee to check
   * @return true if the employee exists, false otherwise
   */
  boolean containsEmployee(Employee employee);

  /**
   * Finds and returns all employees with annual earnings over the specified threshold.
   *
   * @param threshold the earnings threshold
   * @return an array of employees with annual earnings over the specified threshold
   */
  Employee[] findHighEarningEmployees(double threshold);

  /**
   * Finds and returns all employees with annual earnings over the default threshold.
   *
   * @return an array of employees with annual earnings over the default threshold
   */
  default Employee[] findHighEarningEmployees() {
    return findHighEarningEmployees(HIGH_EARNINGS_THRESHOLD);
  }

  /**
   * Finds and returns all employees with the specified role.
   *
   * @param currentRole the role to search for
   * @return an array of employees with the specified role
   */
  Employee[] findEmployeesByRole(String currentRole);

  /**
   * Finds and returns all employees who joined the company in the specified year.
   *
   * @param year the year to search for
   * @return an array of employees who joined in the specified year
   */
  Employee[] findEmployeesByYearJoined(int year);

  /**
   * Default threshold for high earnings.
   */
  double HIGH_EARNINGS_THRESHOLD = 150000.0;
}
