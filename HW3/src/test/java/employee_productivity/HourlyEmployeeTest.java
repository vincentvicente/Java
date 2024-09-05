package employee_productivity;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HourlyEmployeeTest {

  private HourlyEmployee hourlyEmployee;
  private ContactInfo contactInfo;

  @BeforeEach
  void setUp() {
    contactInfo = new ContactInfo(new Name("Jake", "Johnson"), "123 Main St", "555-1234", "jake.johnson@example.com", new Name("Anna", "Smith"));
    hourlyEmployee = new HourlyEmployee("H123", LocalDate.of(2021, 1, 1), contactInfo, EducationLevel.HIGH_SCHOOL_DIPLOMA, EmploymentLevel.ENTRY_LEVEL, 25000, 20, 25, 1000, 13);
  }

  @Test
  void getID() {
    assertEquals("H123", hourlyEmployee.getID());
  }

  @Test
  void setID() {
    hourlyEmployee.setID("H124");
    assertEquals("H124", hourlyEmployee.getID());
  }

  @Test
  void getContactInfo() {
    assertEquals(contactInfo, hourlyEmployee.getContactInfo());
  }

  @Test
  void setContactInfo() {
    ContactInfo newContactInfo = new ContactInfo(new Name("Mia", "Williams"), "456 Elm St", "555-5678", "mia.williams@example.com", new Name("David", "Brown"));
    hourlyEmployee.setContactInfo(newContactInfo);
    assertEquals(newContactInfo, hourlyEmployee.getContactInfo());
  }

  @Test
  void getEducationLevel() {
    assertEquals(EducationLevel.HIGH_SCHOOL_DIPLOMA, hourlyEmployee.getEducationLevel());
  }

  @Test
  void setEducationLevel() {
    hourlyEmployee.setEducationLevel(EducationLevel.SOME_COLLEGE);
    assertEquals(EducationLevel.SOME_COLLEGE, hourlyEmployee.getEducationLevel());
  }

  @Test
  void getEmploymentDate() {
    assertEquals(LocalDate.of(2021, 1, 1), hourlyEmployee.getEmploymentDate());
  }

  @Test
  void setEmploymentDate() {
    LocalDate newDate = LocalDate.of(2020, 1, 1);
    hourlyEmployee.setEmploymentDate(newDate);
    assertEquals(newDate, hourlyEmployee.getEmploymentDate());
  }

  @Test
  void getEmploymentLevel() {
    assertEquals(EmploymentLevel.ENTRY_LEVEL, hourlyEmployee.getEmploymentLevel());
  }

  @Test
  void setEmploymentLevel() {
    hourlyEmployee.setEmploymentLevel(EmploymentLevel.INTERMEDIATE_LEVEL);
    assertEquals(EmploymentLevel.INTERMEDIATE_LEVEL, hourlyEmployee.getEmploymentLevel());
  }

  @Test
  void getLastYearEarning() {
    assertEquals(25000, hourlyEmployee.getLastYearEarning());
  }

  @Test
  void setLastYearEarning() {
    hourlyEmployee.setLastYearEarning(26000);
    assertEquals(26000, hourlyEmployee.getLastYearEarning());
  }

  @Test
  void getContractualNumHours() {
    assertEquals(20, hourlyEmployee.getContractualNumHours());
  }

  @Test
  void setContractualNumHours() {
    hourlyEmployee.setContractualNumHours(25);
    assertEquals(25, hourlyEmployee.getContractualNumHours());
  }

  @Test
  void getActualHours() {
    assertEquals(25, hourlyEmployee.getActualHours());
  }

  @Test
  void setActualHours() {
    hourlyEmployee.setActualHours(30);
    assertEquals(30, hourlyEmployee.getActualHours());
  }

  @Test
  void getExtra() {
    assertEquals(1000, hourlyEmployee.getExtra());
  }

  @Test
  void setExtra() {
    hourlyEmployee.setExtra(1500);
    assertEquals(1500, hourlyEmployee.getExtra());
  }

  @Test
  void getHourlyEarnings() {
    assertEquals(13, hourlyEmployee.getHourlyEarnings());
  }

  @Test
  void setHourlyEarnings() {
    hourlyEmployee.setHourlyEarnings(15);
    assertEquals(15, hourlyEmployee.getHourlyEarnings());
  }

  @Test
  void testEquals() {
    HourlyEmployee sameEmployee = new HourlyEmployee("H123", LocalDate.of(2021, 1, 1), contactInfo, EducationLevel.HIGH_SCHOOL_DIPLOMA, EmploymentLevel.ENTRY_LEVEL, 25000, 20, 25, 1000, 13);
    HourlyEmployee differentEmployee = new HourlyEmployee("H124", LocalDate.of(2021, 1, 1), contactInfo, EducationLevel.HIGH_SCHOOL_DIPLOMA, EmploymentLevel.ENTRY_LEVEL, 25000, 20, 25, 1000, 13);
    assertEquals(hourlyEmployee, sameEmployee);
    assertNotEquals(hourlyEmployee, differentEmployee);
  }

  @Test
  void testHashCode() {
    HourlyEmployee sameEmployee = new HourlyEmployee("H123", LocalDate.of(2021, 1, 1), contactInfo, EducationLevel.HIGH_SCHOOL_DIPLOMA, EmploymentLevel.ENTRY_LEVEL, 25000, 20, 25, 1000, 13);
    assertEquals(hourlyEmployee.hashCode(), sameEmployee.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "HourlyEmployee{ID='H123', contactInfo=" + contactInfo + ", employmentDate=2021-01-01, educationLevel=HIGH_SCHOOL_DIPLOMA, employmentLevel=ENTRY_LEVEL, lastYearEarning=25000.0, contractualNumHours=20.0, actualHours=25.0, extra=1000.0, hourlyEarnings=13.0}";
    assertEquals(expectedString, hourlyEmployee.toString());
  }

  @Test
  void estimateProductivity() {
    double expectedProductivity = (25.0 / 20.0) * 3.7;

    if (hourlyEmployee.getHourlyEarnings() < 14) {
      expectedProductivity += 3.0;
    }

    expectedProductivity = hourlyEmployee.applyEmploymentLevelBonus(hourlyEmployee.getEmploymentLevel(), expectedProductivity);
    assertEquals(expectedProductivity, hourlyEmployee.estimateProductivity());
  }
}
