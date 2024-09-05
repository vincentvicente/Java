package problem1;

public class EmptyList extends AListOfIntegers {

  public EmptyList() {
  }

  @Override
  public Integer size() {
    return 0;
  }

  @Override
  public Boolean isEmpty() {
    return Boolean.TRUE;
  }

  @Override
  public Boolean contains(int value) {
    return Boolean.FALSE;
  }

  @Override
  public Integer elementsAt(int index) throws IndexOutOfBoundsException {
    throw new IndexOutOfBoundsException("The element with this index "
        + "is not a part of the list");
  }

  @Override
  public Integer sum() {
    return 0;
  }
}
