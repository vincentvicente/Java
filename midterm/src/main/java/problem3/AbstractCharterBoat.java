package problem3;


public abstract class AbstractCharterBoat implements ICharterBoat {

  protected String boatID;
  protected Double length;
  protected Double pricePerWeek;
  protected Integer manufacturingYear;
  protected Integer numberOfStaterooms;
  protected Boolean skipperNeeded;

  protected static final int BASIC_ANNUAL_WEEKS = 16;
  protected static final double NEW_BOAT_MULTIPLIER = 1.15;
  protected static final double SKIPPER_MULTIPLIER = 1.35;
  protected static final double LENGTH_MULTIPLIER = 1.15;
  protected static final double CATAMARAN_TANK_DECREASE = 0.85;
  protected static final double MONOHULL_BATTERY_DECREASE = 0.83;
  protected static final int NEW_BOAT_YEAR_THRESHOLD = 2015;
  protected static final int LENGTH_LOWER_LIMIT = 35;
  protected static final int LENGTH_UPPER_LIMIT = 50;

  public AbstractCharterBoat(String boatID, Double length, Double pricePerWeek,
      Integer manufacturingYear,
      Integer numberOfStaterooms, Boolean skipperNeeded) {
    this.boatID = boatID;
    this.length = length;
    this.pricePerWeek = pricePerWeek;
    this.manufacturingYear = manufacturingYear;
    this.numberOfStaterooms = numberOfStaterooms;
    this.skipperNeeded = skipperNeeded;
  }

  public String getBoatID() {
    return boatID;
  }

  public Double getLength() {
    return length;
  }

  public Double getPricePerWeek() {
    return pricePerWeek;
  }

  public Integer getManufacturingYear() {
    return manufacturingYear;
  }

  public Integer getNumberOfStaterooms() {
    return numberOfStaterooms;
  }

  public Boolean isSkipperNeeded() {
    return skipperNeeded;
  }

  @Override
  public abstract Double estimateAnnualBoatRevenue();
}