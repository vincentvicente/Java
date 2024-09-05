package problem1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;

public class OneTimeDonationTest {

  private static final double DONATION_AMOUNT = 100.0;
  private static final LocalDateTime DONATION_DATE = LocalDateTime.of(2024, 6, 5, 17, 45);

  @Test
  public void testGetDonationForYear() {
    Donation oneTime = new OneTimeDonation(DONATION_AMOUNT, DONATION_DATE);
    assertEquals(DONATION_AMOUNT, oneTime.getDonationForYear(2024));
    assertEquals(0, oneTime.getDonationForYear(2023));
  }

  @Test
  public void testEqualsAndHashCode() {
    Donation oneTime1 = new OneTimeDonation(DONATION_AMOUNT, DONATION_DATE);
    Donation oneTime2 = new OneTimeDonation(DONATION_AMOUNT, DONATION_DATE);
    assertEquals(oneTime1, oneTime2);
    assertEquals(oneTime1.hashCode(), oneTime2.hashCode());
  }
}
