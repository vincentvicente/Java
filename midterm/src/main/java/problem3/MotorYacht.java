package problem3;

public class MotorYacht extends PowerBoat {

  public MotorYacht(String boatID, Double length, Double pricePerWeek, Integer manufacturingYear,
      Integer numberOfStaterooms, Boolean skipperNeeded, Double enginePower, Double averageSpeed) {
    super(boatID, length, pricePerWeek, manufacturingYear, numberOfStaterooms, skipperNeeded,
        enginePower, averageSpeed);
  }

  @Override
  public Double estimateAnnualBoatRevenue() {
    double basicEstimate = BASIC_ANNUAL_WEEKS * getPricePerWeek();
    if (getManufacturingYear() >= NEW_BOAT_YEAR_THRESHOLD) {
      basicEstimate *= NEW_BOAT_MULTIPLIER;
    }
    if (getEnginePower() > HIGH_POWER_THRESHOLD) {
      basicEstimate *= HIGH_POWER_MULTIPLIER;
    }
    return basicEstimate;
  }
}