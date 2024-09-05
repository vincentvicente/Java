package exampleProblem;

public class Coffee extends Beverage {

  @Override
  public void method3() {
    System.out.println("C 3");
    this.method2();
  }

  public void tastesAs(Coffee drink) {
    System.out.println("Tastes as Coffee");
  }

  @Override
  public String toString() {
    return "Coffee:"; }
}
