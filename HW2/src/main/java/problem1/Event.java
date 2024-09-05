package problem1;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Event class keeps record of the general information of an event
 */
public class Event {

  protected LocalDate scheduleDate;
  protected String schedulePerson;
  protected int numAttendees;

  /**
   * Constructor for the class Event.
   *
   * @param scheduleDate   - LocalDate, representing event's date using built-in data type
   * @param schedulePerson - String, representing the name of the scheduler
   * @param numAttendees   - Int, representing the number of attendees
   **/
  public Event(LocalDate scheduleDate, String schedulePerson, int numAttendees) {
    this.scheduleDate = scheduleDate;
    this.schedulePerson = schedulePerson;
    this.numAttendees = numAttendees;
  }

  /**
   * Getter for the date of schedule.
   *
   * @return - scheduleDate, giving event's date
   **/
  public LocalDate getScheduleDate() {
    return scheduleDate;
  }

  /**
   * Getter for the name of the scheduler.
   *
   * @return - schedulePerson, giving scheduler's name
   **/
  public String getSchedulePerson() {
    return schedulePerson;
  }

  /**
   * Getter for the number of attendees.
   *
   * @return - numAttendees, giving event's number of attendees
   **/
  public int getNumAttendees() {
    return numAttendees;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Event event = (Event) o;
    return numAttendees == event.numAttendees &&
        Objects.equals(scheduleDate, event.scheduleDate) &&
        Objects.equals(schedulePerson, event.schedulePerson);
  }

  @Override
  public int hashCode() {
    return Objects.hash(scheduleDate, schedulePerson, numAttendees);
  }

  @Override
  public String toString() {
    return "Event{" +
        "scheduleDate=" + scheduleDate +
        ", schedulePerson='" + schedulePerson + '\'' +
        ", numAttendees=" + numAttendees +
        '}';
  }

}
