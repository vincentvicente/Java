package problem1;

import java.util.ArrayList;

/**
 * Class representing a painter.
 */
public class Painter extends Artist implements ExhibitArtist {
  private ArrayList<String> exhibits;

  /**
   * Constructor for creating a Painter.
   * @param name the name of the painter
   * @param age the age of the painter
   * @param genres the genres associated with the painter
   * @param exhibits the list of exhibits where the painter's art was shown
   */
  public Painter(String name, int age, ArrayList<String> genres, ArrayList<String> exhibits) {
    super(name, age, genres);
    this.exhibits = exhibits;
  }

  @Override
  public ArrayList<String> getExhibits() {
    return exhibits;
  }
}
