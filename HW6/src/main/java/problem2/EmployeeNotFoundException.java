package problem2;

/**
 * Exception thrown when an employee is not found in the payroll system.
 */
public class EmployeeNotFoundException extends Exception {
  public EmployeeNotFoundException(String message) {
    super(message);
  }
}
