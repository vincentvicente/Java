package problem1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;

public class MonthlyDonationTest {

  private static final double DONATION_AMOUNT = 25.0;
  private static final LocalDateTime DONATION_DATE = LocalDateTime.of(2024, 6, 5, 17, 45);
  private static final LocalDateTime CANCELLATION_DATE = LocalDateTime.of(2024, 11, 5, 17, 45);

  @Test
  public void testGetDonationForYearWithoutCancellation() {
    Donation monthly = new MonthlyDonation(DONATION_AMOUNT, DONATION_DATE);
    // Should count from June to December (7 months)
    assertEquals(7 * DONATION_AMOUNT, monthly.getDonationForYear(2024));
  }

  @Test
  public void testGetDonationForYearWithCancellation() {
    MonthlyDonation monthly = new MonthlyDonation(DONATION_AMOUNT, DONATION_DATE);
    monthly.setCancellationDateTime(CANCELLATION_DATE);
    // Should count from June to November (6 months)
    assertEquals(6 * DONATION_AMOUNT, monthly.getDonationForYear(2024));
  }

  @Test
  public void testSetCancellationDateTimeBeforeCreation() {
    MonthlyDonation monthly = new MonthlyDonation(DONATION_AMOUNT, DONATION_DATE);
    LocalDateTime invalidCancellationDate = LocalDateTime.of(2024, 5, 5, 17, 45);
    assertThrows(IllegalArgumentException.class, () -> {
      monthly.setCancellationDateTime(invalidCancellationDate);
    });
  }

  @Test
  public void testEqualsAndHashCode() {
    MonthlyDonation monthly1 = new MonthlyDonation(DONATION_AMOUNT, DONATION_DATE);
    MonthlyDonation monthly2 = new MonthlyDonation(DONATION_AMOUNT, DONATION_DATE);
    assertEquals(monthly1, monthly2);
    assertEquals(monthly1.hashCode(), monthly2.hashCode());
  }
}
