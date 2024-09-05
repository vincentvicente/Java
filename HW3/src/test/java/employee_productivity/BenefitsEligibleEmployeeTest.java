package employee_productivity;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BenefitsEligibleEmployeeTest {

  private BenefitsEligibleEmployee benefitsEligibleEmployee;
  private ContactInfo contactInfo;

  @BeforeEach
  void setUp() {
    contactInfo = new ContactInfo(new Name("Alex", "Green"), "789 Birch St", "555-7890",
        "alex.green@example.com", new Name("Susan", "White"));
    benefitsEligibleEmployee = new BenefitsEligibleEmployee("B123", LocalDate.of(2021, 1, 1),
        contactInfo, EducationLevel.ASSOCIATE_DEGREE, EmploymentLevel.ENTRY_LEVEL, 30000, 20, 22,
        1500);
  }

  @Test
  void getID() {
    assertEquals("B123", benefitsEligibleEmployee.getID());
  }

  @Test
  void setID() {
    benefitsEligibleEmployee.setID("B124");
    assertEquals("B124", benefitsEligibleEmployee.getID());
  }

  @Test
  void getContactInfo() {
    assertEquals(contactInfo, benefitsEligibleEmployee.getContactInfo());
  }

  @Test
  void setContactInfo() {
    ContactInfo newContactInfo = new ContactInfo(new Name("Brian", "Adams"), "123 Oak St",
        "555-3210", "brian.adams@example.com", new Name("Emily", "Davis"));
    benefitsEligibleEmployee.setContactInfo(newContactInfo);
    assertEquals(newContactInfo, benefitsEligibleEmployee.getContactInfo());
  }

  @Test
  void getEducationLevel() {
    assertEquals(EducationLevel.ASSOCIATE_DEGREE, benefitsEligibleEmployee.getEducationLevel());
  }

  @Test
  void setEducationLevel() {
    benefitsEligibleEmployee.setEducationLevel(EducationLevel.BACHELOR_DEGREE);
    assertEquals(EducationLevel.BACHELOR_DEGREE, benefitsEligibleEmployee.getEducationLevel());
  }

  @Test
  void getEmploymentDate() {
    assertEquals(LocalDate.of(2021, 1, 1), benefitsEligibleEmployee.getEmploymentDate());
  }

  @Test
  void setEmploymentDate() {
    LocalDate newDate = LocalDate.of(2020, 1, 1);
    benefitsEligibleEmployee.setEmploymentDate(newDate);
    assertEquals(newDate, benefitsEligibleEmployee.getEmploymentDate());
  }

  @Test
  void getEmploymentLevel() {
    assertEquals(EmploymentLevel.ENTRY_LEVEL, benefitsEligibleEmployee.getEmploymentLevel());
  }

  @Test
  void setEmploymentLevel() {
    benefitsEligibleEmployee.setEmploymentLevel(EmploymentLevel.MID_LEVEL);
    assertEquals(EmploymentLevel.MID_LEVEL, benefitsEligibleEmployee.getEmploymentLevel());
  }

  @Test
  void getLastYearEarning() {
    assertEquals(30000, benefitsEligibleEmployee.getLastYearEarning());
  }

  @Test
  void setLastYearEarning() {
    benefitsEligibleEmployee.setLastYearEarning(35000);
    assertEquals(35000, benefitsEligibleEmployee.getLastYearEarning());
  }

  @Test
  void getContractualNumHours() {
    assertEquals(20, benefitsEligibleEmployee.getContractualNumHours());
  }

  @Test
  void setContractualNumHours() {
    benefitsEligibleEmployee.setContractualNumHours(25);
    assertEquals(25, benefitsEligibleEmployee.getContractualNumHours());
  }

  @Test
  void getActualHours() {
    assertEquals(22, benefitsEligibleEmployee.getActualHours());
  }

  @Test
  void setActualHours() {
    benefitsEligibleEmployee.setActualHours(26);
    assertEquals(26, benefitsEligibleEmployee.getActualHours());
  }

  @Test
  void getExtra() {
    assertEquals(1500, benefitsEligibleEmployee.getExtra());
  }

  @Test
  void setExtra() {
    benefitsEligibleEmployee.setExtra(2000);
    assertEquals(2000, benefitsEligibleEmployee.getExtra());
  }

  @Test
  void testEquals() {
    BenefitsEligibleEmployee sameEmployee = new BenefitsEligibleEmployee("B123",
        LocalDate.of(2021, 1, 1), contactInfo, EducationLevel.ASSOCIATE_DEGREE,
        EmploymentLevel.ENTRY_LEVEL, 30000, 20, 22, 1500);
    BenefitsEligibleEmployee differentEmployee = new BenefitsEligibleEmployee("B124",
        LocalDate.of(2021, 1, 1), contactInfo, EducationLevel.ASSOCIATE_DEGREE,
        EmploymentLevel.ENTRY_LEVEL, 30000, 20, 22, 1500);
    assertEquals(benefitsEligibleEmployee, sameEmployee);
    assertNotEquals(benefitsEligibleEmployee, differentEmployee);
  }

  @Test
  void testHashCode() {
    BenefitsEligibleEmployee sameEmployee = new BenefitsEligibleEmployee("B123",
        LocalDate.of(2021, 1, 1), contactInfo, EducationLevel.ASSOCIATE_DEGREE,
        EmploymentLevel.ENTRY_LEVEL, 30000, 20, 22, 1500);
    assertEquals(benefitsEligibleEmployee.hashCode(), sameEmployee.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "BenefitsEligibleEmployee{ID='B123', contactInfo=" + contactInfo
        + ", employmentDate=2021-01-01, educationLevel=ASSOCIATE_DEGREE, employmentLevel=ENTRY_LEVEL, lastYearEarning=30000.0, contractualNumHours=20.0, actualHours=22.0, extra=1500.0}";
    assertEquals(expectedString, benefitsEligibleEmployee.toString());
  }

  @Test
  void estimateProductivity() {
    double expectedProductivity = (22.0 / 20.0) * 3.7;
    expectedProductivity = benefitsEligibleEmployee.applyEmploymentLevelBonus(
        EmploymentLevel.ENTRY_LEVEL, expectedProductivity);
    assertEquals(expectedProductivity, benefitsEligibleEmployee.estimateProductivity());
  }
}
