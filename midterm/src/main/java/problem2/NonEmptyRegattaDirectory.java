package problem2;

import java.util.Objects;


public class NonEmptyRegattaDirectory implements RegattaDirectory {

  private Regatta headNode;
  private RegattaDirectory rest;

  public NonEmptyRegattaDirectory(Regatta headNode, RegattaDirectory rest) {
    this.headNode = headNode;
    this.rest = rest;
  }

  @Override
  public Integer countRegatta() {
    return 1 + this.rest.countRegatta();
  }

  @Override
  public Boolean containsRegatta(Regatta regatta) {
    if (this.headNode.equals(regatta)) {
      return Boolean.TRUE;
    } else {
      return this.rest.containsRegatta(regatta);
    }
  }

  @Override
  public Regatta searchRegattaWithID(String regattaID) throws RegattaNotFoundException {
    if (this.headNode.getRegattaID().equals(regattaID)) {
      return this.headNode;
    } else {
      return this.rest.searchRegattaWithID(regattaID);
    }
  }

  @Override
  public RegattaDirectory addRegatta(Regatta regatta) {
    if (this.containsRegatta(regatta)) {
      return this;
    } else {
      return new NonEmptyRegattaDirectory(regatta, this);
    }
  }

  @Override
  public RegattaDirectory findAllRegattaBasedOnMileage(Double mileageDuration) {
    if (this.headNode.getMileageDuration() <= mileageDuration) {
      return new NonEmptyRegattaDirectory(this.headNode,
          this.rest.findAllRegattaBasedOnMileage(mileageDuration));
    } else {
      return this.rest.findAllRegattaBasedOnMileage(mileageDuration);
    }
  }

  @Override
  public RegattaDirectory findAllRegattaBasedOnLevel(RegattaLevel regattaLevel) {
    if (this.headNode.getRegattaLevel().equals(regattaLevel)) {
      return new NonEmptyRegattaDirectory(this.headNode,
          this.rest.findAllRegattaBasedOnLevel(regattaLevel));
    } else {
      return this.rest.findAllRegattaBasedOnLevel(regattaLevel);
    }
  }

  @Override
  public RegattaDirectory findAllRegattaBasedOnStartingPoint(String startingPoint) {
    if (this.headNode.getStartingPoint().equals(startingPoint)) {
      return new NonEmptyRegattaDirectory(this.headNode,
          this.rest.findAllRegattaBasedOnStartingPoint(startingPoint));
    } else {
      return this.rest.findAllRegattaBasedOnStartingPoint(startingPoint);
    }
  }
}