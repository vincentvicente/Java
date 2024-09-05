package employee_productivity;

import java.time.LocalDate;

/**
 * Class representing an individual contributor in the productivity tracking system.
 */
public class IndividualContributor extends FullTimeEmployee implements EmployeeProductivity {

  private int numberOfPatents;
  private int numberOfPublications;
  private int numberOfExternalCollaborations;

  /**
   * Constructor for the IndividualContributor class.
   *
   * @param ID                             the unique identifier for the employee
   * @param employmentDate                 the date the employee started working at the current
   *                                       company
   * @param contactInfo                    the contact information for the employee
   * @param educationLevel                 the education level of the employee
   * @param employmentLevel                the employment level of the employee
   * @param lastYearEarning                the employee's earnings from last year
   * @param basePay                        the employee's base pay
   * @param bonuses                        the employee's last year earned bonuses
   * @param overTime                       the employee's last year's earnings due to overtime
   *                                       payments
   * @param lastPromotionDate              the date of the employee's last promotion
   * @param numProjects                    the number of projects the employee is working on
   * @param numberOfPatents                the number of patents awarded to the employee while with
   *                                       the company
   * @param numberOfPublications           the number of publications the employee
   *                                       published/presented last year
   * @param numberOfExternalCollaborations the number of external projects the employee is involved
   *                                       in
   */
  public IndividualContributor(String ID, LocalDate employmentDate, ContactInfo contactInfo,
      EducationLevel educationLevel, EmploymentLevel employmentLevel, double lastYearEarning,
      double basePay, double bonuses, double overTime, LocalDate lastPromotionDate,
      Integer numProjects, int numberOfPatents, int numberOfPublications,
      int numberOfExternalCollaborations) {
    super(ID, employmentDate, contactInfo, educationLevel, employmentLevel, lastYearEarning,
        basePay, bonuses, overTime, lastPromotionDate, numProjects);
    this.numberOfPatents = numberOfPatents;
    this.numberOfPublications = numberOfPublications;
    this.numberOfExternalCollaborations = numberOfExternalCollaborations;
  }

  /**
   * Gets the number of patents awarded to the employee while with the company.
   *
   * @return the number of patents
   */
  public int getNumberOfPatents() {
    return numberOfPatents;
  }

  /**
   * Sets the number of patents awarded to the employee while with the company.
   *
   * @param numberOfPatents the number of patents
   */
  public void setNumberOfPatents(int numberOfPatents) {
    this.numberOfPatents = numberOfPatents;
  }

  /**
   * Gets the number of publications the employee published/presented last year.
   *
   * @return the number of publications
   */
  public int getNumberOfPublications() {
    return numberOfPublications;
  }

  /**
   * Sets the number of publications the employee published/presented last year.
   *
   * @param numberOfPublications the number of publications
   */
  public void setNumberOfPublications(int numberOfPublications) {
    this.numberOfPublications = numberOfPublications;
  }

  /**
   * Gets the number of external projects the employee is involved in.
   *
   * @return the number of external collaborations
   */
  public int getNumberOfExternalCollaborations() {
    return numberOfExternalCollaborations;
  }

  /**
   * Sets the number of external projects the employee is involved in.
   *
   * @param numberOfExternalCollaborations the number of external collaborations
   */
  public void setNumberOfExternalCollaborations(int numberOfExternalCollaborations) {
    this.numberOfExternalCollaborations = numberOfExternalCollaborations;
  }

  /**
   * Estimates the productivity of the individual contributor.
   *
   * @return the estimated productivity as a double value
   */
  @Override
  public double estimateProductivity() {
    double baseProductivity = lastYearEarning / basePay;

    if (numProjects > 2) {
      baseProductivity += 1.5;
    }

    if (numberOfPublications > 4) {
      baseProductivity += 1.3;
    }

    if (employmentLevel == EmploymentLevel.INTERMEDIATE_LEVEL) {
      baseProductivity += 1.4;
    }

    if (lastPromotionDate.isBefore(LocalDate.now().minusYears(3))) {
      baseProductivity -= 0.8;
    }

    return baseProductivity;
  }

  @Override
  public String toString() {
    return "IndividualContributor{" + "ID='" + ID + '\'' + ", contactInfo=" + contactInfo
        + ", employmentDate=" + employmentDate + ", educationLevel=" + educationLevel
        + ", employmentLevel=" + employmentLevel + ", lastYearEarning=" + lastYearEarning
        + ", basePay=" + basePay + ", bonuses=" + bonuses + ", overTime=" + overTime
        + ", lastPromotionDate=" + lastPromotionDate + ", numProjects=" + numProjects
        + ", numberOfPatents=" + numberOfPatents + ", numberOfPublications=" + numberOfPublications
        + ", numberOfExternalCollaborations=" + numberOfExternalCollaborations + '}';
  }
}
