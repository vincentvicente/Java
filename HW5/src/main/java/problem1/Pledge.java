package problem1;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Class representing a pledge.
 */
public class Pledge extends Donation {

  private LocalDateTime processingDateTime;

  /**
   * Constructs a new Pledge.
   *
   * @param amount           The amount of the pledge.
   * @param creationDateTime The date and time the pledge was created.
   */
  public Pledge(double amount, LocalDateTime creationDateTime) {
    super(amount, creationDateTime);
  }

  /**
   * Sets the processing date and time of the pledge.
   *
   * @param processingDateTime The processing date and time.
   */
  public void setProcessingDateTime(LocalDateTime processingDateTime) {
    if (processingDateTime.isBefore(creationDateTime)) {
      throw new IllegalArgumentException(
          "Processing date/time cannot be before creation date/time.");
    }
    this.processingDateTime = processingDateTime;
  }

  @Override
  public double getDonationForYear(int year) {
    return (processingDateTime != null && processingDateTime.getYear() == year) ? amount : 0;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Pledge pledge = (Pledge) o;
    return Objects.equals(processingDateTime, pledge.processingDateTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), processingDateTime);
  }
}

