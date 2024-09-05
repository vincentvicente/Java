package employee_productivity;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IndividualContributorTest {

  private IndividualContributor individualContributor;
  private ContactInfo contactInfo;

  @BeforeEach
  void setUp() {
    contactInfo = new ContactInfo(new Name("Samantha", "Lee"), "456 Elm St", "555-5678", "samantha.lee@example.com", new Name("Michael", "Chang"));
    individualContributor = new IndividualContributor("E123", LocalDate.of(2020, 1, 1), contactInfo, EducationLevel.BACHELOR_DEGREE, EmploymentLevel.MID_LEVEL, 50000, 60000, 5000, 2000, LocalDate.of(2021, 6, 1), 3, 5, 5, 2);
  }

  @Test
  void getID() {
    assertEquals("E123", individualContributor.getID());
  }

  @Test
  void setID() {
    individualContributor.setID("E124");
    assertEquals("E124", individualContributor.getID());
  }

  @Test
  void getContactInfo() {
    assertEquals(contactInfo, individualContributor.getContactInfo());
  }

  @Test
  void setContactInfo() {
    ContactInfo newContactInfo = new ContactInfo(new Name("Olivia", "Kim"), "789 Maple Ave", "555-9876", "olivia.kim@example.com", new Name("David", "Nguyen"));
    individualContributor.setContactInfo(newContactInfo);
    assertEquals(newContactInfo, individualContributor.getContactInfo());
  }

  @Test
  void getEducationLevel() {
    assertEquals(EducationLevel.BACHELOR_DEGREE, individualContributor.getEducationLevel());
  }

  @Test
  void setEducationLevel() {
    individualContributor.setEducationLevel(EducationLevel.MASTER_DEGREE);
    assertEquals(EducationLevel.MASTER_DEGREE, individualContributor.getEducationLevel());
  }

  @Test
  void getEmploymentDate() {
    assertEquals(LocalDate.of(2020, 1, 1), individualContributor.getEmploymentDate());
  }

  @Test
  void setEmploymentDate() {
    LocalDate newDate = LocalDate.of(2022, 1, 1);
    individualContributor.setEmploymentDate(newDate);
    assertEquals(newDate, individualContributor.getEmploymentDate());
  }

  @Test
  void getEmploymentLevel() {
    assertEquals(EmploymentLevel.MID_LEVEL, individualContributor.getEmploymentLevel());
  }

  @Test
  void setEmploymentLevel() {
    individualContributor.setEmploymentLevel(EmploymentLevel.SENIOR_LEVEL);
    assertEquals(EmploymentLevel.SENIOR_LEVEL, individualContributor.getEmploymentLevel());
  }

  @Test
  void getLastYearEarning() {
    assertEquals(50000, individualContributor.getLastYearEarning());
  }

  @Test
  void setLastYearEarning() {
    individualContributor.setLastYearEarning(55000);
    assertEquals(55000, individualContributor.getLastYearEarning());
  }

  @Test
  void getNumberOfPatents() {
    assertEquals(5, individualContributor.getNumberOfPatents());
  }

  @Test
  void setNumberOfPatents() {
    individualContributor.setNumberOfPatents(6);
    assertEquals(6, individualContributor.getNumberOfPatents());
  }

  @Test
  void getNumberOfPublications() {
    assertEquals(5, individualContributor.getNumberOfPublications());
  }

  @Test
  void setNumberOfPublications() {
    individualContributor.setNumberOfPublications(6);
    assertEquals(6, individualContributor.getNumberOfPublications());
  }

  @Test
  void getNumberOfExternalCollaborations() {
    assertEquals(2, individualContributor.getNumberOfExternalCollaborations());
  }

  @Test
  void setNumberOfExternalCollaborations() {
    individualContributor.setNumberOfExternalCollaborations(3);
    assertEquals(3, individualContributor.getNumberOfExternalCollaborations());
  }

  @Test
  void testEquals() {
    IndividualContributor sameIndividualContributor = new IndividualContributor("E123", LocalDate.of(2020, 1, 1), contactInfo, EducationLevel.BACHELOR_DEGREE, EmploymentLevel.MID_LEVEL, 50000, 60000, 5000, 2000, LocalDate.of(2021, 6, 1), 3, 5, 5, 2);
    IndividualContributor differentIndividualContributor = new IndividualContributor("E124", LocalDate.of(2020, 1, 1), contactInfo, EducationLevel.BACHELOR_DEGREE, EmploymentLevel.MID_LEVEL, 50000, 60000, 5000, 2000, LocalDate.of(2021, 6, 1), 3, 5, 5, 2);
    assertEquals(individualContributor, sameIndividualContributor);
    assertNotEquals(individualContributor, differentIndividualContributor);
  }

  @Test
  void testHashCode() {
    IndividualContributor sameIndividualContributor = new IndividualContributor("E123", LocalDate.of(2020, 1, 1), contactInfo, EducationLevel.BACHELOR_DEGREE, EmploymentLevel.MID_LEVEL, 50000, 60000, 5000, 2000, LocalDate.of(2021, 6, 1), 3, 5, 5, 2);
    assertEquals(individualContributor.hashCode(), sameIndividualContributor.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "IndividualContributor{ID='E123', contactInfo=" + contactInfo + ", employmentDate=2020-01-01, educationLevel=BACHELOR_DEGREE, employmentLevel=MID_LEVEL, lastYearEarning=50000.0, basePay=60000.0, bonuses=5000.0, overTime=2000.0, lastPromotionDate=2021-06-01, numProjects=3, numberOfPatents=5, numberOfPublications=5, numberOfExternalCollaborations=2}";
    assertEquals(expectedString, individualContributor.toString());
  }

  @Test
  void estimateProductivity() {
    double expectedProductivity = 50000 / 60000.0;
    if (individualContributor.getNumProjects() > 2) {
      expectedProductivity += 1.5;
    }
    if (individualContributor.getNumberOfPublications() > 4) {
      expectedProductivity += 1.3;
    }
    if (individualContributor.getEmploymentLevel() == EmploymentLevel.INTERMEDIATE_LEVEL) {
      expectedProductivity += 1.4;
    }
    if (individualContributor.getLastPromotionDate().isBefore(LocalDate.now().minusYears(3))) {
      expectedProductivity -= 0.8;
    }
    assertEquals(expectedProductivity, individualContributor.estimateProductivity());
  }
}
