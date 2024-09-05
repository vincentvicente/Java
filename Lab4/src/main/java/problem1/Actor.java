package problem1;

import java.util.ArrayList;

/**
 * Class representing an actor.
 */
public class Actor extends Artist implements MultimediaArtist {
  private ArrayList<String> movies;
  private ArrayList<String> series;
  private ArrayList<String> otherMultimedia;

  /**
   * Constructor for creating an Actor.
   * @param name the name of the actor
   * @param age the age of the actor
   * @param genres the genres associated with the actor
   * @param movies the list of movies the actor worked on
   * @param series the list of TV series the actor worked on
   * @param otherMultimedia the list of other multimedia content the actor worked on
   */
  public Actor(String name, int age, ArrayList<String> genres, ArrayList<String> movies, ArrayList<String> series, ArrayList<String> otherMultimedia) {
    super(name, age, genres);
    this.movies = movies;
    this.series = series;
    this.otherMultimedia = otherMultimedia;
  }

  @Override
  public ArrayList<String> getMovies() {
    return movies;
  }

  @Override
  public ArrayList<String> getSeries() {
    return series;
  }

  @Override
  public ArrayList<String> getOtherMultimedia() {
    return otherMultimedia;
  }
}



