package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ScheduleTest {

  private Schedule schedule;
  private LocalDate date;

  @BeforeEach
  void setUp() {
    schedule = new Schedule();
    date = LocalDate.of(2024, 8, 23);
  }

  @Test
  void bookBrunch_success() {
    schedule.bookBrunch(date, "Victor Zhang", 30);
    assertTrue(schedule.getBrunchEvent().isPresent());
    assertEquals("Victor Zhang", schedule.getBrunchEvent().get().getSchedulePerson());
    assertEquals(30, schedule.getBrunchEvent().get().getNumAttendees());
  }

  @Test
  void bookBrunch_DuplicateBooking() {
    schedule.bookBrunch(date, "Victor Zhang", 30);
    assertThrows(IllegalArgumentException.class,
        () -> schedule.bookBrunch(date, "Victoria Zhang", 40));
  }

  @Test
  void bookDinner_success() {
    schedule.bookDinner(date, "Johnny Depp", 50);
    assertTrue(schedule.getDinnerEvent().isPresent());
    assertEquals("Johnny Depp", schedule.getDinnerEvent().get().getSchedulePerson());
    assertEquals(50, schedule.getDinnerEvent().get().getNumAttendees());
  }

  @Test
  void bookDinner_DuplicateBooking() {
    schedule.bookDinner(date, "Johnny Depp", 50);
    assertThrows(IllegalArgumentException.class,
        () -> schedule.bookDinner(date, "Amber Heard", 60));
  }

  @Test
  void getBrunchEvent_NotBooked() {
    assertFalse(schedule.getBrunchEvent().isPresent());
  }

  @Test
  void getDinnerEvent_NotBooked() {
    assertFalse(schedule.getDinnerEvent().isPresent());
  }

  @Test
  void getBrunchEvent_Booked() {
    schedule.bookBrunch(date, "Johnny Depp", 30);
    assertTrue(schedule.getBrunchEvent().isPresent());
  }
}