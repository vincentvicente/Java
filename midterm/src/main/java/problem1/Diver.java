package problem1;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Class Diver extends from WaterAthlete, and stores information about a diver.
 */
public class Diver extends WaterAthlete {

  private String favoriteDivingLocation;
  private LocalDate dateOfDivingCertification;

  /**
   * Constructor
   * @param athletesName diver's name, as Name
   * @param dateOfBirth diver's date of birth, as LocalDate
   * @param height diver's height in centimeters, as Double
   * @param weight diver's weight in kilograms, as Double
   * @param favoriteDivingLocation diver's favorite diving location, as String
   * @param dateOfDivingCertification last date of diver's diving certification, as LocalDate
   * @throws InvalidAthleteInformationException exception thrown if invalid information about
   * diver's height and weight is provided
   */
  public Diver(Name athletesName, LocalDate dateOfBirth, Double height, Double weight,
      String favoriteDivingLocation, LocalDate dateOfDivingCertification)
      throws InvalidAthleteInformationException {
    super(athletesName, dateOfBirth, height, weight);
    this.favoriteDivingLocation = favoriteDivingLocation;
    this.dateOfDivingCertification = dateOfDivingCertification;
  }

  /**
   * Getter for diver's favorite diving location.
   * @return diver's favorite diving location, as String
   */
  public String getFavoriteDivingLocation() {
    return favoriteDivingLocation;
  }

  /**
   * Getter for the date of diver's last diving certification.
   * @return the date of diver's last diving certification, as LocalDate
   */
  public LocalDate getDateOfDivingCertification() {
    return dateOfDivingCertification;
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
    Diver diver = (Diver) o;
    return Objects.equals(favoriteDivingLocation, diver.favoriteDivingLocation)
        && Objects.equals(dateOfDivingCertification, diver.dateOfDivingCertification);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), favoriteDivingLocation, dateOfDivingCertification);
  }

  @Override
  public String toString() {
    return "Diver{" +
        "favoriteDivingLocation='" + favoriteDivingLocation + '\'' +
        ", dateOfDivingCertification=" + dateOfDivingCertification +
        ", athletesName=" + athletesName +
        ", dateOfBirth=" + dateOfBirth +
        ", height=" + height +
        ", weight=" + weight +
        '}';
  }
}
