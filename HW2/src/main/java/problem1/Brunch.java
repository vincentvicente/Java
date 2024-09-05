package problem1;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Class Brunch stores information about a brunch event. It inherits from class Event, and adds
 * three fields: number of omelets provided, number of pancakes provided and number of fruit bowls
 * provided
 */
public class Brunch extends Event {

  private final int omelets;
  private final int pancakes;
  private final int fruitBowls;

  /**
   * Constructor for the class Brunch.
   *
   * @param scheduleDate   - LocalDate, representing this brunch event's date using built-in data
   *                       type
   * @param schedulePerson - String, representing the name of the scheduler of this brunch event
   * @param numAttendees   - Int, representing the number of attendees in this brunch event
   */
  public Brunch(LocalDate scheduleDate, String schedulePerson, int numAttendees) {
    super(scheduleDate, schedulePerson, numAttendees);
    if (numAttendees < 10 || numAttendees > 70) {
      throw new IllegalArgumentException(
          "Number of attendees for a brunch event must be between 10 and 70.");
    }
    this.omelets = Math.round(numAttendees * 0.65f);
    this.pancakes = Math.round(numAttendees * 1.5f);
    this.fruitBowls = Math.round(numAttendees * 1.2f);
  }

  /**
   * Getter for the number of omelets provided.
   *
   * @return - omelets, giving the number of omelets provided
   **/
  public int getOmelets() {
    return omelets;
  }

  /**
   * Getter for the number of fruit bowls provided.
   *
   * @return - fruitBowls, giving the number of fruit bowls provided
   **/
  public int getFruitBowls() {
    return fruitBowls;
  }

  /**
   * Getter for the number of pancakes provided.
   *
   * @return - pancakes, giving the number of pancakes provided
   **/
  public int getPancakes() {
    return pancakes;
  }

  @Override
  public String toString() {
    return "BrunchEvent{" +
        "scheduleDate=" + scheduleDate +
        ", schedulePerson='" + schedulePerson + '\'' +
        ", numAttendees=" + numAttendees +
        ", omelets=" + omelets +
        ", pancakes=" + pancakes +
        ", fruitBowls=" + fruitBowls +
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
    Brunch that = (Brunch) o;
    return omelets == that.omelets && pancakes == that.pancakes && fruitBowls == that.fruitBowls;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), omelets, pancakes, fruitBowls);
  }

}
