package problem2;

/**
 * Represents an empty payroll system.
 */
public class EmptyPayroll implements PayrollSystem {

  @Override
  public boolean isEmpty() {
    return true;
  }

  @Override
  public int countEmployees() {
    return 0;
  }

  @Override
  public PayrollSystem addEmployee(Employee employee) {
    return new NonEmptyPayroll(employee, this);
  }

  @Override
  public PayrollSystem removeEmployee(Employee employee) throws EmployeeNotFoundException {
    throw new EmployeeNotFoundException("Employee not found.");
  }

  @Override
  public boolean containsEmployee(Employee employee) {
    return false;
  }

  @Override
  public Employee[] findHighEarningEmployees(double threshold) {
    return new Employee[0];
  }

  @Override
  public Employee[] findEmployeesByRole(String currentRole) {
    return new Employee[0];
  }

  @Override
  public Employee[] findEmployeesByYearJoined(int year) {
    return new Employee[0];
  }

  @Override
  public boolean equals(Object o) {
    return o instanceof EmptyPayroll;
  }

  @Override
  public int hashCode() {
    return 31;
  }

  @Override
  public String toString() {
    return "EmptyPayroll";
  }
}
