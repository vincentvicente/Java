package problem1;

public interface ListOfIntegers {

  Integer size();
  Boolean isEmpty();
  Boolean contains(int value);
  Integer elementsAt(int index) throws IndexOutOfBoundsException;

  //Interface update to accommodate problem 3
  Integer sum();
}
