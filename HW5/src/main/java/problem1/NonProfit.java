package problem1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class representing a non-profit organization.
 */
public class NonProfit {

  private String name;
  private List<Donation> donations;

  /**
   * Constructs a new NonProfit.
   *
   * @param name The name of the non-profit organization.
   */
  public NonProfit(String name) {
    this.name = name;
    this.donations = new ArrayList<>();
  }

  /**
   * Gets the name of the non-profit organization.
   *
   * @return The name of the non-profit organization.
   */
  public String getName() {
    return name;
  }

  /**
   * Adds a donation to the non-profit organization.
   *
   * @param donation The donation to be added.
   */
  public void addDonation(Donation donation) {
    donations.add(donation);
  }

  /**
   * Calculates the total donations for a specified year.
   *
   * @param year The year for which to calculate the total donations.
   * @return The total donations for the specified year.
   */
  public double getTotalDonationsForYear(int year) {
    return donations.stream()
        .mapToDouble(donation -> donation.getDonationForYear(year))
        .sum();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NonProfit nonProfit = (NonProfit) o;
    return Objects.equals(name, nonProfit.name) && Objects.equals(donations,
        nonProfit.donations);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, donations);
  }
}

