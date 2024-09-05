package problem3;

public class Monohull extends SailBoat {

  public Monohull(String boatID, Double length, Double pricePerWeek, Integer manufacturingYear,
      Integer numberOfStaterooms, Boolean skipperNeeded, String setupInfo, Integer powerStorage) {
    super(boatID, length, pricePerWeek, manufacturingYear, numberOfStaterooms, skipperNeeded,
        setupInfo, powerStorage);
  }

  @Override
  public Double estimateAnnualBoatRevenue() {
    double basicEstimate = BASIC_ANNUAL_WEEKS * getPricePerWeek();
    if (getManufacturingYear() >= NEW_BOAT_YEAR_THRESHOLD) {
      basicEstimate *= NEW_BOAT_MULTIPLIER;
    }
    if (getLength() >= LENGTH_LOWER_LIMIT && getLength() <= LENGTH_UPPER_LIMIT) {
      basicEstimate *= LENGTH_MULTIPLIER;
    }
    if (isSkipperNeeded()) {
      basicEstimate *= SKIPPER_MULTIPLIER;
    }
    if (getPowerStorage() < 130) {
      basicEstimate *= MONOHULL_BATTERY_DECREASE;
    }
    return basicEstimate;
  }
}