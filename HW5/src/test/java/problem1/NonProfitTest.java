package problem1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;

public class NonProfitTest {

  private static final String NON_PROFIT_NAME = "Helping Hands";
  private static final double ONE_TIME_DONATION_AMOUNT = 100.0;
  private static final double MONTHLY_DONATION_AMOUNT = 25.0;
  private static final double PLEDGE_AMOUNT = 500.0;
  private static final LocalDateTime ONE_TIME_DONATION_DATE = LocalDateTime.of(2024, 6, 5, 17, 45);
  private static final LocalDateTime MONTHLY_DONATION_DATE = LocalDateTime.of(2024, 6, 5, 17, 45);
  private static final LocalDateTime PLEDGE_CREATION_DATE = LocalDateTime.of(2024, 6, 5, 17, 45);
  private static final LocalDateTime PLEDGE_PROCESSING_DATE = LocalDateTime.of(2024, 12, 5, 17, 45);
  private static final LocalDateTime MONTHLY_DONATION_CANCELLATION_DATE = LocalDateTime.of(2024, 11, 5, 17, 45);

  @Test
  public void testCreateNonProfit() {
    NonProfit nonProfit = new NonProfit(NON_PROFIT_NAME);
    assertEquals(NON_PROFIT_NAME, nonProfit.getName());
  }

  @Test
  public void testAddDonation() {
    NonProfit nonProfit = new NonProfit(NON_PROFIT_NAME);
    Donation oneTime = new OneTimeDonation(ONE_TIME_DONATION_AMOUNT, ONE_TIME_DONATION_DATE);
    nonProfit.addDonation(oneTime);
    assertEquals(ONE_TIME_DONATION_AMOUNT, nonProfit.getTotalDonationsForYear(2024));
  }

  @Test
  public void testGetTotalDonationsForYear() {
    NonProfit nonProfit = new NonProfit(NON_PROFIT_NAME);

    Donation oneTime = new OneTimeDonation(ONE_TIME_DONATION_AMOUNT, ONE_TIME_DONATION_DATE);
    MonthlyDonation monthly = new MonthlyDonation(MONTHLY_DONATION_AMOUNT, MONTHLY_DONATION_DATE);
    Pledge pledge = new Pledge(PLEDGE_AMOUNT, PLEDGE_CREATION_DATE);

    monthly.setCancellationDateTime(MONTHLY_DONATION_CANCELLATION_DATE);
    pledge.setProcessingDateTime(PLEDGE_PROCESSING_DATE);

    nonProfit.addDonation(oneTime);
    nonProfit.addDonation(monthly);
    nonProfit.addDonation(pledge);

    double expectedTotal = ONE_TIME_DONATION_AMOUNT + (5 * MONTHLY_DONATION_AMOUNT) + PLEDGE_AMOUNT;
    assertEquals(expectedTotal, nonProfit.getTotalDonationsForYear(2024));
  }

  @Test
  public void testEqualsAndHashCode() {
    NonProfit nonProfit1 = new NonProfit(NON_PROFIT_NAME);
    NonProfit nonProfit2 = new NonProfit(NON_PROFIT_NAME);
    assertEquals(nonProfit1, nonProfit2);
    assertEquals(nonProfit1.hashCode(), nonProfit2.hashCode());

    Donation oneTime = new OneTimeDonation(ONE_TIME_DONATION_AMOUNT, ONE_TIME_DONATION_DATE);
    nonProfit1.addDonation(oneTime);
    assertNotEquals(nonProfit1, nonProfit2);
    assertNotEquals(nonProfit1.hashCode(), nonProfit2.hashCode());

    nonProfit2.addDonation(oneTime);
    assertEquals(nonProfit1, nonProfit2);
    assertEquals(nonProfit1.hashCode(), nonProfit2.hashCode());
  }
}
