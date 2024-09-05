package problem1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CookieCatalogImplTest {

  @Test
  void testIsEmpty() {
    CookieCatalog catalog = new CookieCatalogImpl();
    assertTrue(catalog.isEmpty());
    catalog.addCookie(
        new Cookie("Chocolate Chip", new String[]{"flour", "sugar", "chocolate"}, 50.0, 200.0, 20.0,
            10.0, 5.0, 2.0, true, true, true));
    assertFalse(catalog.isEmpty());
  }

  @Test
  void testCountCookies() {
    CookieCatalog catalog = new CookieCatalogImpl();
    assertEquals(0, catalog.countCookies());
    catalog.addCookie(
        new Cookie("Chocolate Chip", new String[]{"flour", "sugar", "chocolate"}, 50.0, 200.0, 20.0,
            10.0, 5.0, 2.0, true, true, true));
    assertEquals(1, catalog.countCookies());
  }

  @Test
  void testCheckCookie() {
    CookieCatalog catalog = new CookieCatalogImpl();
    assertFalse(catalog.checkCookie("Chocolate Chip"));
    catalog.addCookie(
        new Cookie("Chocolate Chip", new String[]{"flour", "sugar", "chocolate"}, 50.0, 200.0, 20.0,
            10.0, 5.0, 2.0, true, true, true));
    assertTrue(catalog.checkCookie("Chocolate Chip"));
  }

  @Test
  void testAddCookie() {
    CookieCatalog catalog = new CookieCatalogImpl();
    Cookie cookie = new Cookie("Chocolate Chip", new String[]{"flour", "sugar", "chocolate"}, 50.0,
        200.0, 20.0, 10.0, 5.0, 2.0, true, true, true);
    catalog.addCookie(cookie);
    assertEquals(1, catalog.countCookies());
    assertThrows(IllegalArgumentException.class, () -> catalog.addCookie(cookie));
  }

  @Test
  void testRemoveCookie() throws CookieNotFoundException {
    CookieCatalog catalog = new CookieCatalogImpl();
    Cookie cookie = new Cookie("Chocolate Chip", new String[]{"flour", "sugar", "chocolate"}, 50.0,
        200.0, 20.0, 10.0, 5.0, 2.0, true, true, true);
    assertThrows(CookieNotFoundException.class, () -> catalog.removeCookie(cookie));
    catalog.addCookie(cookie);
    catalog.removeCookie(cookie);
    assertEquals(0, catalog.countCookies());
  }

  @Test
  void testFindGlutenFreeSugarLiteCookies() {
    CookieCatalog catalog = new CookieCatalogImpl();
    catalog.addCookie(
        new Cookie("Cookie1", new String[]{"ingredient1"}, 50.0, 200.0, 20.0, 10.0, 5.0, 2.0, true,
            true, true));
    catalog.addCookie(
        new Cookie("Cookie2", new String[]{"ingredient2"}, 50.0, 200.0, 35.0, 10.0, 5.0, 2.0, true,
            true, true));
    catalog.addCookie(
        new Cookie("Cookie3", new String[]{"ingredient3"}, 50.0, 200.0, 25.0, 10.0, 5.0, 2.0, true,
            true, true));
    Cookie[] result = catalog.findGlutenFreeSugarLiteCookies();
    assertEquals(2, result.length);
  }

  @Test
  void testFindNutsAndDairyCookies() {
    CookieCatalog catalog = new CookieCatalogImpl();
    catalog.addCookie(
        new Cookie("Cookie1", new String[]{"ingredient1"}, 50.0, 200.0, 20.0, 10.0, 5.0, 2.0, true,
            true, true));
    catalog.addCookie(
        new Cookie("Cookie2", new String[]{"ingredient2"}, 50.0, 200.0, 35.0, 10.0, 5.0, 2.0, false,
            true, true));
    catalog.addCookie(
        new Cookie("Cookie3", new String[]{"ingredient3"}, 50.0, 200.0, 25.0, 10.0, 5.0, 2.0, true,
            false, true));
    Cookie[] result = catalog.findNutsAndDairyCookies();
    assertEquals(1, result.length);
  }
}
