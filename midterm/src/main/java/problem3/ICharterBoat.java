package problem3;

public interface ICharterBoat {

  String getBoatID();

  Double getLength();

  Double getPricePerWeek();

  Integer getManufacturingYear();

  Integer getNumberOfStaterooms();

  Boolean isSkipperNeeded();

  Double estimateAnnualBoatRevenue();
}

