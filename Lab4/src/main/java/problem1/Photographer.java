package problem1;

import java.util.ArrayList;

/**
 * Class representing a photographer.
 */
public class Photographer extends Artist implements ExhibitArtist {
  private ArrayList<String> exhibits;

  /**
   * Constructor for creating a Photographer.
   * @param name the name of the photographer
   * @param age the age of the photographer
   * @param genres the genres associated with the photographer
   * @param exhibits the list of exhibits where the photographer's art was shown
   */
  public Photographer(String name, int age, ArrayList<String> genres, ArrayList<String> exhibits) {
    super(name, age, genres);
    this.exhibits = exhibits;
  }

  @Override
  public ArrayList<String> getExhibits() {
    return exhibits;
  }
}
