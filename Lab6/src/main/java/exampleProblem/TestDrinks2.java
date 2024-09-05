package exampleProblem;

class TestDrinks2{

  public static void main(String[] args){

    Beverage cup1 = new Espresso(); //static time data type: Beverage, dynamic time data type: Espresso
    Object cup2 = new DoubleEspresso();//static time data type: Object, dynamic time data type is DoubleEspresso

    ((Coffee) cup1).method1(); //Espresso's method1 - E 1, B 2
    cup1.method1();//Espresso's method1 - E 1, B 2
    System.out.println("********");
    //((DoubleEspresso) cup1).method1(); //Invalid down cast - espresso can't be down-casted to double espresso
    ((Beverage) cup2).method2(); //safe down-cast, D 2
    System.out.println("********");
    ((Coffee) cup2).method2(); //safe down-cast, D 2
    System.out.println("********");
    ((Coffee) cup2).method3(); // C 3, D 2
    //cup2.method1();
  }
}
