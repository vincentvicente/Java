package problem1;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Class Dinner stores information about a dinner event. It inherits from class Event, and adds
 * three fields: number of non-vegetarian entrees provided, number of vegetarian entrees provided
 * and number of vegan entrees provided
 */
public class Dinner extends Event {

  private final int nonVegetarian;
  private final int vegetarian;
  private final int vegan;

  /**
   * Constructor for the class Brunch.
   *
   * @param scheduleDate   - LocalDate, representing this dinner event's date using built-in data
   *                       type
   * @param schedulePerson - String, representing the name of the scheduler of this dinner event
   * @param numAttendees   - Int, representing the number of attendees in this dinner event
   */
  public Dinner(LocalDate scheduleDate, String schedulePerson, int numAttendees) {
    super(scheduleDate, schedulePerson, numAttendees);
    if (numAttendees < 15 || numAttendees > 75) {
      throw new IllegalArgumentException(
          "Number of attendees for a dinner event must be between 15 and 75.");
    }
    this.nonVegetarian = Math.round(numAttendees * 0.8f);
    this.vegetarian = Math.round(numAttendees * 0.2f);
    this.vegan = Math.round(numAttendees * 0.05f);
  }

  /**
   * Getter for the number of non-vegetarian entrees provided.
   *
   * @return - nonVegetarian, giving the number of non-vegetarian entrees provided
   **/
  public int getNonVegetarian() {
    return nonVegetarian;
  }

  /**
   * Getter for the number of vegetarian entrees provided.
   *
   * @return - vegetarian, giving the number of vegetarian entrees provided
   **/
  public int getVegetarian() {
    return vegetarian;
  }

  /**
   * Getter for the number of vegan entrees provided.
   *
   * @return - vegan, giving the number of vegan entrees provided
   **/
  public int getVegan() {
    return vegan;
  }

  @Override
  public String toString() {
    return "DinnerEvent{" +
        "scheduleDate=" + scheduleDate +
        ", schedulePerson='" + schedulePerson + '\'' +
        ", numAttendees=" + numAttendees +
        ", non-vegetarian entrees=" + nonVegetarian +
        ", vegetarian entrees=" + vegetarian +
        ", vegan entrees=" + vegan +
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
    Dinner that = (Dinner) o;
    return nonVegetarian == that.nonVegetarian && vegetarian == that.vegetarian
        && vegan == that.vegan;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), nonVegetarian, vegetarian, vegan);
  }


}
