package exampleProblem;

public class Espresso extends Coffee {

  @Override
  public void method1() {
    System.out.println("E 1");
    super.method2();
  }

  @Override
  public void method2() {
    System.out.println("E 2");
  }

  @Override
  public String toString() {
    return "Espresso:"; }
}