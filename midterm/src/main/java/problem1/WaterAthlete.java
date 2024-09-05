package problem1;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Class WaterAthlete stores information about a water athlete, such as a swimmer. The information
 * includes athlete's name, their date of birth, their height in centimeters (cm) and their weight in
 * kilograms (kg).
 */
public class WaterAthlete {

  private static final Double HEIGHT_LIMIT = 150.0;
  private static final Double WEIGHT_MIN = 35.0;
  private static final Double WEIGHT_MAX = 125.0;
  protected Name athletesName;
  protected LocalDate dateOfBirth;
  protected Double height;
  protected Double weight;

  /**
   * Constructor
   * @param athletesName athlete's name, represented as object Name
   * @param dateOfBirth athlete's date of birth, represented as LocalDate
   * @param height athlete's height in centimeters, represented as Double
   * @param weight athlete's weight in kilograms, represented as Double
   * @throws InvalidAthleteInformationException exception thrown if the provided weight is outside
   * of the weight lower and upper bounds, or if the provided height is greater than the upper limit
   */
  public WaterAthlete(Name athletesName, LocalDate dateOfBirth, Double height, Double weight)
      throws InvalidAthleteInformationException {
    if(this.validateHeight(height) && this.validateWeight(weight)) {
      this.athletesName = athletesName;
      this.dateOfBirth = dateOfBirth;
      this.height = height;
      this.weight = weight;
    }

  }

  private Boolean validateWeight(Double weight) throws InvalidAthleteInformationException {
    if ((WEIGHT_MIN < weight) && (weight <= WEIGHT_MAX))
      return Boolean.TRUE;
    else throw new InvalidAthleteInformationException("This is not a valid weight for this sports discipline!");
  }

  private Boolean validateHeight(Double height) throws InvalidAthleteInformationException{
    if (height >= HEIGHT_LIMIT)
      return Boolean.TRUE;
    else throw new InvalidAthleteInformationException("This is not a valid height for this sports discipline!");
  }

  /**
   * Getter for athlete's name
   * @return athlete's name, as Name
   */
  public Name getAthletesName() {
    return athletesName;
  }

  /**
   * Getter for athlete's date of birth
   * @return athlete's date of birth, as LocalDate
   */
  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  /**
   * Getter for athlete's height
   * @return athlete's height in centimeters, as Double
   */
  public Double getHeight() {
    return height;
  }

  /**
   * Getter for athlete's weight
   * @return athlete's weight in kilograms, as Double
   */
  public Double getWeight() {
    return weight;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WaterAthlete that = (WaterAthlete) o;
    return Objects.equals(athletesName, that.athletesName) && Objects.equals(
        dateOfBirth, that.dateOfBirth) && Objects.equals(height, that.height)
        && Objects.equals(weight, that.weight);
  }

  @Override
  public int hashCode() {
    return Objects.hash(athletesName, dateOfBirth, height, weight);
  }

  @Override
  public String toString() {
    return "WaterAthlete{" +
        "athletesName=" + athletesName +
        ", dateOfBirth=" + dateOfBirth +
        ", height=" + height +
        ", weight=" + weight +
        '}';
  }

}
