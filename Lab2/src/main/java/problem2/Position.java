package problem2;

import java.util.Objects;

/**
 * Class Position represents information about the position of
 * a 2-dimensional point in Cartesian space.
 */
public class Position {

  private Integer xCoordinate;
  private Integer yCoordinate;

  public Position(Integer xCoordinate, Integer yCoordinate) {
    this.xCoordinate = xCoordinate;
    this.yCoordinate = yCoordinate;
  }

  /**
   * Getter for x coordinate
   * @return x coordinate, as an Integer
   */
  public Integer getXCoordinate() {
    return xCoordinate;
  }

  /**
   * Getter for y coordinate
   * @return y coordinate, as an Integer
   */
  public Integer getYCoordinate() {
    return yCoordinate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Position position = (Position) o;
    return Objects.equals(xCoordinate, position.xCoordinate) && Objects.equals(
        yCoordinate, position.yCoordinate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(xCoordinate, yCoordinate);
  }
}
