package problem1;

import java.util.ArrayList;

/**
 * Abstract class representing a generic artist.
 */
public abstract class Artist implements AwardReceiver {

  protected String name;
  protected int age;
  protected String[] genres;
  protected String[] awards;
  private static final Integer MINIMAL_AGE = 0;
  private static final Integer MAXIMUM_AGE = 128;

  /**
   * Constructor for creating an Artist.
   *
   * @param name   the name of the artist
   * @param age    the age of the artist
   * @param genres the genres associated with the artist
   */
  public Artist(String name, int age, ArrayList<String> genres) throws invalidAgeException {
    if (validateAge(this.age)) {
      this.name = name;
      this.age = age;
      this.genres = genres.toArray(new String[0]);
      this.awards = new ArrayList<>();
    } else
      throw new invalidAgeException("Age should be between 0 and 100.");
  }

  public boolean validateAge(Integer age){
    return age >= MINIMAL_AGE && age <= MAXIMUM_AGE;
  }

  @Override
  public void receiveAward(String award) {
    awards.add(award);
  }


  /**
   * Gets the name of the artist.
   *
   * @return the name of the artist
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the artist.
   *
   * @param name the name of the artist
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets the age of the artist.
   *
   * @return the age of the artist
   */
  public int getAge() {
    return age;
  }

  /**
   * Sets the age of the artist.
   *
   * @param age the age of the artist
   */
  public void setAge(int age) {
    this.age = age;
  }

  /**
   * Gets the genres associated with the artist.
   *
   * @return the genres associated with the artist
   */
  public ArrayList<String> getGenres() {
    return genres;
  }

  /**
   * Sets the genres associated with the artist.
   *
   * @param genres the genres associated with the artist
   */
  public void setGenres(ArrayList<String> genres) {
    this.genres = genres;
  }

  /**
   * Gets the awards received by the artist.
   *
   * @return the awards received by the artist
   */
  public ArrayList<String> getAwards() {
    return awards;
  }

}



