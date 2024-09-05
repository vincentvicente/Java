package problem2;

import java.util.Arrays;

/**
 * Represents a non-empty payroll system.
 */
public class NonEmptyPayroll implements PayrollSystem {

  private final Employee employee;
  private final PayrollSystem next;

  public NonEmptyPayroll(Employee employee, PayrollSystem next) {
    this.employee = employee;
    this.next = next;
  }

  @Override
  public boolean isEmpty() {
    return false;
  }

  @Override
  public int countEmployees() {
    return 1 + next.countEmployees();
  }

  @Override
  public PayrollSystem addEmployee(Employee newEmployee) {
    if (employee.equals(newEmployee)) {
      return new NonEmptyPayroll(newEmployee, next);
    }
    return new NonEmptyPayroll(employee, next.addEmployee(newEmployee));
  }

  @Override
  public PayrollSystem removeEmployee(Employee employee) throws EmployeeNotFoundException {
    if (this.employee.equals(employee)) {
      return next;
    }
    return new NonEmptyPayroll(this.employee, next.removeEmployee(employee));
  }

  @Override
  public boolean containsEmployee(Employee employee) {
    return this.employee.equals(employee) || next.containsEmployee(employee);
  }

  @Override
  public Employee[] findHighEarningEmployees(double threshold) {
    Employee[] nextHighEarners = next.findHighEarningEmployees(threshold);
    if (employee.getAnnualEarnings() > threshold) {
      Employee[] result = new Employee[nextHighEarners.length + 1];
      result[0] = employee;
      System.arraycopy(nextHighEarners, 0, result, 1, nextHighEarners.length);
      return result;
    }
    return nextHighEarners;
  }

  @Override
  public Employee[] findEmployeesByRole(String currentRole) {
    Employee[] nextRoleEmployees = next.findEmployeesByRole(currentRole);
    if (employee.getCurrentRole().equals(currentRole)) {
      Employee[] result = new Employee[nextRoleEmployees.length + 1];
      result[0] = employee;
      System.arraycopy(nextRoleEmployees, 0, result, 1, nextRoleEmployees.length);
      return result;
    }
    return nextRoleEmployees;
  }

  @Override
  public Employee[] findEmployeesByYearJoined(int year) {
    Employee[] nextYearEmployees = next.findEmployeesByYearJoined(year);
    if (employee.getYearJoinedCompany().equals(year)) {
      Employee[] result = new Employee[nextYearEmployees.length + 1];
      result[0] = employee;
      System.arraycopy(nextYearEmployees, 0, result, 1, nextYearEmployees.length);
      return result;
    }
    return nextYearEmployees;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof NonEmptyPayroll)) return false;
    NonEmptyPayroll that = (NonEmptyPayroll) o;
    return employee.equals(that.employee) && next.equals(that.next);
  }

  @Override
  public int hashCode() {
    return 31 * employee.hashCode() + next.hashCode();
  }

  @Override
  public String toString() {
    return "NonEmptyPayroll{" +
        "employee=" + employee +
        ", next=" + next +
        '}';
  }
}
