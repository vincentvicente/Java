package problem1;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Abstract class representing a general donation.
 */
public abstract class Donation {

  protected double amount;
  protected LocalDateTime creationDateTime;

  /**
   * Constructs a new Donation.
   *
   * @param amount           The amount of the donation.
   * @param creationDateTime The date and time the donation was created.
   */
  public Donation(double amount, LocalDateTime creationDateTime) {
    this.amount = amount;
    this.creationDateTime = creationDateTime;
  }

  /**
   * Gets the amount of the donation.
   *
   * @return The amount of the donation.
   */
  public double getAmount() {
    return amount;
  }

  /**
   * Gets the creation date and time of the donation.
   *
   * @return The creation date and time of the donation.
   */
  public LocalDateTime getCreationDateTime() {
    return creationDateTime;
  }

  /**
   * Calculates the donation amount for a specified year.
   *
   * @param year The year for which to calculate the donation amount.
   * @return The donation amount for the specified year.
   */
  public abstract double getDonationForYear(int year);

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Donation donation = (Donation) o;
    return Double.compare(amount, donation.amount) == 0 && Objects.equals(
        creationDateTime, donation.creationDateTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, creationDateTime);
  }
}


