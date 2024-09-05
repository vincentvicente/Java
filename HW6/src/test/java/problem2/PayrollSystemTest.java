package problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;

class PayrollSystemTest {

  private PayrollSystem payrollSystem;
  private Employee employee1;
  private Employee employee2;
  private Employee employee3;

  @BeforeEach
  void setUp() {
    payrollSystem = new EmptyPayroll();
    employee1 = new Employee(new Name("Michael", "Jordan", "Smith"), new ContactInfo("123 Main St", "Springfield", "IL", "62704", "555-1234", "michael@example.com"), LocalDate.of(1985, 5, 15), "E001", 2010, "Manager", 2018, 160000.0);
    employee2 = new Employee(new Name("Sarah", "Connor", "Doe"), new ContactInfo("456 Elm St", "Springfield", "IL", "62704", "555-5678", "sarah@example.com"), LocalDate.of(1990, 7, 20), "E002", 2015, "Developer", 2020, 120000.0);
    employee3 = new Employee(new Name("James", "Bond", "Wong"), new ContactInfo("789 Pine St", "Springfield", "IL", "62704", "555-8765", "james@example.com"), LocalDate.of(1988, 10, 10), "E003", 2012, "Developer", 2019, 170000.0);
  }

  @Test
  void isEmpty() {
    assertTrue(payrollSystem.isEmpty());
    payrollSystem = payrollSystem.addEmployee(employee1);
    assertFalse(payrollSystem.isEmpty());
  }

  @Test
  void countEmployees() {
    assertEquals(0, payrollSystem.countEmployees());
    payrollSystem = payrollSystem.addEmployee(employee1);
    assertEquals(1, payrollSystem.countEmployees());
    payrollSystem = payrollSystem.addEmployee(employee2);
    assertEquals(2, payrollSystem.countEmployees());
  }

  @Test
  void addEmployee() {
    payrollSystem = payrollSystem.addEmployee(employee1);
    assertEquals(1, payrollSystem.countEmployees());
    payrollSystem = payrollSystem.addEmployee(employee1); // Duplicate, should not increase count
    assertEquals(1, payrollSystem.countEmployees());
    payrollSystem = payrollSystem.addEmployee(employee2);
    assertEquals(2, payrollSystem.countEmployees());
  }

  @Test
  void removeEmployee() throws EmployeeNotFoundException {
    payrollSystem = payrollSystem.addEmployee(employee1);
    payrollSystem = payrollSystem.addEmployee(employee2);
    assertEquals(2, payrollSystem.countEmployees());
    payrollSystem = payrollSystem.removeEmployee(employee1);
    assertEquals(1, payrollSystem.countEmployees());
    assertFalse(payrollSystem.containsEmployee(employee1));
    assertThrows(EmployeeNotFoundException.class, () -> payrollSystem.removeEmployee(employee1));
  }

  @Test
  void containsEmployee() throws EmployeeNotFoundException {
    assertFalse(payrollSystem.containsEmployee(employee1));
    payrollSystem = payrollSystem.addEmployee(employee1);
    assertTrue(payrollSystem.containsEmployee(employee1));
    payrollSystem = payrollSystem.removeEmployee(employee1);
    assertFalse(payrollSystem.containsEmployee(employee1));
  }

  @Test
  void findHighEarningEmployees() {
    payrollSystem = payrollSystem.addEmployee(employee1);
    payrollSystem = payrollSystem.addEmployee(employee2);
    payrollSystem = payrollSystem.addEmployee(employee3);
    Employee[] highEarners = payrollSystem.findHighEarningEmployees(PayrollSystem.HIGH_EARNINGS_THRESHOLD);
    assertEquals(2, highEarners.length);
    assertTrue(Arrays.asList(highEarners).contains(employee1));
    assertTrue(Arrays.asList(highEarners).contains(employee3));
  }

  @Test
  void findEmployeesByRole() {
    payrollSystem = payrollSystem.addEmployee(employee1);
    payrollSystem = payrollSystem.addEmployee(employee2);
    payrollSystem = payrollSystem.addEmployee(employee3);
    Employee[] developers = payrollSystem.findEmployeesByRole("Developer");
    assertEquals(2, developers.length);
    assertTrue(Arrays.asList(developers).contains(employee2));
    assertTrue(Arrays.asList(developers).contains(employee3));
  }

  @Test
  void findEmployeesByYearJoined() {
    payrollSystem = payrollSystem.addEmployee(employee1);
    payrollSystem = payrollSystem.addEmployee(employee2);
    payrollSystem = payrollSystem.addEmployee(employee3);
    Employee[] joined2015 = payrollSystem.findEmployeesByYearJoined(2015);
    assertEquals(1, joined2015.length);
    assertTrue(Arrays.asList(joined2015).contains(employee2));
  }
}
