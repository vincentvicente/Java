package exampleProblem;

public class Beverage {
  public void method1() {
    System.out.println("B 1");
  }
  public void method2() {
    System.out.println("B 2");
  }
  public void method3() {
    System.out.println("B 3");
  }
  public void tastesAs(Beverage drink) {
    System.out.println("Tastes as Beverage");
  }

  @Override
  public String toString() {
    return "Beverage:"; }
}

