package problem1;

public class EmptyList extends ALinkedList{

  public EmptyList() {
  }

  @Override
  public Integer size() {
    return 0;
  }

  @Override
  public Boolean contains(int element) {
    return Boolean.FALSE;
  }

  @Override
  public int elementsAt(Integer index) throws IndexOutOfBoundsException {
    throw new IndexOutOfBoundsException("The element with this index is not a part of the list");
  }
}