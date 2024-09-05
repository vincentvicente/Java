package problem1;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Class Swimmer extends a class WaterAthlete, and stores information about a Swimmer.
 */
public class Swimmer extends WaterAthlete{

  private String favoriteSwimmingStroke;
  private Double bestSwimTime;


  /**
   * Constructor
   * @param athletesName swimmer's name, as object Name
   * @param dateOfBirth swimmer's date of birth, as LocalDate
   * @param height swimmer's height in centimeters, as Double
   * @param weight swimmer's weight in kilograms, as Double
   * @param favoriteSwimmingStroke swimmer's favorite stroke, as String
   * @param bestSwimTime swimmer's best 50m swim time in favorite stroke, measured in milliseconds,
   *                     as Double
   * @throws InvalidAthleteInformationException exception thrown if invalid height and weight
   * information is provided
   */
  public Swimmer(Name athletesName, LocalDate dateOfBirth, Double height, Double weight,
      String favoriteSwimmingStroke, Double bestSwimTime)
      throws InvalidAthleteInformationException {
    super(athletesName, dateOfBirth, height, weight);
    this.favoriteSwimmingStroke = favoriteSwimmingStroke;
    this.bestSwimTime = bestSwimTime;
  }

  /**
   * Getter for swimmer's favorite swimming stroke.
   * @return favorite swimming stroke, as String
   */
  public String getFavoriteSwimmingStroke() {
    return favoriteSwimmingStroke;
  }

  /**
   * Getter for swimmer's best 50m swim time in favorite stroke, measured in milliseconds.
   * @return swimmer's best 50m swim time in favorite stroke, measured in milliseconds. as Double
   */
  public Double getBestSwimTime() {
    return bestSwimTime;
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
    Swimmer swimmer = (Swimmer) o;
    return Objects.equals(favoriteSwimmingStroke, swimmer.favoriteSwimmingStroke)
        && Objects.equals(bestSwimTime, swimmer.bestSwimTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), favoriteSwimmingStroke, bestSwimTime);
  }

  @Override
  public String toString() {
    return "Swimmer{" +
        "favoriteSwimmingStroke='" + favoriteSwimmingStroke + '\'' +
        ", bestSwimTime=" + bestSwimTime +
        ", athletesName=" + athletesName +
        ", dateOfBirth=" + dateOfBirth +
        ", height=" + height +
        ", weight=" + weight +
        '}';
  }
}

