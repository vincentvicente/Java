package problem1;

import java.util.Objects;

/**
 * Class Runner stores information about a runner. It inherits from Athlete, and adds three new
 * fields: best 5K running time, best half-marathon running time, and favorite running event.
 */
public class Runner extends Athlete {

  private Double best5KRunTime;
  private Double bestHalfMarathonRunTime;
  private String favoriteRunningEvent;

  /**
   * Constructor for runner.
   *
   * @param athletesName            runner's name, stored as Name
   * @param height                  runner's height in cm, stored as Double
   * @param weight                  runner's weight in kg, stored as Double
   * @param league                  runner's league, as String
   * @param best5KRunTime           runner's best 5k running time, as Double
   * @param bestHalfMarathonRunTime best half-marathon running time, as Double
   * @param favoriteRunningEvent    favorite running event, as String
   */
  public Runner(Name athletesName, Double height, Double weight, String league,
      Double best5KRunTime,
      Double bestHalfMarathonRunTime, String favoriteRunningEvent) {
    super(athletesName, height, weight, league);
    this.best5KRunTime = best5KRunTime;
    this.bestHalfMarathonRunTime = bestHalfMarathonRunTime;
    this.favoriteRunningEvent = favoriteRunningEvent;
  }

  /**
   * Constructor for runner.
   *
   * @param athletesName            runner's name, stored as Name
   * @param height                  runner's height in cm, stored as Double
   * @param weight                  runner's weight in kg, stored as Double
   * @param best5KRunTime           runner's best 5k running time, as Double
   * @param bestHalfMarathonRunTime best half-marathon running time, as Double
   * @param favoriteRunningEvent    favorite running event, as String
   */
  public Runner(Name athletesName, Double height, Double weight, Double best5KRunTime,
      Double bestHalfMarathonRunTime, String favoriteRunningEvent) {
    super(athletesName, height, weight);
    this.best5KRunTime = best5KRunTime;
    this.bestHalfMarathonRunTime = bestHalfMarathonRunTime;
    this.favoriteRunningEvent = favoriteRunningEvent;
  }

  /**
   * Getter for best 5k running time.
   *
   * @return best 5k running time, as Double.
   */
  public Double getBest5KRunTime() {
    return best5KRunTime;
  }

  /**
   * Getter for best half-marathon time.
   *
   * @return best half-marathon time, as Double.
   */
  public Double getBestHalfMarathonRunTime() {
    return bestHalfMarathonRunTime;
  }

  /**
   * Getter for favorite running event.
   *
   * @return favorite running event, as String.
   */
  public String getFavoriteRunningEvent() {
    return favoriteRunningEvent;
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
    Runner runner = (Runner) o;
    return Objects.equals(best5KRunTime, runner.best5KRunTime) && Objects.equals(
        bestHalfMarathonRunTime, runner.bestHalfMarathonRunTime) && Objects.equals(
        favoriteRunningEvent, runner.favoriteRunningEvent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), best5KRunTime, bestHalfMarathonRunTime,
        favoriteRunningEvent);
  }

  @Override
  public String toString() {
    return "Runner{" +
        "best5KRunTime=" + best5KRunTime +
        ", bestHalfMarathonRunTime=" + bestHalfMarathonRunTime +
        ", favoriteRunningEvent='" + favoriteRunningEvent + '\'' +
        ", athletesName=" + athletesName +
        ", height=" + height +
        ", weight=" + weight +
        ", league='" + league + '\'' +
        '}';
  }
}
