package problem1;

import java.util.ArrayList;

/**
 * Interface representing an artist involved in multimedia.
 */
public interface MultimediaArtist {

  /**
   * Gets the movies the artist worked on.
   *
   * @return the list of movies
   */
  ArrayList<String> getMovies();

  /**
   * Gets the TV series the artist worked on.
   *
   * @return the list of TV series
   */
  ArrayList<String> getSeries();

  /**
   * Gets other multimedia content the artist worked on.
   *
   * @return the list of other multimedia content
   */
  ArrayList<String> getOtherMultimedia();
}


