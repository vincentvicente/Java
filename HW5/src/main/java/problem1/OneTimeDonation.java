package problem1;

import java.time.LocalDateTime;

/**
 * Class representing a one-time donation.
 */
public class OneTimeDonation extends Donation {

  /**
   * Constructs a new OneTimeDonation.
   *
   * @param amount           The amount of the donation.
   * @param creationDateTime The date and time the donation was created.
   */
  public OneTimeDonation(double amount, LocalDateTime creationDateTime) {
    super(amount, creationDateTime);
  }

  @Override
  public double getDonationForYear(int year) {
    return creationDateTime.getYear() == year ? amount : 0;
  }

}
