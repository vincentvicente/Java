package employee_productivity;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ManagerTest {

  private Manager manager;
  private ContactInfo contactInfo;

  @BeforeEach
  void setUp() {
    contactInfo = new ContactInfo(new Name("Alice", "Brown"), "123 Main St", "555-1234", "alice.brown@example.com", new Name("John", "Smith"));
    manager = new Manager("M001", LocalDate.of(2018, 1, 1), contactInfo, EducationLevel.BACHELOR_DEGREE, EmploymentLevel.MID_LEVEL, 75000, 85000, 12000, 3000, LocalDate.of(2020, 6, 1), 4, 9);
  }

  @Test
  void getID() {
    assertEquals("M001", manager.getID());
  }

  @Test
  void setID() {
    manager.setID("M002");
    assertEquals("M002", manager.getID());
  }

  @Test
  void getContactInfo() {
    assertEquals(contactInfo, manager.getContactInfo());
  }

  @Test
  void setContactInfo() {
    ContactInfo newContactInfo = new ContactInfo(new Name("Bob", "Johnson"), "456 Elm St", "555-5678", "bob.johnson@example.com", new Name("David", "Williams"));
    manager.setContactInfo(newContactInfo);
    assertEquals(newContactInfo, manager.getContactInfo());
  }

  @Test
  void getEducationLevel() {
    assertEquals(EducationLevel.BACHELOR_DEGREE, manager.getEducationLevel());
  }

  @Test
  void setEducationLevel() {
    manager.setEducationLevel(EducationLevel.MASTER_DEGREE);
    assertEquals(EducationLevel.MASTER_DEGREE, manager.getEducationLevel());
  }

  @Test
  void getEmploymentDate() {
    assertEquals(LocalDate.of(2018, 1, 1), manager.getEmploymentDate());
  }

  @Test
  void setEmploymentDate() {
    LocalDate newDate = LocalDate.of(2019, 2, 1);
    manager.setEmploymentDate(newDate);
    assertEquals(newDate, manager.getEmploymentDate());
  }

  @Test
  void getEmploymentLevel() {
    assertEquals(EmploymentLevel.MID_LEVEL, manager.getEmploymentLevel());
  }

  @Test
  void setEmploymentLevel() {
    manager.setEmploymentLevel(EmploymentLevel.SENIOR_LEVEL);
    assertEquals(EmploymentLevel.SENIOR_LEVEL, manager.getEmploymentLevel());
  }

  @Test
  void getLastYearEarning() {
    assertEquals(75000, manager.getLastYearEarning());
  }

  @Test
  void setLastYearEarning() {
    manager.setLastYearEarning(80000);
    assertEquals(80000, manager.getLastYearEarning());
  }

  @Test
  void getNumberOfEmployeesManaged() {
    assertEquals(9, manager.getNumberOfEmployeesManaged());
  }

  @Test
  void setNumberOfEmployeesManaged() {
    manager.setNumberOfEmployeesManaged(11);
    assertEquals(11, manager.getNumberOfEmployeesManaged());
  }

  @Test
  void testEquals() {
    Manager sameManager = new Manager("M001", LocalDate.of(2018, 1, 1), contactInfo, EducationLevel.BACHELOR_DEGREE, EmploymentLevel.MID_LEVEL, 75000, 85000, 12000, 3000, LocalDate.of(2020, 6, 1), 4, 9);
    Manager differentManager = new Manager("M002", LocalDate.of(2018, 1, 1), contactInfo, EducationLevel.BACHELOR_DEGREE, EmploymentLevel.MID_LEVEL, 75000, 85000, 12000, 3000, LocalDate.of(2020, 6, 1), 4, 9);
    assertEquals(manager, sameManager);
    assertNotEquals(manager, differentManager);
  }

  @Test
  void testHashCode() {
    Manager sameManager = new Manager("M001", LocalDate.of(2018, 1, 1), contactInfo, EducationLevel.BACHELOR_DEGREE, EmploymentLevel.MID_LEVEL, 75000, 85000, 12000, 3000, LocalDate.of(2020, 6, 1), 4, 9);
    assertEquals(manager.hashCode(), sameManager.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "Manager{ID='M001', contactInfo=" + contactInfo + ", employmentDate=2018-01-01, educationLevel=BACHELOR_DEGREE, employmentLevel=MID_LEVEL, lastYearEarning=75000.0, basePay=85000.0, bonuses=12000.0, overTime=3000.0, lastPromotionDate=2020-06-01, numProjects=4, numberOfEmployeesManaged=9}";
    assertEquals(expectedString, manager.toString());
  }

  @Test
  void estimateProductivity() {
    double expectedProductivity = 75000 / 85000.0;
    if (manager.getNumProjects() > 2) {
      expectedProductivity += 1.5;
    }
    if (manager.getNumberOfEmployeesManaged() > 8) {
      expectedProductivity += 1.8;
    }
    if (manager.getEmploymentLevel() == EmploymentLevel.INTERMEDIATE_LEVEL) {
      expectedProductivity += 1.4;
    }
    if (manager.getLastPromotionDate().isBefore(LocalDate.now().minusYears(3))) {
      expectedProductivity -= 0.8;
    }
    assertEquals(expectedProductivity, manager.estimateProductivity());
  }
}
