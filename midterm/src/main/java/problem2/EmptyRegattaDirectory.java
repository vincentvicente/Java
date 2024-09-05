package problem2;


public class EmptyRegattaDirectory implements RegattaDirectory {

  @Override
  public Integer countRegatta() {
    return 0;
  }

  @Override
  public Boolean containsRegatta(Regatta regatta) {
    return Boolean.FALSE;
  }

  @Override
  public Regatta searchRegattaWithID(String regattaID) throws RegattaNotFoundException {
    throw new RegattaNotFoundException("This regatta cannot be found.");
  }

  @Override
  public RegattaDirectory addRegatta(Regatta regatta) {
    return new NonEmptyRegattaDirectory(regatta, this);
  }

  @Override
  public RegattaDirectory findAllRegattaBasedOnMileage(Double mileageDuration) {
    return this;
  }

  @Override
  public RegattaDirectory findAllRegattaBasedOnLevel(RegattaLevel regattaLevel) {
    return this;
  }

  @Override
  public RegattaDirectory findAllRegattaBasedOnStartingPoint(String startingPoint) {
    return this;
  }
}