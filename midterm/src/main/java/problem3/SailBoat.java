package problem3;

public abstract class SailBoat extends AbstractCharterBoat {
  protected String setupInfo;
  protected Integer powerStorage;

  public SailBoat(String boatID, Double length, Double pricePerWeek, Integer manufacturingYear,
      Integer numberOfStaterooms, Boolean skipperNeeded, String setupInfo, Integer powerStorage) {
    super(boatID, length, pricePerWeek, manufacturingYear, numberOfStaterooms, skipperNeeded);
    this.setupInfo = setupInfo;
    this.powerStorage = powerStorage;
  }

  public String getSetupInfo() {
    return setupInfo;
  }

  public Integer getPowerStorage() {
    return powerStorage;
  }
}

