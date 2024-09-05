package problem1;

import java.util.Objects;

/**
 * Class BaseballPlayer stores information about a baseball player. It inherits from class Athlete,
 * and adds three fields: team, average batting score and season home runs.
 */
public class BaseballPlayer extends Athlete {

  private String team;
  private Double avgBattingScore;
  private Integer seasonHomeRuns;

  /**
   * Constructor for BaseballPlayer.
   *
   * @param athletesName    baseball player's name, as Name.
   * @param height          baseball player's height in cm, as Double.
   * @param weight          baseball player's weight in kg, as Double.
   * @param league          player's league, as String.
   * @param team            player's team, as String.
   * @param avgBattingScore player's average batting score, as Double.
   * @param seasonHomeRuns  number of season home runs, as Integer.
   */
  public BaseballPlayer(Name athletesName, Double height, Double weight, String league, String team,
      Double avgBattingScore, Integer seasonHomeRuns) {
    super(athletesName, height, weight, league);
    this.team = team;
    this.avgBattingScore = avgBattingScore;
    this.seasonHomeRuns = seasonHomeRuns;
  }

  /**
   * Constructor for BaseballPlayer.
   *
   * @param athletesName    baseball player's name, as Name.
   * @param height          baseball player's height in cm, as Double.
   * @param weight          baseball player's weight in kg, as Double.
   * @param team            player's team, as String.
   * @param avgBattingScore player's average batting score, as Double.
   * @param seasonHomeRuns  number of season home runs, as Integer.
   */
  public BaseballPlayer(Name athletesName, Double height, Double weight, String team,
      Double avgBattingScore, Integer seasonHomeRuns) {
    super(athletesName, height, weight);
    this.team = team;
    this.avgBattingScore = avgBattingScore;
    this.seasonHomeRuns = seasonHomeRuns;
  }

  /**
   * Getter for team.
   *
   * @return team, as String.
   */
  public String getTeam() {
    return team;
  }

  /**
   * Getter for average batting score.
   *
   * @return average batting score, as Double.
   */
  public Double getAvgBattingScore() {
    return avgBattingScore;
  }

  /**
   * Getter for season home runs.
   *
   * @return number of home runs, as Integer.
   */
  public Integer getSeasonHomeRuns() {
    return seasonHomeRuns;
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
    BaseballPlayer that = (BaseballPlayer) o;
    return Objects.equals(team, that.team) && Objects.equals(avgBattingScore, that.avgBattingScore)
        && Objects.equals(seasonHomeRuns, that.seasonHomeRuns);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), team, avgBattingScore, seasonHomeRuns);
  }

  @Override
  public String toString() {
    return "BaseballPlayer{" +
        "team='" + team + '\'' +
        ", avgBattingScore=" + avgBattingScore +
        ", seasonHomeRuns=" + seasonHomeRuns +
        ", athletesName=" + athletesName +
        ", height=" + height +
        ", weight=" + weight +
        ", league='" + league + '\'' +
        '}';
  }
}
