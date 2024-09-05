package problem1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;

public class PledgeTest {

  private static final double PLEDGE_AMOUNT = 500.0;
  private static final LocalDateTime PLEDGE_DATE = LocalDateTime.of(2024, 6, 5, 17, 45);
  private static final LocalDateTime PROCESSING_DATE = LocalDateTime.of(2024, 12, 5, 17, 45);

  @Test
  public void testGetDonationForYear() {
    Pledge pledge = new Pledge(PLEDGE_AMOUNT, PLEDGE_DATE);
    pledge.setProcessingDateTime(PROCESSING_DATE);
    assertEquals(PLEDGE_AMOUNT, pledge.getDonationForYear(2024));
    assertEquals(0, pledge.getDonationForYear(2023));
  }

  @Test
  public void testSetProcessingDateTimeBeforeCreation() {
    Pledge pledge = new Pledge(PLEDGE_AMOUNT, PLEDGE_DATE);
    LocalDateTime invalidProcessingDate = LocalDateTime.of(2024, 5, 5, 17, 45);
    assertThrows(IllegalArgumentException.class, () -> {
      pledge.setProcessingDateTime(invalidProcessingDate);
    });
  }

  @Test
  public void testEqualsAndHashCode() {
    Pledge pledge1 = new Pledge(PLEDGE_AMOUNT, PLEDGE_DATE);
    Pledge pledge2 = new Pledge(PLEDGE_AMOUNT, PLEDGE_DATE);
    assertEquals(pledge1, pledge2);
    assertEquals(pledge1.hashCode(), pledge2.hashCode());
  }
}
