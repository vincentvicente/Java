package problem1;

/**
 * Exception thrown when a cookie is not found in the catalog.
 */
public class CookieNotFoundException extends Exception {

  public CookieNotFoundException(String message) {
    super(message);
  }
}
