package exampleProblem;

public class TestDrinks3 {

  public static void main(String[] args){

    Beverage bb = new Beverage();
    Beverage bc = new Coffee();
    Coffee cc = new Coffee();

    bb.tastesAs(bb); //Tastes as Beverage
    System.out.println("*******");
    bb.tastesAs(bc); //Tastes as Beverage
    System.out.println("*******");
    bc.tastesAs(bb); //Tastes as Beverage
    System.out.println("*******");
    bc.tastesAs(bc);; //Tastes as Beverage
    System.out.println("*******");
    cc.tastesAs(bb); //Tastes as Beverage
    System.out.println("*******");
    cc.tastesAs(bc); //Tastes as Beverage
    System.out.println("*******");
    bb.tastesAs(cc); //Tastes as Beverage
    System.out.println("*******");
    bc.tastesAs(cc); //Tastes as Beverage (not Coffee - we look at the static time data type of bc)
    System.out.println("*******");
    cc.tastesAs(cc); //Tastes as Coffee
  }

}
