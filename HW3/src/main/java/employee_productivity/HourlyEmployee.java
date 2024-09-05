package employee_productivity;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Class representing an hourly employee in the productivity tracking system.
 */
public class HourlyEmployee extends PartTimeEmployee implements EmployeeProductivity {

  private double hourlyEarnings;

  /**
   * Constructor for the HourlyEmployee class.
   *
   * @param ID                  the unique identifier for the employee
   * @param employmentDate      the date the employee started working at the current company
   * @param contactInfo         the contact information for the employee
   * @param educationLevel      the education level of the employee
   * @param employmentLevel     the employment level of the employee
   * @param lastYearEarning     the employee's earnings from last year
   * @param contractualNumHours the contractual number of hours the part-time employee is expected
   *                            to work
   * @param actualHours         the actual number of hours the part-time employee worked
   * @param extra               the extra earnings from bonuses and overtime
   * @param hourlyEarnings      the contractual hourly earnings
   */
  public HourlyEmployee(String ID, LocalDate employmentDate, ContactInfo contactInfo,
      EducationLevel educationLevel, EmploymentLevel employmentLevel,
      double lastYearEarning, double contractualNumHours, double actualHours, double extra,
      double hourlyEarnings) {
    super(ID, employmentDate, contactInfo, educationLevel, employmentLevel, lastYearEarning,
        contractualNumHours, actualHours, extra);
    this.hourlyEarnings = hourlyEarnings;
  }

  /**
   * Gets the contractual hourly earnings.
   *
   * @return the hourly earnings
   */
  public double getHourlyEarnings() {
    return hourlyEarnings;
  }

  /**
   * Sets the contractual hourly earnings.
   *
   * @param hourlyEarnings the hourly earnings
   */
  public void setHourlyEarnings(double hourlyEarnings) {
    this.hourlyEarnings = hourlyEarnings;
  }

  /**
   * Estimates the productivity of the hourly employee.
   *
   * @return the estimated productivity as a double value
   */
  @Override
  public double estimateProductivity() {
    double baseProductivity = (actualHours / contractualNumHours) * 3.7;

    if (hourlyEarnings < 14) {
      baseProductivity += 3.0;
    }

    return applyEmploymentLevelBonus(employmentLevel, baseProductivity);
  }

  @Override
  public String toString() {
    return "HourlyEmployee{" +
        "ID='" + ID + '\'' +
        ", contactInfo=" + contactInfo +
        ", employmentDate=" + employmentDate +
        ", educationLevel=" + educationLevel +
        ", employmentLevel=" + employmentLevel +
        ", lastYearEarning=" + lastYearEarning +
        ", contractualNumHours=" + contractualNumHours +
        ", actualHours=" + actualHours +
        ", extra=" + extra +
        ", hourlyEarnings=" + hourlyEarnings +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    HourlyEmployee that = (HourlyEmployee) o;
    return Double.compare(hourlyEarnings, that.hourlyEarnings) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), hourlyEarnings);
  }
}
///**
// * [Description of what the method does].
// *
// * @param [paramName] [description of the parameter]
// * @param [paramName] [description of the parameter]
// * @return [description of the return value]
// * @throws [ExceptionType] [description of the condition that causes the exception]
// */
//public [returnType] [methodName]([parameters]) throws [ExceptionType] {
//    // method implementation
// * @throws IllegalArgumentException if the file path is null or empty.
// */
//    }


//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//@Test
//void testMethod() {
//    assertThrows(ExpectedException.class, () -> {
//        // Code that should throw the exception
//    });
//}

