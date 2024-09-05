package exampleProblem;

class TestDrink1 {
  public static void main(String[] arg) {
    Beverage[] drinks = {new DoubleEspresso(), new Beverage(), new Coffee(), new Espresso()};
    for (int i = 0; i < drinks.length; i++) {
      System.out.println(drinks[i]);
      drinks[i].method1();
      System.out.println("*****");
      drinks[i].method2();
      System.out.println("*****");
      drinks[i].method3();
      System.out.println("*****");
    }
  }
}

