package problem1;

/**
 * Interface representing a Cookie Catalog.
 */
public interface CookieCatalog {

  /**
   * Checks if the CookieCatalog is empty.
   *
   * @return true if the catalog is empty, false otherwise.
   */
  boolean isEmpty();

  /**
   * Counts the number of Cookies in the CookieCatalog.
   *
   * @return the number of cookies in the catalog.
   */
  int countCookies();

  /**
   * Checks if a Cookie with the requested name exists in the CookieCatalog.
   *
   * @param cookieName the name of the cookie to check.
   * @return true if the cookie exists, false otherwise.
   */
  boolean checkCookie(String cookieName);

  /**
   * Adds a Cookie to the CookieCatalog. Duplicate cookies are not allowed.
   *
   * @param cookie the cookie to add.
   * @throws IllegalArgumentException if the cookie is already in the catalog.
   */
  void addCookie(Cookie cookie);

  /**
   * Removes a specified Cookie from the CookieCatalog.
   *
   * @param cookie the cookie to remove.
   * @throws CookieNotFoundException if the cookie does not exist in the catalog.
   */
  void removeCookie(Cookie cookie) throws CookieNotFoundException;

  /**
   * Finds and returns all gluten-free Cookies with less than 30 grams of sugar per serving.
   *
   * @return an array of gluten-free, sugar-lite cookies.
   */
  Cookie[] findGlutenFreeSugarLiteCookies();

  /**
   * Finds and returns all Cookies that contain both nuts and dairy.
   *
   * @return an array of cookies containing both nuts and dairy.
   */
  Cookie[] findNutsAndDairyCookies();
}
