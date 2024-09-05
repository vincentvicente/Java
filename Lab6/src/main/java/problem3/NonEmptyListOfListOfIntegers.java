package problem3;

import problem1.ListOfIntegers;

public class NonEmptyListOfListOfIntegers implements ListOfListOfIntegers {

  private ListOfIntegers list;
  private ListOfListOfIntegers rest;

  public NonEmptyListOfListOfIntegers(ListOfIntegers list, ListOfListOfIntegers rest) {
    this.list = list;
    this.rest = rest;
  }

  @Override
  public Integer size() {
    return 1 + this.rest.size();
  }

  @Override
  public Integer length() {
    return this.list.size() + this.rest.length();
  }

  @Override
  public Integer sum() {
    return this.list.sum() + this.rest.sum();
  }

  @Override
  public Boolean isEmpty() {
    return false;
  }

  @Override
  public ListOfListOfIntegers add(ListOfIntegers list) {
    return new NonEmptyListOfListOfIntegers(list, this);
  }

  @Override
  public ListOfListOfIntegers remove(Integer intToRemove) {
    return null;
  }

  @Override
  public ListOfListOfIntegers removeAllIntegers(Integer intToRemove) {
    return null;
  }
}
