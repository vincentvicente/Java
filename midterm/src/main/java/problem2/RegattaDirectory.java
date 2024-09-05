package problem2;

/**
 * Interface for a directory of regattas.
 */
public interface RegattaDirectory {

  /**
   * Counts the number of regattas in the directory.
   *
   * @return the number of regattas.
   */
  Integer countRegatta();

  /**
   * Checks if a specific regatta exists in the directory.
   *
   * @param regatta the regatta to check.
   * @return true if the regatta exists, false otherwise.
   */
  Boolean containsRegatta(Regatta regatta);

  /**
   * Searches and returns a regatta based on the regatta ID.
   *
   * @param regattaID the ID of the regatta to search for.
   * @return the regatta with the specified ID.
   * @throws RegattaNotFoundException if the regatta is not found.
   */
  Regatta searchRegattaWithID(String regattaID) throws RegattaNotFoundException;

  /**
   * Adds a regatta to the directory. Duplicate regattas are not allowed.
   *
   * @param regatta the regatta to add.
   * @return the updated regatta directory.
   */
  RegattaDirectory addRegatta(Regatta regatta);

  /**
   * Finds and returns all regattas with a mileage duration less than or equal to the given input argument.
   *
   * @param mileageDuration the maximum mileage duration.
   * @return a regatta directory containing all required regattas.
   */
  RegattaDirectory findAllRegattaBasedOnMileage(Double mileageDuration);

  /**
   * Finds and returns all regattas whose regatta level is equal to the provided regatta level.
   *
   * @param regattaLevel the level of the regatta to search for.
   * @return a regatta directory containing all required regattas.
   */
  RegattaDirectory findAllRegattaBasedOnLevel(RegattaLevel regattaLevel);

  /**
   * Finds and returns all regattas whose starting point is equal to the provided input argument.
   *
   * @param startingPoint the starting point to search for.
   * @return a regatta directory containing all required regattas.
   */
  RegattaDirectory findAllRegattaBasedOnStartingPoint(String startingPoint);
}