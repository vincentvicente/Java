package problem1;

import java.util.Arrays;

/**
 * Implementation of the CookieCatalog interface.
 */
public class CookieCatalogImpl implements CookieCatalog {

  private Cookie[] cookies;
  private int size;
  private static final int NUM_SLOTS = 10;

  public CookieCatalogImpl() {
    this.cookies = new Cookie[NUM_SLOTS];
    this.size = 0;
  }

  /**
   * Checks if the CookieCatalog is empty.
   *
   * @return true if the catalog is empty, false otherwise.
   */
  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Counts the number of Cookies in the CookieCatalog.
   *
   * @return the number of cookies in the catalog.
   */
  @Override
  public int countCookies() {
    return size;
  }

  /**
   * Checks if a Cookie with the requested name exists in the CookieCatalog.
   *
   * @param cookieName the name of the cookie to check.
   * @return true if the cookie exists, false otherwise.
   */
  @Override
  public boolean checkCookie(String cookieName) {
    for (int i = 0; i < size; i++) {
      if (cookies[i].getName().equals(cookieName)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Adds a Cookie to the CookieCatalog. Duplicate cookies are not allowed.
   *
   * @param cookie the cookie to add.
   * @throws IllegalArgumentException if the cookie is already in the catalog.
   */
  @Override
  public void addCookie(Cookie cookie) {
    if (checkCookie(cookie.getName())) {
      throw new IllegalArgumentException("Duplicate cookie not allowed.");
    }
    if (size == cookies.length) {
      cookies = Arrays.copyOf(cookies, size * 2);
    }
    cookies[size++] = cookie;
  }

  /**
   * Removes a specified Cookie from the CookieCatalog.
   *
   * @param cookie the cookie to remove.
   * @throws CookieNotFoundException if the cookie does not exist in the catalog.
   */
  @Override
  public void removeCookie(Cookie cookie) throws CookieNotFoundException {
    int index = -1;
    for (int i = 0; i < size; i++) {
      if (cookies[i].equals(cookie)) {
        index = i;
        break;
      }
    }
    if (index == -1) {
      throw new CookieNotFoundException("Cookie not found.");
    }
    System.arraycopy(cookies, index + 1, cookies, index, size - index - 1);
    size--;
    cookies[size] = null;
  }

  /**
   * Finds and returns all gluten-free Cookies with less than 30 grams of sugar per serving.
   *
   * @return an array of gluten-free, sugar-lite cookies.
   */
  @Override
  public Cookie[] findGlutenFreeSugarLiteCookies() {
    Cookie[] result = new Cookie[size];
    int index = 0;
    for (int i = 0; i < size; i++) {
      if (cookies[i].getGlutenFree() && cookies[i].getSugarPerServing() < 30) {
        result[index++] = cookies[i];
      }
    }
    return Arrays.copyOf(result, index);
  }

  /**
   * Finds and returns all Cookies that contain both nuts and dairy.
   *
   * @return an array of cookies containing both nuts and dairy.
   */
  @Override
  public Cookie[] findNutsAndDairyCookies() {
    Cookie[] result = new Cookie[size];
    int index = 0;
    for (int i = 0; i < size; i++) {
      if (cookies[i].getContainsNuts() && cookies[i].getContainsDairy()) {
        result[index++] = cookies[i];
      }
    }
    return Arrays.copyOf(result, index);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < size; i++) {
      sb.append(cookies[i]).append("\n");
    }
    return sb.toString();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    CookieCatalogImpl that = (CookieCatalogImpl) obj;
    return size == that.size && Arrays.equals(toArray(), that.toArray());
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(toArray());
  }

  private Cookie[] toArray() {
    return Arrays.copyOf(cookies, size);
  }
}
