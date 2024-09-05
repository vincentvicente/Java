package problem3;

import problem1.ListOfIntegers;

public interface ListOfListOfIntegers {
  Integer size();
  Integer length();
  Integer sum();
  Boolean isEmpty();
  ListOfListOfIntegers add(ListOfIntegers list);
  ListOfListOfIntegers remove(Integer intToRemove);
  ListOfListOfIntegers removeAllIntegers(Integer intToRemove);
}
