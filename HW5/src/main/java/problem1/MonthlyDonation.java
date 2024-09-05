package problem1;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import problem1.Donation;

/**
 * Class representing a monthly donation.
 */
public class MonthlyDonation extends Donation {
  private LocalDateTime cancellationDateTime;

  /**
   * Constructs a new MonthlyDonation.
   *
   * @param amount           The amount of the donation.
   * @param creationDateTime The date and time the donation was created.
   */
  public MonthlyDonation(double amount, LocalDateTime creationDateTime) {
    super(amount, creationDateTime);
  }

  /**
   * Sets the cancellation date and time of the monthly donation.
   *
   * @param cancellationDateTime The cancellation date and time.
   */
  public void setCancellationDateTime(LocalDateTime cancellationDateTime) {
    if (cancellationDateTime.isBefore(creationDateTime)) {
      throw new IllegalArgumentException("Cancellation date/time cannot be before creation date/time.");
    }
    this.cancellationDateTime = cancellationDateTime;
  }

  @Override
  public double getDonationForYear(int year) {
    LocalDateTime endOfYear = LocalDateTime.of(year, 12, 31, 23, 59, 59);
    LocalDateTime endDate = (cancellationDateTime == null || cancellationDateTime.isAfter(endOfYear)) ?
        endOfYear : cancellationDateTime;

    if (creationDateTime.isAfter(endDate) || creationDateTime.getYear() > year) {
      return 0;
    }

    LocalDateTime startDate = creationDateTime.getYear() < year ? LocalDateTime.of(year, 1, 1, 0, 0) : creationDateTime;
    long monthsBetween = ChronoUnit.MONTHS.between(startDate.withDayOfMonth(1), endDate.withDayOfMonth(1)) + 1;

    return monthsBetween * amount;
  }
}
