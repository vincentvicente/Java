package problem1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CookieTest {

  @Test
  void testGetName() {
    Cookie cookie = new Cookie("Chocolate Chip", new String[]{"flour", "sugar", "chocolate"}, 50.0,
        200.0, 20.0, 10.0, 5.0, 2.0, true, true, true);
    assertEquals("Chocolate Chip", cookie.getName());
  }

  @Test
  void testGetIngredients() {
    String[] ingredients = {"flour", "sugar", "chocolate"};
    Cookie cookie = new Cookie("Chocolate Chip", ingredients, 50.0, 200.0, 20.0, 10.0, 5.0, 2.0,
        true, true, true);
    assertArrayEquals(ingredients, cookie.getIngredients());
  }

  @Test
  void testGetQuantityPerServing() {
    Cookie cookie = new Cookie("Chocolate Chip", new String[]{"flour", "sugar", "chocolate"}, 50.0,
        200.0, 20.0, 10.0, 5.0, 2.0, true, true, true);
    assertEquals(50.0, cookie.getQuantityPerServing());
  }

  @Test
  void testGetCaloriesPerServing() {
    Cookie cookie = new Cookie("Chocolate Chip", new String[]{"flour", "sugar", "chocolate"}, 50.0,
        200.0, 20.0, 10.0, 5.0, 2.0, true, true, true);
    assertEquals(200.0, cookie.getCaloriesPerServing());
  }

  @Test
  void testGetSugarPerServing() {
    Cookie cookie = new Cookie("Chocolate Chip", new String[]{"flour", "sugar", "chocolate"}, 50.0,
        200.0, 20.0, 10.0, 5.0, 2.0, true, true, true);
    assertEquals(20.0, cookie.getSugarPerServing());
  }

  @Test
  void testGetFatPerServing() {
    Cookie cookie = new Cookie("Chocolate Chip", new String[]{"flour", "sugar", "chocolate"}, 50.0,
        200.0, 20.0, 10.0, 5.0, 2.0, true, true, true);
    assertEquals(10.0, cookie.getFatPerServing());
  }

  @Test
  void testGetProteinPerServing() {
    Cookie cookie = new Cookie("Chocolate Chip", new String[]{"flour", "sugar", "chocolate"}, 50.0,
        200.0, 20.0, 10.0, 5.0, 2.0, true, true, true);
    assertEquals(5.0, cookie.getProteinPerServing());
  }

  @Test
  void testGetFiberPerServing() {
    Cookie cookie = new Cookie("Chocolate Chip", new String[]{"flour", "sugar", "chocolate"}, 50.0,
        200.0, 20.0, 10.0, 5.0, 2.0, true, true, true);
    assertEquals(2.0, cookie.getFiberPerServing());
  }

  @Test
  void testGetContainsNuts() {
    Cookie cookie = new Cookie("Chocolate Chip", new String[]{"flour", "sugar", "chocolate"}, 50.0,
        200.0, 20.0, 10.0, 5.0, 2.0, true, true, true);
    assertTrue(cookie.getContainsNuts());
  }

  @Test
  void testGetContainsDairy() {
    Cookie cookie = new Cookie("Chocolate Chip", new String[]{"flour", "sugar", "chocolate"}, 50.0,
        200.0, 20.0, 10.0, 5.0, 2.0, true, true, true);
    assertTrue(cookie.getContainsDairy());
  }

  @Test
  void testGetGlutenFree() {
    Cookie cookie = new Cookie("Chocolate Chip", new String[]{"flour", "sugar", "chocolate"}, 50.0,
        200.0, 20.0, 10.0, 5.0, 2.0, true, true, true);
    assertTrue(cookie.getGlutenFree());
  }

  @Test
  void testEquals() {
    Cookie cookie1 = new Cookie("Chocolate Chip", new String[]{"flour", "sugar", "chocolate"}, 50.0,
        200.0, 20.0, 10.0, 5.0, 2.0, true, true, true);
    Cookie cookie2 = new Cookie("Chocolate Chip", new String[]{"flour", "sugar", "chocolate"}, 50.0,
        200.0, 20.0, 10.0, 5.0, 2.0, true, true, true);
    Cookie cookie3 = new Cookie("Oatmeal Raisin", new String[]{"flour", "sugar", "raisins"}, 50.0,
        200.0, 20.0, 10.0, 5.0, 2.0, true, true, true);
    assertEquals(cookie1, cookie2);
    assertNotEquals(cookie1, cookie3);
  }

  @Test
  void testHashCode() {
    Cookie cookie1 = new Cookie("Chocolate Chip", new String[]{"flour", "sugar", "chocolate"}, 50.0,
        200.0, 20.0, 10.0, 5.0, 2.0, true, true, true);
    Cookie cookie2 = new Cookie("Chocolate Chip", new String[]{"flour", "sugar", "chocolate"}, 50.0,
        200.0, 20.0, 10.0, 5.0, 2.0, true, true, true);
    Cookie cookie3 = new Cookie("Oatmeal Raisin", new String[]{"flour", "sugar", "raisins"}, 50.0,
        200.0, 20.0, 10.0, 5.0, 2.0, true, true, true);
    assertEquals(cookie1.hashCode(), cookie2.hashCode());
    assertNotEquals(cookie1.hashCode(), cookie3.hashCode());
  }
}
