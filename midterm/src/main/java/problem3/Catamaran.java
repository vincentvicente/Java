package problem3;

public class Catamaran extends SailBoat {

  private Integer waterTankSize;

  public Catamaran(String boatID, Double length, Double pricePerWeek, Integer manufacturingYear,
      Integer numberOfStaterooms, Boolean skipperNeeded, String setupInfo, Integer powerStorage,
      Integer waterTankSize) {
    super(boatID, length, pricePerWeek, manufacturingYear, numberOfStaterooms, skipperNeeded,
        setupInfo, powerStorage);
    this.waterTankSize = waterTankSize;
  }

  public Integer getWaterTankSize() {
    return waterTankSize;
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
    if (getWaterTankSize() < 200) {
      basicEstimate *= CATAMARAN_TANK_DECREASE;
    }
    return basicEstimate;
  }
}
