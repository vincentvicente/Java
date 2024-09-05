package problem3;

import problem1.ListOfIntegers;

public class EmptyListOfListOfIntegers implements ListOfListOfIntegers {

  public EmptyListOfListOfIntegers() {
  }

  @Override
  public Integer size() {
    return 0;
  }

  @Override
  public Integer length() {
    return 0;
  }

  @Override
  public Integer sum() {
    return 0;
  }

  @Override
  public Boolean isEmpty() {
    return true;
  }

  @Override
  public ListOfListOfIntegers add(ListOfIntegers list) {
    return new NonEmptyListOfListOfIntegers(list, this);
  }

  @Override
  public ListOfListOfIntegers remove(Integer intToRemove) {
    return this;
  }

  @Override
  public ListOfListOfIntegers removeAllIntegers(Integer intToRemove) {
    return this;
  }
}
