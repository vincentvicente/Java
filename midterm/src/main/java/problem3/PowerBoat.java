package problem3;

public abstract class PowerBoat extends AbstractCharterBoat {

  private Double enginePower;
  private Double averageSpeed;

  protected static final double HIGH_POWER_MULTIPLIER = 1.2;
  protected static final double HIGH_POWER_THRESHOLD = 250.0;

  public PowerBoat(String boatID, Double length, Double pricePerWeek, Integer manufacturingYear,
      Integer numberOfStaterooms, Boolean skipperNeeded, Double enginePower, Double averageSpeed) {
    super(boatID, length, pricePerWeek, manufacturingYear, numberOfStaterooms, skipperNeeded);
    this.enginePower = enginePower;
    this.averageSpeed = averageSpeed;
  }

  public Double getEnginePower() {
    return enginePower;
  }

  public Double getAverageSpeed() {
    return averageSpeed;
  }
}