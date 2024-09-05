package problem1;

import java.time.LocalDate;
import java.util.Optional;

/**
 * Schedule class tracks the events booked for each meal on a single day.
 */
public class Schedule {
  private Brunch brunchEvent;
  private Dinner dinnerEvent;
  /**
   * Method for booking a brunch event.
   *
   * @param scheduleDate   - LocalDate, representing the date of the brunch event
   * @param schedulePerson - String, representing the name of the scheduler
   * @param numAttendees   - int, representing the number of attendees
   * @throws IllegalArgumentException if a brunch event is already booked for the given date
   */
  public void bookBrunch(LocalDate scheduleDate, String schedulePerson, int numAttendees) {
    if (this.brunchEvent != null && this.brunchEvent.getScheduleDate().equals(scheduleDate)) {
      throw new IllegalArgumentException("A brunch event is already booked for this date.");
    }
    this.brunchEvent = new Brunch(scheduleDate, schedulePerson, numAttendees);
  }
  /**
   * Method for booking a dinner event.
   *
   * @param scheduleDate   - LocalDate, representing the date of the dinner event
   * @param schedulePerson - String, representing the name of the scheduler
   * @param numAttendees   - int, representing the number of attendees
   * @throws IllegalArgumentException if a dinner event is already booked for the given date
   */
  public void bookDinner(LocalDate scheduleDate, String schedulePerson, int numAttendees) {
    if (this.dinnerEvent != null && this.dinnerEvent.getScheduleDate().equals(scheduleDate)) {
      throw new IllegalArgumentException("A dinner event is already booked for this date.");
    }
    this.dinnerEvent = new Dinner(scheduleDate, schedulePerson, numAttendees);
  }

  /**
   * Gets the brunch event if booked.
   *
   * @return an Optional containing the brunch event if booked, otherwise an empty Optional
   */
  public Optional<Brunch> getBrunchEvent() {
    return Optional.ofNullable(brunchEvent);
  }

  /**
   * Gets the dinner event if booked.
   *
   * @return an Optional containing the dinner event if booked, otherwise an empty Optional
   */
  public Optional<Dinner> getDinnerEvent() {
    return Optional.ofNullable(dinnerEvent);
  }
}

